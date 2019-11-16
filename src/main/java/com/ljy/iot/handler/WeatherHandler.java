package com.ljy.iot.handler;

import com.ljy.iot.config.TSDBconfig;
import com.ljy.iot.entity.WeatherBean;
import com.ljy.iot.util.CRC;
import com.ljy.iot.util.MyTDengineUtil;
import com.ljy.iot.util.TDengineUtil;
import com.ljy.iot.util.TSDButil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : 夕
 * @date : 2019/11/15
 */
public class WeatherHandler extends SimpleChannelInboundHandler {

    private static Logger logger = LoggerFactory.getLogger(WeatherHandler.class);

    private WeatherBean weatherBean = new WeatherBean();



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;

        int length = byteBuf.readableBytes();
        byte[] bytes = new byte[length];
        for (int k = 0; k < length; k++) {
            bytes[k] = byteBuf.getByte(k);
        }

        System.out.println("bytes length : " + bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(Integer.toHexString(bytes[i]) + " ");
        }
        System.out.println();

        byte[] bytes1 = new byte[70];
        for (int j = 0; j < 70; j++) {
            bytes1[j] = bytes[j];
        }
        byte[] crc = CRC.getCRC(bytes1);

        if (crc[0] == bytes[bytes.length - 2] && crc[1] == bytes[bytes.length - 1]) {

            logger.info("校验成功 ");

            //ts
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(new Date());
            weatherBean.setTs(date);

            //id
            String id = "";
            for (int i = 0; i < 4; i++) {
                String temp = String.valueOf(Integer.parseInt(Integer.toHexString(bytes[i]), 16));
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                id = id + temp;
            }
            weatherBean.setId(id);

            //data
            weatherBean.setWind_speed(getData(bytes[6], bytes[7], 1));
            weatherBean.setRainfall(getData(bytes[8], bytes[9], 1));
            weatherBean.setTemperature(getData(bytes[10], bytes[9], 1));
            weatherBean.setHumidity(getData(bytes[12], bytes[13], 1));
            weatherBean.setIllumination(getData(bytes[14], bytes[15], 1));
            weatherBean.setPhotosynthesis(getData(bytes[16], bytes[17], 1));
            weatherBean.setWind_direction(getData(bytes[18], bytes[19], 0));
            weatherBean.setCo2(getData(bytes[20], bytes[21], 1));
            weatherBean.setPh(getData(bytes[22], bytes[23], 1));
            weatherBean.setSoil_temperature_1(getData(bytes[24], bytes[25], 1));
            weatherBean.setSoil_moisture_1(getData(bytes[26], bytes[27], 1));
            weatherBean.setSoil_temperature_2(getData(bytes[28], bytes[29], 1));
            weatherBean.setSoil_moisture_2(getData(bytes[30], bytes[31], 1));
            weatherBean.setSoil_temperature_3(getData(bytes[32], bytes[33], 1));
            weatherBean.setSoil_moisture_3(getData(bytes[34], bytes[35], 1));
            weatherBean.setConductance(getData(bytes[36], bytes[37], 1));

            logger.info(weatherBean.toString());

            //入库
            TSDButil.doExecuteInsert(weatherBean.toSqlString());

        } else {
            logger.info("校验失败 ");

        }

    }

    private double getData(byte start, byte end, int flag) {

        if (start == 0x7f && end == 0xffffffff) {
            return 0;
        }

        String s = "";
        String e = "";

        if (Integer.toHexString(start).length() == 1) {
            s = "0" + Integer.toHexString(start);
        }

        if (Integer.toHexString(start).length() > 2) {
            s = Integer.toHexString(start).substring(6);
        }

        if (Integer.toHexString(end).length() == 1) {
            e = "0" + Integer.toHexString(end);
        }

        if (Integer.toHexString(end).length() > 2) {
            e = Integer.toHexString(end).substring(6);
        }

        int temp = Integer.parseInt(s + e, 16);

        if (flag == 0) {
            return temp;
        } else {
            return temp / 10.0;
        }

    }
}
