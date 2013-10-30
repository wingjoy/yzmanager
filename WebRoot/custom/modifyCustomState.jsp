<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="com.yz.manager.custom.bean.*" %> 
<%@page import="com.yz.manager.dao.daoUtil" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客户状态</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9"> 
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  customState g=new customState();
  if(null==request.getAttribute("c")){
     g=daoUtil.selectCustomState(Integer.valueOf(request.getParameter("Id").trim()).intValue());
     request.setAttribute("g",g); 
  }else request.setAttribute("g",(customState)request.getAttribute("c"));
  %>
 <h1 class="h1" align="center">修改客户状态</h1>
 
 <s:form action="modifyCustomStateAction" method="post" theme="simple">
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           <tr >
             <td> 状态编号：</td>
             <td align="center"> <s:textfield name="id" value="%{#request.g.id}"  readonly="true" size="30" ></s:textfield></td>
         </tr> 
         <tr><td>&nbsp;</td></tr>
           <tr >
             <td> 原客户状态：</td>
             <td align="center"> <s:textfield  value="%{#request.g.stateName}"  readonly="true" size="30" ></s:textfield></td>
         </tr>  
         <tr><td>&nbsp;</td></tr>    
           <tr>
             <td>新客户状态：</td>
             <td align="center"> <s:textfield name="stateName"  size="30"></s:textfield></td>
            <td class="actionmessage">
              <s:fielderror>
                 <s:param>nullstateName</s:param>
              </s:fielderror>
            </td>
         </tr>
               <tr><td>&nbsp;</td></tr>         
          <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="提 交"></s:submit>&nbsp;&nbsp;
              <s:reset name="reset" value="重 置"></s:reset>             
            <br></td>
          </tr>
       </table>
       
       
       </s:form>
           
</body>
</html>