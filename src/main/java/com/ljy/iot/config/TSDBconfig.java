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

    private static String jdbcUrl;

    public  String getJdbcUrl() {
        Properties prop = new Properties();
        try{
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("tsdb.properties");
            prop.load(in);     ///加载属性列表
            host = prop.getProperty("taos.host");
            username  = prop.getProperty("taos.username");
            password = prop.getProperty("taos.password");
            port = Integer.parseInt(prop.getProperty("taos.port"));
            dbName = prop.getProperty("taos.dbname");
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        jdbcUrl = String.format("%s%s:%d/%s?user=%s&password=%s", JDBC_PROTOCAL, host, port, dbName,
                username,password);
        return jdbcUrl;
    }

}
