package com.zwl.userssoclient.UserInterceport;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Duration;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

      /*  HttpSession sin =request.getSession();
        sin.setAttribute("login","login"); */


        //检查user.com 中是否有局部session对象
/*        HttpServletRequest.getSession(ture) 等同于 HttpServletRequest.getSession()

        HttpServletRequest.getSession(false) 等同于 如果当前Session没有就为null；*/
        HttpSession session = request.getSession(false);

        if (session !=null && session.getAttribute("login").equals("login")){
            return true;
        }

        return false;
    }
}
