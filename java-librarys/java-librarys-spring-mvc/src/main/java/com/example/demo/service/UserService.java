package com.example.demo.service;

import com.example.demo.config.UserProperties;
import com.example.demo.cycle.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuelu
 * 2019-06-04.
 */
@Service
public class UserService {

    @Autowired
    private UserProperties userProperties;

//    @Autowired
    private ServiceB serviceB;

    public String getUserName(){
        return userProperties.getName();
    }

}
