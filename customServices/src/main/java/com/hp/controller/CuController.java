package com.hp.controller;

import com.hp.client.UserClient;
import com.hp.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController//作用相当于 controller+responseBody
@RequestMapping("custom")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class CuController {
    //注入
    @Autowired
    private UserClient userClient;
   /* @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;*/
    //单查询
   /* @GetMapping("/{i}")
    public User say(@PathVariable("i") Long id){
       User user=restTemplate.getForObject("http://localhost:8889/user/"+id,User.class);
       return user;
    }*/
/*    @GetMapping("/{i}")
    public User say(@PathVariable("i") Long id){
        List<ServiceInstance> instances=discoveryClient.getInstances("userServices");
        ServiceInstance serviceInstance=instances.get(0);
        String url= "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        User user=restTemplate.getForObject(url,User.class);
        return user;
    }*/
    @GetMapping("/{i}")
    public User say(@PathVariable("i") Long id){

        return userClient.say(id);
    }
   //熔断的第一种方法
  /*  @GetMapping("/{i}")
    @HystrixCommand(fallbackMethod = "queryback")
    public String say(@PathVariable("i") Long id){
        String url= "http://userServices/user/"+id;
        String user=restTemplate.getForObject(url,String.class);
        return user;
    }
    public String queryback(Long id){
        return "不好意思，网络拥挤！";
    }*/
    //熔断的第二种方法
  /*  @GetMapping("/{i}")
    @HystrixCommand
    public String say(@PathVariable("i") Long id){
        String url= "http://userServices/user/"+id;
        String user=restTemplate.getForObject(url,String.class);
        return user;
    }
    public String defaultFallback(){
        return "不好意思，网络拥挤！";
    }*/
}
