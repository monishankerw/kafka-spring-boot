package com.aop_service.aspect;


import com.aop_service.annotations.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogExecutionAspect {

    @Around("@annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();  // Proceed with method execution
        long executionTime = System.currentTimeMillis() - start;

        log.info("Executed method {} in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
