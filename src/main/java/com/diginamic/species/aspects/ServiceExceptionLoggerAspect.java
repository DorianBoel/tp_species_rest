package com.diginamic.species.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExceptionLoggerAspect extends AbstractLoggerAspect {

    @AfterThrowing(value = "execution(* com.diginamic.species.services.*.*(..))", throwing = "exception")
    public void logServiceException(JoinPoint joinPoint, Exception exception) {
        log(
            String.format(
                "Exception dans %s.%s : (%s) %s",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                exception.getClass().getSimpleName(),
                exception.getMessage()
            )
        );
    }

}
