package com.example.consummer1.controller;

import com.example.consummer1.remote.HelloRemote2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {

    @Autowired
    HelloRemote2 helloRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

    // hystrix默认1秒超时，下面的随机方法可能让线程睡3秒，从而引发hystrix熔断降级，
    // 观察dashboard界面，有百分比与圆点为红色则说明有熔断
    @HystrixCommand(fallbackMethod = "getNameFallback" ,
            threadPoolKey = "hystrixDemoThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    @RequestMapping("/test")
    public String test(String username){
        randomlyRunLong();
        return "randomlyRunLong"+username;
    }

    // 1/3的机率会让线程睡3秒
    private void randomlyRunLong() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if (randomNum == 3) sleep();
    }

    //线程睡3秒
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 出错后会调用该降级方法，返回指定的信息
     *
     * @param username
     * @return
     */
    public String getNameFallback(String username) {
        return " this username is not exist ";
    }

}
