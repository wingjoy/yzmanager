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
<title>add secondClass</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">

 <h1 class="h1" align="center">增加二级分类</h1>
   <%
      user user=(user)session.getAttribute("us");
      if(user==null) response.sendRedirect("../index.jsp"); 
     
      String dpId=(String)request.getParameter("dpId");
      String dp=(String)request.getParameter("department1");
      String sdp;
      if(dpId==null&dp==null){
       dpId="1";
       sdp=daoUtil.selectDepartment3(Integer.valueOf(dpId).intValue());
       }else if(dp!=null){
       sdp=dp;
       dpId=daoUtil.selectDepartment5(dp);
       }
       else sdp=daoUtil.selectDepartment3(Integer.valueOf(dpId).intValue());
      request.setAttribute("sdp1",sdp);
     
     List<String> system=new ArrayList<String>();
     system=daoUtil.selectSystem2();
     request.setAttribute("system",system);

     HashMap<String, List<String>> fc = new HashMap<String, List<String>>();
     fc=daoUtil.selectDoubleFirstClass2(dpId);
     request.setAttribute("fc",fc);
    %>
 
    <s:form action="addsecondClassAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
      
        <tr>
             <td> 部  门：</td>
             <td align="center"> <s:textfield style="width:160px;" name="department1" value="%{#request.sdp1}" readonly="true" size="30" ></s:textfield></td>
         </tr> 
          <tr><td>&nbsp;</td></tr>         
         <tr>
             <td>选择具体系统分类：  </td>
             <td><s:doubleselect name="systemName" list="#request.system"
		doubleName="firstCName" doubleList="#request.fc.get(top)" ></s:doubleselect></td>
        <td>
           <s:fielderror  >   
                         <s:param>nullfirstclass</s:param>
                 </s:fielderror>
        </td>
         </tr>
         <tr><td>&nbsp;</td></tr>         
         <tr>    
             <td> 二级分类名：</td>
             <td align="center"> <s:textfield style="width:160px;" name="secondCName" size="30"></s:textfield></td>
        <td>
           <s:fielderror  >   
                         <s:param>nullsecondclass</s:param>
                 </s:fielderror>
        </td>
         </tr>
          <tr><td>&nbsp;</td></tr>         
          <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="提 交"></s:submit>
              <s:reset name="reset" value="重 置"></s:reset>             
            <br></td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>