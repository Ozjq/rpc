package com.zjq.example.provider;

import com.zjq.example.common.service.UserService;
import com.zjq.registry.LocalRegistry;
import com.zjq.server.HttpServer;
import com.zjq.server.VertxHttpServer;

public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        //启动web服务
        HttpServer server = new VertxHttpServer();
        server.doStart(8080);
    }
}
