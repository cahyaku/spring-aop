package com.cahya.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy untuk mengaktifkan dukungan AOP berbasis anotasi.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }
}
