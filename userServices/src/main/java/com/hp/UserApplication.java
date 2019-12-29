package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.hp.mapper")
@SpringBootApplication
public class UserApplication {
    //启动
    public static void main(String[] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
