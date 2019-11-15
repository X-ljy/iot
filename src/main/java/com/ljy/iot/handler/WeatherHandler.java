package com.ljy.iot.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : 夕
 * @date : 2019/11/15
 */
public class WeatherHandler extends SimpleChannelInboundHandler {

    private static Logger logger = LoggerFactory.getLogger(WeatherHandler.class);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;


    }
}
