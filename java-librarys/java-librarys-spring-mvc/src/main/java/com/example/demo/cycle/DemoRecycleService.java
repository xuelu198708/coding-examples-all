package com.example.demo.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by xuelu.xl on 2020-06-10.
 */
@Component
@DependsOn("serviceB")
public class DemoRecycleService {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceC serviceC;
}
