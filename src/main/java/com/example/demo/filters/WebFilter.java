package com.example.demo.filters;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by vickl on 2018/12/8.
 */
public class WebFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
    try{
        final HttpSession session = request.getSession();
        final Object user2 = session.getAttribute("user");
        if (user2 != null) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String url = request.getRequestURI().toString();
        if (url.endsWith("login") || url.endsWith("index")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
    }catch(IOException e)

        {
            e.printStackTrace();
        }
        response.sendRedirect("index");
    }


    @Override
    public void destroy() {

    }
}
