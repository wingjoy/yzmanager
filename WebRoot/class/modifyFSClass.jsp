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
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();  
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	  if(fid!=null&&!fid.equals("null")) { 
	  pg=new PageSet(daoUtil.selectSecondClassSize(fid),10);  
      totalsize=pg.getTotalsize();
      totalPage=pg.getTotalpage();
	  sc=daoUtil.selectSecondClass(fid,currentPage,pg.getPagesize());
	  }
	  else{   
	     pg=new PageSet(daoUtil.selectSecondClassSize(scn),10);  
         totalsize=pg.getTotalsize();
         totalPage=pg.getTotalpage();
         fid=scn;
	     sc=daoUtil.selectSecondClass(scn,currentPage,pg.getPagesize());
	 }
	  %>
      
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
          <th>部门</th><th>系统</th><th>一级分类</th><th>二级分类</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(secondClass s : sc){
            String sdp=daoUtil.selectDepartment3(Integer.valueOf(s.getDepartment()).intValue());
            String s1=daoUtil.selectSystem2(Integer.valueOf(s.getSystemName()).intValue());
             String f1=daoUtil.selectFirstClass5(Integer.valueOf(s.getFirstCName()).intValue());
            out.println(
              "<tr height='25'>"+
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
        <table class="tablelink" width="60%" align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页|</td>
             <td><a class="tablelink" href="modifyFSClass.jsp?currentPage=1&fId=<%=fid %>">首页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="modifyFSClass.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>&fId=<%=fid %>">上一页</a></td>
             <td><a class="tablelink" href="modifyFSClass.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>&fId=<%=fid %>">下一页</a></td>
             <td><a class="tablelink" href="modifyFSClass.jsp?currentPage=<%=totalPage %>&fId=<%=fid %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='modifyFSClass.jsp?fId="+fid+"&currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='modifyFSClass.jsp?fId="+fid+"&currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
       
   
     
</body>
</html>