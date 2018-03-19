<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Alter | Show</title>
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<form action="updateStudent" method="post">
    <input name="sid" type="hidden" value="${stu.sid}">
    <div style="width: 200px" align="center">
        <h1>学生信息修改</h1>
        <jsp:useBean id="stu" scope="request" type="org.lanqiao.entity.Student"/>
        姓名:<input type="text" class="required" name="sname" value="${stu.sname}"><br>
        生日:<input type="text" class="required" name="birthday" value="${stu.birthday}"><br>
        性别:<input type="text" class="required" name="gender" value="${stu.gender}"><br>
        电话:<input type="text" class="required" name="telephone" value="${stu.telephone}"><br>
        Email:<input type="text" class="required" name="email" value="${stu.email}"><br>
        班级:
        <select name="classid" style="width: 200px">
            <jsp:useBean id="classesList" scope="request" type="java.util.List"/>
            <c:forEach items="${classesList}" var="clazz">
                <option value="${clazz.cid}">${clazz.cname}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>
