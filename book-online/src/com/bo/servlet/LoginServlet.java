package com.bo.servlet;


import com.bo.entity.User;
import com.bo.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        //获得用户列表数据
        ServletContext sc = this.getServletContext();
        List<User> userList = (List<User>) sc.getAttribute("userList");
        //将数据传到userservice
        userService.setUserList(userList);
        //调用登录功能
        User user=userService.sigIn(account,password);
        if(user != null){
            //登录成功，将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/index");
        }
        else {
            resp.setContentType("text/html;charset=URF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('账号密码错误');location.href='.login';</script>");
        }

    }
}
