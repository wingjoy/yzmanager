<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add  user</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body>

 <h1 class="h1" align="center">增加用户</h1>
   <%
      user user=(user)session.getAttribute("us");
      if(user==null) response.sendRedirect("../index.jsp");  
    %>
 
    <s:form action="addDpuserAction" method="post" theme="simple">
      
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           <tr>    
             <td > <s:hidden name="department" value="%{#session.us.department}"></s:hidden></td>
         </tr>       
          <tr >
             <td> 用户名：</td>
             <td align="center"> <s:textfield style="width:160px;" name="userName" size="30" ></s:textfield></td>
             <td class="actionmessage"> 
                 <s:fielderror  >   
                         <s:param> usernameagain</s:param>
                 </s:fielderror>
                 <s:fielderror  >   
                         <s:param> nullusername</s:param>
                 </s:fielderror>
             </td>
         </tr>
          <tr><td>&nbsp;</td></tr>
          <tr>
             <td> 密 码：</td>
             <td align="center"> <s:password style="width:160px;" name="userPassword" size="32"></s:password></td>
              <td class="actionmessage"> 
                 <s:fielderror  >   
                         <s:param>nullPassword</s:param>
                 </s:fielderror>
                  <s:fielderror  >   
                         <s:param>newPasswordlength</s:param>
                 </s:fielderror>
             </td>
         </tr>
          <tr><td>&nbsp;</td></tr>
           <tr>
             <td>姓    名：</td>
             <td align="center"> <s:textfield style="width:160px;" name="name"  size="30"></s:textfield></td>
           <td class="actionmessage"> 
                 <s:fielderror  >   
                         <s:param>nullname</s:param>
                 </s:fielderror>  
             </td>
         </tr>
          <tr><td>&nbsp;</td></tr>
           <tr>
             <td> 性    别：</td>
             <td align="center"> 
             <input type="radio"  name="sex" value="男"  checked="checked"/>男
             <input type="radio"  name="sex" value="女" />女            
              </td>            
         </tr> 
         <tr><td>&nbsp;</td></tr>
          <tr>
             <td> 状态：</td>
             <td align="center"> 
             <input type="radio"  name="status" value="true"  checked="checked"/>启用
             <input type="radio"  name="status" value="false" />冻结            
              </td>            
         </tr>
              <tr><td>&nbsp;</td></tr>
         <tr> 
             <td> 职    位：</td>
             <td align="center"> <s:textfield style="width:160px;" name="post" size="30"></s:textfield></td>
         </tr>
         <tr><td>&nbsp;</td></tr>
          <tr>
             <td> 备    注：</td>
             <td align="center"> <s:textfield style="width:160px;" name="remarks" size="30"></s:textfield></td>
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