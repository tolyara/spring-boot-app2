package com.springboot.app2.entity.fetchmode;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class FmCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<FmOrder> orders = new HashSet<>();

    public FmCustomer(String name, Set<FmOrder> orders) {
        this.name = name;
        this.orders = orders;
    }

    public FmCustomer(String name) {
        this.name = name;
    }

}
