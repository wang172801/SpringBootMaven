package com.hp.controller;

import com.hp.pojo.User;
import com.hp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
@RestController
@RequestMapping("user")
@EnableDiscoveryClient//Eucka客户端
public class UserController {
    //自动注入
    @Autowired
    private UserServices userServices;

    @GetMapping("say")
    public String say(){
        System.out.printf("你好");
        return  "success";
    }
    @GetMapping("/{id}")
    public User selectId(@PathVariable("id") Long i){
        User user=userServices.selectId(i);
        //设置超过四秒
      /*  try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return user;
    }

}
