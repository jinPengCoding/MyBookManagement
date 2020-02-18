package com.liuwen.repository.impl;

import com.liuwen.entity.Book;
import com.liuwen.entity.BookCase;
import com.liuwen.repository.BookRepository;
import com.liuwen.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Liu Wen
 * @create: 2020-02-18 16:30
 * @description: Good good study,day day up!
 **/
public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> findAll(int index,int limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from book,bookcase where book.bookcaseid = bookcase.id limit ?,? ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,index);
            statement.setInt(2,limit);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                list.add(new Book(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getFloat(6),
                        new BookCase(resultSet.getInt(9),resultSet.getString(10))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return list;
    }

    /**
     * @Description: 获取数据的总个数
      * @param
     * @return int
     * @date 20.2.18 18:44
     */
    @Override
    public int count() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from book,bookcase where book.bookcaseid = bookcase.id";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        int i =0;
        return count;
    }
}
