package com.ljy.iot.handler;

import com.ljy.iot.entity.Entity5015;
import com.ljy.iot.util.DataUtil2;
import com.ljy.iot.util.TSDButil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * @author : 夕
 * @date : 2019/8/8
 */
@ChannelHandler.Sharable                                        //1 @Sharable 标识这类的实例之间可以在 channel 里面共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(EchoServerHandler.class);


    @Override
    public void channelRead(ChannelHandlerContext ctx,
                            Object msg) throws UnsupportedEncodingException {
        logger.info("------------------------------");
        ByteBuf in = (ByteBuf) msg;
        logger.info("服务端接收数据: " + in.toString());

        String[] strings = null;
        if(in.getByte(0) == 0x7b && in.getByte(1) == 0x09){

            //存储数据容器
            strings = new String [52];

            //时间戳
            int time_flag = 0;
            byte[] time_data = new byte[12];
            String timeStamp = null;
            for(int i = 24; i < 36;i++){
                time_data[time_flag] = in.getByte(i);
                time_flag++;
                if(time_flag > 11){
                    timeStamp = new String(time_data ,"ascii");
                    logger.info("时间戳：" + timeStamp);
                }
            }
            strings[0] = DataUtil2.getTimeStamp(timeStamp);

            //设备标识符
            byte[] id = new byte[11];
            int id_flag = 0;
            String deviceId = null;
            for(int i = 4; i < 15 ; i++){
                id[id_flag] = in.getByte(i);
                id_flag++;
            }
            deviceId = new String(id,"ascii");
            logger.info("设备标识符：" + deviceId);
            strings[1] = deviceId;


            //设备地址
            int adr_flag = 0;
            byte[] adr_data = new byte[4];
            String deviceAdr = null;
            for(int i = 16; i < 20;i++){
                adr_data[adr_flag] = in.getByte(i);
                adr_flag++;
                if(adr_flag > 3){
                    deviceAdr = new String(adr_data ,"ascii");
                    logger.info("地址：" + deviceAdr);
                    adr_flag = 0;
                }
            }
            deviceAdr = new BigInteger(deviceAdr,16).toString(10);
            strings[2] = deviceAdr;

            int x_flag = 0;
            int data_flag = 3;
            byte[] data = new byte[4];
            String device_Data = null;
            for(int i = 36;i < 232;i++){
                data[x_flag] = in.getByte(i);
                x_flag++;
                if(x_flag > 3){
                    device_Data = new String(data ,"ascii");
                    x_flag = 0;
                    device_Data = DataUtil2.compareAndSwap(data_flag,device_Data);
                    logger.info("设备记录数据：" + device_Data);
                    strings[data_flag] = device_Data;
                    data_flag++;
                }
            }
        }
        if(strings != null){
            logger.info("数据存储length :" + strings.length);
            Entity5015 entity5015 = new Entity5015(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],
                    strings[7],strings[8],strings[9],strings[10],strings[11],strings[12],strings[13],strings[14],strings[15],
                    strings[16],strings[17],strings[18],strings[19],strings[20],strings[21],strings[22],strings[23],strings[24],
                    strings[25],strings[26],strings[27],strings[28],strings[29],strings[30],strings[31],strings[32],strings[33],
                    strings[34],strings[35],strings[36],strings[37],strings[38],strings[39],strings[40],strings[41],strings[42],
                    strings[43],strings[44],strings[45],strings[46],strings[47],strings[48],strings[49],strings[50],strings[51]);
            TSDButil.doExecuteInsert(entity5015.toSqlString());
        }

        int flag = 0;
        byte[] bytes = new byte[in.capacity()];
        for (int i = 0; i < in.capacity(); i++) {
            if(in.getByte(i) == 0x7b){
                flag ++;
            }
            if(flag <= 2){
                byte b = in.getByte(i);
                bytes[i] = b;
                if(flag == 2){
                    flag = 3;
                }
            }
        }
        logger.info("数据ASCII编码处理：" + new String(bytes,"ascii"));
        //构建返回消息

//        //5016
//        byte[] bytes1 = new byte[]{(byte) 0x7B, (byte) 0x81, (byte) 0x00 ,(byte) 0x10,
//                (byte) 0x34, (byte) 0x30, (byte) 0x33, (byte) 0x32, (byte) 0x36, (byte) 0x39, (byte) 0x30, (byte) 0x34, (byte) 0x39, (byte) 0x36, (byte) 0x34,
//                (byte) 0x7B};

//        5015
        byte[] bytes1 = new byte[]{(byte) 0x7B, (byte) 0x81, (byte) 0x00 ,(byte) 0x10,
                (byte) 0x34, (byte) 0x30, (byte) 0x33, (byte) 0x37, (byte) 0x38, (byte) 0x35, (byte) 0x31, (byte) 0x30, (byte) 0x30, (byte) 0x35, (byte) 0x34,
                (byte) 0x7B};
        ByteBuf out =  Unpooled.buffer(128);
        out.writeBytes(bytes1);
        ctx.writeAndFlush(out);                            //3 将所接收的消息返回给发送者。
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();                //5  打印异常堆栈跟踪
        ctx.close();                            //6 关闭通道
    }
}