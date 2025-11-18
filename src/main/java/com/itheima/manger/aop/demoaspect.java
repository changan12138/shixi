package com.itheima.manger.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
//@Component
public class demoaspect {
    @Around("execution(* com.itheima.manger.service.ClazzServiceImpi.*(..))")
    public Object recordtime(ProceedingJoinPoint joinPoint) throws Throwable {
        long bgein = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("执行耗时：{}ms" ,end-bgein);
        return result;
    }
}
