package com.cahya.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect untuk membuat aspect
 */
@Aspect
@Component
@Slf4j
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

    /**
     * Method ini akan dieksekusi sebelum method yang ditandai dengan @Pointcut,
     * yaitu helloServiceMethod().
     * <p>
     * Menggunakan parameter join point untuk mendapatkan informasi tentang method.
     */
    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before " + className + "." + methodName + "()");
    }

    /**
     * Jika ini lebih dari satu bisa,
     * asalkan nama methodnya berbeda.
     */
//    @Before("helloServiceMethod()")
//    public void beforeHelloServiceMethod2() {
//        log.info("Before HelloService Method Again");
//    }

    /**
     * Ini contoh Around Aspect
     */
    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        try {
            log.info("Around Before " + className + "." + methodName + "()");
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("Around Error " + className + "." + methodName + "()");
            throw throwable;
        } finally {
            log.info("Around Finally " + className + "." + methodName + "()");
        }
    }

    /**
     * Pointcut Expression Format
     * Ini mengarah pada semua method di class HelloService dengan parameter string.
     */
    @Pointcut("execution(* com.cahya.aop.service.HelloService.* (java.lang.String))")
    public void pointcutHelloServiceStringParam() {
    }

    @Before("pointcutHelloServiceStringParam()")
    public void logStringParameter(JoinPoint joinPoint) {
        String value = joinPoint.getArgs()[0].toString();
        log.info("Execute method with parameter: {}", value);
    }

    /**
     * 3 pointcut baru, untuk test menggabungkan beberapa pointcut
     */
    // mengambil semua method di package com.cahya.aop.service
    @Pointcut("execution(* com.cahya.aop.service.*.*(..))")
    public void pointcutServicePackage() {
    }

    // mengambil bean yang namanya diakhiri dengan Service
    @Pointcut("bean(*Service)")
    public void pointcutServiceBean() {
    }

    // mengambil semua method public
    @Pointcut("execution(public * *(..))")
    public void pointcutPublicMethod() {
    }

    /**
     * Pointcut baru untuk menggabungkan 3 pointcut di atas
     */
    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutPublicMethod())")
    public void publicMethodForService() {
    }

    /**
     * Membuat Advice yang akan dieksekusi sebelum method yang ditandai dengan pointcut
     */
    @Before("publicMethodForService()")
    public void logAllPublicServiceMethod() {
        log.info("Log for all public service method");
    }
}
