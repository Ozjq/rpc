package com.zjq.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.zjq.example.common.model.User;
import com.zjq.example.common.service.UserService;
import com.zjq.model.RpcRequest;
import com.zjq.model.RpcResponse;
import com.zjq.serializer.JdkSerializer;
import com.zjq.serializer.Serializer;

import java.io.IOException;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {

    @Override
    public User getUser(User user) {
        //指定序列化器
        Serializer serializer = new JdkSerializer();
        //发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try{
            byte[] bytes = serializer.serialize(rpcRequest);
            byte[] result;
            try(HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
