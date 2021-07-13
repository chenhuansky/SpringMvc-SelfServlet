package com.seu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求 web.xml里配置的 <url-pattern>/hello</url-pattern>
        //是该servlet处理的路径，下面的method是路径参数 后面跟的value才是get到的String method
        //因此访问的路径设置成为/hello?method=add或者delete
        String method=req.getParameter("method");
        if(method.equals("add")){
            req.getSession().setAttribute("msg","执行了add方法");
        }
        if(method.equals("delete")){
            req.getSession().setAttribute("msg","执行了delete方法");
        }
        //调用业务层处理

        //返回页面
        req.getRequestDispatcher("/WEB-INF/jsp/Hello.jsp").forward(req,resp);
    }
    //尝试merge
//"不快乐"
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //复用doGet
        doGet(req, resp);
    }
}
