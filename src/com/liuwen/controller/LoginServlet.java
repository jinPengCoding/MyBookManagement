package com.liuwen.controller;

import com.liuwen.entity.Admin;
import com.liuwen.entity.Book;
import com.liuwen.entity.Reader;
import com.liuwen.service.BookService;
import com.liuwen.service.LoginService;
import com.liuwen.service.impl.BookServiceImpl;
import com.liuwen.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: MyBookManagement
 * @description: Good good study,day day up!
 * @author: Liu Wen
 * @create: 2020-02-17 20:11
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();
    private BookService bookService = new BookServiceImpl();
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        //servie层方法调用
        Object object = loginService.login(username,password,type);
        if (object!=null) {
            HttpSession session = req.getSession();
            switch (type){
                case "reader":
                    Reader reader = (Reader) object;
                    session.setAttribute("reader",reader);
                    //跳转到读者Reader首页
                    resp.sendRedirect("/book?page=1");
                    break;
                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin",admin);
                    //跳转到管理员Admin首页
//                    req.getRequestDispatcher("admin.jsp").forward(req,resp);
                    resp.sendRedirect("/admin?method=findAllBorrow&page=1");
                    break;
            }
        }else {
            resp.sendRedirect("login.jsp");
        }
    }
}
