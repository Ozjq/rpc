package com.zjq.example.provider;

import com.zjq.example.common.service.UserService;
import com.zjq.registry.LocalRegistry;
import com.zjq.server.HttpServer;
import com.zjq.server.VertxHttpServer;
import com.zjq.zjqrpc.RpcApplication;

public class ProviderExample {
    public static void main(String[] args) {
        //rpc框架初始化
        RpcApplication.init();

        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        //启动web框架
        HttpServer server = new VertxHttpServer();
        server.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
