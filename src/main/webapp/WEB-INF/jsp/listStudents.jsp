<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.lanqiao.util.PageController"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
    <!-- jQuery and Modernizr-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        /* 内部 CSS */
    </style>
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<table width="600" align="center">
    <caption>学员信息列表</caption>
    <thead>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>生日</td>
        <td>性别</td>
        <td>电话</td>
        <td>Email</td>
        <td>班级</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.stuList}" var="stu">
        <tr>
            <td><a href="showStudent?sid=${stu.sid}">${stu.sid}</a></td>
            <td>${stu.sname}</td>
            <td>${stu.birthday}</td>
            <td>${stu.gender}</td>
            <td>${stu.telephone}</td>
            <td>${stu.email}</td>
            <td>${stu.classid}</td>
            <td><span class="del" alt="${stu.sid}">删除</span></td>
        </tr>
    </c:forEach>
    <tr>
        <c:set var="maxPage" value="${maxPage}"></c:set>

        <td colspan="10" align="center">
            <%=PageController.getPageCode((Integer) request.getAttribute("pageNum"),
                    (Integer) request.getAttribute("maxPage"), "listStudents")%>
        </td>
    </tr>
    <tr>
        <td colspan="10" align="center"><input type="button" id="addNewStu" value="添加学生"/></td>
    </tr>
    </tbody>
</table>


</body>
</html>