package com.king.demo.grpc;

import io.grpc.ServerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * 服务端
 */

public class AppServer {

    private static final int PORT = 10001;

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        try {
            ServerBuilder.forPort(PORT)
                    // 注册服务
                    .addService(new GreeterServiceImpl())
                    .build()
                    .start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.debug("服务已启动");

        while (true) {
        }

    }
}
