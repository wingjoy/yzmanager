<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="com.yz.manager.dao.daoUtil" %>
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  user u2=new user();
  if(request.getAttribute("usId")==null){
       u2=daoUtil.selectUser(Integer.valueOf(request.getParameter("usId").trim()).intValue());
  }
  else {
       u2=daoUtil.selectUser(Integer.valueOf((String)request.getAttribute("usId")).intValue());
  }
  request.setAttribute("u2",u2);
  %>
 <h1 class="h1" align="center">修改用户信息</h1>
 
 <s:form action="modifyDpUser" method="post" theme="simple">
        <s:token></s:token>
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>    
             <td > <s:hidden name="department" value="%{#session.us.department}"></s:hidden></td>
         </tr>
           <tr >
             <td align="center"> 用户编号：</td>
             <td align="center"> <s:textfield name="userId" value="%{#request.u2.userId}"  readonly="true" size="30" ></s:textfield></td>
         </tr>
             <tr><td>&nbsp;</td></tr>
          <tr >
             <td align="center"> 用户名：</td>
             <td align="center"> <s:textfield name="userName" value="%{#request.u2.userName}" readonly="true" size="30" ></s:textfield></td>
         </tr>
           <tr><td>&nbsp;</td></tr>
          <tr>
             <td align="center"> 新密码：</td>
             <td align="center"> <s:password  name="userPassword" size="32"></s:password></td>
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
             <td align="center">姓名：</td>
             <td align="center"> <s:textfield name="name" value="%{#request.u2.name}" size="30"></s:textfield></td>
         </tr>
           <tr><td>&nbsp;</td></tr>
           <tr>
             <td align="center"> 性别：</td>
             <td align="center"> 
             <input type="radio"  name="sex" value="男"  checked="checked"/>男
             <input type="radio"  name="sex" value="女" />女            
              </td>            
         </tr>
          <tr><td>&nbsp;</td></tr>
          <tr>
             <td align="center"> 状态：</td>
             <td align="center"> 
             <input type="radio"  name="status" value="true"  checked="checked"/>启用
             <input type="radio"  name="status" value="false" />冻结            
              </td>            
         </tr>
              <tr><td>&nbsp;</td></tr>
         <tr> 
             <td align="center">  职位：</td>
             <td align="center"> <s:textfield name="post" value="%{#request.u2.post}" size="30"></s:textfield></td>
         </tr>
          <tr><td>&nbsp;</td></tr>
          <tr>
             <td align="center"> 备 注：</td>
             <td align="center"> <s:textfield name="remarks" value="%{#request.u2.remarks}" size="30"></s:textfield></td>
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