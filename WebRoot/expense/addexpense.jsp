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
	sc = daoUtil.selectSecondClassId1(user.getDepartment(), "3");

	HashMap<String, String> en = new LinkedHashMap<String, String>();
	en = (HashMap<String, String>) daoUtil.selectEverifyName(user
			.getDepartment());
	request.setAttribute("en", en);

	HashMap<String, String> gc = new LinkedHashMap<String, String>();
	gc = (HashMap<String, String>) daoUtil.selectGCompanyMap();
	request.setAttribute("gc", gc);

	HashMap<String, String> py = new LinkedHashMap<String, String>();
	py = (HashMap<String, String>) daoUtil.selectPayModeMap();
	request.setAttribute("py", py);
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
			String systemName = "3";
			fc = daoUtil.selectFirstClassId(department, systemName);
		%>
		<table align="center" border="0" cellspacing="0" cellpadding="0">
			
			<tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>firstCNamenull</s:param>
					</s:fielderror>
			   </td>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>secondCNamenull</s:param>
					</s:fielderror>
			    </td>
			 </tr>
			 <tr>
			    <td class="actionmessage">
					<s:fielderror>
						<s:param>contnull</s:param>
					</s:fielderror>
				 </td>
				 <td class="actionmessage">
					<s:fielderror>
						<s:param>unitPrice1</s:param>
					</s:fielderror>
			     </td>
			     <tr>
			     <td class="actionmessage">
					<s:fielderror>
						<s:param>number1</s:param>
					</s:fielderror>
			     </td>
			       <td class="actionmessage">
					<s:fielderror>
						<s:param>totalPrice1</s:param>
					</s:fielderror>
				</td>
			</tr>
			<tr>
				<td class="actionmessage">
					<s:actionmessage />
				</td>
			</tr>
			<tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>total</s:param>
					</s:fielderror>
				</td>
			</tr>
		</table>

		<s:form name="myform" action="addexpenseAction" method="post"
			theme="simple">
			<s:token></s:token>
			<s:hidden name="userName" value="%{#session.us.userName}"></s:hidden>
			<s:hidden name="department" value="%{#session.us.department}"></s:hidden>
			<table class="left-font01" align="center" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						一级分类：
					</td>
					<td>
						<select style="width: 200px;" name="firstCName"
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
						<select style="width: 200px;" name="secondCName" size="1">
							<option selected value="0">
								选择二级分类
							</option>
						</select>

					</td>

				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						事由：
					</td>
					<td align="center">
						<s:textfield name="content" size="30"></s:textfield>
					</td>

					<td align="center">
						&nbsp;&nbsp;供应商：
					</td>
					<td align="center">
						<s:textfield name="supplier" size="30"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						联系人：
					</td>
					<td align="center">
						<s:textfield name="contactName" size="30"></s:textfield>
					</td>

					<td align="center">
						&nbsp;&nbsp;联系电话：
					</td>
					<td align="center">
						<s:textfield name="contactPhone" size="30"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						供应商地址：
					</td>
					<td align="center">
						<s:textfield name="supplierAddress" size="30"></s:textfield>
					</td>
					<td align="center">
						&nbsp;&nbsp;费用性质：
					</td>
					<td align="center">
						<input type="radio" name="nature" value="报销" checked="checked" />
						报销&nbsp;&nbsp;
						<input type="radio" name="nature" value="借款" />
						借款
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				<td align="center">
						数量：
					</td>
					<td align="center">
						<s:textfield name="number" size="30"></s:textfield>
					</td>
					
					<td align="center">
						&nbsp;&nbsp;单位：
					</td>
					<td align="center">
						<s:textfield name="unit" size="30"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				  <td align="center">
						单价：
					</td>
					<td align="center">
						<s:textfield name="unitPrice" size="30"></s:textfield>
					</td>
					<td align="center">
						&nbsp;&nbsp;总价：
					</td>
					<td align="center">
						<s:textfield name="TotalPrice" size="30"></s:textfield>
					</td>
					
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				 <td align="center">
						挂账公司：
					</td>
					<td align="center">
						<s:select style="width:200px;" name="gCompany" list="#request.gc"
							listKey="key" listValue="value"></s:select>
					</td>
					<td align="center">
						&nbsp;&nbsp;付款方式：
					</td>
					<td align="center">
						<s:select style="width:200px;" name="payMode" list="#request.py"
							listKey="key" listValue="value"></s:select>
					</td>		
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				 <td align="center">
						费用审核人：
					</td>
					<td align="center">
						<s:select style="width:200px;" name="everifyName"
							list="#request.en" listKey="key" listValue="value"></s:select>
					</td>
					<td align="center">
						&nbsp;&nbsp;备 注：
					</td>
					<td colspan="3">
						<s:textarea name="remarks" cols="23" rows="4"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<s:submit name="submit" value="提交申请"></s:submit>
						&nbsp;&nbsp;
						<s:reset name="reset" value="重新输入"></s:reset>
						<br>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>