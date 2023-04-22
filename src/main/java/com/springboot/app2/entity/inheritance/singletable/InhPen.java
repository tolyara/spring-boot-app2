package com.springboot.app2.entity.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("2")
public class InhPen extends InhProduct {

    private String color;

    public InhPen(String name, String color) {
        super.setName(name);
        this.color = color;
    }

}
