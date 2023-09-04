package com.springboot.app2.springcore.injection;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService implements InitializingBean {

    private MyOptionalBean myOptionalBean;

    @Autowired
    public void setMyOptionalBean(MyOptionalBean myOptionalBean) {
        this.myOptionalBean = myOptionalBean;
    }

    // from the InitializingBean interface
    @Override
    public void afterPropertiesSet() {
        if (myOptionalBean == null) {
            throw new IllegalStateException("MyOptionalBean must be set in order for service to work");
        }
    }

}
