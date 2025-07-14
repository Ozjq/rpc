package com.zjq.example.consumer;

import com.zjq.config.RpcConfig;
import com.zjq.example.common.model.User;
import com.zjq.example.common.service.UserService;
import com.zjq.proxy.ServiceProxyFactory;
import com.zjq.utils.ConfigUtils;

public class ConsumerExample {
    public static void main(String[] args) {
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        System.out.printf("rpc :{}", rpc.toString());
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("zjq");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}
