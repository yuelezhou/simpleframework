package org.simpleframework.mvc;

import com.imooc.controller.MainPageController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 4:42 PM 2/16/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("reqest path is:" + req.getServletPath());
        System.out.println("reqest method is:" + req.getMethod());
        if (req.getServletPath().equals("/frontend/getmainpageinfo") && req.getMethod().equals("GET")){
            new MainPageController().getMainPageInfo(req,resp);
        }else if (req.getServletPath().equals("/superadmin/addheadline") && req.getMethod().equals("POST")){
            // todo new HeadLineOperationController().addHeadLine(req,resp);
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("我是首次请求被处理前执行的，后续不会再执行");
    }
}
