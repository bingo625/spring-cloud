package com.example.consumer.hystrix;

import com.example.consumer.remote.HelloRemote1;
import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote1 {
    @Override
    public String hello(String name) {
        return name+" message send fail";
    }
}
