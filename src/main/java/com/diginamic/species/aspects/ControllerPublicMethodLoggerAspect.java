package com.diginamic.species.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerPublicMethodLoggerAspect extends AbstractLoggerAspect {

	@Before("execution(public * com.diginamic.species.controllers.*.*(..))")
	public void logMethodName(JoinPoint joinPoint) {
		log(
            String.format(
                "Méthode publique du controller : %s.%s",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName()
            )
        );
	}

}
