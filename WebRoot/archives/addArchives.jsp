<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	user user = (user) session.getAttribute("us");
	if (user == null)
		response.sendRedirect("index.jsp");
	List<secondClass> sc = new ArrayList<secondClass>();
	sc = daoUtil.selectSecondClassId1(user.getDepartment(),"1");

	List<user> u = new ArrayList<user>();
	u = daoUtil.selectDoubleUserId();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>add archives</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />

		<script language="javascript">
		var onecount;
		onecount=0;
		subcat=new  Array();  
		<%
		int count=0;
		for(secondClass s : sc){
		 %>
		 subcat[<%=count%>]=new Array("<%=s.getId()%>","<%=s.getSecondCName()%>","<%=s.getFirstCName()%>");
		 <%
		 count = count + 1 ; 	
		}
		%>
		onecount=<%=count%>;
		function changelocation(locationid){
		document.myform.secondCName.length=0;
		var locationid=locationid;
		var i;
		document.myform.secondCName.options[0]=new Option('选择二级分类','0'); 
		for(i=0;i<onecount;i++){
		if (subcat[i][2] == locationid) 
		{ 
		document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat[i][1], subcat[i][0]); 
		} 
		} 		   
		}
		</script>

		<script language="javascript">
		var onecount3;
		onecount3=0;
		subcat3=new  Array();  
		<%
		int count3=0;
		for(user u1 : u){
		 %>
		 subcat3[<%=count3%>]=new Array("<%=u1.getUserName()%>","<%=u1.getName()%>","<%=u1.getDepartment()%>");
		 <%
		 count3 = count3 + 1 ; 	
		}
		%>
		onecount3=<%=count3%>;
		function changelocation3(locationid3){
		document.myform.saveArName.length=0;
		var locationid3=locationid3;
		var k;
		document.myform.saveArName.options[0]=new Option('选择存档用户','0'); 
		for(k=0;k<onecount3;k++){
		if (subcat3[k][2] == locationid3) 
		{ 
		document.myform.saveArName.options[document.myform.saveArName.length] = new Option(subcat3[k][1], subcat3[k][0]); 
		} 
		} 		   
		}
		</script>
	</head>
	<body bgcolor="#E4FAF9">
		<%
			List<firstClass> fc = new ArrayList<firstClass>();
			String department = user.getDepartment().trim();
			String systemName = "1";
			fc = daoUtil.selectFirstClassId(department, systemName);
			List<department> sdp = new ArrayList<department>();
			sdp = daoUtil.selectDepartmentId();
		%>
		<table align="center" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="actionmessage">
					<s:actionmessage />
				</td>
			</tr>
		</table>
		<br><br>
		<s:form name="myform" action="addArchivesAction"
			enctype="multipart/form-data" method="post" theme="simple">
			<s:token></s:token>
			<s:hidden name="giveArName" value="%{#session.us.name}"></s:hidden>
			<table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td>
						档案分类：
					</td>
					<td>&nbsp;
						<select name="firstCName"
							onChange="changelocation(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)"
							size="1">
							<option selected value="0">
								选择一级分类
							</option>
							<%
								for (firstClass f : fc) {
							%>
							<option value="<%=f.getId()%>"><%=f.getFirstCName()%></option>

							<%
								}
							%>
						</select>
						&nbsp;
						<select name="secondCName" size="1">
							<option selected value="0">
								选择二级分类
							</option>
						</select>

					</td>
					<td class="actionmessage">
						<s:fielderror>
							<s:param>firstCNamenull</s:param>
						</s:fielderror>
						<br>
						<s:fielderror>
							<s:param>secondCNamenull</s:param>
						</s:fielderror>
					</td>
				</tr>
              <tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						档案名称：
					</td>
					<td align="center">
						<s:textfield name="fileName" size="30"></s:textfield>
					</td>
					<td class="actionmessage">
						<s:fielderror>
							<s:param>fileNamenull</s:param>
						</s:fielderror>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						电子文档：
					</td>
					<td>&nbsp;
						<s:file name="file" size="22"></s:file>
					</td>
					<td class="actionmessage">
						<s:actionerror />
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						档案编号：
					</td>
					<td align="center">
						<s:textfield name="fileNumber" size="30"></s:textfield>
					</td>
					<td class="actionmessage">
						<s:fielderror>
							<s:param>fileNumbernull</s:param>
						</s:fielderror>
					</td>
				</tr>
                <tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						文本页数：
					</td>
					<td align="center">
						<s:textfield name="filePages" size="30"></s:textfield>
					</td>
				</tr>
              <tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						存档用户：
					</td>
					<td>&nbsp;
						<select name="saveArDepartment"
							onChange="changelocation3(document.myform.saveArDepartment.options[document.myform.saveArDepartment.selectedIndex].value)"
							size="1">
							<option selected value="0">
								选择存档部门
							</option>
							<%
								for (department d : sdp) {
							%>
							<option value="<%=d.getDepartmentId()%>"><%=d.getDepartment()%></option>

							<%
								}
							%>
						</select>
						&nbsp;
						<select name="saveArName" size="1">
							<option selected value="0">
								选择存档用户
							</option>
						</select>

					</td>
					<td class="actionmessage">
						<s:fielderror>
							<s:param>saveArDepartmentnull</s:param>
						</s:fielderror>
						<br>
						<s:fielderror>
							<s:param>saveArNamenull</s:param>
						</s:fielderror>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						备 注：
					</td>
					<td align="center">
						<s:textarea name="remarks" cols="23" rows="4"></s:textarea>
					</td>
				</tr>
					<tr><td>&nbsp;</td></tr>
				<tr>
					<td align="right">

					</td>
					<td align="center">
						<s:submit name="submit" value="提交申请"></s:submit>
						<s:reset name="reset" value="重新输入"></s:reset>
						<br>
					</td>
				</tr>
			</table>


		</s:form>


	</body>
</html>