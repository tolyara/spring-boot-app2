package com.springboot.app2.service.elasticsearch;

import com.springboot.app2.dto.elasticsearch.SearchRequestDto;
import com.springboot.app2.entity.elasticsearch.Vehicle;

import java.util.List;

public interface VehicleService {

    Boolean index(Vehicle vehicle);

    Vehicle findById(String id);

    List<Vehicle> search(SearchRequestDto dto);

}
