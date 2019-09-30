package com.lyf.utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 该类用于匹配Servlet中的方法
 *
 * @author 喜闻乐见i
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        int loc = uri.lastIndexOf("/");
        String methodName = uri.substring(loc + 1);
        System.out.println(methodName);
        Class<? extends BaseServlet> clazz = this.getClass();
        try {
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
