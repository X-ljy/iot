package com.ljy.iot.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author : 夕
 * @date : 2019/9/8
 */
public class MyHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        if(byteBuf.hasArray()){
            byte[] bytes = byteBuf.array();
            String str = new String (bytes,"ascii");
            System.out.println(str);
        }else {
            int length = byteBuf.readableBytes();
            byte[] bytes = new byte[length];
            for(int i = 0;i<length;i++){
                bytes[i] = byteBuf.getByte(i);
            }
            String str = new String (bytes,"ascii");
            System.out.println(str);
        }
    }
}
