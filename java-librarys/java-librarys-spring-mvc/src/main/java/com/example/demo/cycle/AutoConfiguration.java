package com.example.demo.cycle;

import com.example.demo.cycle.ServiceA;
import com.example.demo.cycle.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuelu.xl on 2020-06-10.
 */
@Configuration
public class AutoConfiguration {

    @Bean
    public ServiceA serviceA(ServiceB serviceB){
        ServiceA serviceA = new ServiceA();
        serviceA.setServiceB(serviceB);
        return serviceA;
    }
}
