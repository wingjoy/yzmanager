<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="com.yz.manager.custom.bean.*" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	user user=(user)session.getAttribute("us");
	  if(user==null) response.sendRedirect("../index.jsp"); 
	  
	   List<user> us=new ArrayList<user>();
	   us=daoUtil.selectUser();
	   List<department> department=new ArrayList<department>();
	   department=daoUtil.selectDepartmentId();	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户区域分配</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
			var onecount;
			onecount=0;
			subcat=new  Array();  
			<%
			int count=0;
			for(user user1: us){
			 %>
			 subcat[<%=count%>]=new Array("<%= user1.getUserName()%>","<%=user1.getName()%>","<%=user1.getDepartment()%>");
			 <%
			 count = count + 1 ; 	
			}
			%>
			onecount=<%=count%>;
			function changelocation(locationid){
			document.myform.userName.length=0;
			var locationid=locationid;
			var i;
			document.myform.userName.options[0]=new Option('选择用户','0'); 
			for(i=0;i<onecount;i++){
			if (subcat[i][2] == locationid) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat[i][1], subcat[i][0]); 
			} 
			} 		   		
			}
			</script>
			
</head>
<body bgcolor="#E4FAF9">
 <%
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();

     pg=new PageSet(daoUtil.selecUserAreaSize(),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     List<userArea> cs=daoUtil.selectUserArea(currentPage,pg.getPagesize());
  %>
       <s:form name="myform" action="userAreaByOption.action?currentPage=1" method="post" theme="simple">
       <table class="left-font01" width="60%"  align="center" border="0" cellspacing="0" cellpadding="0" >
                <tr>
          <td  align="center"> 部门:</td>
             <td > 
             <select  name="department" style="width:100px;" style="width:100px;" onChange="changelocation(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
              <option selected value="0">选择部门</option> 
            <% 
		
		   for(department d :department){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
            <td align="center" > &nbsp;&nbsp;用户:</td>
             <td  >
                  <select name="userName"  style="width:100px;" size="1">  
        			   <option selected value="0">选择用户</option> 
                 </select>
             </td>
             <td>
            &nbsp;&nbsp; <s:submit name="submit" value="查 找"></s:submit>  &nbsp;&nbsp;            
             <a class="left-font01" href="/custom/addUserArea.jsp">用户区域分配</a></td>
        </tr>
       </table>
       </s:form>
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" height="25" class="tableth" bgcolor="#8E8EFF">
          <th>部门</th><th>用户</th><th>负责区域</th><th>删除</th>
          </tr>
          <%
            for(userArea c : cs){
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+daoUtil.selectDepartment3(Integer.valueOf(c.getDepartment()).intValue())+"</td>"+
              "<td align='center'>"+daoUtil.selectUser(c.getUserName())+"</td>"+
              "<td align='center'>"+daoUtil.selectArea(c.getAreaName())+"</td>"+
              "<td align='center'><a class='left-font01' href='deleteUserArea.action?cId="+c.getId()+"' >>></a></td>"+
              "</tr>");
            };                   
           %>
         
       </table>
       <table class="tablelink" align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页|</td>
             <td><a class="tablelink" href="/custom/userAreaManager.jsp?currentPage=1">首页</a></td>
             <td><a class="tablelink" href="/custom/userAreaManager.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a></td>
             <td><a class="tablelink" href="/custom/userAreaManager.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a></td>
             <td><a class="tablelink" href="/custom/userAreaManager.jsp?currentPage=<%=totalPage %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='/custom/userAreaManager.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='/custom/userAreaManager.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
   
     
</body>
</html>