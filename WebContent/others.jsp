<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>其他用户</title>
<!-- 引入Bootstrap核心样式表文件 -->
<link href="weblib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet" type="text/css">
<style type="text/css">
.table {
	width: 450px;
}
</style>
</head>
<body>
	<!-- 导航栏 -->
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="PersonalCenter.jsp">动态</a></li>
			<li role="presentation" class="active"><a href="others.jsp">其他用户</a></li>
			<li role="presentation" class="dropdown"><a
				class="dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false"> 个人中心 <span
					class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li role="presentation"><a href="others.jsp">我的资料</a></li>
					<li role="presentation"><a href="others.jsp">我的关注</a></li>
					<li role="presentation"><a href="others.jsp">我的粉丝</a></li>
				</ul></li>
			<li role="presentation"><a href="GetLogoutServlet">退出登录</a></li>
		</ul>
	</div>
	<!-- /导航栏 -->
	<%
		String name = String.valueOf(session.getAttribute("username"));
		System.out.println("当前用户为" + name);
		IUserDao iUserDao = new UserDaoImpl();
		List<User> users = iUserDao.queryExceptName(name);
		for (int i = 0; i < users.size(); i++) {
			User user = new User();
			user = users.get(i);
	%>

	<!-- 用户 列表-->
	<form action="">
		<table class="table" align="center">
			<tr>
				<td><address>
						<a href="othersPublish.jsp?id=<%=String.valueOf(user.getId()) %>"><strong>
								<%
								System.out.println("所查看用户id为"+String.valueOf(user.getId()));
									out.print(user.getUsername());
								%>
						</strong></a>
					</address></td>
				<td align="right">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary btn-sl"
						data-toggle="modal" data-target="#myModal">关注</button> <!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">确认关注</h4>
								</div>
							
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary" >确认</button>
								</div>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<%
		}
	%>
	<!-- /用户列表 -->
	<!-- 引入脚本 -->
	<script src="weblib/jquery/jquery.js"></script>
	<script src="weblib/bootstrap/js/bootstrap.js"></script>
	<script src="js/main.js"></script>
	<!-- /引入脚本 -->
</body>
</html>