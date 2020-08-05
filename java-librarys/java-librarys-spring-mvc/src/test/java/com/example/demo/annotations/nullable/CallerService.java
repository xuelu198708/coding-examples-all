package com.example.demo.annotations.nullable;

import org.junit.Test;

/**
 * Created by xuelu
 * 2020-06-17.
 */
public class CallerService {

    @Test
    public void testHello(){
        NullableService service = new NullableService();
        String hello = service.hello();
        if (hello.equals("xxx")) {
            System.out.println("xxx");
        }

        String hi = service.hi();
        if (hi.equals("xxx")) {
            System.out.println("xxx");
        }

    }
}
