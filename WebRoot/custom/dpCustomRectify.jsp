<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.custom.bean.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>

<%
   user user=(user)session.getAttribute("us");
   if(user==null) response.sendRedirect("../index.jsp");  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息纠正</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%  
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();
     List<custom> cs=new ArrayList<custom>();
    
     pg=new PageSet(customDao.selectCustomSize(user.getDepartment(),true),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
    
     cs=customDao.selectCustom(user.getDepartment(),true,currentPage,pg.getPagesize());
  
  %>   
    <s:form name="myform" action="selectPersonalByOption?currentPage=1" method="post" theme="simple" >

      </s:form>
     
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="23" class="tableth" bgcolor="#8E8EFF" >
          <th>序号</th><th>添加日期</th><th>区域</th><th>单位名称</th><th>联系人</th><th>联系电话</th><th>客户类型</th><th>客户状态</th><th>添加部门</th><th>添加人</th><th>详情</th><th>删除</th><th>修改</th>
          </tr>
          <%
           int i=1;
            for(custom a : cs){
              String dp=daoUtil.selectDepartment3(Integer.valueOf(a.getDepartment()).intValue());
              String sname=daoUtil.selectUser(a.getUserName().trim());
              String ct=daoUtil.selectCustomTypeName(Integer.valueOf(a.getCustomType()).intValue());
              String cstate=daoUtil.selectCustomStateName(Integer.valueOf(a.getCustomState()).intValue());
              String an=daoUtil.selectCustomAreaName(Integer.valueOf(a.getAreaName()).intValue());
            out.println(
              "<tr height='23'>"+
              "<td align='center'>"+ i++ +"</td>"+
              "<td align='center'>&nbsp;"+CurrentDate.parseDate1(a.getAddDate().toString())+"</td>"+
              "<td align='center'>&nbsp;"+an+"</td>" +  
              "<td align='center'>&nbsp;"+a.getCompanyName()+"</td>" +   
              "<td align='center'>&nbsp;"+a.getContactName()+"</td>"+ 
              "<td align='center'>&nbsp;"+a.getMobilePhone()+"/"+a.getWorkPhone()+"</td>" +         
              "<td align='center'>&nbsp;"+ct+"</td>" +  
              "<td align='center'>&nbsp;"+cstate+"</td>" +  
              "<td align='center'>&nbsp;"+dp+"</td>" +             
              "<td align='center'>&nbsp;"+sname+"</td>" + 
              "<td align='center'><a class='left-font01' href='detailCustom.jsp?aId="+a.getId()+"' >>></a></td>"+
              "<td align='center'><a class='left-font01' href='deleteDpCustomRectifyAction.action?aId="+a.getId()+"' >>></a></td>"+
               "<td align='center'><a class='left-font01' href='modifyCustomRectify.jsp?aId="+a.getId()+"' >>></a></td>"+             
              "</tr>");
              }                       
           %>
         
       </table>
         <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="customRectify.jsp?currentPage=1">首页</a>&nbsp;</td>
             <td><a class="tablelink" href="customRectify.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;</td>
             <td><a class="tablelink" href="customRectify.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;</td>
             <td><a class="tablelink" href="customRectify.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='customRectify.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='customRectify.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
     
</body>
</html>