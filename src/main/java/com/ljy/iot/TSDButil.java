package com.ljy.iot;


import java.sql.*;

/**
 * @author : 夕
 * @date : 2019/8/29
 */
public class TSDButil {

    private static final String JDBC_PROTOCAL = "jdbc:TAOS://";
    private static final String TSDB_DRIVER = "com.taosdata.jdbc.TSDBDriver";

    private String host = "49.235.215.208";
    private String user = "root";
    private String password = "taosdata";
    private int port = 0;
    private String jdbcUrl = "";

    static {
        try {
            Class.forName(TSDB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doMakeJdbcUrl() {
        // jdbc:TSDB://127.0.0.1:0/dbname?user=root&password=taosdata
        this.jdbcUrl = String.format("%s%s:%d/%s?user=%s&password=%s", JDBC_PROTOCAL, this.host, this.port, "",
                this.user, this.password);
        System.out.println("JDBC连接URL：" + this.jdbcUrl);
    }
    public void doExecuteInsert(String sql) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl);
            Statement stmt = conn.createStatement();
            System.out.println("sql: \n" + sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        TSDButil tester = new TSDButil();
//        tester.doMakeJdbcUrl();
//        tester.doExecuteInsert("insert into db.t0 values(1519833600000,0)(1519833600001,1)(1519833600002,2)(1519833600003,3)(1519833600004,4)(1519833600005,5)(1519833600006,6)(1519833600007,7)(1519833600008,8)(1519833600009,9)");
//    }


}
