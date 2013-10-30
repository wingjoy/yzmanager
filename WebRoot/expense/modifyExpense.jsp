<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.expense.bean.*" %> 
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
  expense ps=new expense();
    String aId=(String)request.getParameter("aId");
    
    if(aId!=null){
    ps=expenseDao.selectExpense(aId); 
    }
    else {
    String said=(String)request.getAttribute("said");
    if(said!=null) ps=expenseDao.selectExpense(said);
    }
    request.setAttribute("ps",ps); 
    String fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.getFirstCName()).intValue());
    String sc=daoUtil.selectSecondClass8(ps.getSecondCName());     
    String gd=daoUtil.selectDepartment3(Integer.valueOf(ps.getDepartment()).intValue());
    String sname=daoUtil.selectUser(ps.getUserName().trim());
    String vname=daoUtil.selectUser(ps.getEverifyName().trim());
    String cm=daoUtil.selectGCompanyName(Integer.valueOf(ps.getCompany()).intValue());
    String pm=daoUtil.selectPayModeName(Integer.valueOf(ps.getPayMode()).intValue());
    String status;
    if(ps.getEverify()==0)status="未审核";
    else if(ps.getEverify()==1)status="审核通过";
    else status="审核未通过";
  %>
     <s:form action="modifyExpenseAction" method="post" theme="simple">
       <table class="actionmessage" align="center" >
         <tr><td>&nbsp;</td></tr>
      
      <tr><td class="actionmessage"> <s:actionmessage/></td></tr>
      
            <tr><td>&nbsp;</td></tr>
       </table>
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
               <s:hidden name="id" value="%{#request.ps.id}" ></s:hidden>
          <tr height="25">
              <td align="center" width="15%">日期</td><td width="35%"><%= CurrentDate.parseDate4(ps.getAddDate().toString()) %></td><td align="center" width="15%">部门</td><td width="35%"><%= gd%></td>
          </tr>
            <tr height="25">
              <td align="center">经办人</td><td><%= sname%></td><td align="center">费用性质</td><td><%= ps.getNature() %></td>
          </tr>
            <tr height="25">
              <td align="center">分类</td><td><%= fc%>--<%= sc%></td>
              <td align="center">内容</td><td><%= ps.getContent() %></td>
          </tr>
            <tr height="25">
              <td align="center">供应商</td><td><s:textfield name="supplier" value="%{#request.ps.supplier}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center">供应商地址</td><td><s:textfield size="40" name="supplierAddress" value="%{#request.ps.supplierAddress}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
          <tr height="25">
              <td align="center">联系人</td><td><s:textfield name="contactName" value="%{#request.ps.contactName}" ></s:textfield><span class="xiugai">*可修改</span></td>
              <td align="center">联系电话</td><td><s:textfield name="contactPhone" value="%{#request.ps.contactPhone}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
           <tr height="25">
              <td align="center">单价</td><td><%= ps.getUnitPrice() %></td>
              <td align="center">数量</td><td><%= ps.getTotalPrice()%>&nbsp;<%= ps.getUnit()%></td>
          </tr> 
           <tr height="25">
              <td align="center">总价</td><td><%= ps.getTotalPrice() %></td>
              <td align="center">挂账公司</td><td><%= cm %></td>
         
          </tr>
          <tr height="25">
              <td align="center">付款方式</td><td><%= pm %></td>
              <td align="center">审核人</td><td><%= vname%></td>
         
          </tr>
              <tr height="25">
               <td align="center">审核状态</td><td><%= status %></td>
              <td  align="center">档案备注</td><td><s:textarea name="remarks" value="%{#request.ps.remarks}" cols="25" rows="4" ></s:textarea><span class="xiugai">*可修改</span></td>
          </tr>
           <tr height="25">
            <td align="center" colspan="4">
              <s:submit name="submit" style="font-size:14px"value="修   改"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
              <s:reset name="reset" style="font-size:14px"value="重   置"></s:reset>             
            <br></td>
          </tr>
       </table>
   </s:form>
</body>
</html>