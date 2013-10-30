<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.archives.bean.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>档案查询</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  archives ar=new archives();
    String aId=(String)request.getParameter("aId");
    
    if(aId!=null){
    ar=archivesDao.selectArchives1(aId); 
    }
    else {
    String said=(String)request.getAttribute("said");
    if(said!=null) ar=archivesDao.selectArchives1(said);
    }
    request.setAttribute("ar",ar); 
    String fc=daoUtil.selectFirstClass5(Integer.valueOf(ar.getFirstCName()).intValue());
    String sc=daoUtil.selectSecondClass8(ar.getSecondCName());     
    String gd=daoUtil.selectDepartment3(Integer.valueOf(ar.getDepartment()).intValue());
    String sd=daoUtil.selectDepartment3(Integer.valueOf(ar.getSaveArDepartment()).intValue());
    String sname=daoUtil.selectUser(ar.getSaveArName().trim());
  %>
     <s:form action="modifyArchivesAction" method="post" theme="simple">
       <table class="actionmessage" align="center" >
       <tr><td align="center"> <s:actionmessage></s:actionmessage></td></tr>
       <tr>
          <td  align="center"> 
              <s:fielderror  >   
                         <s:param>fileNamenull</s:param>
                 </s:fielderror>
          </td>
       </tr>
        <tr>
          <td align="center"> 
              <s:fielderror  >   
                         <s:param>fileNumbernull</s:param>
                 </s:fielderror>
          </td>
       </tr>
       <tr>
          <td align="center"> 
              <s:fielderror  >   
                         <s:param>fileCoverNumbernull</s:param>
                 </s:fielderror>
          </td>
       </tr>
        <tr><td><a class="left-font01" href="selectArchives.jsp?currentPage=1">返回</a></td></tr>
       </table>
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
               <s:hidden name="id" value="%{#request.ar.id}" ></s:hidden>
          <tr height="25">
              <td align="center" width="15%">文件名称</td><td width="35%"><s:textfield name="fileName" value="%{#request.ar.fileName}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center" width="15%">分类</td><td width="35%"><%= fc%>--<%= sc%></td>
          </tr>
            <tr height="25">
              <td align="center">档案编号</td><td><s:textfield name="fileNumber" value="%{#request.ar.fileNumber}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center">页数</td><td><%= ar.getFilePages() %></td>
          </tr>
            <tr height="25">
              <td align="center">袋号</td><td><s:textfield name="fileCoverNumber" value="%{#request.ar.fileCoverNumber}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center">保存年限</td><td><s:textfield name="saveYears" value="%{#request.ar.saveYears}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
            <tr height="25">
              <td align="center"> 交档部门</td><td><%= gd %></td><td align="center">交档人</td><td><%= ar.getGiveArName() %></td>
          </tr>
            <tr>
              <td align="center">存档部门</td><td><%= sd %></td><td align="center">存档人</td><td><%= sname %></td>
          </tr>
           <tr height="25">
              <td align="center">交档日期</td><td><%= CurrentDate.parseDate1(ar.getArDate().toString()) %></td><td align="center">存档日期</td><td><%=  CurrentDate.parseDate1(ar.getSaveArDate().toString()) %></td>
          </tr>
           <tr height="25">
            <td align="center">文件下载</td>
           <%
             if(ar.getFileDir()==null){
                 out.println(
		              "<td>无电子档文件</td>" 
		             ); 
             }else{
                 out.println(
		              "<td ><a class='left-font01' href='"+ ar.getFileDir()+"' >下载查阅</a></td>" 
		              );
             }
            %>            
          </tr>
            <tr height="25">
              <td align="center">档案备注</td><td><s:textarea value="%{#request.ar.remarks}" cols="25" rows="4" ></s:textarea><span class="xiugai">*可修改</span></td>
          </tr>
          <tr height="25">
              <td align="center"> 审核意见</td><td><s:textarea value="%{#request.ar.saveArRemarks}" cols="25" rows="4" readonly="true"></s:textarea></td>
          </tr>
           <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="修 改"></s:submit>
              <s:reset name="reset" value="重 置"></s:reset>             
            <br></td>
          </tr>
       </table>
   </s:form>
</body>
</html>