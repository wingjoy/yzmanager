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

 <h1 class="h1" align="center">增加挂账公司</h1>
   <%
   
     user user=(user)session.getAttribute("us");
     if(user==null) response.sendRedirect("../index.jsp");  
    %>
 
    <s:form action="addComPanyAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
            <tr><td>
              <s:actionerror/>
            &nbsp;</td></tr>       
          <tr><td>&nbsp;</td></tr>               
    
          <tr><td>&nbsp;</td></tr>  
         <tr>    
             <td> 公司名称：</td>
             <td align="center"> <s:textfield style="width:160px;" name="companyName" size="30"></s:textfield></td>
         </tr>
             <tr><td>&nbsp;</td></tr>  
          <tr> 
          <td> &nbsp;</td>
            <td align="center">
              <s:submit name="submit" value="提 交"></s:submit>&nbsp;
              <s:reset name="reset" value="重 置"></s:reset>             
            <br></td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>