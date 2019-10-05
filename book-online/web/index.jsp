<%@ page import="java.util.List" %>
<%@ page import="com.bo.entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: 管儿子
  Date: 2019/10/5
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <style type="text/css">
      h2,h3{
        color: cyan;
      }
      #search{
        height: 80px;
        background-color: cyan;
        display: flex;
        align-items: center;
        padding-left: 8%;
        margin-bottom: 10px;
      }
      .search-input{
        flex: 0 0 40%;
        height: 35px;
        background-color: cyan;
        border: none;
        border-radius: 3px;
        margin-left: 50px;
      }

      .search-btn{
        width: 35px;
        height: 35px;
        background-color: cyan;
        display: flex;
        align-items: center;
        justify-content: center;
      }

      .search-btn img{
        width: 50%;
        height: 50%;
      }
      .card {
        height: 180px;
        margin: 20px 5px 20px 5px;
      }

      .card img {
        width: 100%;
        height: 90%;
      }

      .card p {
        font-size: 13px;
        color: #9b9b9b;
      }

      .col-4 img {
        margin: 10px 5px 20px 5px;
        width: 80%;
      }

      hr {
        width: 90%;
        color: #eee;
        margin-top: 10px;
      }
    </style>

  </head>
  <body>
  <%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
  %>
  //搜索区
  <div id="search">
    <h2>读书时刻</h2>
    <input type="text" placeholder="书名、作者、ISN" class="search-input">
    <div class="search-btn">
      <img src="images/search.png" alt="">
    </div>
  </div>
//主体区
  <div class="container">
    <div class="row">
      <h3>好书推荐</h3>
      <hr>
      <div class="row">
     //主题左侧部分
        <div class="col-8">
          <h3>新书推荐</h3>
          <hr>
          <div class="row">
            <%
              for (Book book : bookList){
                pageContext.setAttribute("book",book);
              }
            %>
            <div class="col-2 card">
              <a href="${pageContext.request.contextPath}/detail/${book.id}">
                <img src="images/${book.cover}" alt="">
              </a>
              <p>${book.name}</p>
              <p>${book.author}</p>
            </div>
          </div>
        </div>

        <div class="col-4">
          <h3>推荐作者</h3>
          <hr>
          //左边
        </div>
      </div>
    </div>
    <footer>
      <ul>
        <li>@2015-2019</li>

        <li>南京工业职业技术学院</li>
      </ul>
      <ul>
        <li>联系我们</li>
        <li>帮助中心</li>
        <li>法律声明</li>
        <li>移动合作</li>
      </ul>
    </footer>
  </div>
  </body>
</html>
