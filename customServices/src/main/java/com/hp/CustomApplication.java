package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@EnableCircuitBreaker//开启熔断器
@EnableDiscoveryClient//开启encru注册
@SpringBootApplication*/
@SpringCloudApplication
@EnableFeignClients
public class CustomApplication {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getrestTemplate(){
//        return new RestTemplate();
//    }
    public static void main(String[] args){
        SpringApplication.run(CustomApplication.class,args);
    }
}
