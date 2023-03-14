package com.springboot.app2.service.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Vehicle;
import com.springboot.app2.enums.elasticsearch.DateFormats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DummyDataServiceImpl implements DummyDataService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DateFormats.yyyy_MM_dd);

    private final VehicleService vehicleService;

    @Autowired
    public DummyDataServiceImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void insertVehicleDummyData() {
        vehicleService.index(buildVehicle("1", "Audi A1", "AAA-123", "2010-01-01"));
        vehicleService.index(buildVehicle("2", "Audi A3", "AAB-123", "2011-07-05"));
        vehicleService.index(buildVehicle("3", "Audi A3", "AAC-123", "2012-10-03"));

        vehicleService.index(buildVehicle("4", "BMW M3", "AAA-023", "2021-10-06"));
        vehicleService.index(buildVehicle("5", "BMW 3", "1AA-023", "2001-10-01"));
        vehicleService.index(buildVehicle("6", "BMW M5", "12A-023", "1999-05-08"));

        vehicleService.index(buildVehicle("7", "VW Golf", "42A-023", "1991-04-08"));
        vehicleService.index(buildVehicle("8", "VW Passat", "18A-023", "2021-04-08"));

        vehicleService.index(buildVehicle("9", "Skoda Kodiaq", "28A-023", "2020-01-04"));
        vehicleService.index(buildVehicle("10", "Skoda Yeti", "88A-023", "2015-03-09"));
    }

    private Vehicle buildVehicle(String id, String name, String number, String date) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName(name);
        vehicle.setNumber(number);
        try {
            vehicle.setCreated(DATE_FORMAT.parse(date));
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return vehicle;
    }

}
