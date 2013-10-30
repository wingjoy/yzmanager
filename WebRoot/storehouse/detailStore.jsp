<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
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
    storeHouse ps=new storeHouse();
    String aId=(String)request.getParameter("aId");
    
    if(aId!=null){
    ps=storeHouseDao.selectHouse(aId); 
    }
  
    request.setAttribute("ps",ps); 
    String shn=daoUtil.selectShouseName(Integer.valueOf(ps.getHouseId()).intValue());
    String fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.getFirstCName()).intValue());
    String sc=daoUtil.selectSecondClass8(ps.getSecondCName());     
    String gd=daoUtil.selectDepartment3(Integer.valueOf(ps.getDepartment()).intValue());
     String gd1=daoUtil.selectDepartment3(Integer.valueOf(ps.getInDepartment()).intValue());
    String sname=daoUtil.selectUser(ps.getUserName().trim());
    String vname=daoUtil.selectUser(ps.getInVerifyName().trim());
    String status;
    if(ps.getInVerify()==0)status="未审核";
       else if(ps.getInVerify()==1)status="审核通过";
            else status="审核未通过";
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
              <td align="center" width="15%">日期</td><td width="35%"><%= CurrentDate.parseDate4(ps.getInDate().toString()) %></td><td width="15%" align="center">库房部门</td><td width="35%"><%= gd%></td>
          </tr>
            <tr height="25">
              <td align="center">库房</td><td><%= shn %></td><td align="center">分类</td><td><%= fc%>--<%= sc%></td>
          </tr>
            <tr height="25">
              <td align="center">入库人</td><td><%= gd1%>--<%= sname%></td>
              <td align="center">规格</td><td><%= ps.getInContent()%></td>
          </tr>
           <tr height="25">
              <td align="center">单价</td><td><%= ps.getUnitPrice() %></td>
              <td align="center">数量</td><td><%= ps.getInCount()%>&nbsp;<%= ps.getUnit()%></td>
          </tr>  
          <tr height="25">
              <td align="center">总价</td><td><%= ps.getTotalPrice() %></td>
              <td align="center">审核人</td><td><%= vname%></td>
          </tr>
              <tr height="25">
                <td align="center">审核状态</td><td><%= status %></td>
                <td align="center">入库备注</td><td><%= ps.getInRemarks() %></td>
           </tr>
             <tr height="25">	
					<td align="center" >审核意见</td>
					<td colspan="3"><%= ps.getVerifyRemarks() %></td>
				</tr>
          
       </table>
</body>
</html>