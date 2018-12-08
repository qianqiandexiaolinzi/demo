package com.example.demo.config;



import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vickl on 2018/12/6.
 */
public class PermissionInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        try{
            final HttpSession session = httpServletRequest.getSession();
            final Object user2 = session.getAttribute("user");
            if(user2 != null){
                return true;
            }
            String url = httpServletRequest.getRequestURI().toString();
            if(url.endsWith("login") || url.endsWith("index")){
                return true;
            }
            httpServletResponse.sendRedirect("index");
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
