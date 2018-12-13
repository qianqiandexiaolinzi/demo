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
	private static final String NOT_FILTERS = ".js,.css,.ico,.jpg,.png,.eot,.svg,.ttf,.woff";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
    try{
    	String url = request.getRequestURI().toString();
    	String suffix = url.substring(url.lastIndexOf(".")+1,url.length());
    	if(NOT_FILTERS.contains(suffix)) {
    		filterChain.doFilter(servletRequest, response);
    		return;
    	}    	
    	
        final HttpSession session = request.getSession();
        final Object user2 = session.getAttribute("user");
        if (user2 != null) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if (url.endsWith("login.html") || url.endsWith("doLogin.json")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
    }catch(IOException e)

        {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/login.html");
    }


    @Override
    public void destroy() {

    }
}
