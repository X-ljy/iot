package com.ljy.iot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : 夕
 * @date : 2019/9/8
 */
public class DataSunConfig {

    public static int data_length;

    public static byte data_type;
    public static int data_type_index;

    public static int data_id_index;
    public static int data_id_length;
    public static int id_flag;

    public static int data_address_index;
    public static int data_address_length;
    public static int address_flag;

    public static int data_timestamp_index;
    public static int data_timestamp_length;
    public static int timestamp_flag;

    public static int data_all_index;
    public static int data_all_length;
    public static int data_field_length;
    public static int data_flag;

    static {
        Properties properties = new Properties();
        InputStream inputStream = DataSunConfig.class.getClassLoader().getResourceAsStream("data_sun.properties");
        try {
            properties.load(inputStream);

            data_length = Integer.parseInt(properties.getProperty("data_length"));

            data_type = (byte) Integer.parseInt(properties.getProperty("data_type"),16);
            data_type_index = Integer.parseInt(properties.getProperty("data_type_index"));

            data_id_index = Integer.parseInt(properties.getProperty("data_id_index"));
            data_id_length = Integer.parseInt(properties.getProperty("data_id_length"));
            id_flag = Integer.parseInt(properties.getProperty("id_flag"));

            data_address_index = Integer.parseInt(properties.getProperty("data_address_index"));
            data_address_length = Integer.parseInt(properties.getProperty("data_address_length"));
            address_flag = Integer.parseInt(properties.getProperty("address_flag"));

            data_timestamp_index = Integer.parseInt(properties.getProperty("data_timestamp_index"));
            data_timestamp_length = Integer.parseInt(properties.getProperty("data_timestamp_length"));
            timestamp_flag = Integer.parseInt(properties.getProperty("timestamp_flag"));

            data_all_index = Integer.parseInt(properties.getProperty("data_all_index"));
            data_all_length = Integer.parseInt(properties.getProperty("data_all_length"));
            data_field_length = Integer.parseInt(properties.getProperty("data_field_length"));
            data_flag = Integer.parseInt(properties.getProperty("data_flag"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
