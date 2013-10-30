<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理</title>
</head>
<body>
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  List<manager> m=new ArrayList<manager>();

  m=(List<manager>)daoUtil.selectManager();
    
  %>
      
   
      <table  align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>     
             <td align="right"><a href="/user/addManager.jsp">增加管理员</a></td>
         </tr>
        </table>
   
       <table width="60%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr >
          <th>编号</th><th>用户名</th><th>部门</th><th>部门管理员</th><th>系统管理员</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(manager m1 : m){
            String dp=daoUtil.selectDepartment3(Integer.valueOf(m1.getDepartment()).intValue());
            String systemManager="否";
            String departmentManager="否";
            if(m1.isSystemManager())systemManager="是";
            if(m1.isDepartmentManager()) departmentManager="是";
            out.println(
              "<tr>"+
              "<td align='center'>"+m1.getId()+"</td>"+
              "<td align='center'>"+m1.getUserName()+"</td>"+
               "<td align='center'>"+dp+"</td>"+
              "<td align='center'>"+departmentManager+"</td>"+
              "<td align='center'>"+systemManager+"</td>");
              if("admin".equals(m1.getUserName().trim())){
              out.println(
              "<td align='center'>不可删除</td>"            
              );
               out.println(
              "<td align='center'>不可修改</td>"            
              );
              }else{
               out.println(
              "<td align='center'><a href='deleteManager.action?mId="+m1.getId()+"' >删除</a></td>"
              );
                         
               out.println(
              "<td align='center'><a href='/user/modifyManager.jsp?mId="+m1.getId()+"' >修改</a></td>"+
              "</tr>");
            }; 
            }                  
           %>
         
       </table>
       
   
     
</body>
</html>