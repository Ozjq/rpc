package com.zjq.example.consumer;

import com.zjq.config.RpcConfig;
import com.zjq.utils.ConfigUtils;

public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.printf("rpc :{}", rpc.toString());
    }
}
