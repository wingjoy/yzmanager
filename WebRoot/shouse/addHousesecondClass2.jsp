<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门二级分类增加管理</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  List<department> dp=daoUtil.selectDepartment2();
  %>
       <table class="left-font01" width="60%"  align="center" border="0" cellspacing="0" cellpadding="0" >     
       <tr><td>&nbsp;</td></tr>
       </table>
       
       <table class="left-font01" width="60%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
          <th>部门编号</th><th>部门名称</th><th>增加部门库房物品</th>
          </tr>
          <%
            for(department d : dp){
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+d.getDepartmentId()+"</td>"+
              "<td align='center'>"+d.getDepartment()+"</td>"+          
              "<td align='center'><a class='left-font01' href='addHousesecondClass.jsp?dpId="+d.getDepartmentId()+"' >增加</a></td>"+
              "</tr>");
            };                   
           %>
         
       </table>
       
   
     
</body>
</html>