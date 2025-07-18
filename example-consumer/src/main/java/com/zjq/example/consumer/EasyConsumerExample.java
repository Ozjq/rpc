package com.zjq.example.consumer;

import com.zjq.example.common.model.User;
import com.zjq.example.common.service.UserService;
import com.zjq.proxy.ServiceProxyFactory;

public class EasyConsumerExample {
    public static void main(String[] args) {
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

        User user = new User();
        user.setName("qms");
        User newUser = userService.getUser(user);
        if(newUser != null){
            System.out.println(newUser.getName());
        }else {
            System.out.println("user == null");
        }
    }
}
