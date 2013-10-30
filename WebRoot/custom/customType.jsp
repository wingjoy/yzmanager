<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.custom.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户类型管理</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
    
     List<customType> cm=daoUtil.selectCustomType();
  %>
       <table class="left-font01"  align="center" border="0" cellspacing="0" cellpadding="0" >
         <tr><td><a class="left-font01" href="addCustomType.jsp">增加客户类型</a></td></tr>
       </table>
       
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
          <th>客户类型编号</th><th>客户类型</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(customType c : cm){
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+c.getId()+"</td>"+
              "<td align='center'>"+c.getTypeName()+"</td>"+
              "<td align='center'><a class='left-font01' href='deleteCustomType.action?Id="+c.getId()+"' >删除</a></td>"+
              "<td align='center'><a class='left-font01' href='modifyCustomType.jsp?Id="+c.getId()+"' >修改</a></td>"+
              "</tr>");
            };                   
           %>
       </table>
      
</body>
</html>