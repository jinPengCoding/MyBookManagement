package com.liuwen.controller;

import com.liuwen.entity.Admin;
import com.liuwen.entity.Borrow;
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
 * @create: 2020-02-19 15:31
 * @description: Good good study,day day up!
 **/
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    // 业务1：借书管理页面
    // 借书处理状态码（0（未审核）,1（审核通过）,2（审核未通过）,3（已归还））
    // 业务2：还书管理页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String method = req.getParameter("method");
       if(method == null){
           method = "findAllBorrow";
       }
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

       switch (method){
            case "findAllBorrow":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Borrow> borrowList = bookService.findAllBorrow(0,page);
                req.setAttribute("list",borrowList);
                req.setAttribute("dataPrePage",10);
                req.setAttribute("currentPage",page);
                req.setAttribute("pages",bookService.getBorrowPagesByState(0));
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            break;
            case "getBorrowed":
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                borrowList = bookService.findAllBorrowByState(1,page);
                req.setAttribute("list",borrowList);
                req.setAttribute("dataPrePage",6);
                req.setAttribute("currentPage",page);
                req.setAttribute("pages",bookService.getBorrowPagesByState(1));
                req.getRequestDispatcher("return.jsp").forward(req,resp);
            break;
            case "handle":            //处理   同意/拒绝
                String idStr = req.getParameter("id");
                String stateStr = req.getParameter("state");
                Integer id = Integer.parseInt(idStr);
                Integer state = Integer.parseInt(stateStr);
                bookService.handleBorrow(id,state,admin.getId());
                if(state == 1 || state == 2){
                    resp.sendRedirect("/admin?page=1");
                }
                if(state == 3){
                    resp.sendRedirect("/admin?method=getBorrowed&page=1");
                }
            break;
       }

    }

    //

}
