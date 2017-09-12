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
		$("input[type='button']").click(function() {
			$.post("checkUserAjax", {
				"userName" : $("input[name='userName']").val(),
				"password" : $("input[name='password']").val()
			}, function(data) {
				alert("fuck");
			    alert(data.username);
			}, "json");
		});

	});
</script>
</head>
<body>
	<form action="checkUser" method="post">
		<input name="userName" placeholder="UserName"> ${error} <br>
		<input name="password" placeholder="Password"><br>
		<!-- <input type="submit" value="form 登录"><br>  --> 
		<input type="button" value="Ajax 登录">
	</form>
</body>
</html>