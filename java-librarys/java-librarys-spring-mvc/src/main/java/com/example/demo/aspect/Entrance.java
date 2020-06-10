package com.example.demo.aspect;

import java.lang.annotation.*;

/**
 * Created by xuelu.xl on 2020-04-28.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Entrance {
}
