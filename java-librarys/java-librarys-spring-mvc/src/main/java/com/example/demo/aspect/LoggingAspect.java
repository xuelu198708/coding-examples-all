package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by xuelu.xl on 2020-04-28.
 */
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(com.example.demo.aspect.Entrance)")
    public void entrances(){}

    @Pointcut("execution(* com.example.demo.service..*.*(..))")
    public void services(){}

    @Before("entrances() || services()")
    public void loggingAdvice(){
        System.out.println("entrance");
    }

}
