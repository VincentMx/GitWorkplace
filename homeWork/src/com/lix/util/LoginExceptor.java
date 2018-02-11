package com.lix.util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginExceptor extends HandlerInterceptorAdapter {

    public static  final String[] IGNORE_URI = {
            "/pages/hello.jsp",
            "/login.html",
            "/404.html"
    };
    public boolean preHandle(HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        boolean flag = false;
        String url = request.getRequestURI().toString();
        for (String s : IGNORE_URI){
            if(url.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            String sname = (String)request.getSession().getAttribute("sname");
            if (sname != null){
                flag = true;
            }else{
                request.getRequestDispatcher("/ramdom").forward(request,response);
            }

        }

        return flag;
    }
    public void postHandle(HttpServletRequest request, HttpServletResponse  response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request,response,handler,modelAndView);
    }
}
