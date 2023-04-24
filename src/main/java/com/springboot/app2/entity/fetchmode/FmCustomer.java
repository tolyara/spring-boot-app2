package com.springboot.app2.entity.fetchmode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *  @Fetch(FetchMode.SELECT)
 *
 * The Hibernate FetchMode.SELECT generates a separate query for each Order that needs to be loaded.
 * In our example, that gives one query to load the Customers and five additional queries to load the orders collection.
 * This is known as the n + 1 select problem. Executing one query will trigger n additional queries.
 *
 * For 3 records, each record has one child entity:
 * Hibernate: select f1_0.id,f1_0.name from fm_customer f1_0
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 *
 *
 *
 */

@Entity
public class FmCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 5)
    @JsonIgnore
    private Set<FmOrder> orders = new HashSet<>();

    public FmCustomer() {
    }

    public FmCustomer(String name, Set<FmOrder> orders) {
        this.name = name;
        this.orders = orders;
    }

    public FmCustomer(String name) {
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

    public Set<FmOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<FmOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "FmCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
