package com.hp.services;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServices {
    //注入mapper
    @Autowired
    private UserMapper userMapper;

    //单查
    public User selectId(Long i){
        User user=userMapper.selectByPrimaryKey(i);
        return user;
    }

}
