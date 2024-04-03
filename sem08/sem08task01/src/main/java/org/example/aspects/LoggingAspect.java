package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.model.Comment;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //оборачиваем все классы (.*) и методы(.*) из пакета services
    // и не имеет значения, что мы можем передавать(..)
    // почитать: https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html
    @Around("execution(* org.example.services.*.*(..))")
    @Order(1)
    public Object log (ProceedingJoinPoint joinPoint) throws Throwable{

        // перехватываем данные. .берем адрес метода.берем сигнатуру
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("Method " + methodName
                + " with parameters " + Arrays.asList(arguments)
                + " will execute");

        //сообщение до вызова декорироуемого метода
        logger.info("Method will execute");
        System.out.println("Method will execute");

        Comment comment = new Comment();
        comment.setText("Second comment");
        comment.setAuthor("Bob");
        Object[] newArguments = {comment};


        Object returnedByMethod = joinPoint.proceed(newArguments);
        // сообщение после метода декорируемого метода
        logger.info("Method executed");
        System.out.println("Method executed");


        return returnedByMethod;
    }

    @Around("execution(* org.example.services.*.*(..))")
    @Order(2)
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Method : " + joinPoint.getSignature().getName()
                + " " + elapsedTime + " milliseconds.");
        return result;
    }

    // к ней нужно аннотировать еще и метод
    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Method executed and returned throw annotation: " + returnedValue);;
    }
}
