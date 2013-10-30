<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add  archives</title>
</head>
<body>

 <h1 align="center">增加 档案</h1>
   <%
     user user=(user)session.getAttribute("us");
     if(user!=null){     		   
		     String department=user.getDepartment().trim();
		     String systemName="1";

	
		     List<String> fc=new ArrayList<String>();
		     fc=daoUtil.selectFirstClass(department,systemName);
		     request.setAttribute("fc",fc);
		
		     HashMap<String, List<String>> sc = new HashMap<String, List<String>>();
		     sc=daoUtil.selectDoubleSecondClass(fc,department,systemName);
		     request.setAttribute("sc",sc); 
		    
		      List<String> sdp=new ArrayList<String>();
	          sdp=daoUtil.selectDepartment4();
	          request.setAttribute("sdp",sdp);
	
	          HashMap<String, List<String>> sn= new HashMap<String, List<String>>();
	          sn=daoUtil.selectDoubleUser2();	   
	          request.setAttribute("sn",sn);

	  }
	  else response.sendRedirect("index.jsp"); 
    %>  
    <table  align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr >           
             <td>
               <s:actionmessage/>
            </td>
         </tr>
         </table> 
    <s:form action="addArchivesAction" enctype="multipart/form-data"  method="post" theme="simple">
        <s:token></s:token>
        <s:hidden name="giveArName" value="%{#session.us.name}" ></s:hidden>
       <table  align="center" border="0" cellspacing="0" cellpadding="0" >
         
             <tr>
             <td>系统分类：</td>
             <td><s:doubleselect name="firstCName" list="#request.fc"
		doubleName="secondCName" doubleList="#request.sc.get(top)" ></s:doubleselect></td>
         </tr>
            <tr >
             <td> 档案名称：</td>
             <td align="center"> <s:textfield name="fileName" size="30" ></s:textfield></td>
             <td>
               <s:fielderror>   
                         <s:param>fileNamenull</s:param>
                 </s:fielderror>
            </td>
         </tr> 
           <tr >
             <td> 电子文档：</td>
             <td ><s:file name="file" size="18"></s:file> </td>
             <td>   
             <s:actionerror/>                     
            </td>
         </tr>                
         <tr>
             <td>档案编号：</td>
             <td align="center"> <s:textfield name="fileNumber"  size="30"></s:textfield></td>
             <td>
               <s:fielderror  >   
                         <s:param>fileNumbernull</s:param>
                 </s:fielderror>
            </td>
         </tr>
       
         <tr> 
             <td> 文本页数：</td>
             <td align="center"> <s:textfield name="filePages" size="30"></s:textfield></td>
         </tr>          
          <tr>
             <td> 存档人：</td>
              <td><s:doubleselect name="saveArDepartment" list="#request.sdp"
		doubleName="saveArName" doubleList="#request.sn.get(top)" ></s:doubleselect></td>
        <td>
               <s:fielderror  >   
                         <s:param>saveArNamenull</s:param>
                 </s:fielderror>
            </td>
         </tr>
          <tr>
             <td> 备    注：</td>
             <td align="center"> <s:textarea  name="remarks" cols="23" rows="4"></s:textarea> </td>
         </tr>
          <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="提交申请"></s:submit>
              <s:reset name="reset" value="重新输入"></s:reset>             
            <br></td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>