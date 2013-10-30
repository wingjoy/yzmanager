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
	sc = daoUtil.selectSecondClassId1(user.getDepartment(),"2");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>add personal</title>
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
		document.myform.secondCName.options[0]=new Option('==选择二级分类==','0'); 
		for(i=0;i<onecount;i++){
		if (subcat[i][2] == locationid) 
		{ 
		document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat[i][1], subcat[i][0]); 
		} 
		} 		   
		}
		</script>

	</head>
	<body bgcolor="#E4FAF9">
		<%
			List<firstClass> fc = new ArrayList<firstClass>();
			String department = user.getDepartment().trim();
			String systemName = "2";
			fc = daoUtil.selectFirstClassId(department, systemName);
		%>
		<table align="center" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="actionmessage">
					<s:actionmessage />
				</td>
			</tr>
			 <tr>
                 <td class="actionmessage">
						<s:fielderror>
							<s:param>namenull</s:param>
						</s:fielderror>
				</td>
			</tr>	
				<tr>
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
		</table>
	
		<s:form name="myform" action="addPersonalAction"
			 method="post" theme="simple">
			<s:token></s:token>
			<s:hidden name="userName" value="%{#session.us.userName}"></s:hidden>
			<s:hidden name="department" value="%{#session.us.department}"></s:hidden>
			<table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0">
               <tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center">
						一级分类：
					</td>
					<td>
						<select style="width:218px;" name="firstCName"
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
						</td>
					<td align="center">
						&nbsp;&nbsp;二级分类：
					</td>
					<td>	
						<select style="width:218px;" name="secondCName" size="1">
							<option selected value="0">
								选择二级分类
							</option>
						</select>

					</td>
					
				</tr>
                  <tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center">
						联系人：
					</td>
					<td align="center">
						<s:textfield name="contactName" size="30"></s:textfield>
					</td>
					
					<td align="center">
						&nbsp;&nbsp;单位名称：
					</td>
					<td align="center">
						<s:textfield name="companyName" size="30"></s:textfield>
					</td>
				</tr>
                  <tr><td>&nbsp;</td></tr>
				<tr>
					<td>
						手  机：
					</td>
					<td align="center">
						<s:textfield name="mobilePhone" size="30"></s:textfield>
					</td>
			
					<td align="center">
						&nbsp;&nbsp;固定电话：
					</td>
					<td align="center">
						<s:textfield name="workPhone" size="30"></s:textfield>
					</td>		
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center">
						传  真：
					</td>
					<td align="center">
						<s:textfield name="fax" size="30"></s:textfield>
					</td>		
					<td align="center">
						&nbsp;&nbsp;职  务：
					</td>
					<td align="center">
						<s:textfield name="post" size="30"></s:textfield>
					</td>	
				</tr>
				<tr><td>&nbsp;</td></tr>
				 <tr>
					<td align="center">
						单位地址：
					</td>
					<td align="center">
						<s:textfield name="companyAddress" size="30"></s:textfield>
					</td>	

					<td align="center">
						&nbsp;&nbsp;邮政编码：
					</td>
					<td align="center">
						<s:textfield name="zipCode" size="30"></s:textfield>
					</td>		
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center">
						电子邮件：
					</td>
					<td align="center">
						<s:textfield name="mail" size="30"></s:textfield>
					</td>			

					<td align="center">
						&nbsp;&nbsp;QQ号码：
					</td>
					<td align="center">
						<s:textfield name="qq" size="30"></s:textfield>			
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center">
						备 注：
					</td>
					<td colspan="3" >
						<s:textarea name="remarks" cols="23" rows="4"></s:textarea>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td colspan="4" align="center">
						<s:submit name="submit" value="提交申请"></s:submit>&nbsp;&nbsp;
						<s:reset name="reset" value="重新输入"></s:reset>
						<br>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>