package com.erjean.greenojjudgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@SpringBootApplication
@ComponentScan("com.erjean")
public class GreenOJJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenOJJudgeServiceApplication.class, args);
    }

}
