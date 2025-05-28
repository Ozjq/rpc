package com.zjq.example.common.model;

import java.io.Serializable;

/**
 * 对象需要实现序列化接口，为网络传输序列化提供支持
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
