package com.springboot.app2.entity.inheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class InhBird extends InhAnimal {

    private String numberOfWings;

    public InhBird(String species, String numberOfWings) {
        super.setSpecies(species);
        this.numberOfWings = numberOfWings;
    }
}
