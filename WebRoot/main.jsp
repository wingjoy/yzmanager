<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body bgcolor="#E4FAF9">

用户：<%=  session.getAttribute("userName") %><br>
密码：<%= request.getParameter("userPassword") %><br>
<h2>登陆验证成功</h2>
     
</body>
</html>