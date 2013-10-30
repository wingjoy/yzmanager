<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@page import="com.yz.manager.bean.department" %>  
<%
   
     user user=(user)session.getAttribute("us");
     if(user==null) response.sendRedirect("../index.jsp");  
     
      List<shouse> sh=new ArrayList<shouse>();
	  sh=daoUtil.selectShouse(user.getDepartment());	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />	
</head>
<body bgcolor="#E4FAF9"> 
    <s:form name="myform" action="addDpHouseClassAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           
          <tr><td align="center" colspan="2"><h1 class="h1" align="center">增加库房物品分类</h1></td></tr>               
             <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>         
            <tr>
              <td align="center" colspan="2" class="actionmessage">
               <s:fielderror >
                   <s:param>
                    classnull
                   </s:param>
               </s:fielderror>
             </td>
            </tr>         
          <tr>
             <td  align="center"> 库房名称：</td>
             <td > 
             <select  name="shouseName" style="width:160px;"  > 
                 <%
								for (shouse s : sh) {
							%>
							<option value="<%=s.getId()%>"><%=s.getHouseName()%></option>

							<%
								}
							%>
            </select>
            </td>
          
          </tr> 
             <tr><td>&nbsp;</td></tr>          
                 
           <tr>
         <td  align="center">物品分类： </td>
            <td > <s:textfield style="width:155px;" name="firstCName" size="30"></s:textfield></td>
          </tr>
           <tr><td>&nbsp;</td></tr>          
    
          <tr> 
       
            <td align="center" colspan="2">
              &nbsp;&nbsp;<s:submit name="submit" value="提  交"></s:submit>&nbsp;
              <s:reset name="reset" value="重  置"></s:reset>             
            </td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>