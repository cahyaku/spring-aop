package com.cahya.aop.test;

import com.cahya.aop.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    void helloService() {
        Assertions.assertEquals("Hello Cahya", helloService.hello("Cahya"));
        Assertions.assertEquals("Bye Cahya", helloService.bye("Cahya"));
    }
}
