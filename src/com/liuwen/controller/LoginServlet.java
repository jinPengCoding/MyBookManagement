package com.liuwen.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: MyBookManagement
 * @description: Good good study,day day up!
 * @author: Liu Wen
 * @create: 2020-02-17 20:11
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
/**
 * @Description: 这里处理登录业务
  * @param req
 * @param resp
 * @return void
 * @date 20.2.17 22:41
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取拿到的用户(包括姓名、密码、用户类型)


        //servie层方法调用



    }
}
