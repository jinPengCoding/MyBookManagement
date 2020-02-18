package com.liuwen.controller;

import com.liuwen.entity.Book;
import com.liuwen.service.BookService;
import com.liuwen.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: Liu Wen
 * @create: 2020-02-18 16:25
 * @description: Good good study,day day up!
 **/
@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    /**
     * @Description: 获取图书信息加载在首页
      * @param req
     * @param resp
     * @return void
     * @date 20.2.18 16:26
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> list = bookService.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
