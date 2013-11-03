<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@page import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>费用详情</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
 String aId=(String)request.getParameter("aId");
  if(user==null) response.sendRedirect("../index.jsp"); 
    List<storeHouse> ps=new ArrayList<storeHouse>();
    if(aId!=null){
    ps=storeHouseDao.selectHouseForUser(user.getUserName(), aId); 
    }
    else {/* 
    String said=(String)request.getAttribute("said");
    if(said!=null) ps=storeHouseDao.selectHouse(said); 
     */}
    request.setAttribute("ps",ps); 
    String shn="",fc="",sc="",gd="",sname="",vname="";
    if(ps.size()>0){
	     shn=daoUtil.selectShouseName(Integer.valueOf(ps.get(0).getHouseId()).intValue());
	     fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.get(0).getFirstCName()).intValue());
	     sc=daoUtil.selectSecondClass8(ps.get(0).getSecondCName());     
	     gd=daoUtil.selectDepartment3(Integer.valueOf(ps.get(0).getDepartment()).intValue());
	     sname=daoUtil.selectUser(ps.get(0).getUserName().trim());
	     vname=daoUtil.selectUser(ps.get(0).getInVerifyName().trim());
	    String status;
	    if(ps.get(0).getInVerify()==0)status="未审核";
	       else if(ps.get(0).getInVerify()==1)status="审核通过";
	            else status="审核未通过"; 
    }
  %>
     <s:form action="verifyStoreAction" method="post" theme="simple">
       <table class="actionmessage" align="center" >
           <tr><td>&nbsp; <s:actionmessage/></td></tr>
      
       </table>
       <div style="width:80%;margin: 0 auto;">
       <table class="table table-striped table-bordered" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
               <s:hidden name="id" value="%{#request.ps.id}" ></s:hidden>
          <tr height="25">
             <%--  <td align="center" width="15%">日期</td><td width="35%"><%= CurrentDate.parseDate4(ps.getInDate().toString()) %></td> --%>
              <td colspan="2" width="15%" align="center">部门</td><td colspan="2" width="35%"><%= gd%></td>
              <td colspan="2" align="center">库房</td><td colspan="2"><%= shn %></td>
          </tr>
            <tr height="25">
              <td colspan="2" align="center">入库人</td><td colspan="2"><%= daoUtil.selectUser(aId)%></td>
               <td colspan="2" align="center">审核人</td><td colspan="2"><%= vname%></td>
          </tr>
          <tr>
          	<td align="center">分类</td>
          	<td>物品名称</td>
          	<td>规格</td>
          	<td>数量</td>
          	<td>单价</td>
          	<td>总价</td>
          	<td>状态</td>
          	<td>备注</td>
          </tr>
          <%for(storeHouse p:ps) {%>
          	<tr>
          		<td><%= daoUtil.selectFirstClass5(Integer.valueOf(p.getFirstCName()).intValue())%></td>
          	    <td><%= daoUtil.selectSecondClass8(p.getSecondCName())%></td>
          		<td><%= p.getInContent()%></td>
          		<td><%= p.getInCount()%>&nbsp;<%= p.getUnit()%></td>
          		<td><%= p.getUnitPrice() %></td>
          		<td><%= p.getUnitPrice()*p.getInCount() %></td>
          		<td>
          			<%if(ps.get(0).getInVerify()==0){%>未审核
          			<%}else if(ps.get(0).getInVerify()==1){%>审核通过
          			<%}else{ %>
	                                                     审核未通过<%} %> 
          		</td>
          		<td><%= p.getInRemarks() %></td>
          	</tr>
          <% } %> 
             <tr height="25">	
            	<td align="center" colspan="2">
						审 核：
					</td>
					<td align="left" colspan="2">
						<input type="radio" name="inVerify" value="1" checked="checked" />
						通过
						<input type="radio" name="inVerify" value="2" />
						不通过
					</td>
					<td align="center" colspan="2">审核意见</td>
					<td colspan="2"><s:textarea name="verifyRemarks" value="同意" cols="23" rows="4"></s:textarea></td>
				</tr>
           <tr height="26">
            <td align="center" colspan="8">
              <s:submit name="submit" style="font-size:12px"value="审核确认"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
              <s:reset name="reset" style="font-size:12px"value="重新填写"></s:reset>             
            <br></td>
          </tr>
       </table>
       </div>
   </s:form>
</body>
</html>