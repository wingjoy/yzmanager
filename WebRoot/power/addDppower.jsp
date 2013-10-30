<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.user" %> 
<%@page import="com.yz.manager.bean.power" %> 
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add user power</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body  bgcolor="#E4FAF9">

 <h1 class="h1" align="center">增加员工权限</h1>
   <% 
    user user=(user)session.getAttribute("us");
    if(user==null) response.sendRedirect("../index.jsp"); 
     String un=request.getParameter("uname").trim();
     request.setAttribute("username",un);
     power pw=new power();
     pw=daoUtil.selectPower(un);
    
    %>

    <s:form action="addDppowerAction" method="post" theme="simple">
                    
           <input type="hidden" name="username" value="<%= request.getParameter("uname").trim() %>"/>
		   <input type="hidden" name="department" value="<%= request.getParameter("dp").trim() %>"/>
		  <table class="left-font01" width="60%"  align="center" border="1" cellspacing="0" cellpadding="0" >
      <tr>  
      </table>
      
		
			<table width="80%" class="left-font01" align="center" border="1" cellspacing="0" cellpadding="0" height="40">
				
				<tr height="25" class="tableth" bgcolor="#8E8EFF">
					<th align="center">系统选择</th>				
					<th align="center">查询</th>
					<th align="center">增加</th>
					<th align="center">修改</th>
					<th align="center">删除</th>
					<th align="center">查询其他员工</th>	
					<th align="center">人员费用汇总</th>	
					<th align="center">分类费用汇总</th>	
					<th align="center">审核</th>						
				</tr>
		 <%
		   if(pw==null){
		    out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ams' value='true' />"+
						"档案管理系统"+
					"</td>"+					
					"<td align='center'>"+
						"<input type='checkbox' name='amsselect' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='amsadd' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"&nbsp;<input type='hidden' name='amsmodify' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"&nbsp;<input type='hidden' name='amsdelete' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='amsSelectOther' value='true' />"+
					"</td>"+
					"<td align='center'>&nbsp;"+
					"</td>	"+	
					"<td align='center'>&nbsp;"+
					"</td>	"+	
					"<td align='center'>"+
						"<input type='checkbox' name='averify' value='true' />"+
					"</td>	"+				
				"</tr>"+
				
				 " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pms' value='true' />"+
						"人员管理系统"+
					"</td>"+					
					"<td align='center'>"+
						"<input type='checkbox' name='pmsselect' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pmsadd' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pmsmodify' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pmsdelete' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pmsSelectOther' value='true' />"+
					"</td>"+
					"<td align='center'>&nbsp;"+			
					"</td>	"+	
					"<td align='center'>&nbsp;"+
					"</td>	"+	
					"<td align='center'>&nbsp;"+
					"</td>	"+				
				"</tr>"+

			   " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ems' value='true' />"+
						"费用管理系统"+
					"</td>"+					
					"<td align='center'>"+
						"<input type='checkbox' name='emsselect' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='emsadd' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='emsmodify' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='emsdelete' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='emsSelectOther' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='emsMonth' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='emsClass' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='everify' value='true' />"+
					"</td>	"+	
				"</tr>"+
				
				" <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ims' value='true' />"+
						"库存管理系统"+
					"</td>"+					
					"<td align='center'>"+
						"<input type='checkbox' name='imsInRegister' value='true' />入库"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='imsOutRegister' value='true' />出库"+
					"</td>"+
					"<td align='center'>&nbsp;"+			
					"</td>	"+	
					"<td align='center'>&nbsp;"+			
					"</td>	"+	
					"<td align='center'>&nbsp;"+			
					"</td>	"+	
					"<td align='center'>&nbsp;"+			
					"</td>	"+	
					"<td align='center'>&nbsp;"+			
					"</td>	"+		
					"<td align='center'>"+
						"<input type='checkbox' name='iverify' value='true' />"+
					"</td>	"+				
				"</tr>"	+
				
				" <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cms' value='true' />"+
						"客户管理系统"+
					"</td>"+					
					"<td align='center'>"+
						"<input type='checkbox' name='cmsselect' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cmsadd' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cmsmodify' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cmsdelete' value='true' />"+
					"</td>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cmsSelectOther' value='true' />"+
					"</td>"+
					"<td align='center'>&nbsp;"+			
					"</td>	"+	
					"<td align='center'>&nbsp;"+			
					"</td>	"+		
					"<td align='center'>&nbsp"+					
					"</td>	"+				
				"</tr>"	
				);  
		   }else{
		     if(pw.isAms()){
		        out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ams' value='true' checked='checked' />"+
						"档案管理系统"+
					"</td>");
		     }else{
		         out.println(
		    " <tr height='25'> "+
					"<td align='center'>"+
						"<input type='checkbox' name='ams' value='true'  />"+
						"档案管理系统"+
					"</td>");
		     }
		     if(pw.isAmsselect()){
		       out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='amsselect' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='amsselect' value='true' />"+
					"</td>");
		     }
		     if(pw.isAmsadd()){
		        out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='amsadd' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='amsadd' value='true' />"+
					"</td>");
		     }
		     if(pw.isAmsmodify()){
		          out.println(								
					"<td align='center'>"+
						"&nbsp;<input type='hidden' name='amsmodify' value='true' checked='checked' />"+
					"</td>");
		     }else{
		         out.println(								
					"<td align='center'>"+
						"&nbsp;<input type='hidden' name='amsmodify' value='true' />"+
					"</td>");
		     }
		     if(pw.isAmsdelete()){
		       out.println(													
					"<td align='center'>"+
						"&nbsp;<input type='hidden' name='amsdelete' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(													
					"<td align='center'>"+
						"&nbsp;<input type='hidden' name='amsdelete' value='true'/>"+
					"</td>");
		     }
		     if(pw.isAmsSelectOther()){
		       out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='amsSelectOther' value='true' checked='checked' />"+
					"</td>");
		     }else{
		        out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='amsSelectOther' value='true'  />"+
					"</td>");
		     }
		      out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
			  out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
		     if(pw.isAverify()){
		          out.println(																					
					"<td align='center'>"+
						"<input type='checkbox' name='averify' value='true'checked='checked' />"+
					"</td></tr>	");
		     }else{
		          out.println(																					
					"<td align='center'>"+
						"<input type='checkbox' name='averify' value='true'/>"+
					"</td></tr>	");
		     }
		     
		      if(pw.isPms()){
		        out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pms' value='true' checked='checked' />"+
						"人员管理系统"+
					"</td>");
		     }else{
		         out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='pms' value='true'  />"+
						"人员管理系统"+
					"</td>");
		     }
		     if(pw.isPmsselect()){
		       out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='pmsselect' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='pmsselect' value='true' />"+
					"</td>");
		     }
		     if(pw.isPmsadd()){
		        out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='pmsadd' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='pmsadd' value='true' />"+
					"</td>");
		     }
		     if(pw.isPmsmodify()){
		          out.println(								
					"<td align='center'>"+
						"<input type='checkbox' name='pmsmodify' value='true' checked='checked' />"+
					"</td>");
		     }else{
		         out.println(								
					"<td align='center'>"+
						"<input type='checkbox' name='pmsmodify' value='true' />"+
					"</td>");
		     }
		     if(pw.isPmsdelete()){
		       out.println(													
					"<td align='center'>"+
						"<input type='checkbox' name='pmsdelete' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(													
					"<td align='center'>"+
						"<input type='checkbox' name='pmsdelete' value='true'/>"+
					"</td>");
		     }
		     if(pw.isPmsSelectOther()){
		       out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='pmsSelectOther' value='true' checked='checked' />"+
					"</td>");
		     }else{
		        out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='pmsSelectOther' value='true'  />"+
					"</td>");
		     }
		      out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
					   out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
		   	out.println("<td align='center'>&nbsp;</td></tr>");
		    
		     if(pw.isEms()){
		        out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ems' value='true' checked='checked' />"+
						"费用管理系统"+
					"</td>");
		     }else{
		         out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ems' value='true'  />"+
						"费用管理系统"+
					"</td>");
		     }
		     if(pw.isEmsselect()){
		       out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='emsselect' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='emsselect' value='true' />"+
					"</td>");
		     }
		     if(pw.isEmsadd()){
		        out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='emsadd' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='emsadd' value='true' />"+
					"</td>");
		     }
		     if(pw.isEmsmodify()){
		          out.println(								
					"<td align='center'>"+
						"<input type='checkbox' name='emsmodify' value='true' checked='checked' />"+
					"</td>");
		     }else{
		         out.println(								
					"<td align='center'>"+
						"<input type='checkbox' name='emsmodify' value='true' />"+
					"</td>");
		     }
		     if(pw.isEmsdelete()){
		       out.println(													
					"<td align='center'>"+
						"<input type='checkbox' name='emsdelete' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(													
					"<td align='center'>"+
						"<input type='checkbox' name='emsdelete' value='true'/>"+
					"</td>");
		     }
		     if(pw.isEmsSelectOther()){
		       out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='emsSelectOther' value='true' checked='checked' />"+
					"</td>");
		     }else{
		        out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='emsSelectOther' value='true'  />"+
					"</td>");
		     }
		     if(pw.isEmsMonth()){
		       out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='emsMonth' value='true' checked='checked' />"+
					"</td>");
		     }else{
		        out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='emsMonth' value='true'  />"+
					"</td>");
		     }
		      if(pw.isEmsClass()){
		       out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='emsClass' value='true' checked='checked' />"+
					"</td>");
		     }else{
		        out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='emsClass' value='true'  />"+
					"</td>");
		     }
		      if(pw.isEverify()){
		          out.println(																					
					"<td align='center'>"+
						"<input type='checkbox' name='everify' value='true'checked='checked' />"+
					"</td></tr>	");
		     }else{
		          out.println(																					
					"<td align='center'>"+
						"<input type='checkbox' name='everify' value='true'/>"+
					"</td>	");
		     }
		   	out.println("</tr>");
		     
		     if(pw.isIms()){
		        out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ims' value='true' checked='checked' />"+
						"库存管理系统"+
					"</td>");
		     }else{
		         out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='ims' value='true'  />"+
						"库存管理系统"+
					"</td>");
		     }
		     if(pw.isImsInRegister()){
		       out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='imsInRegister' value='true'checked='checked' />入库"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='imsInRegister' value='true' />入库"+
					"</td>");
		     }
		     if(pw.isImsOutRegister()){
		        out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='imsOutRegister' value='true'checked='checked' />出库"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='imsOutRegister' value='true' />出库"+
					"</td>");
		     } 
		        out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
					   out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
					   out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
		      out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
					   out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
		   if(pw.isIverify()){
		          out.println(																					
					"<td align='center'>"+
						"<input type='checkbox' name='iverify' value='true'checked='checked' />"+
					"</td>");
		     }else{
		          out.println(																					
					"<td align='center'>"+
						"<input type='checkbox' name='iverify' value='true'/>"+
					"</td>");
		     }
		   	out.println("</tr>");     	   
		 
		    if(pw.isCms()){
		        out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cms' value='true' checked='checked' />"+
						"客户管理系统"+
					"</td>");
		     }else{
		         out.println(
		    " <tr height='25'>"+
					"<td align='center'>"+
						"<input type='checkbox' name='cms' value='true'  />"+
						"客户管理系统"+
					"</td>");
		     }
		     if(pw.isCmsselect()){
		       out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='cmsselect' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='cmsselect' value='true' />"+
					"</td>");
		     }
		     if(pw.isCmsadd()){
		        out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='cmsadd' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(			
					"<td align='center'>"+
						"<input type='checkbox' name='cmsadd' value='true' />"+
					"</td>");
		     }
		     if(pw.isCmsmodify()){
		          out.println(								
					"<td align='center'>"+
						"<input type='checkbox' name='cmsmodify' value='true' checked='checked' />"+
					"</td>");
		     }else{
		         out.println(								
					"<td align='center'>"+
						"<input type='checkbox' name='cmsmodify' value='true' />"+
					"</td>");
		     }
		     if(pw.isCmsdelete()){
		       out.println(													
					"<td align='center'>"+
						"<input type='checkbox' name='cmsdelete' value='true'checked='checked' />"+
					"</td>");
		     }else{
		         out.println(													
					"<td align='center'>"+
						"<input type='checkbox' name='cmsdelete' value='true'/>"+
					"</td>");
		     }
		     if(pw.isCmsSelectOther()){
		       out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='cmsSelectOther' value='true' checked='checked' />"+
					"</td>");
		     }else{
		        out.println(																	
					"<td align='center'>"+
						"<input type='checkbox' name='cmsSelectOther' value='true'  />"+
					"</td>");
		     }
		      out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
			  out.println(																					
					"<td align='center'>&nbsp;"+
					"</td>");
		   	out.println("<td align='center'>&nbsp;</td></tr>"); 	   
		   }
		  %>						
				<tr height="25">
				
					<td colspan="9" align="center">
						<s:submit name="submit" value="提 交"></s:submit>&nbsp;&nbsp;
						<s:reset name="reset" value="重 置"></s:reset>
					</td>
				</tr>
			</table>


		</s:form>
           
     
</body>
</html>