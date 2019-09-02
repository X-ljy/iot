package com.ljy.iot.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author : 夕
 * @date : 2019/9/2
 */
public class Test {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world",Charset.forName("utf-8"));
//        for(int i = 0;i<10;i++){
//            byteBuf.writeByte(i);
//        }

//        for(int i =0 ;i < byteBuf.capacity();i++){
//            System.out.println(byteBuf.readByte());
//        }

        for(int i =0 ;i < byteBuf.readableBytes();i++)
        {
            System.out.println(byteBuf.getByte(i));
        }
        System.out.println(byteBuf.maxCapacity());
        System.out.println(byteBuf.capacity());


    }
}
