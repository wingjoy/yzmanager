<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.yz.manager.storehouse.bean.*" %> 
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
<title>库房分类管理</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
 
   int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();
     pg=new PageSet(daoUtil.selectHouseFirstClassSize(user.getDepartment()),10);  
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	 List<firstClass> fc=new ArrayList<firstClass>();
	 fc=daoUtil.selectHouseFirstClass2(currentPage,pg.getPagesize());
	 
  %>   
    <s:form name="myform" action="selectDpHouseFirstClassAction?currentPage=1" method="post" theme="simple">
      <table class="left-font01" width="60%" align="center" border="0" cellspacing="0" cellpadding="0" >
         <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>
          <tr>
            <td> &nbsp;库房名称：</td>
             <td > 
             <select  name="shouseName" style="width:100px;"  > 
                 <option selected value="-1">选择库房</option> 
                 <%
								for (shouse s : sh) {
							%>
							<option value="<%=s.getId()%>"><%=s.getHouseName()%></option>

							<%
								}
							%>
            </select>
            </td>
              <td> &nbsp;</td>  
              <td> <s:submit name="submit" value="查 找"></s:submit>  </td> 
              <td align="center">&nbsp;<a class="left-font01" href="/shouse/addDpHousefirstClass.jsp" >增加物品分类</a></td>
              <td>&nbsp;</td>
              <td align="center"><a class="left-font01" href="/shouse/addDpHousesecondClass.jsp" >增加物品</a></td>            
               <td>&nbsp;</td>
              <td align="center"><a  class="left-font01" href="/shouse/managerDpHouseSClass.jsp?currentPage=1" >修改物品</a></td>           
         </tr>
        <tr><td>&nbsp;</td></tr>
        </table>
      </s:form>
     
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF" >
          <th>部门</th><th>库房</th><th>物品分类</th><th>删除</th><th>修改</th><th>查看对应物品</th>
          </tr>
          <%
            for(firstClass f : fc){
            String sdp=daoUtil.selectDepartment3(Integer.valueOf(f.getDepartment()).intValue());
            String sn=daoUtil.selectShouseName(Integer.valueOf(f.getHouseId()).intValue());
            out.println(
              "<tr height='25'>"+  
              "<td align='center'>"+sdp+"</td>"+
              "<td align='center'>"+sn+"</td>"+
              "<td align='center'>"+f.getFirstCName()+"</td>" +  
              "<td align='center'><a class='left-font01' href='deleteDpHouseFirstAction.action?fId="+f.getId()+"' >删除</a</td>"+
               "<td align='center'><a class='left-font01' href='/shouse/modifyDpHouseFirstClass.jsp?fId="+f.getId()+"' >修改</a</td>"+
               "<td align='center'><a class='left-font01' href='/shouse/modifyHouseFSClass.jsp?currentPage=1&fId="+f.getId()+"'>查看</a</td>"+    
              "</tr>");
              }                       
           %>
         
       </table>
        <table class="tablelink"  align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页|</td>
             <td><a class="tablelink" href="houseDpClassManager.jsp?currentPage=1">首页</a></td>
             <td><a class="tablelink" href="houseDpClassManager.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a></td>
             <td><a class="tablelink" href="houseDpClassManager.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a></td>
             <td><a class="tablelink" href="houseDpClassManager.jsp?currentPage=<%=totalPage %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='houseDpClassManager.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='houseDpClassManager.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
   
   
     
</body>
</html>