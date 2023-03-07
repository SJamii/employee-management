package com.example.empManagement.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWork {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
   /* @Pointcut("execution(public * com.example.myapp.services.*.*(..))")
    public void serviceMethods() {}

    @Around("serviceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("Method {} took {} ms to execute", joinPoint.getSignature().toShortString(), end - start);
        return result;
    }*/
    @Pointcut("execution(* com.example.empManagement.controller.*.*(..) )")
    public void myPointCut() {}

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String methodName = proceedingJoinPoint.getSignature().getName();  // It will give the method name
        String className = proceedingJoinPoint.getTarget().getClass().toString(); // It will give the class name.
        Object[] params = proceedingJoinPoint.getArgs(); // It will give the parameter.
        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("AOP :: Method {} invoked and took {} ms to execute", methodName, end-start);
        return object;
    }
}
