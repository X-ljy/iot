package com.ljy.iot.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : 夕
 * @date : 2019/9/25
 */
public class TestHandler extends SimpleChannelInboundHandler {

    private static Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        byte[] asciiBytes = new byte[byteBuf.capacity()];
        for (int i = 0; i < byteBuf.capacity(); i++) {
            asciiBytes[i] = byteBuf.getByte(i);
        }
        logger.info("数据ASCII编码处理：" + new String(asciiBytes,"ascii"));

    }
}
