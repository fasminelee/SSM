<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {

		/* Ajax 提交数据 */
		$("").click(function() {
			$.post("checkUserAjax", {
				userName : $("input[name='userName']").val(),
				password : $("input[name='password']").val()
			}, function(data) {
				alert("fuck");
			    alert(data.username);
			}, "json");
		});

        /* 注册名 Jquery 表单验证 */
        $("input[type='button']").keyup(function() {

            $.post("checkUserAjax", {
                registerName : $("input[name='userName']").val()
            }, function(n) {
                if (n === 1) {
                    alert("用戶名已存在");
                }
            })
        });

	});
</script>
</head>
<body>
	<form action="checkUser" method="post">
		<input name="userName" placeholder="UserName"> ${error} <br>
		<input name="password" placeholder="Password"><br>
		<input type="submit" value="form 登录">
		<input type="button" value="Ajax 注册">
	</form>
</body>
</html>