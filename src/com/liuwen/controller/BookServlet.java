package com.liuwen.controller;

import com.liuwen.entity.Book;
import com.liuwen.entity.Borrow;
import com.liuwen.entity.Reader;
import com.liuwen.service.BookService;
import com.liuwen.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String method = req.getParameter("method");
        if(method == null){
            method = "findAll";
        }
        HttpSession session = req.getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        switch (method){
             case "findAll":
                 String pageStr = req.getParameter("page");
                 Integer page =Integer.parseInt(pageStr);
                 List<Book> list = bookService.findAll(page);
                 req.setAttribute("list",list);
                 req.setAttribute("dataPrePage",10);      //每页显示的数据个数 10
                 req.setAttribute("currentPage",page);       //当前页数赋值给 currentPage
                 req.setAttribute("pages",bookService.getPages());
                 req.getRequestDispatcher("index.jsp").forward(req,resp);
             break;
             case "addBorrow":   //图书借阅功能  （往borrow表中添加数据的过程）
                 String bookidStr = req.getParameter("bookid");
                 int bookid =Integer.parseInt(bookidStr);
                 bookService.addBorrow(bookid,reader.getId());
                 resp.sendRedirect("/book?method=findAllBorrow&page=1");
             break;
             case "findAllBorrow":   //展示当前用户的借阅情况（查询当前用户的借阅）
                 pageStr = req.getParameter("page");
                 page  = Integer.parseInt(pageStr);
                 //展示当前用户的所有借书记录
                 List<Borrow> borrowList = bookService.findAllBorrowByReaderId(reader.getId(),page);
                 req.setAttribute("list",borrowList);
                 req.setAttribute("dataPrePage",6);
                 req.setAttribute("currentPage",page);
                 req.setAttribute("pages",bookService.getBorrowPages(reader.getId()));
                 req.getRequestDispatcher("borrow.jsp").forward(req,resp);
             break;
        }











    }
}
