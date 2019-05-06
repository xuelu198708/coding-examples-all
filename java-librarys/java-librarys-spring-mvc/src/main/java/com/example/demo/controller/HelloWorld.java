package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xuelu
 * 2019-05-06.
 */
@Slf4j
@RestController
public class HelloWorld {

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

    @RequestMapping(value = "/helloList", method = RequestMethod.POST)
    public String helloList(@RequestBody User user){
        log.info(JSON.toJSONString(user));
        return "helloList";
    }

    @Data
    static class User{
        private int id;
        private String value;
        private List<Phone> phones;
    }

    @Data
    static class Phone{
        private String areaCode;
        private String telephone;
    }
}
