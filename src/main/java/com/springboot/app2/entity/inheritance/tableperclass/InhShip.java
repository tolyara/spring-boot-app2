package com.springboot.app2.entity.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class InhShip extends InhVehicle {

    private String displacement; // water displacement

    public InhShip(String manufacturer, String displacement) {
        super.setManufacturer(manufacturer);
        this.displacement = displacement;
    }
}
