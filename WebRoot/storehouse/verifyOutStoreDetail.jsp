<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>费用详情</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
    outStoreHouse ps=new outStoreHouse();
    String aId=(String)request.getParameter("aId");
    
    if(aId!=null){
    ps=storeHouseDao.selectOutHouse(aId); 
    }
    else {
    String said=(String)request.getAttribute("said");
    if(said!=null) ps=storeHouseDao.selectOutHouse(said); 
    }
    request.setAttribute("ps",ps); 
     List<user> verifyName=new ArrayList<user>();
     if(ps.getOutVerify()==0){
        verifyName=daoUtil.selectHouseVerifyName(ps.getDepartment());
     }else if(ps.getOutVerify()==1){
         verifyName=daoUtil.selectHouseManagerVerifyName(ps.getHouseId());
     }
     
    String shn=daoUtil.selectShouseName(Integer.valueOf(ps.getHouseId()).intValue());
    String fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.getFirstCName()).intValue());
    String sc=daoUtil.selectSecondClass8(ps.getSecondCName());     
    String sqgd=daoUtil.selectDepartment3(Integer.valueOf(ps.getApplyDepartment()).intValue());
    String kgd=daoUtil.selectDepartment3(Integer.valueOf(ps.getDepartment()).intValue());
    String sname=daoUtil.selectUser(ps.getUserName().trim());  
  %>
     <s:form action="verifyOutStoreAction" method="post" theme="simple">
       <table class="actionmessage" align="center" >
           <tr><td>&nbsp; <s:actionmessage/></td></tr>
            <tr><td>&nbsp; 
             <s:fielderror>
               <s:param>
                 verifynull
               </s:param>
             </s:fielderror>
            </td></tr>
      
       </table>
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
               <s:hidden name="id" value="%{#request.ps.id}" ></s:hidden>
               <s:hidden name="outVerify" value="%{#request.ps.outVerify}" ></s:hidden>
          <tr height="25">
              <td align="center" width="15%">申请日期</td><td width="35%"><%= CurrentDate.parseDate4(ps.getApplyDate().toString()) %></td><td width="15%" align="center">申请部门</td><td width="35%"><%= sqgd%></td>
          </tr>
           <tr height="25">
              <td align="center">申请人</td><td><%= sname%></td>
              <td align="center">库存部门</td><td><%= kgd %></td>
          </tr>
            <tr height="25">
              <td align="center">库房</td><td><%= shn %></td><td align="center">分类</td><td><%= fc%>--<%= sc%></td>
          </tr>
         
           <tr height="25">
              <td align="center">申请数量</td><td><%= ps.getApplyCount()%>&nbsp;<%= ps.getUnit()%></td>
              <td align="center">用途</td><td><%= ps.getPurpose()%></td>
          </tr>  
          <tr height="25">
             <td align="center">领用备注</td><td colspan="3"><%= ps.getOutRemarks() %></td>
              
          </tr>
           
             <tr height="25">	
            	<td align="center">
						审 核：
					</td>
					<td align="left">
						<input type="radio" name="verify" value="1" checked="checked" />
						通过
						<input type="radio" name="verify" value="2" />
						不通过
					</td>
					<td align="center">审核意见</td>
					<td><s:textarea name="verifyRemarks" value="" cols="23" rows="4"></s:textarea></td>
				</tr>
		<tr height="25">
		 <%
		   if(ps.getOutVerify()==0){
		      out.println(
		          "<td align='center' style='color:red'> 提交库房主管审核：</td>");
		  %>
		      <td colspan='3'>
		           <select  name="nextVerifyName" style="width:200px;" > 
		           <option selected value="0">选择审核人</option>
		           <% 
					   for(user u :verifyName){
				%>
					 <option value="<%= u.getUserName()%>"><%=u.getName()%></option>
                    <% }
		           %> 
                   </select>
              </td>
            
		   <% }
		    else  if(ps.getOutVerify()==1){
			      out.println(
			          "<td align='center' style='color:red'> 提交库房管理员审核：</td>");
		   
		   %>
		        <td colspan='3'>
		           <select  name="nextVerifyName" style="width:200px;" > 
		           <option selected value="0">选择审核人</option>
		           <% 
					   for(user u :verifyName){
				%>
					 <option value="<%= u.getUserName()%>"><%=u.getName()%></option>
                    <% }
		           %> 
                   </select>
              </td>
		  <%}
		    else{
		         out.println(
			          "<td align='center' style='color:red' colspan='3'> 请联系物品领用人进行出库业务处理</td>");
		     %>
		        <td>
		           <s:hidden name="nextVerifyName" value="%{#request.ps.nextVerifyName}" ></s:hidden>
              </td></tr> 
		  <%}
	     %>
		  
             
           <tr align="center" height="26">
            <td align="center" colspan="4">
              <s:submit name="submit" style="font-size:12px"value="审核确认"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
              <s:reset name="reset" style="font-size:12px"value="重新填写"></s:reset>             
            <br></td>
          </tr>
       </table>
   </s:form>
</body>
</html>