package com.springboot.app2.entity.testing;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_persons")
@Data
@NoArgsConstructor
public class TestPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "test_address_id", nullable = false)
    private TestAddress address;

}
