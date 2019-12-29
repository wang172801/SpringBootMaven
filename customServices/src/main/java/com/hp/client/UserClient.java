package com.hp.client;

import com.hp.callback.FeignBack;
import com.hp.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userServices",fallback = FeignBack.class)
public interface UserClient {
    @GetMapping("user/{i}")
    public User say(@PathVariable("i") Long id);
    //这个实现类 的作用就是拼成
}
