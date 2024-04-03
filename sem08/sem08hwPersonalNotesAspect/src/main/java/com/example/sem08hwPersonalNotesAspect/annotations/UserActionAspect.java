package com.example.sem08hwPersonalNotesAspect.annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class UserActionAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserActionAspect.class);
    @Before("@annotation(com.example.sem08hwPersonalNotesAspect.annotations.TrackUserAction)")
    public void logUserAction (JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("User action = Method : {}, Args : {}", methodName, args);
    }

}
