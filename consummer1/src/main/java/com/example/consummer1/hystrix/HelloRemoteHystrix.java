package com.example.consummer1.hystrix;

import com.example.consummer1.remote.HelloRemote2;
import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote2 {
    @Override
    public String hello(String name) {
        return name+" message send fail";
    }
}
