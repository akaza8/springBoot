package com.boot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final MyService myService;
    public MyController() {
        this.myService = null;
    }
    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }
    @GetMapping("/hello")
    public String hello() {
        return myService.sayHello();
    }
}
