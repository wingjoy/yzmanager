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
<title>��������</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
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
  
    request.setAttribute("ps",ps); 
    String shn=daoUtil.selectShouseName(Integer.valueOf(ps.getHouseId()).intValue());
    String fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.getFirstCName()).intValue());
    String sc=daoUtil.selectSecondClass8(ps.getSecondCName());     
    String gd=daoUtil.selectDepartment3(Integer.valueOf(ps.getDepartment()).intValue());
    String sgd=daoUtil.selectDepartment3(Integer.valueOf(ps.getApplyDepartment()).intValue());
    String outd="δ����";
    if(ps.getOutDate()!=null)
    outd= CurrentDate.parseDate4(ps.getOutDate().toString());
     
      String sname="";
      String bname="";
      String kname="";
      String kgname="";
     sname=daoUtil.selectUser(ps.getUserName().trim());
	    if(!"0".equals(ps.getInVerifyName().trim())){
	       bname=daoUtil.selectUser(ps.getInVerifyName().trim());
	    }
         if(!"0".equals(ps.getHouseVerifyName().trim())){
	        kname=daoUtil.selectUser(ps.getHouseVerifyName().trim());
	    }
	    if(!"0".equals(ps.getHouseManager().trim())){
	        kgname=daoUtil.selectUser(ps.getHouseManager().trim());
	    }
	    
        String bVerify="δ���";
        String kVerify="δ���";
        String kfVerify="δ���";
               if(ps.getOutVerify()!=0&ps.getOutVerify()!=11){
		              bVerify="���ͨ��";
		              }else  if(ps.getOutVerify()==11){
		                 bVerify="���δͨ��";
		              }
		              if(ps.getOutVerify()>=2&ps.getOutVerify()<11){
		                 kVerify="���ͨ��";
		              }else  if(ps.getOutVerify()==22){
		                kVerify="���δͨ��";
		              }
		              if(ps.getOutVerify()==3){
		                kfVerify="���ͨ��";
		              }else  if(ps.getOutVerify()==33){
		                 kfVerify="���δͨ��";
		              }
  %>
  
       <table class="left-font01" align="center">
       <tr><td>&nbsp;</td></tr>
       <tr><td>&nbsp;</td></tr>
       <tr><td>&nbsp;</td></tr>
        <tr><td><a class="left-font01" href='javascript:history.go(-1);'>����</a></td></tr>
            <tr><td>&nbsp;</td></tr>
       </table>
       <table class="table table-bordered" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
            
          <tr height="25">
              <td align="center" width="15%">��������</td><td width="35%">&nbsp;<%= CurrentDate.parseDate4(ps.getApplyDate().toString()) %></td><td width="15%" align="center">���벿��</td><td width="35%">&nbsp;<%= sgd%></td>
          </tr>
           <tr height="25">
              <td align="center">������</td><td>&nbsp;<%= sname%></td>
              <td align="center">������Ʒ</td><td>&nbsp;<%=  sc%></td>
          </tr>
            <tr height="25">
              <td align="center">��;</td><td >&nbsp;<%= ps.getPurpose()%></td>
               <td align="center">��ע</td><td>&nbsp;<%= ps.getOutRemarks()%></td>
          </tr>
            <tr height="25">
              
              <td align="center">��Ʒ�ⷿ</td><td>&nbsp;<%=  gd %>--<%= shn %></td><td align="center">��Ʒ����</td><td>&nbsp;<%= fc%></td>
          </tr>
            <tr height="25">
            <td align="center">��������</td><td>&nbsp;<%= ps.getApplyCount()%>&nbsp;<%= ps.getUnit()%></td>
            <td align="center" width="15%">��������</td><td width="35%">&nbsp;<%= outd%></td>
          </tr>
          <tr height="25">
             <td align="center">���������</td><td>&nbsp;<%= bname%>&nbsp;&nbsp;<%=bVerify %></td>
              <td align="center">����������</td><td>&nbsp;<%= ps.getInVerifyRemarks()%></td>
          </tr>
           <tr height="25">
              <td align="center">�ⷿ�����</td><td>&nbsp;<%= kname%>&nbsp;&nbsp;<%=kVerify %></td>
              <td align="center">�ⷿ������</td><td>&nbsp;<%= ps.getHouseVerifyRemarks()%></td>
          </tr>  
          <tr height="25">
              <td align="center">���Ա</td><td>&nbsp;<%= kgname%>&nbsp;&nbsp;<%=kfVerify %></td>
              <td align="center">��ܳ������</td><td>&nbsp;<%= ps.getHouseManagerRemarks()%></td>
          </tr>
   
       </table>
</body>
</html>