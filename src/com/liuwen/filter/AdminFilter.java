package com.liuwen.filter;

import com.liuwen.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: Liu Wen
 * @create: 2020-02-17 21:20
 * @description: Good good study,day day up!         功能和readerFilter一样
 **/
@WebFilter("/admin")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin == null){    //
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
