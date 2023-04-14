package com.springboot.app2.dao.testing;

import com.springboot.app2.entity.testing.TestPerson;
import org.springframework.stereotype.Repository;

@Repository
public interface TestPersonRepository extends DistributedRepository<TestPerson> {
}
