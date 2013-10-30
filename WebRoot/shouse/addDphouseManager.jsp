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
	  String sdp=daoUtil.selectDepartment3(Integer.valueOf(user.getDepartment()).intValue());
	  request.setAttribute("sdp",sdp);
	  List<user> us=new ArrayList<user>();
      us=daoUtil.selectUser2(user.getDepartment());
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add firstClass</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9"> 
    <s:form name="myform" action="addHouseManagerAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           
          <tr><td align="center" colspan="2"><h1 class="h1" align="center">增加库房管理员</h1></td></tr>               
             <tr><td align="center" >
                <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>
              </tr>               
            <tr>
              <td align="center" colspan="2" class="actionmessage">
               <s:fielderror >
                   <s:param>
                     shousenull
                   </s:param>
               </s:fielderror>
             </td>
            </tr>  
            <tr>
              <td align="center" colspan="2" class="actionmessage">
               <s:fielderror >
                   <s:param>
                    managernull
                   </s:param>
               </s:fielderror>
             </td>
            </tr>  
       <tr>
          <td  align="center"> 库房部门：</td>
            <td> <s:textfield style="width:160px;"  value="%{#request.sdp}"  size="30"></s:textfield></td>
          </tr>
            <tr><td>&nbsp;</td></tr>           
          <tr>
             <td  align="center"> 库房名称：</td>
             <td > 
             <select  name="shouseName" style="width:160px;"  > 
                 <option selected value="0">选择库房</option> 
              <% 
		
		   for(shouse d :sh){
		    %> 
		  <option value="<%= d.getId()%>"><%=d.getHouseName()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
          
          </tr> 
             <tr><td>&nbsp;</td></tr>          
                 
           <tr>
         <td  align="center">
           管理员:</td>
            <td >
                  <select name="managerName"  style="width:160px;" size="1"> 
           <option selected value="0">选择管理员</option> 
            <% 
		
		   for(user u1 :us){
		    %> 
		  <option value="<%= u1.getUserName()%>"><%=u1.getName()%></option> 
		
		 <% }
        %> 
            </select>        
           </td>
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