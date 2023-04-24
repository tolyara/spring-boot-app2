package com.springboot.app2.entity.fetchmode;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@NoArgsConstructor
@Entity
public class FmOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Fetch(FetchMode.SELECT)
    private FmCustomer customer;

    public FmOrder(String name, FmCustomer customer) {
        this.name = name;
        this.customer = customer;
    }

}
