package com.liuwen.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: Liu Wen
 * @create: 2020-02-17 23:18
 * @description: Good good study,day day up!
 **/
public class JDBCTools {
    private static DataSource dataSource;
    static{
        dataSource = new ComboPooledDataSource("JdbcTools");
    }

    /**
     * @Description: 获取数据库连接（写成静态方法，方便调用）
      * @param
     * @return java.sql.Connection
     * @date 20.2.17 23:21
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @Description: 释放连接（只是将连接放回数据库连接池中）
      * @param connection
     * @param statement
     * @param resultSet
     * @return void
     * @date 20.2.17 23:25
     */
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection!=null){
                connection.close();
            }
            if(statement!=null){
                connection.close();
            }
            if(resultSet!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
