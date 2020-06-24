package com.example.consumer.controller;

import com.example.consumer.remote.HelloRemote1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerTestController {
   /* @Autowired
    private RestTemplate restTemplate;*/
   /* @RequestMapping("/index/{name}")
    public Object index(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:9000/hello?name="+name,String.class);
    }*/


    @Autowired
    HelloRemote1 helloRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }
}
