<%@page import="com.sun.corba.se.spi.legacy.interceptor.RequestInfoExt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <%    
      String fail =(String)session.getAttribute("fail");
       if(fail!=null){
    	   %>
    	   <h1>注册失败,用户名<%=fail%>已存在</h1>
       <% }
%>
   <h1>注册成功<a href="index.jsp">点击进入登入界面</a></h1>
   
</body>
</html>