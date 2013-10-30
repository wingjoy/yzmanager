<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();

     pg=new PageSet(daoUtil.selectDepartmentSize(),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     List<department> dp=daoUtil.selectDepartment2(currentPage,pg.getPagesize());
  %>
       <table class="left-font01" width="80%"  align="center" border="0" cellspacing="0" cellpadding="0" >
         <tr><td><a class="left-font01" href="addDepartment.jsp">增加部门</a></td></tr>
       </table>
       
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" height="25" class="tableth" bgcolor="#8E8EFF">
          <th>部门编号</th><th>部门名称</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(department d : dp){
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+d.getDepartmentId()+"</td>"+
              "<td align='center'>"+d.getDepartment()+"</td>"+
              "<td align='center'><a class='left-font01' href='deleteDepartment.action?dpId="+d.getDepartmentId()+"' >删除</a></td>"+
              "<td align='center'><a class='left-font01' href='modifyDepartment.jsp?dpId="+d.getDepartmentId()+"' >修改</a></td>"+
              "</tr>");
            };                   
           %>
         
       </table>
       <table class="tablelink" align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页|</td>
             <td><a class="tablelink" href="managerdDepartment.jsp?currentPage=1">首页</a></td>
             <td><a class="tablelink" href="managerdDepartment.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a></td>
             <td><a class="tablelink" href="managerdDepartment.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a></td>
             <td><a class="tablelink" href="managerdDepartment.jsp?currentPage=<%=totalPage %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='managerdDepartment.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='managerdDepartment.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
   
     
</body>
</html>