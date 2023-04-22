package com.springboot.app2.entity.inheritance.singletable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://www.baeldung.com/hibernate-inheritance
 *
 * The Single Table strategy creates one table for each class hierarchy. JPA also chooses this strategy by default if we don't specify one explicitly.
 *
 */

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "inh_product_type", discriminatorType = DiscriminatorType.INTEGER) // by default: "dtype", character varying (31)
public abstract class InhProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
