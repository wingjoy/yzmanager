<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="com.yz.manager.expense.bean.payMode" %> 
<%@page import="com.yz.manager.dao.daoUtil" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改付款方式名称</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9"> 
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  payMode g=new payMode();
 if(null==request.getAttribute("p")){
    g=daoUtil.selectPayMode(Integer.valueOf(request.getParameter("Id").trim()).intValue());
     request.setAttribute("g",g); 
 }else request.setAttribute("g",(payMode)request.getAttribute("p"));
  
 
  
  %>
 <h1 class="h1" align="center">修改付款方式名称</h1>
 
 <s:form action="modifyPaymodeAction" method="post" theme="simple">
        <s:token></s:token>
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           <tr >
             <td> 编号：</td>
             <td align="center"> <s:textfield name="id" value="%{#request.g.id}"  readonly="true" size="30" ></s:textfield></td>
         </tr> 
         <tr><td>&nbsp;</td></tr>
           <tr >
             <td> 原名称：</td>
             <td align="center"> <s:textfield  value="%{#request.g.modeName}"  readonly="true" size="30" ></s:textfield></td>
         </tr>  
         <tr><td>&nbsp;</td></tr>    
           <tr>
             <td>新名称：</td>
             <td align="center"> <s:textfield name="modeName"  size="30"></s:textfield></td>
            <td class="actionmessage">
              <s:fielderror>
                 <s:param>nullmodeName</s:param>
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