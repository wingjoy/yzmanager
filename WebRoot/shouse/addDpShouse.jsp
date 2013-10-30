<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.yz.manager.bean.department" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9"> 

 
   <%
   
     user user=(user)session.getAttribute("us");
     if(user==null) response.sendRedirect("../index.jsp"); 
     
     String sdp=daoUtil.selectDepartment3(Integer.valueOf(user.getDepartment()).intValue()); 
     request.setAttribute("sdp",sdp);
    %>
 
    <s:form action="addDpShouseAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           
          <tr><td align="center" colspan="2"><h1 class="h1" align="center">增加部门库房</h1></td></tr>               
             <tr><td align="center" colspan="2" class="actionmessage">
               <s:fielderror >
                   <s:param>
                      housenull
                   </s:param>
               </s:fielderror>
             </td></tr>               
            <tr><td>&nbsp;</td></tr>  
              <tr>
             <td > 
               <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>
            </td>
          
          </tr>         
          <tr>
             <td  align="center"> 部门：</td>
             <td > 
               <s:textfield style="width:160px;"  value="%{#request.sdp}"  size="30"></s:textfield></td>
       
          </tr> 
           <tr><td>&nbsp;</td></tr>          
         <tr>    
             <td> 库房名称：</td>
             <td align="center"> <s:textfield style="width:160px;" name="houseName" size="30"></s:textfield></td>
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