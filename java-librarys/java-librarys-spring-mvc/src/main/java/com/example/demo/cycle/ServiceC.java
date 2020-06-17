package com.example.demo.cycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuelu.xl on 2020-06-11.
 */
@Service
public class ServiceC implements InitializingBean {

    @Autowired
    private ServiceD serviceD;

    public ServiceC() {
        System.out.println("ServiceC construct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ServiceC afterPropertiesSet");
    }
}
