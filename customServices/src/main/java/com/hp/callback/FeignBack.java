package com.hp.callback;

import com.hp.client.UserClient;
import com.hp.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class FeignBack implements UserClient {

    @Override
    public User say(Long id) {
        User user=new User();
        user.setUsername("biubiu");
        return user;
    }
}
