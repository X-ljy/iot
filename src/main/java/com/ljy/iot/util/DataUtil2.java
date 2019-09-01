package com.ljy.iot.util;

import java.math.BigInteger;

/**
 * @author : 夕
 * @date : 2019/9/1
 */
public class DataUtil2 {

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
        if( (data_flag >= 3 && data_flag <= 9) || data_flag == 21 || data_flag == 24 ||  data_flag == 35
                || data_flag == 38 || data_flag == 45 || data_flag == 48 ) {

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
        if( (flag >= 3 && flag <= 8) || (flag >= 10 && flag <= 16) || (flag >= 26 && flag <= 29 ) || flag == 39 || flag == 50 ){
            data = String.valueOf(Integer.parseInt(data) * 0.1);
            java.text.DecimalFormat dF = new   java.text.DecimalFormat("0.0");
            data = dF.format(Float.parseFloat(data));
        }

        if(flag == 9 ){
            data = String.valueOf(Integer.parseInt(data) * 0.01);
            java.text.DecimalFormat dF = new   java.text.DecimalFormat("0.00");
            data = dF.format(Float.parseFloat(data));
        }

        if( (flag >= 31 && flag <= 38) || (flag >= 41 && flag <= 48) ){
            data = String.valueOf(Integer.parseInt(data) * 0.001);
            java.text.DecimalFormat dF = new   java.text.DecimalFormat("0.000");
            data = dF.format(Float.parseFloat(data));
        }
        return data;
    }
}
