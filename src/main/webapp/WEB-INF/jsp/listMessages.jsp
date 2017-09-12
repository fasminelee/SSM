<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="org.lanqiao.util.PageController " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>留言板</title>
    <style type="text/css">
        /* 内部 CSS */
        div {
            margin: 0;
            padding: 0;
            font-size: 12px;
            margin: 0 auto;
        }

        h3 {
            text-align: center;
        }

        #container {
            width: 500px;
        }

        .article {
            border: 1px solid #a6cbe7;
            margin-top: 5px;
        }

        .author {
            background-color: #0099FF;
            width: 100%;
            height: 24px;
            line-height: 24px;
        }

        .content {
            height: 40px;
            padding: 10px;
        }

        .author span {
            float: right;
            padding-right: 10px;
        }

        .time {
            border-top: solid 1px #a6cbe7;
        }

        .page {
            text-align: right;
            height: 30px;
            line-height: 30px;
            padding-right: 10px;
        }
    </style>
    <link rel="stylesheet" href="css/message.css" type="text/css"/>
    <script type="text/javascript" src="js/message.js"></script>
</head>

<body>
<div id="container">
    <div>
        <h3>留言板</h3>
    </div>
    <div>
        <div class="article">
            <div class="author">
                用户:张三<span>12#</span>
            </div>
            <div class="content">测试一下</div>
            <div class="time page">发表于:2016-02-09 13:12:23</div>
        </div>
        <div class="article">
            <div class="author">
                用户:张三<span>11#</span>
            </div>
            <div class="content">测试一下</div>
            <div class="time page">发表于:2016-02-09 13:12:23</div>
        </div>

        <c:forEach items="${msgList}" var="m">
            <div class="article">
                <div class="author">
                    用户:${m.author}<span>10#</span>
                </div>
                <div class="content">${m.comment}</div>

                <div class="time page">
                    发表于:
                    <fmt:formatDate value="${m.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                </div>
            </div>
        </c:forEach>
        <div class="page"><%=PageController.getPageCode((Integer) request.getAttribute("pageNum"),
                (Integer) request.getAttribute("maxPage"), "showMessages")%>
        </div>

    </div>

    <div class="page">
        <input class="btn1" type="button" value="上一页" onClick=""> <input
            class="btn1" type="button" value="下一页" onClick="">
    </div>
    <br>
    <div>
        <form action="leaveMessages" method="post">
            <div>
                用户: <input type="text" name="author" value=""/>
            </div>
            <br>
            <div>
                留言:
                <textarea name="message" rows="5" cols="72"></textarea>
            </div>
            <div align="center">
                <input type="reset" value="清除"/> <input type="submit" value="发表"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
