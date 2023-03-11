package com.springboot.app2.service.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.app2.entity.elasticsearch.Vehicle;
import com.springboot.app2.enums.elasticsearch.Indices;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    public final ObjectMapper MAPPER = new ObjectMapper();

    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public VehicleServiceImpl(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    @Override
    public Boolean index(Vehicle vehicle) {
        try {
            final String vehicleAsString = MAPPER.writeValueAsString(vehicle);

            IndexRequest request = new IndexRequest(Indices.VEHICLE_IDX);
            request.id(vehicle.getId());
            request.source(vehicleAsString, XContentType.JSON);

            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            return response != null && response.status().equals(RestStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
