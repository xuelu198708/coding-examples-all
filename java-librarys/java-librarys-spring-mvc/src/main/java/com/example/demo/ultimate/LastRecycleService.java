package com.example.demo.ultimate;

import com.example.demo.service.ServiceA;
import com.example.demo.service.ServiceC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xuelu.xl on 2020-06-10.
 */
@Component
public class LastRecycleService {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceC serviceC;
}
