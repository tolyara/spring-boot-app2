package com.springboot.app2.entity.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class InhCar extends InhVehicle {

    private String engineType;

    public InhCar(String manufacturer, String engineType) {
        super.setManufacturer(manufacturer);
        this.engineType = engineType;
    }
}
