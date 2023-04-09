package com.springboot.app2.entity.fortest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_book_authors")
@Data
@NoArgsConstructor

/**
 * Hibernate Entity class can be declared final, however it is not a good practice.
 * Hibernate uses the proxy pattern for performance improvement during lazy association.
 * By making an entity final, Hibernate will no longer be able to use a proxy as Java doesn't allow the final class to be extended.
 */
public final class TestBookAuthor {
//public class TestBookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

}
