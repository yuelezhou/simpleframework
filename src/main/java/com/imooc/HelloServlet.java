package com.imooc;

import com.imooc.dao.bo.HeadLine;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:02 2020-07-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Slf4j
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化Servlet...");
        super.init();

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        System.out.println("执行了doGet方法...");
        doGet(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "我的简易框架";
        log.debug("name is" + name);
        req .setAttribute("name",name);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
        HeadLine headLine = new HeadLine();
        headLine.setLineId(1L);
        headLine.getLineId();

    }

    @Override
    public void destroy() {
        System.out.println("销毁Servlet...");
        super.destroy();
    }
}
