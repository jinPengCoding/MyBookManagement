package com.liuwen.filter;

import com.liuwen.entity.Reader;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: Liu Wen                 判断页面登录用户是否存在与session中，若不存在则跳转到登录页面
 * @create: 2020-02-17 21:21
 * @description: Good good study,day day up!
 **/
@WebFilter("/book")
public class ReaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Reader reader =(Reader)session.getAttribute("reader");
        if(reader == null){
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void destroy() {
    }
}
