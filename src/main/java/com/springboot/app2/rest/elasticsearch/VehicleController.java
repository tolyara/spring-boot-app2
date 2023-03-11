package com.springboot.app2.rest.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Vehicle;
import com.springboot.app2.service.elasticsearch.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public void index(@RequestBody Vehicle vehicle) {
        vehicleService.index(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable String id) {
        return vehicleService.findById(id);
    }

}
