package com.erjean.greenojjudgeservice;

import com.erjean.greenojjudgeservice.rabbitmq.InitRabbitMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@SpringBootApplication
@ComponentScan("com.erjean")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.erjean.greenojserviceclient")
public class GreenOJJudgeServiceApplication {

    public static void main(String[] args) {
        InitRabbitMQ.doInitRabbitMQ();
        SpringApplication.run(GreenOJJudgeServiceApplication.class, args);
    }

}
