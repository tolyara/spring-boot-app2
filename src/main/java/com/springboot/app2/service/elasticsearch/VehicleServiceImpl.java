package com.springboot.app2.service.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.app2.dto.elasticsearch.SearchRequestDto;
import com.springboot.app2.entity.elasticsearch.Vehicle;
import com.springboot.app2.enums.elasticsearch.Indices;
import com.springboot.app2.util.elasticsearch.SearchUtil;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
            return false;
        }
    }

    @Override
    public Vehicle findById(String id) {
        try {
            final GetResponse documentFields = restHighLevelClient.get(new GetRequest(Indices.VEHICLE_IDX, id), RequestOptions.DEFAULT);
            if (documentFields == null || documentFields.isSourceEmpty()) return null;
            return MAPPER.readValue(documentFields.getSourceAsString(), Vehicle.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<Vehicle> search(SearchRequestDto dto) {
        SearchRequest request = SearchUtil.buildSearchRequest(Indices.VEHICLE_IDX, dto);
        return searchVehicles(request);
    }

    @Override
    public List<Vehicle> searchVehiclesCreatedSince(Date date) {
        SearchRequest request = SearchUtil.buildSearchRequest(Indices.VEHICLE_IDX, "created", date);
        return searchVehicles(request);
    }

    private List<Vehicle> searchVehicles(SearchRequest request) {
        if (request == null) {
            logger.error("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            SearchHit[] searchHits = response.getHits().getHits();
            List<Vehicle> vehicles = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                vehicles.add(MAPPER.readValue(hit.getSourceAsString(), Vehicle.class));
            }
            return vehicles;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

}
