package com.ljy.iot.handler;

import com.ljy.iot.util.CRC;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

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

        int length = byteBuf.readableBytes();
        byte[] bytes = new byte[length];
        for(int k=0;k<length;k++){
            bytes[k] = byteBuf.getByte(k);
        }

        System.out.println("bytes length : " + bytes.length );
        for(int i = 0;i<bytes.length;i++){
            System.out.print(Integer.toHexString(bytes[i]) + " ");
        }
        System.out.println();
        byte[] bytes1 = new byte[70];
        for(int j = 0;j < 70 ;j++){
            bytes1[j] = bytes[j];
        }
        byte[] bytes2 = CRC.getCRC(bytes1);

        if(bytes2[0] == bytes[bytes.length-2] && bytes2[1] == bytes[bytes.length-1]){

            logger.info("校验成功 ");

            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR) - 2000;
            int month = now.get(Calendar.MONTH) + 1;
            int day = now.get(Calendar.DAY_OF_MONTH);
            int hour = now.get(Calendar.HOUR_OF_DAY);
            int minute = now.get(Calendar.MINUTE);
            int second =  now.get(Calendar.SECOND);

            byte[] time = new byte[]{(byte) year, (byte) month, (byte) day, (byte) hour, (byte) minute, (byte) second};

            byte[] temp = new byte[]{bytes[0],bytes[1],bytes[2],bytes[3],
                                            (byte)0xa2,(byte)0x06,
                                            time[0],time[1],time[2],time[3],time[4],time[5]};
            byte[] tempEnd = CRC.getCRC(temp);

            byte[] responseByte = new byte[]{bytes[0],bytes[1],bytes[2],bytes[3],
                                                 (byte)0xa2,(byte)0x06,
                                            time[0],time[1],time[2],time[3],time[4],time[5],
                                            tempEnd[0],tempEnd[1]};
            ByteBuf out = Unpooled.buffer(128);
            out.writeBytes(responseByte);
            ctx.writeAndFlush(out);


        }else {
            logger.info("校验失败 ");
        }

    }


}
