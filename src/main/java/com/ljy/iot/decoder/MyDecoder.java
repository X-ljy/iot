package com.ljy.iot.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : 夕
 * @date : 2019/8/31
 */
public class MyDecoder extends ByteToMessageDecoder {

    private byte start;
    private byte end;

    public MyDecoder(){

    }

    public MyDecoder(byte start,byte end){
        this.start = start;
        this.end = end;
    }

    private static Logger logger = LoggerFactory.getLogger(MyDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        logger.info("进入Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
        if(start != end){
            int length = in.readableBytes();
            int start_flag = in.indexOf(0,length,start);
            int end_flag = in.indexOf(0,length,end);
            logger.info("start_flag: "+ start_flag + ";  end_flag: " + end_flag);
            if( (start_flag >= 0 && end_flag >= 0) && ((end_flag - start_flag) > 0) ){
                out.add(in.copy(start_flag,end_flag - start_flag + 1));
                in.skipBytes(in.readableBytes());
            }
            logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
        }else {
            int length = in.readableBytes();
            int start_flag = in.indexOf(0,length,start);
            if(start_flag < 0) {
                logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
                return;
            }
            int end_flag = in.indexOf(start_flag+1,length-start_flag,end);
            if(end_flag > start_flag){
                logger.info("start_flag: "+ start_flag + ";  end_flag: " + end_flag);
                out.add(in.copy(start_flag,end_flag - start_flag + 1));
                in.skipBytes(in.readableBytes());
            }
            logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
        }
    }
}
