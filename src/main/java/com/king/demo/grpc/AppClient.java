package com.king.demo.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by king on 2018/2/1.
 *
 * 客户端
 */
public class AppClient {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 10001;

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(HOST, PORT)
                .usePlaintext(true)
                .build();

        GreeterServiceGrpc.GreeterServiceBlockingStub stub
                = GreeterServiceGrpc.newBlockingStub(channel);

        GreeterServiceProto.HelloRequest request
                = GreeterServiceProto.HelloRequest.newBuilder().setName("AppClient").build();

        GreeterServiceProto.HelloReply helloReply = stub.sayHello(request);

        String message = helloReply.getMessage();

        LOGGER.debug("响应结果：{}", message);
    }
}
