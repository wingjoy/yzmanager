<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
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
     
     List<system> sys=new ArrayList<system>();
     sys=daoUtil.selectSystem4();

     List<firstClass> fc = new ArrayList<firstClass>();
     fc=daoUtil.selectFirstClass3(dpId);
    %>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add secondClass</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<script language="javascript">
			var onecount1;
			onecount1=0;
			subcat1=new  Array();  
			<%
			int count1=0;
			for(firstClass sf: fc){
			 %>
			 subcat1[<%=count1%>]=new Array("<%= sf.getId()%>","<%=sf.getFirstCName()%>","<%=sf.getSystemName()%>");
			 <%
			 count1 = count1 + 1 ; 	
			}
			%>
			onecount1=<%=count1%>;
			function changelocation1(locationid){
			var locationid=locationid;
			document.myform.firstCName.length=0;
			var i1;
			document.myform.firstCName.options[0]=new Option('选择一级分类','0'); 
			for(i1=0;i1<onecount1;i1++){
			if (subcat1[i1][2] == locationid) 
			{ 
			document.myform.firstCName.options[document.myform.firstCName.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
			} 			 
			} 		   
			}
			</script>
</head>
<body bgcolor="#E4FAF9">

 <h1 class="h1" align="center">增加二级分类</h1>
  
    <s:form name="myform" action="addsecondClassAction" method="post" theme="simple">     
       <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
      
        <tr>
             <td align="right"> 部  门：</td>
             <td align="center"> <s:textfield style="width:160px;" name="department1" value="%{#request.sdp1}" readonly="true" size="30" ></s:textfield></td>
         </tr> 
          <tr><td>&nbsp;</td></tr>         
         <tr>
             <td align="right">选择系统：  </td>
           <td>  <select name="systemName" style="width:165px;"
							onChange="changelocation1(document.myform.systemName.options[document.myform.systemName.selectedIndex].value)"
							size="1">						
					<option selected value="0">	选择系统</option>	
							<%
								for (system s : sys) {
							%>
							<option value="<%=s.getSystemID()%>"><%=s.getSystemName()%></option>

							<%
								}
							%>
						</select>
				</td>
		 </tr>
		  <tr><td>&nbsp;</td></tr>         	
		 <tr>
		   <td align="right">一级分类：  </td>
           <td>  <select name="firstCName" style="width:165px;">				
							<option selected value="0">
								选择一级分类
							</option>
						</select>
				</td>	
        <td>
           <s:fielderror  >   
                         <s:param>nullfirstclass</s:param>
                 </s:fielderror>
        </td>
         </tr>
         <tr><td>&nbsp;</td></tr>         
         <tr>    
             <td align="right"> 二级分类名：</td>
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