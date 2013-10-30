<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.bean.*"%>
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.custom.bean.*" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 

    List<department> dp=new ArrayList<department>();
	dp=daoUtil.selectDepartmentId();
	 List<user> allUser=new ArrayList<user>();
    allUser=daoUtil.selectUser();	
    
     List<customArea> csa=new ArrayList<customArea>();
     csa=daoUtil.selectAllCustomArea();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户区域</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />

		<script language="javascript">
			var onecount7;
			onecount7=0;
			subcat7=new  Array();  
			<%
			int count7=0;
			for(user user7: allUser){
			 %>
			 subcat7[<%=count7%>]=new Array("<%= user7.getUserName()%>","<%=user7.getName()%>","<%=user7.getDepartment()%>");
			 <%
			 count7 = count7 + 1 ; 	
			}
			%>
			onecount7=<%=count7%>;
			function changelocation7(locationid){
			
			document.myform.userName.length=0;
			var locationid7=locationid;
			var i7;
			document.myform.userName.options[0]=new Option('选择用户','0'); 
			for(i7=0;i7<onecount7;i7++){
			if (subcat7[i7][2] == locationid7) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat7[i7][1], subcat7[i7][0]); 
			} 
			} 
			
			var onecount9;
			onecount9=0;
			subcat9=new  Array();  
			<%
			int count9=0;
			for(customArea u: csa){
			 %>
			 subcat9[<%=count9%>]=new Array("<%= u.getId()%>","<%=u.getAreaName()%>","<%=u.getDepartment()%>");
			 <%
			 count9 = count9 + 1 ; 	
			}
			%>
			onecount9=<%=count9%>;	
			document.myform.areaName.length=0;
			document.myform.areaName.options[0]=new Option('选择区域','0'); 
		
			var i9; 
			for(i9=0;i9<onecount9;i9++){
			if (subcat9[i9][2] == locationid) 
			{ 
			document.myform.areaName.options[document.myform.areaName.length] = new Option(subcat9[i9][1], subcat9[i9][0]); 
			} 			   
			}		   	
			}
			</script>

</head>
<body bgcolor="#E4FAF9">

 <h1 class="h1" align="center">增加用户区域</h1>
   <table align="center" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>areaeixt</s:param>
					</s:fielderror>
				</td>
			</tr>
		   <tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>dpnull</s:param>
					</s:fielderror>
			    </td>
			 </tr>
			 <tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>unnull</s:param>
					</s:fielderror>
				</td>
			</tr>
		   <tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>annull</s:param>
					</s:fielderror>
			    </td>
			 </tr>
  </table>
 
    <s:form action="addUserAreaAction" name="myform" method="post" theme="simple">
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >

         <tr>
          <td  align="center"> 部门：</td>
             <td > 
             <select  name="department"  style="width:200px;" onChange="changelocation7(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
              <option selected value="0">选择部门</option> 
            <% 
		
		   for(department d1 :dp){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
         <td  align="center">
           用户：</td>
            <td >
                  <select name="userName"  style="width:200px;" size="1"> 
                      <option selected value="0">选择用户</option> 
                 </select>          
           </td>
           </tr>
          <tr><td>&nbsp;</td></tr>
          <tr>
         <td  align="center">
           选择区域：</td>
            <td >
                  <select name="areaName"  style="width:200px;" size="1"> 
                      <option selected value="0">选择区域</option> 
                 </select>          
           </td>
           </tr>
          <tr><td>&nbsp;</td></tr>
          <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="提 交"></s:submit>
              &nbsp;&nbsp;<s:reset name="reset" value="重 置"></s:reset>             
            </td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>