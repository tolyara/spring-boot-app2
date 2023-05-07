package com.springboot.app2.service.test.bean;

import com.springboot.app2.entity.test.bean.Bird;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdServiceImpl implements BirdService {

    @Override
    public void makeBirdsSound(List<Bird> birds) {
        birds.forEach(Bird::makeSound);
    }

}
