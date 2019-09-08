package com.ljy.iot.util;

import com.ljy.iot.config.TSDBconfig;
import com.ljy.iot.entity.TestEntity;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author : 夕
 * @date : 2019/9/5
 */
public class testUtil {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        TDengineUtil tDengineUtil = new TDengineUtil("jdbc:TAOS://49.235.215.208:0/iot","root","taosdata",false);
        TestEntity testEntity = new TestEntity();
        testEntity.setT_ts("2019-08-02 10:05:05");
        testEntity.setT_id(1);
        testEntity.setT_address("test001");
        boolean isSussess = tDengineUtil.insert("test",testEntity);
        if(isSussess){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
}
