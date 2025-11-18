package com.itheima.manger.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class myaspect {
    @Pointcut("execution(* com.itheima.manger.service.ClazzServiceImpi.*(..))")
    public void pointcut() {}


    @Around("pointcut() c")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("环绕前");
        Object result = joinPoint.proceed();
        log.info("环绕后");
        return result;
    }
    @Before("@annotation(com.itheima.manger.aop.Log)")
    public void before()  {
        log.info("before");
    }

    @After("execution(* com.itheima.manger.service.ClazzServiceImpi.*(..))")
    public void after(JoinPoint joinPoint)  {
        //目标类名
        String name = joinPoint.getTarget().getClass().getName();

        //方法签名
        Signature methodName = joinPoint.getSignature();

         //方法名
        String methname = methodName.getName();

        //方法参数
        Object[] args = joinPoint.getArgs();
        // 推荐：统一用日志 + 占位符 + deepToString
        log.info("[AFTER] name={},methname={}, methodName={}, args={}",
                name, methodName,methname, Arrays.deepToString(args));
        log.info("after");
    }
    @AfterReturning("execution(* com.itheima.manger.service.ClazzServiceImpi.*(..))")
    public void afterReturning()  {
        log.info("afterReturning");
    }
    @AfterThrowing("execution(* com.itheima.manger.service.ClazzServiceImpi.*(..))")
    public void afterThrowing()  {
        log.info("afterThrowing");
    }
}
