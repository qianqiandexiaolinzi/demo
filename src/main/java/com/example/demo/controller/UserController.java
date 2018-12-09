package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.bean.ResultJson;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by vickl on 2018/12/3.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("en")
    private String hello(){
        return "/user/login";
    }
    @RequestMapping("hello")
    @ResponseBody
    public String HellWorld(){
        return "HELLO WORLD";
    }
    @RequestMapping("index")
    public String index(){
        return "/user/index";
    }

    @RequestMapping("save")
    @ResponseBody
    public User save(User user){
        return userService.save(user);
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultJson login(String userName,String password, HttpServletRequest httpServletRequest, HttpServletResponse response){


        Map<String,Object> map=new HashMap<>();
        User user1 = userService.findByUserName(userName);
        if(user1 == null){
            return new ResultJson(ResultJson.ERROR,  "此用户不存在");
        }
        if(!password.equals(user1.getPassword())){
            return new ResultJson(ResultJson.ERROR,"密码输入不正确");
        }
        httpServletRequest.getSession().setAttribute("user",user1);
        return new ResultJson(ResultJson.SUCCESS,"验证通过");
    }

    @RequestMapping("logout")
    @ResponseBody
    public String logout(HttpServletResponse response, HttpServletRequest request){
        try {
            final HttpSession session =request.getSession();
            if(session != null){
                session.removeAttribute("user");
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath()+"/user/index");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "注销失败";
    }
}
