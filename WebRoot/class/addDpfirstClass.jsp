<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add firstClass</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9"> 

 <h1 class="h1" align="center">增加一级分类</h1>
   <%
   
     user user=(user)session.getAttribute("us");
     if(user==null) response.sendRedirect("../index.jsp"); 
     HashMap<String,String> system=new LinkedHashMap<String,String>();
     system=( HashMap<String,String>)daoUtil.selectSystem();
     request.setAttribute("system",system);  
    %>
 
    <s:form action="addDpfirstClassAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>    
             <td > <s:hidden name="department" value="%{#session.us.department}"></s:hidden></td>
         </tr>
          <tr><td>&nbsp;</td></tr>               
          <tr>
             <td> 系   统：</td>
             <td align="center"> <s:select style="width:160px;" name="systemName" list="#request.system"   listKey="key" listValue="value" ></s:select></td>
         </tr>  
          <tr><td>&nbsp;</td></tr>  
         <tr>    
             <td> 一级分类：</td>
             <td align="center"> <s:textfield style="width:160px;" name="firstCName" size="30"></s:textfield></td>
         </tr>
         
          <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="提 交"></s:submit>
              <s:reset name="reset" value="重 置"></s:reset>             
            <br></td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>