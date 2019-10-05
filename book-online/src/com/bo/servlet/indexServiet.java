package com.bo.servlet;

import com.bo.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class indexServiet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得哥哥ServLet共享的对象
        ServletContext sc = this.getServletContext();
        //获得全局应用对象中的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //存入request
        req.setAttribute("bookList",bookList);
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().print(bookList.toString());
        //通过服务器转发，江数据带过去，保持地址栏不变
        req.getRequestDispatcher("/index.jsp").forward(req,resp);



    }
}
