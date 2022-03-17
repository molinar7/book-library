package com.booklibrary.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class LoggerHelper {

    @Before("execution(* com.booklibrary.controller.*.*(..))")
    public void notifyControllerMethod(JoinPoint joinPoint){
        log.info("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
    }

}
