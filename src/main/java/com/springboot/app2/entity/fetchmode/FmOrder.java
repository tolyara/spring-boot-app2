package com.springboot.app2.entity.fetchmode;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
 * Hibernate: select f1_0.id,f1_0.name from fm_customer f1_0
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 * Hibernate: select o1_0.customer_id,o1_0.id,o1_0.name from fm_order o1_0 where o1_0.customer_id=?
 */

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
