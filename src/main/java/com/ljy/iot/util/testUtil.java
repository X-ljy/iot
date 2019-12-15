package com.ljy.iot.util;

import com.ljy.iot.config.TSDBconfig;
import com.ljy.iot.entity.TestEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : 夕
 * @date : 2019/9/5
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;


public class testUtil {

    /*public static void main(String[] args){
        System.out.println("****\\\\");
        String str = "a\\b\\b\\c.csv|aaaaa";
        String[] chars = str.split("\\\\");
        String[] fileName = chars[3].split("\\.");// u002e
        String[] tmp = chars[3].split("\\u007c");//  \\u007c
        for(String cha:chars){
            System.out.println(cha);
        }
        System.out.println(fileName[0]);
        System.out.println(tmp[1]);
    }*/

    public static void main(String args[])
    {
        StringBuffer fileBuf=new StringBuffer();
        String filePar = "d:"+System.getProperty("file.separator")+"test" + System.getProperty("file.separator") + "aava";// 文件夹路径
        File myPath = new File( filePar );
        if ( !myPath.exists()){//若此目录不存在，则创建之
            myPath.mkdir();
            System.out.println("创建文件夹路径为："+ filePar);
        }
        // 文件夹路径存在的情况下
        String filename = "test.txt";// 文件名
        try {
            FileWriter fw = new FileWriter(filePar + System.getProperty("file.separator") + filename,true);// filePar + "\\" + filename,true
            // FileWriter 就是牛，如果文件名 的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            String originalLine = "aaaaaaaaaa" + "\n";//
            System.out.println("*** "+ originalLine);
            fw.write(originalLine);
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

