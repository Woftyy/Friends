<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"content="width=device-width, initial-scale=1, user-scalable=no">
<title>主页</title>
<!-- 引入Bootstrap核心样式表文件 -->
<link href="weblib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<style>
#header{
}

 .container {
 
 }

</style>
</head>
<body >
<header id="header">
<div class="container">

</div>
</header>

</form>
<form action="PostLoginServlet" method="post">
<table align="center">
<caption><h1>欢迎</h1></caption>
<tr>
<td>
    <label for="username">用户名：</label>
    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
  </td>
</tr>
<tr>
<td><label for="password">密码：</label>
 <input type="password" class="form-control" name="password" placeholder="请输入密码">
</td>

</tr>
<tr>
<td><button type="submit"  class="btn btn-success">登陆</button>
<button type="button" onclick="location.href='register.jsp'" class="btn btn-danger">注册</button>
</td>

</tr>
</table>
</form>
<p align="center"><font color="red">${msg }</font></p>

<!-- 引入脚本 -->
	<script src="weblib/jquery/jquery.js"></script>
	<script src="weblib/bootstrap/js/bootstrap.js"></script>
	<script src="js/main.js"></script>
	<!-- /引入脚本 -->
</body>
</html>