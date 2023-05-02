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
 * https://www.baeldung.com/hibernate-fetchmode
 *
 *  @Fetch(FetchMode.SELECT)
 *
 * The Hibernate FetchMode.SELECT generates a separate query for each Order that needs to be loaded.
 * In our example, that gives one query to load the Customers and five additional queries to load the orders collection.
 * This is known as the n + 1 select problem. Executing one query will trigger n additional queries.
 *
 * For 5 records, each record has one child entity:
 * Hibernate: select f1_0.id,f1_0.name from fm_customer f1_0 where f1_0.name like (?||'%') escape ''
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 *
 * This is known as the n + 1 select problem. Executing one query will trigger n additional queries.
 *
 * @BatchSize
 * FetchMode.SELECT has an optional configuration annotation using the @BatchSize annotation.
 * In our example, we have just five orders so one query is enough.
 *
 * Hibernate: select f1_0.id,f1_0.name from fm_customer f1_0
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id in(?,?,?,?,?)
 *
 * But it will only be run once. Now we have just two queries: One to load the Customer and one to load the orders collection.
 *
 */

@Entity
public class FmCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 5)
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
