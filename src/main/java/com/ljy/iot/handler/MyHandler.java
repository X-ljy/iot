package com.ljy.iot.handler;

import com.ljy.iot.config.DataSunConfig;
import com.ljy.iot.config.DecopConfig;
import com.ljy.iot.config.ResponseConfig;
import com.ljy.iot.entity.Entity5015;
import com.ljy.iot.util.DataUtil1;
import com.ljy.iot.util.TSDButil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : 夕
 * @date : 2019/9/8
 */
public class MyHandler extends SimpleChannelInboundHandler {

    private static Logger logger = LoggerFactory.getLogger(MyHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;

        byte[] asciiBytes = new byte[byteBuf.capacity()];
        for (int i = 0; i < byteBuf.capacity(); i++) {
            asciiBytes[i] = byteBuf.getByte(i);
        }
        logger.info("数据ASCII编码处理：" + new String(asciiBytes,"ascii"));

        if( byteBuf.getByte(ResponseConfig.request_type_index) == ResponseConfig.request_type ){
            byte[] bytes = getResponse(byteBuf);
            logger.info("返回应答：" + new String(bytes,"ascii"));
            ctx.writeAndFlush(bytes);
        }

        if(byteBuf.getByte(DataSunConfig.data_type_index) == DataSunConfig.data_type){
            String[] strings = getData(byteBuf);
            Entity5015 entity5015 = new Entity5015(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],
                    strings[7],strings[8],strings[9],strings[10],strings[11],strings[12],strings[13],strings[14],strings[15],
                    strings[16],strings[17],strings[18],strings[19],strings[20],strings[21],strings[22],strings[23],strings[24],
                    strings[25],strings[26],strings[27],strings[28],strings[29],strings[30],strings[31],strings[32],strings[33],
                    strings[34],strings[35],strings[36],strings[37],strings[38],strings[39],strings[40],strings[41],strings[42],
                    strings[43],strings[44],strings[45],strings[46],strings[47],strings[48],strings[49],strings[50],strings[51]);
            TSDButil.doExecuteInsert(entity5015.toSqlString());
        }

        //诱娥心跳数据
        if(byteBuf.getByte(DecopConfig.data_start1_index) == DecopConfig.data_start[DecopConfig.data_start1_index] &&
                byteBuf.getByte(DecopConfig.data_start2_index) == DecopConfig.data_start[DecopConfig.data_start2_index] &&
                byteBuf.getByte(DecopConfig.field_start_index) == DecopConfig.field_start){


            int length = byteBuf.readableBytes();
            byte[] bytes = new byte[length];
            for(int i = 0;i < length; i++){
                bytes[i] = byteBuf.getByte(i);
            }
            logger.info("诱娥心跳数据：" + new String(bytes,"ascii"));

            int start;
            int end;
            start = byteBuf.indexOf(0,length,DecopConfig.field_start);
            end = byteBuf.indexOf(0,length,DecopConfig.field_end);

        }

        //诱娥图片
        if(byteBuf.getByte(DecopConfig.data_start1_index) == DecopConfig.data_start[DecopConfig.data_start1_index] &&
                byteBuf.getByte(DecopConfig.data_start2_index) == DecopConfig.data_start[DecopConfig.data_start2_index] &&
                byteBuf.getByte(DecopConfig.field_start_index) != DecopConfig.field_start ){

                logger.info("诱娥图片");

                if(byteBuf.hasArray()){
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
                    byte[] bytes = byteBuf.array();
                    File dir = new File("\\image\\5017\\");
                    if(!dir.exists()){
                        dir.mkdir();
                    }
                    FileOutputStream fout = new FileOutputStream(new File(dir.getPath() + "\\" + df.format(new Date()) + ".jpg"));
                    //将字节写入文件
                    fout.write(bytes);
                    fout.close();
                }else {
                    int length = byteBuf.readableBytes();
                    byte[] bytes = new byte[length];
                    for (int i = 0;i<length;i++){
                        bytes[i] = byteBuf.getByte(i);
                    }
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
                    File dir = new File("\\image\\5017\\");
                    if(!dir.exists()){
                        dir.mkdir();
                    }
                    FileOutputStream fout = new FileOutputStream(new File(dir.getPath()  + "\\" + df.format(new Date()) + ".jpg"));
                    //将字节写入文件
                    fout.write(bytes);
                    fout.close();
                }

        }



    }

    private byte[] getResponse(ByteBuf byteBuf){
        byte[] bytes = new byte[ResponseConfig.response_length2];
        bytes[ResponseConfig.response_start_flag_index] = ResponseConfig.response_start_flag;
        bytes[ResponseConfig.response_type_index] = ResponseConfig.response_type;
        bytes[ResponseConfig.response_length_index1] = ResponseConfig.response_length1;
        bytes[ResponseConfig.response_length_index2] = ResponseConfig.response_length2;
        for(int i = ResponseConfig.response_id_index;i<(ResponseConfig.request_id_index + ResponseConfig.response_id_length);i++){
            bytes[i] = byteBuf.getByte(i);
        }
        bytes[ResponseConfig.response_end_flag_index] = ResponseConfig.response_end_flag;
        return bytes;
    }

    private String[] getData(ByteBuf byteBuf) throws UnsupportedEncodingException {
        String[] strings = new String[DataSunConfig.data_length];

        //设备标识符
        byte[] id = new byte[DataSunConfig.data_id_length];
        int id_flag = 0;
        String deviceId = null;
        for(int i = DataSunConfig.data_id_index; i < (DataSunConfig.data_id_index + DataSunConfig.data_id_length) ; i++){
            id[id_flag] = byteBuf.getByte(i);
            id_flag++;
        }
        deviceId = new String(id,"ascii");
        logger.info("设备标识符：" + deviceId);
        strings[DataSunConfig.id_flag] = deviceId;

        //设备地址
        int adr_flag = 0;
        byte[] adr_data = new byte[DataSunConfig.data_address_length];
        String deviceAdr = null;
        for(int i = DataSunConfig.data_address_index; i < (DataSunConfig.data_address_index + DataSunConfig.data_address_length);i++){
            adr_data[adr_flag] = byteBuf.getByte(i);
            adr_flag++;
        }
        deviceAdr = new String(adr_data ,"ascii");
        deviceAdr = new BigInteger(deviceAdr,16).toString(10);
        logger.info("设备地址：" + deviceAdr);
        strings[DataSunConfig.address_flag] = deviceAdr;

        //时间戳
        int time_flag = 0;
        byte[] time_data = new byte[DataSunConfig.data_timestamp_length];
        String timeStamp = null;
        for(int i = DataSunConfig.data_timestamp_index; i < (DataSunConfig.data_timestamp_index + DataSunConfig.data_timestamp_length);i++){
            time_data[time_flag] = byteBuf.getByte(i);
            time_flag++;
        }
        timeStamp = new String(time_data ,"ascii");
        logger.info("时间戳：" + timeStamp);
        strings[DataSunConfig.timestamp_flag] = DataUtil1.getTimeStamp(timeStamp);

        //设备具体数据
        int x_flag = 0;
        int data_flag = DataSunConfig.data_field_length -1;
        byte[] data = new byte[DataSunConfig.data_field_length];
        String device_Data = null;
        for(int i = DataSunConfig.data_all_index;i < (DataSunConfig.data_all_index + DataSunConfig.data_all_length);i++){
            data[x_flag] = byteBuf.getByte(i);
            x_flag++;
            if(x_flag > DataSunConfig.data_field_length -1){
                device_Data = new String(data ,"ascii");
                x_flag = 0;
                device_Data = DataUtil1.compareAndSwap(data_flag,device_Data);
                logger.info("设备记录数据：" + device_Data);
                strings[data_flag] = device_Data;
                data_flag++;
            }
        }

        logger.info("数据存储length :" + strings.length);
        return strings;
    }


}
