<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	 <%
	 String msg=(String)request.getAttribute("msg");
	  msg=msg==null?"":msg;
	 %>
	 <form action="CookieLogin" method="post">
		  账号：<input type="text" name='username'><span><%=msg %></span><br/>
		 密码：<input type="text" name='password'><br/>
	 <input type="submit">
	 </form>

</body>
</html>