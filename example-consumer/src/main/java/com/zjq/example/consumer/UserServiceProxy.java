package com.zjq.example.consumer;

import com.zjq.example.common.model.User;
import com.zjq.example.common.service.UserService;
import com.zjq.serializer.JdkSerializer;
import com.zjq.serializer.Serializer;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {

    @Override
    public User getUser(User user) {
        Serializer serializer = new JdkSerializer();

        return null;
    }
}
