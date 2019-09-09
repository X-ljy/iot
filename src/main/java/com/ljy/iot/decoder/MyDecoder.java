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

    private byte start ;
    private byte end ;

    public MyDecoder(byte start,byte end){
        this.start = start;
        this.end = end;
    }

    private byte[] starts;
    private byte[] ends;

    public MyDecoder(byte[] starts,byte[] ends){
        this.starts = starts;
        this.ends = ends;
    }


    private static Logger logger = LoggerFactory.getLogger(MyDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        logger.info("进入Decoder的ByteBuf.readableBytes(): " + in.readableBytes());

        if(starts == null){
            //开始结束标志符为单字节时
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

            }else{

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

        }else {
            //开始结束标志符为多字节时
            int length = in.readableBytes();

            int start_length = starts.length;
            int[] start_flag = new int[start_length];
            boolean startSuccess = false;

            int end_length = ends.length;
            int[] end_flag = new int[end_length];
            boolean endSuccess = false;

            for(int i =0 ; i < start_length ; i++){
                start_flag[i] = in.indexOf(0,length,starts[i]);
            }


            for(int i = 0;i< start_length -1 ;i++){
                if((start_flag[i] + 1) == start_flag[i+1] ){
                    startSuccess = true;
                }else {
                    startSuccess = false;
                    break;
                }
            }

            if(startSuccess){
                for(int i = 0; i < end_length ; i++){
                    end_flag[i] = in.indexOf(start_flag[start_length-1] + 1 ,length - start_flag[start_length-1],ends[i]);
                }

                for(int i = 0;i< end_length -1 ;i++){
                    if((end_flag[i] + 1) == end_flag[i+1] ){
                        endSuccess = true;
                    }else {
                        endSuccess = false;
                        break;
                    }
                }
            }

            if(startSuccess && endSuccess){
                out.add(in.copy(start_flag[0],end_flag[end_length-1] - start_flag[0] + 1));
                in.skipBytes(in.readableBytes());
                logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
            }else {
                logger.info("退出Decoder的ByteBuf.readableBytes(): " + in.readableBytes());
                return;
            }

        }


    }
}
