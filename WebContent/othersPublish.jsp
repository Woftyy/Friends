<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.IUserDao"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Moment"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.impl.MomentDaoImpl"%>
<%@page import="com.dao.IMomentDao"%>
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
</head>
<style type="text/css">
.content {
	margin: 0 auto;
	width: 1024px;
	background: #E9E9E9;
	border-radius: 30px;
	text-align: center;
	line-height: 200px;
}

.pp {
	font-size: 18sp;
}
</style>
<body>
	<%   
     
%>
	<!-- 导航栏 -->
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" ><a
				href="PersonalCenter.jsp">动态</a></li>
			<li role="presentation"  class="active"><a href="others.jsp">其他用户</a></li>
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
	String id =request.getParameter("id");
    int uid = Integer.valueOf(id);
    System.out.println("所查看的用户id为"+uid);
    IMomentDao iMomentDao=new MomentDaoImpl();
    IUserDao iUserDao =new UserDaoImpl();
    List<Moment> moments= iMomentDao.queryByUid(uid);
				System.out.println("moments.size()" + Integer.valueOf(moments.size()));
				if(Integer.valueOf(moments.size()).equals(0)){
					%>
	<h4 align="center">
		<% out.println("所查看用户暂时没有动态");%>
	</h4>
	<%
				}else{
				for (int i = moments.size() - 1; i >= 0; i--) {
					Moment moment = new Moment();
					moment = moments.get(i);
			%>
	<!-- 循环显示动态 -->
	<div class="content">
		<!-- 姓名 -->
		<div class="row">
			<div class="col-md-4">
				<h4>
					<strong> <%User user=iUserDao.queryById(moment.getUid());
							     out.println(user.getUsername());%>
					</strong>
				</h4>
			</div>
			<div class="col-md-4">
				<h6></h6>
			</div>
			<div class="col-md-4">
				<h6></h6>
			</div>
		</div>
		<!-- 内容 -->
		<div class="row">
			<div class="col-md-12">
				<p class="lead">
					<%out.println(moment.getContent()); %>

				</p>


			</div>
		</div>
		<!-- 日期 -->
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<h6>
					发表于 ​<%out.println(moment.getPublishdate());
						%>
				</h6>
			</div>
		</div>
	</div>
	<br>
	<hr>
	<br>

	<%
				}
				}
			%>
	<!-- /循环显示动态 -->


	<!-- 引入脚本 -->
	<script src="weblib/jquery/jquery.js"></script>
	<script src="weblib/bootstrap/js/bootstrap.js"></script>
	<script src="js/main.js"></script>
	<!-- /引入脚本 -->
</body>
</html>