package com.iu.iulearn.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ActionAspect {
    private static Logger logger = LoggerFactory.getLogger(ActionAspect.class);

    //    @Around("execution(* com.pyco.pycozza.service..*.*(..))")
    @Around("execution(* com.iu.iulearn..*.*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();

        Object result = null;
        try {
//            logger.info("Start method '{}' with arguments {}", methodName, this.getParameterNames(joinPoint));
            logger.info("Start method '{}' with arguments {}", methodName, joinPoint.getArgs());
            long start = System.currentTimeMillis();
            result = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;
            logger.info("End method '{}' with execution time of '{}' ms", methodName, executionTime);
        } catch (Throwable ex) {
            logger.error("Failed to execute '{}' {}", methodName, ex);
        }
        return result;
    }


    private String getParameterNames(ProceedingJoinPoint joinPoint) {
        CodeSignature codeSig = (CodeSignature)joinPoint.getSignature();
        return String.join(", ", codeSig.getParameterNames());
    }


}
