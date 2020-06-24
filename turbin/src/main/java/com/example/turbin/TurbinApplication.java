package com.example.turbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * netflix.turbine 集群监控
 */
@EnableHystrixDashboard
@EnableTurbine     //EnableTurbine注解包含了@EnableDiscoveryClient注解，即开启了注册服务
@SpringBootApplication
public class TurbinApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbinApplication.class, args);
    }

}
