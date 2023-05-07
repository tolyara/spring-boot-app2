package com.springboot.app2.service.test.bean;

import com.springboot.app2.entity.test.bean.Bird;

import java.util.List;

public interface BirdService {

    void makeBirdsSound(List<Bird> birds);

}
