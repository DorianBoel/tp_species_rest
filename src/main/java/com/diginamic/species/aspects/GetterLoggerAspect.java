package com.diginamic.species.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GetterLoggerAspect extends AbstractLoggerAspect {

    @Before("execution(* com.diginamic.species..get*(..))")
    public void logGetterMethod(JoinPoint joinPoint) {
		log(
            String.format(
                "Méthode getter appelée : %s.%s",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName()
            )
        );
    }

}
