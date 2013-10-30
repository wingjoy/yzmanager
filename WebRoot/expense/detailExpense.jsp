<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.expense.bean.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>费用详情</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
    String aId=(String)request.getParameter("aId");
    expense ps=expenseDao.selectExpense(aId); 

    request.setAttribute("p1",ps); 
    String fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.getFirstCName()).intValue());
    String sc=daoUtil.selectSecondClass8(ps.getSecondCName());     
    String gd=daoUtil.selectDepartment3(Integer.valueOf(ps.getDepartment()).intValue());
    String sname=daoUtil.selectUser(ps.getUserName().trim());
    String everifyName=daoUtil.selectUser(ps.getEverifyName().trim());
    String cm=daoUtil.selectGCompanyName(Integer.valueOf(ps.getCompany()).intValue());
    String pm=daoUtil.selectPayModeName(Integer.valueOf(ps.getPayMode()).intValue());
  %>
       <table class="left-font01" align="center">
       <tr><td>&nbsp;</td></tr>
       <tr><td>&nbsp;</td></tr>
       <tr><td>&nbsp;</td></tr>
        <tr><td><a class="left-font01" href='javascript:history.go(-1);'>返回</a></td></tr>
            <tr><td>&nbsp;</td></tr>
       </table>
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
           <tr height="25">
              <td width="15%"align="center">日期</td><td width="35%">&nbsp;<%= CurrentDate.parseDate4(ps.getAddDate().toString()) %></td><td align="center" width="15%">费用部门</td><td width="35%">&nbsp;<%= gd%></td>
          </tr>
           <tr height="25">
              <td align="center">经办人</td><td>&nbsp;<%= sname %></td><td align="center">费用性质</td><td>&nbsp;<%= ps.getNature()%></td>
          </tr>
          <tr height="25">
              <td align="center">分类</td><td>&nbsp;<%= fc%>--<%= sc%></td><td align="center">内容</td><td>&nbsp;<%= ps.getContent()%></td>
          </tr>
            <tr height="25">
              <td align="center">供应商</td><td>&nbsp;<%= ps.getSupplier() %></td><td align="center">供应商地址</td><td>&nbsp;<%= ps.getSupplierAddress()%></td>
          </tr>
           <tr height="25">
              <td align="center">联系人</td><td>&nbsp;<%= ps.getContactName()%></td><td align="center">联系电话</td><td>&nbsp;<%= ps.getContactPhone()%></td>
          </tr>
            <tr height="25">
              <td align="center">单价</td><td>&nbsp;<%= ps.getUnitPrice() %></td><td align="center">数量</td><td>&nbsp;<%= ps.getNumber() %>&nbsp;<%= ps.getUnit()%></td>
          </tr>
          <tr height="25">
              <td align="center">总价</td><td>&nbsp;<%= ps.getTotalPrice()%></td>
              <td align="center">挂账公司</td><td>&nbsp;<%= cm %></td>
          </tr>
          <tr height="25">
              <td align="center">付款方式</td><td>&nbsp;<%= pm %></td>
              <td align="center">审核人</td><td>&nbsp;<%= everifyName%></td>
          </tr>    
          <tr height="25">
               <td align="center">审核状态</td>
               <% 
              if(0==ps.getEverify()){
		       out.println(													
					"<td >&nbsp;未审核</td>");
		     }else if(1==ps.getEverify()){
		         out.println(													
						"<td >&nbsp;审核通过</td>");
		     }else{
		         out.println(													
						"<td >&nbsp;审核没有通过</td>");
		     }
             %>  
              <td align="center">备注</td><td colspan="3">&nbsp;<%= ps.getRemarks() %></td>   
          </tr>
       </table>
 
</body>
</html>