<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="com.yz.manager.bean.secondClass" %> 
<%@page import="com.yz.manager.dao.daoUtil" %>
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修二级分类名</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
<%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  int id=0;
  if(request.getAttribute("said")!=null){
      
    id=Integer.valueOf((String)request.getAttribute("said")).intValue();
   
  }else{
    id=Integer.valueOf(request.getParameter("sId").trim()).intValue();
  }
     secondClass fc=daoUtil.selectSecondClass3(id);
    request.setAttribute("fc",fc); 
     String sn=daoUtil.selectShouseName(Integer.valueOf(fc.getHouseId()).intValue()); 
    request.setAttribute("s",sn);  
    String sdp=daoUtil.selectDepartment3(Integer.valueOf(fc.getDepartment()).intValue());
    request.setAttribute("sdp1",sdp);
    String fcn=daoUtil.selectFirstClass5(Integer.valueOf(fc.getFirstCName()).intValue());
    request.setAttribute("fcn",fcn);
  
  %>
 <h1 class="h1" align="center">修改二级分类</h1>
 
 <s:form action="modifyHouseSecondClassAction2" method="post" theme="simple">
        <s:token></s:token>
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
           <tr >
             <td align="center"> 分类编号：</td>
             <td align="center"> <s:textfield name="id" value="%{#request.fc.id}"  readonly="true" size="30" ></s:textfield></td>
         </tr>
                <tr><td>&nbsp;</td></tr>  
          <tr >
             <td align="center"> 部门：</td>
             <td align="center"> <s:textfield  value="%{#request.sdp1}" readonly="true" size="30" ></s:textfield></td>
         </tr>
           <tr><td>&nbsp;</td></tr> 
          <tr>
             <td align="center"> 库房：</td>
             <td align="center"> <s:textfield value="%{#request.s}" readonly="true"  size="30"></s:textfield></td>
         </tr>
          <tr><td>&nbsp;</td></tr> 
         <tr>
            <td align="center"> 一级分类：</td>
             <td align="center"> <s:textfield  name="firstCName" value="%{#request.fcn}" readonly="true"  size="30"></s:textfield></td>
         </tr>
          <tr><td>&nbsp;</td></tr> 
           <tr>
             <td align="center">修改二级分类：</td>
             <td align="center"> <s:textfield name="secondCName" value="%{#request.fc.secondCName}"  size="30"></s:textfield></td>
              <td class="actionmessage">
            <s:fielderror >
                   <s:param>
                    secondnull
                   </s:param>
               </s:fielderror>
             </td>
         </tr>
               <tr><td>&nbsp;</td></tr>  
               <tr>
             <td align="center">修改价格：</td>
             <td align="center"> <s:textfield name="unitPrice"  value="%{#request.fc.unitPrice}" size="30"></s:textfield></td>
             <td class="actionmessage">
            <s:fielderror >
                   <s:param>
                     unitPrice
                   </s:param>
               </s:fielderror>
             </td>
         </tr>
               <tr><td>&nbsp;</td></tr>    
               <tr>
             <td align="center">修改单位：</td>
             <td align="center"> <s:textfield name="unit" value="%{#request.fc.unit}"  size="30"></s:textfield></td>
            <td class="actionmessage">
            <s:fielderror >
                   <s:param>
                     unitnull
                   </s:param>
               </s:fielderror>
             </td>
         </tr>
               <tr><td>&nbsp;</td></tr>             
          <tr>
            
            <td align="center" colspan="2">
              <s:submit name="submit" value="提  交"></s:submit>&nbsp;&nbsp;
              <s:reset name="reset" value="重  置"></s:reset>             
            <br></td>
          </tr>
       </table>
       
       
       </s:form>
           
</body>
</html>