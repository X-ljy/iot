package com.ljy.iot;

import com.ljy.iot.server.EchoServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : 夕
 * @date : 2019/8/31
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt("2048");        //1 设置端口值（抛出一个 NumberFormatException 如果该端口参数的格式不正确）
        new EchoServer(port).start();                //2 呼叫服务器的 start() 方法
    }

}
