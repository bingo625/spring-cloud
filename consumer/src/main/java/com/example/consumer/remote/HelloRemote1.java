package com.example.consumer.remote;

import com.example.consumer.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name= "spring-cloud-producer",fallback=HelloRemoteHystrix.class)
public interface HelloRemote1 {

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);


}
