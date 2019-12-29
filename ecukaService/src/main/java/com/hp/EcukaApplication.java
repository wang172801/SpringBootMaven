package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EcukaApplication {

    //启动ecuka
    public static void main(String[] args) {
        SpringApplication.run(EcukaApplication.class,args);
    }
}
