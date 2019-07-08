package com.example.demo.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xuelu
 * 2019-06-04.
 */
@Data
@Component
public class UserProperties {

    @Value(value = "${users.name}")
    private String name;

    public UserProperties() {
        System.out.println("init method!");
    }
}
