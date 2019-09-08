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
public class testUtil {
    private static final String TSDB_DRIVER = "com.taosdata.jdbc.TSDBDriver";
    static {
        try {
            Class.forName(TSDB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
        MyTDengineUtil tDengineUtil = new MyTDengineUtil("jdbc:TAOS://49.235.215.208:0/iot?user=root&password=taosdata",true);
        TestEntity testEntity = new TestEntity();
        testEntity.setMyTs("2019-09-20 10:05:22");
        testEntity.setMyId(1);
        testEntity.setMyAddress("test001");
        /**
         * 如果sql是select查询语句，返回值为true；
         * 否则是false；
         * 如果语句本身错误会抛出异常。
         */
        boolean isSussess = tDengineUtil.insert("test",testEntity);
        List<TestEntity> testEntity1 = tDengineUtil.getList(" select * from test where my_ts >= '2019-09-20 10:05:20';",TestEntity.class);
        System.out.println(testEntity1.get(1).getMyAddress());
    }

}

