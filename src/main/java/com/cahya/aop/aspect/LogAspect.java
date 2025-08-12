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
     * Jadi ini niatnya helloServiceMethod() yang akan mengeksekusi semua method di
     * Jadi yang di targetkan adalah semua method di class HelloService
     * => package com.cahya.aop.service.HelloService
     * Ingat classnya harus sebagai spring bean
     */
    @Pointcut("target(com.cahya.aop.service.HelloService)")
    public void helloServiceMethod() {

    }
}
