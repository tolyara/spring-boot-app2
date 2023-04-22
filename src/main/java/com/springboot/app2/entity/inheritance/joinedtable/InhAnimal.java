package com.springboot.app2.entity.inheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://www.baeldung.com/hibernate-inheritance
 *
 * Using this strategy, each class in the hierarchy is mapped to its table.
 * The only column that repeatedly appears in all the tables is the identifier, which will be used for joining them when needed.
 *
 */

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InhAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;

}
