package com.ljy.iot.decoder;

import com.ljy.iot.config.WeatherIdConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : 夕
 * @date : 2019/11/15
 */
public class WeatherDecoder  extends ByteToMessageDecoder {

    private static Logger logger = LoggerFactory.getLogger(WeatherDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        logger.info("进入Decoder的ByteBuf.readableBytes(): " + in.readableBytes());

        int length = in.readableBytes();
        int start_index = in.indexOf(0,length,WeatherIdConfig.id[0]);

        if(     in.getByte(start_index + 1 ) == WeatherIdConfig.id[1] &&
                in.getByte(start_index + 2 ) == WeatherIdConfig.id[2] &&
                in.getByte(start_index + 3 ) == WeatherIdConfig.id[3]) {

            out.add(in.copy(command_index - 4 ,command_index + 67 + 1));
            in.skipBytes(in.readableBytes());

        }


        if(command_index >= 4 && length >= 72){
            out.add(in.copy(command_index - 4 ,command_index + 67 + 1));
            in.skipBytes(in.readableBytes());
        }

        logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
    }
}
