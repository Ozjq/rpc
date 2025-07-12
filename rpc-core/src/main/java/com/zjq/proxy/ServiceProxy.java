package com.zjq.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.zjq.model.RpcRequest;
import com.zjq.model.RpcResponse;
import com.zjq.serializer.JdkSerializer;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理（服务代理）
 */
public class ServiceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        JdkSerializer serializer = new JdkSerializer();
        //构建请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .args(args)
                .serviceName(method.getDeclaringClass().getName())
                .parameterTypes(method.getParameterTypes())
                .methodName(method.getName())
                .build();
        try{
            //序列化
            byte[] bytes = serializer.serialize(rpcRequest);
            //发送请求
            //todo 这里的地址被硬编码了（需要使用注册中心和服务发现机制解决）
            try(HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bytes)
                    .execute()){
                byte[] result = httpResponse.bodyBytes();
                //反序列化
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return rpcResponse.getData();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
