package com.zjq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RpcRequest implements Serializable {
    //服务名
    private String serviceName;
    //方法名
    private String methodName;
    //参数类型列表
    private Class<?>[] parameterTypes;
    //参数列表
    private Object[] args;
}
