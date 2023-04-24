package com.springboot.app2.dao.fetchmode;

import com.springboot.app2.entity.fetchmode.FmCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FmCustomerRepository extends JpaRepository<FmCustomer, Long> {
}
