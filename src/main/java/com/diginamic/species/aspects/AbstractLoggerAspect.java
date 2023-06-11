package com.diginamic.species.aspects;

import java.time.LocalDateTime;

public abstract class AbstractLoggerAspect {

    protected void log(String msg) {

        System.out.println(
            String.format(
                "%s - %s : %s",
                LocalDateTime.now(),
                getClass().getSimpleName(),
                msg
            )
        );

    }

}
