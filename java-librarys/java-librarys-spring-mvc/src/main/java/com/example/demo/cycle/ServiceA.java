package com.example.demo.cycle;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xuelu.xl on 2020-06-10.
 */
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public ServiceA() {
        System.out.println("ServiceA construct");
    }

    public void sayIt(){
        System.out.println("serviceA say it");
        serviceB.sayIt();
    }

}
