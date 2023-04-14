package com.springboot.app2.dao.testing;

import com.springboot.app2.entity.testing.TestAddress;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAddressRepository extends DistributedRepository<TestAddress> {
}
