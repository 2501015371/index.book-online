package com.bo.listener;


import com.bo.entity.Book;
import com.bo.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        //创建并生成用户数据列
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1,"gjy","123","管爸爸","1.jpg","江苏南京", LocalDate.of(2018,6,11)),
                new User(2,"sjw","123","孙儿子","2.jpg","江苏南京", LocalDate.of(2018,4,4)),
                new User(3,"dhb","123","戴儿子","3.jpg","江苏南京", LocalDate.of(2018,8,3)),

        };
        userList = Arrays.asList(users);

        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books = {
                new Book(1,"漫长婚礼","book1.jpg","111"),
                new Book(2,"漫长婚礼","book2.jpg","111"),
                new Book(3,"漫长婚礼","book3.jpg","111"),
                new Book(4,"漫长婚礼","book4.jpg","111"),
                new Book(5,"漫长婚礼","book5.jpg","111"),
                new Book(6,"漫长婚礼","book6.jpg","111"),
                new Book(7,"漫长婚礼","book7.jpg","111"),
                new Book(8,"漫长婚礼","book8.jpg","111"),
                new Book(9,"漫长婚礼","book9.jpg","111"),
                new Book(10,"漫长婚礼","book10.jpg","111"),
        };
        bookList = Arrays.asList(books);

        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据记入，整个应用可以共享
        servletContext.setAttribute("userList",userList);
        servletContext.setAttribute("bookLIst",bookList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");

    }
}
