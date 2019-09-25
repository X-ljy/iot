package com.ljy.iot.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : 夕
 * @date : 2019/9/25
 */
public class TestDecoder extends ByteToMessageDecoder {

    private static Logger logger = LoggerFactory.getLogger(TestDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        logger.info("进入Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
        int length = in.readableBytes();
        int command_index = in.indexOf(0,length,(byte) 0xa2);
        if(command_index >= 4 && length >= 72){
            out.add(in.copy(command_index - 4 ,command_index + 67 + 1));
            in.skipBytes(in.readableBytes());
        }
        logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());


    }
}
