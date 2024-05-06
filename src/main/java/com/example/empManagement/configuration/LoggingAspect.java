package com.example.empManagement.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.empManagement.controller.*.*(..))")
    private void publicMethodsFromLoggingPackage() {
    }

    @Around("execution(* com.example.empManagement.controller.*.*(..))")
    public Object logBefore(ProceedingJoinPoint pjp) throws Throwable {
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getSignature().getDeclaringTypeName();
//        logger.info("Method execution started: {}", className);
//        String packageName = pjp.getSignature().getDeclaringTypeName();
//        String packageName = pjp.getTarget().getClass().getCanonicalName();
        String packageName = pjp.getSignature().getDeclaringType().getName();;
        String methodName = pjp.getSignature().getName();
        long start = System.currentTimeMillis();
        if(!pjp.getSignature().getName().equals("initBinder")) {
            logger.info("Entering method " + packageName);
        }
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        if(!methodName.equals("initBinder")) {
            logger.info("Exiting method [" + packageName + "." + methodName + "]; exec time (ms): " + elapsedTime);
        }
        return output;
    }

    @After("execution(* com.example.empManagement.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method execution completed: {}", joinPoint.getSignature());
    }
}
