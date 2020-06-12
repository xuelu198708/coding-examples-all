package com.example.demo.aspect;

import com.example.demo.service.ServiceA;
import com.example.demo.service.ServiceC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by xuelu.xl on 2020-06-10.
 */
@Component
public class DemoRecycleService {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceC serviceC;
}
