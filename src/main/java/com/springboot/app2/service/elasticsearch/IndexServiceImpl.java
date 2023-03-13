package com.springboot.app2.service.elasticsearch;

import com.springboot.app2.enums.elasticsearch.Indices;
import com.springboot.app2.util.FileUtil;
import jakarta.annotation.PostConstruct;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<String> INDICES_TO_CREATE = List.of(Indices.VEHICLE_IDX);

    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public IndexServiceImpl(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    @PostConstruct
    public void createIndicesIfNotExists() {
        final String settings = FileUtil.loadAsString("static/es-settings.json");

        for (String indexName : INDICES_TO_CREATE) {
            try {
                boolean indexExists = restHighLevelClient.indices().exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
                if (indexExists) continue;

                final String mappings = FileUtil.loadAsString("static/mappings/" + indexName + ".json");
                if (settings == null || mappings == null) {
                    logger.error("Failed to create index with name {}", indexName);
                }
                final CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
                createIndexRequest.settings(settings, XContentType.JSON);
                createIndexRequest.mapping(mappings, XContentType.JSON);
                restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
