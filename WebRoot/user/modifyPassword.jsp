<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  %>
 <h1 class="h1" align="center">修改密码</h1>
 
 <s:form action="modifyUserPassword" method="post" theme="simple">
        <s:token></s:token>
       <table  class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
         <tr>
            <td class="actionmessage">
               <s:fielderror  >   
                         <s:param>addsuccess</s:param>
                 </s:fielderror>
            </td>
          </tr>
         
          <tr>
            <td class="actionmessage">
               <s:fielderror  >   
                         <s:param>modifypasswordsuccess</s:param>
                 </s:fielderror>
            </td>
          </tr>
           <tr >
             <td align="center"> 用户编号：</td>
             <td align="center"> <s:textfield style="width:160px;" name="userId" value="%{#session.us.userId}"  readonly="true" size="30" ></s:textfield></td>
         </tr>
               <tr><td>&nbsp;</td></tr>  
          <tr >
             <td align="center"> 用户名：</td>
             <td align="center"> <s:textfield style="width:160px;" name="userName" value="%{#session.us.userName}" readonly="true" size="30" ></s:textfield></td>
         </tr>
           <tr><td>&nbsp;</td></tr>
          <tr>
             <td align="center"> 旧密码：</td>
             <td align="center"> <s:password  style="width:160px;" name="userPassword"  size="30"></s:password></td>
             <td class="actionmessage">
                 <s:fielderror  >   
                         <s:param>userPassworderror</s:param>
                 </s:fielderror>
                 
                 <s:fielderror  >   
                         <s:param>nullPassword</s:param>
                 </s:fielderror>
             </td>
         </tr>
          <tr><td>&nbsp;</td></tr>
            <tr>
             <td align="center"> 新密码：</td>
             <td align="center"> <s:password style="width:160px;" name="newUserPassword" size="30"></s:password></td>
             <td class="actionmessage">
                 <s:fielderror  >   
                         <s:param>nullnewPassword</s:param>
                 </s:fielderror>
                 
                 <s:fielderror  >   
                         <s:param>newPasswordlength</s:param>
                 </s:fielderror>
             </td>
        
         </tr>
          <tr><td>&nbsp;</td></tr>
           <tr>
             <td align="center"> 确认密码：</td>
             <td align="center"> <s:password style="width:160px;"  name="againPassword" size="30"></s:password></td>
            <td class="actionmessage">
                 <s:fielderror  >   
                         <s:param>againPassword</s:param>
                 </s:fielderror>
                 
                 <s:fielderror  >   
                         <s:param>passwordnotequalrepassword</s:param>
                 </s:fielderror>
             </td>
         </tr>
          <tr><td>&nbsp;</td></tr>
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