package com.springboot.app2.entity.inheritance.tableperclass;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://www.baeldung.com/hibernate-inheritance
 *
 * The resulting schema is similar to the one using @MappedSuperclass.
 * But Table per Class will indeed define entities for parent classes, allowing associations and polymorphic queries as a result.
 *
 * This is not that different from merely mapping each entity without inheritance.
 * The distinction is clear when querying the base class, which will return all the subclass records as well by using a UNION statement in the background.
 *
 * The use of UNION can also lead to inferior performance when choosing this strategy.
 * Another issue is that we can no longer use identity key generation.
 *
 */

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class InhVehicle {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // org.hibernate.MappingException: Cannot use identity column key generation with <union-subclass> mapping for: com.springboot.app2.entity.inheritance.tableperclass.InhVehicle
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String manufacturer;

}
