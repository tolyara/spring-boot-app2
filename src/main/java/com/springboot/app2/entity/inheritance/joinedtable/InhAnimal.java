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
 * The disadvantage of this inheritance mapping method is that retrieving entities requires joins between tables,
 * which can result in lower performance for large numbers of records.
 *
 * The number of joins is higher when querying the parent class because it will join with every single related child —
 * so performance is more likely to be affected the higher up the hierarchy we want to retrieve records.
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
