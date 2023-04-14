package com.springboot.app2.dao.testing;

import com.springboot.app2.entity.testing.TestAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface TestAddressRepository extends DistributedRepository<TestAddress> {
//}

@Repository
public interface TestAddressRepository extends JpaRepository<TestAddress, Long> {
}
