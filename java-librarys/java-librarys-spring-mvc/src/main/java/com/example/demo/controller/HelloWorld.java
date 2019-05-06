package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuelu
 * 2019-05-06.
 */
@RestController
public class HelloWorld {

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
