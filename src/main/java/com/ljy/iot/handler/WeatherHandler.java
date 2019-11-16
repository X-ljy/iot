package com.ljy.iot.handler;

import com.ljy.iot.entity.WeatherBean;
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
 * @date : 2019/11/15
 */
public class WeatherHandler extends SimpleChannelInboundHandler {

    private static Logger logger = LoggerFactory.getLogger(WeatherHandler.class);

    private WeatherBean weatherBean;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;

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
        byte[] crc = CRC.getCRC(bytes1);

        if(crc[0] == bytes[bytes.length-2] && crc[1] == bytes[bytes.length-1]){

            logger.info("校验成功 ");

            weatherBean.setTs();

            for(int i = 6;i < 38 ;i++){

                if(Integer.toHexString(bytes[i]).length() > 3){
                    System.out.print(Integer.parseInt(Integer.toHexString(bytes[i]).substring(6),16)+" ");
                }else {
                    System.out.print(Integer.parseInt(Integer.toHexString(bytes[i]),16)+" ");
                }
            }

        }else {
            logger.info("校验失败 ");

        }


    }
}
