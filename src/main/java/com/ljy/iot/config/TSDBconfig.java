package com.ljy.iot.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author : 夕
 * @date : 2019/8/31
 */
public class TSDBconfig {

    private static final String JDBC_PROTOCAL = "jdbc:TAOS://";

    private static String host ;
    private static String username;
    private static String password ;
    private static int port;
    private static String dbName;

    public static String jdbcUrl;

    static {
        Properties prop = new Properties();
        try{
            //在static方法中，通过类加载器得到配置文件
            InputStream in = TSDBconfig.class.getClassLoader().getResourceAsStream("tsdb.properties");
            prop.load(in);     ///加载属性列表
            host = prop.getProperty("taos.host");
            username  = prop.getProperty("taos.username");
            password = prop.getProperty("taos.password");
            port = Integer.parseInt(prop.getProperty("taos.port"));
            dbName = prop.getProperty("taos.dbname");
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        jdbcUrl = String.format("%s%s:%d/%s?user=%s&password=%s", JDBC_PROTOCAL, host, port, dbName,
                username,password);
    }


}
