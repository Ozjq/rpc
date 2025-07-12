package com.zjq.zjqrpc;

import com.zjq.config.RpcConfig;
import com.zjq.constant.RpcConstant;
import com.zjq.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     *
     * @param newConfig
     */
    public static void init(RpcConfig newConfig) {
        rpcConfig = newConfig;
        log.info("rpcConfig:{}", newConfig.toString());
    }

    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newConfig;
        try {
            newConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            //加载配置失败，使用默认值
            newConfig = new RpcConfig();
        }
        init(newConfig);
    }

    /**
     * 获取配置
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
