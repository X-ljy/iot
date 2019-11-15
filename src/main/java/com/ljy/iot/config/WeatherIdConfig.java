package com.ljy.iot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : 夕
 * @date : 2019/11/15
 */
public class WeatherIdConfig {

    public static byte[] id;

    static {
        Properties properties = new Properties();
        InputStream inputStream = ResponseConfig.class.getClassLoader().getResourceAsStream("weatherstation.properties");
        try {
            properties.load(inputStream);
            id = new byte[]{
                    (byte) Integer.parseInt(properties.getProperty("id_1"),16),
                    (byte) Integer.parseInt(properties.getProperty("id_2"),16),
                    (byte) Integer.parseInt(properties.getProperty("id_3"),16),
                    (byte) Integer.parseInt(properties.getProperty("id_4"),16),
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
