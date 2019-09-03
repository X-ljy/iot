package com.ljy.iot.util;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : 夕
 * @date : 2019/8/30
 */
public class DataUtil1 {

    public static String getTimeStamp(String s){
        String a = s.substring(0,2);
        String b = s.substring(2,4);
        String c = s.substring(4,6);
        String d = s.substring(6,8);
        String e = s.substring(8,10);
        String f = s.substring(10,12);
        String res = "20" + a + "-" + b + "-" + c + " " + d + ":" + e + ":" + f ;
        return  res;
    }

    public static String compareAndSwap(int data_flag, String data){
        if(data_flag == 3 || data_flag == 4 || data_flag == 5 || data_flag == 6 ||
                data_flag == 7 || data_flag == 8 || data_flag == 9 ||  data_flag == 32
                || data_flag == 35 || data_flag == 39 || data_flag == 42
                || data_flag == 46 || data_flag == 49){

            if(Integer.parseInt(data ,16)  > Integer.parseInt("8000",16) ){
                data = String.valueOf(Integer.parseInt("8000" ,16)  - Integer.parseInt(data,16));
                data = getFloatData(data_flag,data);
            }else {
                data = new BigInteger(data,16).toString(10);
                data = getFloatData(data_flag,data);
            }

        }else {
            data = new BigInteger(data,16).toString(10);
            data = getFloatData(data_flag,data);
        }
        return  data;
    }

    public static String getFloatData(int flag ,String data){
        if( (flag >= 3 && flag <= 8) || (flag >= 10 && flag <= 13) || (flag >= 17 && flag <= 20 ) || (flag >= 22 && flag <= 26) || flag == 51 ){
            data = String.valueOf(Integer.parseInt(data) * 0.1);
            java.text.DecimalFormat dF = new   java.text.DecimalFormat("0.0");
            data = dF.format(Float.parseFloat(data));
        }

        if(flag == 9 || flag == 15 || flag == 16){
            data = String.valueOf(Integer.parseInt(data) * 0.01);
            java.text.DecimalFormat dF = new   java.text.DecimalFormat("0.00");
            data = dF.format(Float.parseFloat(data));
        }

        if(flag >= 36 && flag <= 49){
            data = String.valueOf(Integer.parseInt(data) * 0.001);
            java.text.DecimalFormat dF = new   java.text.DecimalFormat("0.000");
            data = dF.format(Float.parseFloat(data));
        }
        return data;
    }



}
