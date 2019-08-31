package com.ljy.iot;

/**
 * @author : 夕
 * @date : 2019/8/31
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class PropUtil {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try{
            InputStream in = new BufferedInputStream (new FileInputStream("F:\\java-IDEA\\Java-code\\iot\\src\\main\\resources\\application.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+prop.getProperty(key));
            }
            in.close();

//            FileOutputStream oFile = new FileOutputStream("b.properties", true);//true表示追加打开
//            prop.setProperty("phone", "10086");
//            prop.store(oFile, "The New properties file");
//            oFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
