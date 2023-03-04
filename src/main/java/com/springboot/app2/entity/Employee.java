package com.springboot.app2.entity;

import jakarta.persistence.*;

/**
 * https://www.youtube.com/watch?v=YuRO9-rOgv4&ab_channel=kudvenkat - How do SQL Indexes Work
 */

/*
    select * from employees
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
