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
<title>修改二级分类</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  List<secondClass> sc=new ArrayList<secondClass>();
  String fid=(String)request.getParameter("fId").trim();
  String scn=(String)request.getAttribute("scn");
  if(fid!=null) {
  sc=daoUtil.selectSecondClass(fid);
  }
  if(scn!=null){   
     sc=daoUtil.selectSecondClass(scn);
 }
  %>
      
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
          <th>编号</th><th>部门</th><th>系统</th><th>一级分类</th><th>二级分类</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(secondClass s : sc){
            String sdp=daoUtil.selectDepartment3(Integer.valueOf(s.getDepartment()).intValue());
            String s1=daoUtil.selectSystem2(Integer.valueOf(s.getSystemName()).intValue());
             String f1=daoUtil.selectFirstClass5(Integer.valueOf(s.getFirstCName()).intValue());
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+s.getId()+"</td>"+
              "<td align='center'>"+sdp+"</td>"+
              "<td align='center'>"+s1+"</td>"+
              "<td align='center'>"+f1+"</td>" +  
               "<td align='center'>"+s.getSecondCName()+"</td>" +  
              "<td align='center'><a class='left-font01' href='deleteFSAction.action?sId="+s.getId()+"' >删除</a</td>"+
               "<td align='center'><a class='left-font01' href='/class/modifySecondClass.jsp?sId="+s.getId()+"' >修改</a</td>"+
            
              "</tr>");
              }                       
           %>
         
       </table>
       
   
     
</body>
</html>