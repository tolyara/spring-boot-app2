package com.springboot.app2.service.testing;

import com.springboot.app2.dao.testing.TestAddressRepository;
import com.springboot.app2.entity.testing.TestAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAddressService {

    private final TestAddressRepository addressRepository;

    @Autowired
    public TestAddressService(TestAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public TestAddress createAddress(String name) {
        TestAddress newAddress = new TestAddress();
        newAddress.setName(name);
        return addressRepository.save(newAddress);
    }

    public TestAddress findAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

}
