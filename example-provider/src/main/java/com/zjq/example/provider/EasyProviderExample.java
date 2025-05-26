package com.zjq.example.provider;

import com.zjq.server.HttpServer;
import com.zjq.server.VertxHttpServer;

public class EasyProviderExample {
    public static void main(String[] args) {
        HttpServer server = new VertxHttpServer();
        server.doStart(8080);
    }
}
