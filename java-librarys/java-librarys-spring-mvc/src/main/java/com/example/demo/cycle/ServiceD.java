package com.example.demo.cycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuelu.xl on 2020-06-11.
 */
@Service
public class ServiceD implements InitializingBean {

    @Autowired
    private ServiceC serviceC;

    public ServiceD() {
        System.out.println("serviceD construct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ServiceD afterPropertiesSet");
    }
}
