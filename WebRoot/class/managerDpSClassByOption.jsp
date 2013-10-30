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
<title>分类管理</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
   String dp=(String)session.getAttribute("dp");
   String sys=(String)session.getAttribute("sys");
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();    
     List<secondClass> sc=new ArrayList<secondClass>();
     if(request.getAttribute("ssc")!=null){
     sc=(List<secondClass>)request.getAttribute("ssc");
     int total=Integer.valueOf(request.getAttribute("totalCount").toString().trim()).intValue();
     pg=new PageSet(total,10);  
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     }else{   
        currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
        int total=daoUtil.selectSecondClass61(dp,sys);
        pg=new PageSet(total,10);  
        totalsize=pg.getTotalsize();
        totalPage=pg.getTotalpage();
        sc=daoUtil.selectSecondClass6(dp,sys,currentPage,pg.getPagesize());
     } 
     HashMap<String,String> system=new LinkedHashMap<String,String>();
     system=( HashMap<String,String>)daoUtil.selectSystem();
     request.setAttribute("system",system);  
  %> 
 
    <s:form action="selectDpSecondClassAction?currentPage=1" method="post" theme="simple">
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
         <tr >    
             <td > <s:hidden name="department" value="%{#session.us.department}"></s:hidden></td>
            <td> 系统：</td>
             <td > <s:select name="systemName" list="#request.system"  headerKey="-1" headerValue="所有系统" listKey="key" listValue="value" ></s:select></td>
              <td> &nbsp;&nbsp; &nbsp;&nbsp;</td>  
              <td> <s:submit name="submit" value="查 找"></s:submit>  </td>             
         </tr>
      
        </table>
      </s:form>
     
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
          <th>部门</th><th>系统</th><th>一级分类</th><th>二级分类</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(secondClass f : sc){
            String sdp=daoUtil.selectDepartment3(Integer.valueOf(f.getDepartment()).intValue());
            String s=daoUtil.selectSystem2(Integer.valueOf(f.getSystemName()).intValue());
            String fcn=daoUtil.selectFirstClass5(Integer.valueOf(f.getFirstCName()).intValue());
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+sdp+"</td>"+
              "<td align='center'>"+s+"</td>"+
              "<td align='center'>"+fcn+"</td>" +  
                "<td align='center'>"+f.getSecondCName()+"</td>" +  
              "<td align='center'><a class='left-font01' href='deleteDpSecondAction.action?sId="+f.getId()+"' >删除</a</td>"+
               "<td align='center'><a class='left-font01' href='/class/modifyDpSecondClass2.jsp?sId="+f.getId()+"' >修改</a</td>"+            
              "</tr>");
              }                       
           %>
         
       </table>
        <table class="tablelink" width="60%" align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页|</td>
             <td><a class="tablelink" href="managerDpSClassByOption.jsp?currentPage=1">首页</a></td>
             <td><a class="tablelink" href="managerDpSClassByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a></td>
             <td><a class="tablelink" href="managerDpSClassByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a></td>
             <td><a class="tablelink" href="managerDpSClassByOption.jsp?currentPage=<%=totalPage %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='managerDpSClassByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='managerDpSClassByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
   
     
</body>
</html>