package com.cahya.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect untuk membuat aspect
 */
@Aspect
@Component
public class LogAspect {
    /**
     * Membuat pointcut untuk semua method di package com.cahya.aop.service
     * Jadi ini niatnya helloServiceMethod() yang akan mengeksekusi semua method di HelloService
     */
    @Pointcut
    public void helloServiceMethod() {

    }
}
