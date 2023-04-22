package com.springboot.app2.entity.inheritance.mappedsuperclass;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://www.baeldung.com/hibernate-inheritance
 *
 * Using the MappedSuperclass strategy, inheritance is only evident in the class but not the entity model.
 * Notice that this class no longer has an @Entity annotation, as it won't be persisted in the database by itself.
 * In the database, this will correspond to descendant tables with columns for the declared and inherited fields of the subclass.
 *
 * If we're using this strategy, ancestors cannot contain associations with other entities.
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class InhPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
