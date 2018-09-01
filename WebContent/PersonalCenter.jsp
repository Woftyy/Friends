<%@page import="com.dao.impl.CommentDaoImpl"%>
<%@page import="com.dao.ICommentDao"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.IUserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.impl.MomentDaoImpl"%>
<%@page import="com.dao.IMomentDao"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>主页</title>
<!-- 引入Bootstrap核心样式表文件 -->
<link href="weblib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet" type="text/css">
<style type="text/css">
.content {
	margin: 0 auto;
	width: 1024px;
	background: #E9E9E9;
	border-radius: 30px;
	text-align: center;
	line-height: 200px;
}
.comment{
	margin:  auto;
	margin-top: 1px;
	margin-bottom: 1px;
	border-radius: 30px;
	border:4px solid #E9E9E9;
	width: 866px;
	line-height: 50px;
	align: center;
}
.pp {
	font-size: 18sp;
}

.p_comment{
     align: left;
}
.strong_comment{
     text-align: left;
}
.lead{
margin-left: 20px;

}
</style>
</head>
<body class="body">
	<!-- 导航栏 -->
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a
				href="PersonalCenter.jsp">动态</a></li>
			<li role="presentation"><a href="others.jsp">其他用户</a></li>
			<li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      个人中心 <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
     <li role="presentation"><a href="others.jsp">我的资料</a></li>
    <li role="presentation"><a href="others.jsp">我的关注</a></li>
    <li role="presentation"><a href="others.jsp">我的粉丝</a></li>
    </ul>
  </li>
			<li role="presentation"><a href="GetLogoutServlet">退出登录</a></li>
		</ul>
	</div>
	
	<!-- /导航栏 -->
	<!-- 发布动态 -->

	<div class="publish" align="center">
		<div class="container" align="center">
			<h4>有什么新鲜事告诉大家！</h4>
			<form action="PostPublishServlet" method="post">
				<textarea class="form-control" rows="7" name="content"></textarea>
				<img name="img">
				<button type="submit" class="btn btn-warning" data-toggle="tooltip"
					data-placement="bottom" title="点击发布动态">发布</button>
			</form>
		</div>
		<p align="center">
			<font color="red">${msg }</font>
		</p>
		<br>
	</div>
	<!-- /发布动态 -->
	<!-- 浏览动态 -->
	<ol class="breadcrumb">
		<li><a href="#">全部</a></li>
	</ol>
	<div class="container">

		<%
		String c_uid = String.valueOf(session.getAttribute("id"));
		System.out.println("session传值测试"+c_uid);
			IMomentDao iMomentDao = new MomentDaoImpl();
			IUserDao iUserDao = new UserDaoImpl();
			List<Moment> moments = iMomentDao.queryAllMoment();
			System.out.println("moments.size()" + Integer.valueOf(moments.size()));
			for (int i = moments.size() - 1; i >= 0; i--) {
				Moment moment = new Moment();
				moment = moments.get(i);
		%><!-- 循环显示动态 -->
		<div class="content">
			<!-- 姓名 -->
			<div class="row">
				<div class="col-md-4">
					<h4>
						<strong> <%
 	User user = iUserDao.queryById(moment.getUid());
 		out.println(user.getUsername());
 %>
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
					<p class="lead" align="left">
						<%
							out.println(moment.getContent());
						%>
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
						发表于 ​<%
						out.println(moment.getPublishdate());
					%>
					</h6>
				</div>
			</div>
			<!-- 展开评论列表 -->
			<button class="btn btn-primary" type="button" data-toggle="collapse"
				data-target="#<%=moment.getId()%>" aria-expanded="false"
				aria-controls="collapseExample">评论列表</button>
			<div class="collapse" id="<%=moment.getId()%>">
								<div class="well">
					<form action="PostPCommentServlet" method="post">
						<textarea class="form-control" rows="1" name="content"></textarea>
						<input type="hidden" name="mid" value="<%=moment.getId()%>">
						<input type="hidden" name="uid" value="<%=c_uid%>">
					<p align="right">	<button type="submit" class="btn btn-warning" 
							data-toggle="tooltip" data-placement="bottom" title="点击评论">确认评论</button></p>	
					</form>
					<!-- 循环显示评论内容 -->
					<div>
						<%
							ICommentDao iCommentDao = new CommentDaoImpl();
								List<Comment> comments = iCommentDao.queryByMid(moment.getId());
								for (int j = comments.size() - 1; j >= 0; j--) {
									Comment comment = new Comment();
									comment = comments.get(j);
						%>
						<div class="comment">
							<!-- 名字 -->
							<div class="row" >
								<div class="col-md-3">
							<strong > <%
										User c_user = iUserDao.queryById(comment.getUser_id());
												out.print(c_user.getUsername()+":");
									%></strong><%out.print(comment.getContent()); %>
								</div>
								<div class="col-md-3"></div>
								<div class="col-md-3"></div>
								<div class="col-md-3"></div>
							</div>
							<!-- 评论内容-->
							<div class="row">
								<div class="col-md-12">
									<h6>
							
									</h6>
								</div>
							</div>
							<!-- 评论日期 -->
							<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-3"></div>
								<div class="col-md-3"></div>
								<div class="col-md-3">
									<h6>
										 ​<%
										out.println(comment.getPublishdate());
									%>
									</h6>
								</div>
							</div>
						</div>
	<%
						}
					%>
					</div>
					<!-- /循环显示评论内容 -->
				
				</div>
								
			</div>
			<!-- /展开评论列表 -->
		</div>
		<br>
		<hr>
		<br>

		<%
			}
		%>
		<!-- /循环显示动态 -->
		<br>
	</div>
	<!-- /浏览动态 -->
	<!-- 引入脚本 -->
	<script src="weblib/jquery/jquery.js"></script>
	<script src="weblib/bootstrap/js/bootstrap.js"></script>
	<script src="js/main.js"></script>
	<!-- /引入脚本 -->
</body>
</html>