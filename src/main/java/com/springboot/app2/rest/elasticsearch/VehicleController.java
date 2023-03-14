package com.springboot.app2.rest.elasticsearch;

import com.springboot.app2.dto.elasticsearch.SearchRequestDto;
import com.springboot.app2.entity.elasticsearch.Vehicle;
import com.springboot.app2.enums.elasticsearch.DateFormats;
import com.springboot.app2.service.elasticsearch.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /*
     * {
     *     "id": "2",
     *     "number": "AAA 2"
     * }
     */
    @PostMapping
    public void index(@RequestBody Vehicle vehicle) {
        vehicleService.index(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable String id) {
        return vehicleService.findById(id);
    }

    /*
     * {
     *     "fields": [
     *         "number"
     *     ],
     *     "searchItem": "AAA"
     * }
     */
    @PostMapping("/search")
    public List<Vehicle> search(@RequestBody SearchRequestDto dto) {
        return vehicleService.search(dto);
    }

    /*
        http://localhost:8080/vehicle/search/2012-03-14
     */
    @GetMapping("/search/{date}")
    public List<Vehicle> search(@PathVariable @DateTimeFormat(pattern = DateFormats.yyyy_MM_dd) Date date) {
        return vehicleService.searchVehiclesCreatedSince(date);
    }

}
