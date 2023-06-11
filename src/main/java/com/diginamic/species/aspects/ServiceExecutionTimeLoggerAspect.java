package com.diginamic.species.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExecutionTimeLoggerAspect extends AbstractLoggerAspect {

    @Around("execution(* com.diginamic.species.services.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object methodResult = joinPoint.proceed();
        long execTime = System.currentTimeMillis() - start;

        log(
            String.format(
                "Temps d'exécution de la méthode %s.%s : %dms",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                execTime
            )
        );

        return methodResult;
    }

}
