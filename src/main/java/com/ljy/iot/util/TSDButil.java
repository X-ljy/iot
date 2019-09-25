package com.ljy.iot.util;


import com.ljy.iot.config.TSDBconfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author : 夕
 * @date : 2019/8/29
 */
public class TSDButil {

    private static Logger logger = LoggerFactory.getLogger(TSDButil.class);

    private static final String TSDB_DRIVER = "com.taosdata.jdbc.TSDBDriver";

    static {
        try {
            Class.forName(TSDB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doExecuteInsert(String sql) {
        Connection conn = null;
        try {
            String jdbcUrl = TSDBconfig.jdbcUrl;
            conn = DriverManager.getConnection(jdbcUrl);
            Statement stmt = conn.createStatement();
            logger.info("sql: \n" + sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void doExecuteQuery(String sql){
        Connection conn = null;
        try {
            String jdbcUrl = TSDBconfig.jdbcUrl;
            conn = DriverManager.getConnection(jdbcUrl);
            Statement stmt = conn.createStatement();
            logger.info("sql: \n" + sql);
//            System.out.println(stmt.executeQuery(sql) == null);
            ResultSet resultSet = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TSDButil.doExecuteQuery("select * from iot.t_iot_sun5015 where ts >= '2019-09-22 16:15:11';");

    }


}
