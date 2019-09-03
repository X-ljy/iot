package com.ljy.iot.util;


import com.ljy.iot.config.TSDBconfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

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
            TSDBconfig tsdBconfig = new TSDBconfig();
            String jdbcUrl = tsdBconfig.getJdbcUrl();
            conn = DriverManager.getConnection(jdbcUrl);
            Statement stmt = conn.createStatement();
            logger.info("sql: \n" + sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        TSDButil tester = new TSDButil();
//        tester.doExecuteInsert("insert into test values('2018-06-07 08:00:11.000',0.456)");
//    }


}
