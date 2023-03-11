package com.springboot.app2.service.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Vehicle;

public interface VehicleService {

    Boolean index(Vehicle vehicle);

}
