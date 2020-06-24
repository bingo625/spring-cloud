package com.example.consummer1.remote;

import com.example.consummer1.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name= "spring-cloud-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote2 {

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

}
