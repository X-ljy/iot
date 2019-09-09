package com.ljy.iot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.IntPredicate;

/**
 * @author : 夕
 * @date : 2019/9/9
 */
public class DecopConfig {

    public static byte[] data_start;
    public static byte[] data_end;
    public static byte field_start;
    public static byte field_end;

    public static int data_start1_index;
    public static int data_start2_index;
    public static int field_start_index;

    static {
        Properties properties = new Properties();
        InputStream inputStream = DecopConfig.class.getClassLoader().getResourceAsStream("decoy.properties");
        try {
            properties.load(inputStream);

            byte data_start1  = (byte) Integer.parseInt(properties.getProperty("data_start1"),16);
            byte data_start2  = (byte) Integer.parseInt(properties.getProperty("data_start2"),16);
            data_start = new byte[]{data_start1,data_start2};

            byte data_end1  = (byte) Integer.parseInt(properties.getProperty("data_end1"),16);
            byte data_end2  = (byte) Integer.parseInt(properties.getProperty("data_end2"),16);
            data_end = new byte[]{data_end1,data_end2};

            field_start  = (byte) Integer.parseInt(properties.getProperty("field_start"),16);
            field_end  = (byte) Integer.parseInt(properties.getProperty("field_end"),16);

            data_start1_index = Integer.parseInt(properties.getProperty("data_start1_index"));
            data_start2_index = Integer.parseInt(properties.getProperty("data_start2_index"));
            field_start_index = Integer.parseInt(properties.getProperty("field_start_index"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
