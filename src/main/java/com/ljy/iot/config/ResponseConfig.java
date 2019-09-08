package com.ljy.iot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : 夕
 * @date : 2019/9/8
 */
public class ResponseConfig {

    public static int request_type_index;
    public static byte request_type;
    public static int  request_id_index;
    public static int  request_id_length;


    public static byte  response_length1;
    public static int  response_length_index1;
    public static byte  response_length2;
    public static int  response_length_index2;
    public static byte  response_start_flag;
    public static int  response_start_flag_index;
    public static byte  response_end_flag;
    public static int  response_end_flag_index;
    public static byte  response_type;
    public static int  response_type_index;
    public static int  response_id_index;
    public static int  response_id_length;


    static {
        Properties properties = new Properties();
        InputStream inputStream = ResponseConfig.class.getClassLoader().getResourceAsStream("response.properties");
        try {
            properties.load(inputStream);
            request_type_index = Integer.parseInt(properties.getProperty("request_type_index"));
            request_type = (byte) Integer.parseInt(properties.getProperty("request_type"),16);
            request_id_index = Integer.parseInt(properties.getProperty("request_id_index"));
            request_id_length = Integer.parseInt(properties.getProperty("request_id_length"));

            response_length1  = (byte) Integer.parseInt(properties.getProperty("response_length1"),16);
            response_length_index1  = Integer.parseInt(properties.getProperty("response_length_index1"));
            response_length2  = (byte) Integer.parseInt(properties.getProperty("response_length2"),16);
            response_length_index2  = Integer.parseInt(properties.getProperty("response_length_index2"));
            response_start_flag   = (byte) Integer.parseInt(properties.getProperty("response_start_flag"),16);
            response_start_flag_index  = Integer.parseInt(properties.getProperty("response_start_flag_index"));
            response_end_flag  = (byte) Integer.parseInt(properties.getProperty("response_end_flag"),16);
            response_end_flag_index  = Integer.parseInt(properties.getProperty("response_end_flag_index"));
            response_type  = (byte) Integer.parseInt(properties.getProperty("response_type"),16);
            response_type_index  = Integer.parseInt(properties.getProperty("response_type_index"));
            response_id_index = Integer.parseInt(properties.getProperty("response_id_index"));
            response_id_length = Integer.parseInt(properties.getProperty("response_id_length"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
