<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@page import="com.yz.manager.dao.daoUtil" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改库房管理员</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9"> 
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  houseManager g=new houseManager();
     g=daoUtil.selectHouseManager(Integer.valueOf(request.getParameter("Id").trim()).intValue());
     request.setAttribute("g",g); 
      List<user> us=new ArrayList<user>();
      us=daoUtil.selectUser2(g.getDepartment());
      String hname=daoUtil.selectShouseName(Integer.valueOf(g.getHouseId()).intValue());
	 request.setAttribute("hname",hname);
     String sdp=daoUtil.selectDepartment3(Integer.valueOf(g.getDepartment()).intValue());
     request.setAttribute("sdp",sdp);
     
     String mname=daoUtil.selectUser(g.getManagerName());
      request.setAttribute("mname",mname);
  %>
 <h1 class="h1" align="center">修改库房管理</h1>
 
 <s:form action="modifyDpHouseManagerAction" method="post" theme="simple">
        <s:token></s:token>
         <s:hidden name="id" value="%{#request.g.id}" ></s:hidden>
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           <tr >
             <td align="center"> 库房编号：</td>
             <td align="center"> <s:textfield value="%{#request.g.houseId}"  readonly="true" size="30" ></s:textfield></td>
         </tr> 
         <tr><td>&nbsp;</td></tr>
          <tr >
             <td align="center"> 所属部门：</td>
             <td align="center"> <s:textfield  value="%{#request.sdp}"  readonly="true" size="30" ></s:textfield></td>
         </tr>  
         <tr><td>&nbsp;</td></tr>    
           <tr >
             <td align="center"> 库房名称：</td>
             <td align="center"> <s:textfield  value="%{#request.hname}"  readonly="true" size="30" ></s:textfield></td>
         </tr>  
         <tr><td>&nbsp;</td></tr>    
           <tr>
             <td align="center">原库房管理员：</td>
             <td align="center"> <s:textfield   value="%{#request.mname}"  size="30"></s:textfield></td>
         </tr>
          <tr><td>&nbsp;</td></tr>    
               <tr>
                <td align="center">新库房管理员：</td>
             <td > 
             <select  name="managerName" style="width:215px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
            <% 
		
		   for(user d :us){
		    %> 
		  <option value="<%= d.getUserName()%>"><%=d.getName()%></option> 
		
		 <% }
        %> 
            </select>
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