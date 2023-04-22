package com.springboot.app2.entity.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class InhMammal extends InhAnimal {

    private String numberOfPaws;

    public InhMammal(String species, String numberOfPaws) {
        super.setSpecies(species);
        this.numberOfPaws = numberOfPaws;
    }
}
