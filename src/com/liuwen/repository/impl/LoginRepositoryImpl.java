package com.liuwen.repository.impl;

import com.liuwen.entity.Reader;
import com.liuwen.repository.LoginRepository;
import com.liuwen.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Liu Wen
 * @create: 2020-02-17 23:06
 * @description: Good good study,day day up!
 **/
public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public Object Login(String username, String password) {
        //获取数据库连接
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from reader where username = ? and password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        //Reader定义在这可以省栈内存
        Reader reader = null;
        try {
            statement =connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                reader = new Reader(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return reader;
    }
}
