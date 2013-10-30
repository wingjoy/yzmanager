<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
    
    <title>exportSuccess.jsp</title>
    <link href="../css/css.css" rel="stylesheet" type="text/css" />
	
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body bgcolor="#E4FAF9">
   <% 
      String path=(String)request.getAttribute("path");
    %>
      <table border="0">
        <tr>
          <td><h2>success</h2></td>       
        </tr>
        <tr>
          <td><h2><a class="left-font01" href=<%=path %>>导出文件下载</a></h2></td>       
        </tr>
      </table>
  </body>

