package com.rabbin.application.controller;

import com.rabbin.application.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    private HelloService helloService;

    public Hello(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "rabbin") String name) {
        return helloService.hello(name);
    }
}
