package com.king.demo.grpc;

import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.king.demo.grpc.GreeterServiceProto.HelloRequest;
import com.king.demo.grpc.GreeterServiceProto.HelloReply;

/**
 * Created by king on 2018/2/1.
 *
 * 服务实现类.
 */

public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        // 解析请求数据
        String name = request.getName();

        LOGGER.debug("请求参数：{}", name);

        // 响应内容
        String replyMessage = "你好，" + name;
        // 构造响应实例
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(replyMessage)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
