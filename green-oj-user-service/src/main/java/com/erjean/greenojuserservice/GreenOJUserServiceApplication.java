package com.erjean.greenojuserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.erjean.greenojuserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@SpringBootApplication
@ComponentScan("com.erjean")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.erjean.greenojserviceclient")
public class GreenOJUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenOJUserServiceApplication.class, args);
    }

}
