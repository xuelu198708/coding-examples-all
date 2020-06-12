package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by xuelu.xl on 2020-06-11.
 */
@Service
public class ServiceC {

    @Autowired
    private ServiceD serviceD;

    public ServiceC() {
        System.out.println("ServiceC");
    }
}
