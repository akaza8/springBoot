package com.boot.product;

import org.springframework.stereotype.Component;

@Component
public class MyService {
    public String sayHello() {
        return "Hello World!";
    }
}
