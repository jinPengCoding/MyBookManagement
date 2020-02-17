package com.liuwen.repository.impl;

import com.liuwen.repository.LoginRepository;

import java.sql.Connection;

/**
 * @author: Liu Wen
 * @create: 2020-02-17 23:06
 * @description: Good good study,day day up!
 **/
public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public Object Login(String username, String password) {
        //获取数据库连接



        String sql = "select * from reader where username = ? and password = ?";


        //执行数据库查询任务

        //返回一个Reader/Admin对象

        //断开连接

        return null;
    }
}
