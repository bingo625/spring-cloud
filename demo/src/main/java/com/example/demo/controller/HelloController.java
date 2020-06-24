package com.example.demo.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        log.info(name);
        return "hello2------- "+name+"，this is first messge";
    }
}