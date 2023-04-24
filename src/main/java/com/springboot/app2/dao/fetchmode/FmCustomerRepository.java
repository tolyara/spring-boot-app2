package com.springboot.app2.dao.fetchmode;

import com.springboot.app2.entity.fetchmode.FmCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FmCustomerRepository extends JpaRepository<FmCustomer, Long> {

    @Query("select c from FmCustomer c where c.name like concat(?1, '%')")
    List<FmCustomer> findByNameStartingWith(String prefix);

}
