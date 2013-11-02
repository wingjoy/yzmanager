<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="com.yz.manager.bean.*"%>
<%@page import="com.yz.manager.dao.*"%>
<%@page import="com.yz.manager.date.*"%>
<%@page import="com.yz.manager.storehouse.bean.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>费用详情</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
	<%
		user user = (user) session.getAttribute("us");
		if (user == null)
			response.sendRedirect("../index.jsp");
		List<outStoreHouse> pss = new ArrayList<outStoreHouse>();
		outStoreHouse ps = new outStoreHouse();
		String aId = (String) request.getParameter("aId");
		if (aId != null) {
			String[] aIds = aId.split("/");
			for (int i = 0; i < aIds.length; i++) {
				pss.add(storeHouseDao.selectOutHouse(aIds[i]));
			}
		} else {
			String said = (String) request.getAttribute("said");
			if (said != null)
				pss.add(storeHouseDao.selectOutHouse(said));
		}
		String shn, sqgd, kgd, sname;
		shn=sqgd=kgd=sname=null;
		List<String> fc = new ArrayList<String>();
		List<String> sc = new ArrayList<String>();
		List<Integer> applyCount = new ArrayList<Integer>();
		List<String> unit = new ArrayList<String>();
		List<String> purpose = new ArrayList<String>();
		List<String> remarks = new ArrayList<String>();
		List<user> verifyName = new ArrayList<user>();
		for (int i = 0; i < pss.size(); i++) {
			ps = pss.get(i);
			request.setAttribute("ps", ps);
			if (ps.getOutVerify() == 0) {
				verifyName = daoUtil.selectHouseVerifyName(ps
						.getDepartment());
			} else if (ps.getOutVerify() == 1) {
				verifyName = daoUtil.selectHouseManagerVerifyName(ps
						.getHouseId());
			}
			
			shn = daoUtil.selectShouseName(Integer.valueOf(ps.getHouseId())
						.intValue());
			sqgd = daoUtil.selectDepartment3(Integer.valueOf(
						ps.getApplyDepartment()).intValue());
			kgd = daoUtil.selectDepartment3(Integer.valueOf(
						ps.getDepartment()).intValue());
			sname = daoUtil.selectUser(ps.getUserName().trim());
			fc.add(daoUtil.selectFirstClass5(Integer.valueOf(
					ps.getFirstCName()).intValue()));
			sc.add(daoUtil.selectSecondClass8(ps.getSecondCName()));
			applyCount.add(ps.getApplyCount());
			unit.add(ps.getUnit());
			purpose.add(ps.getPurpose());
			remarks.add(ps.getOutRemarks());
		}
	%>
	<s:form action="verifyOutStoreAction" method="post" theme="simple">
		<table class="actionmessage" align="center">
			<tr>
				<td>&nbsp; <s:actionmessage />
				</td>
			</tr>
			<tr>
				<td>&nbsp; <s:fielderror>
						<s:param>
                 verifynull
               </s:param>
					</s:fielderror></td>
			</tr>

		</table>
		<table class="left-font01" width="90%" align="center" border="1"
			cellspacing="0" cellpadding="0">
			<s:hidden name="id" value="%{#request.ps.id}"></s:hidden>
			<s:hidden name="outVerify" value="%{#request.ps.outVerify}"></s:hidden>
			<tr height="25">
				<td align="center" width="16%">申请日期</td>
				<td width="34%"><%=CurrentDate.parseDate4(ps.getApplyDate().toString())%></td>
				<td width="16%" align="center">申请部门</td>
				<td width="34%"><%=sqgd%></td>
			</tr>
			<tr height="25">
				<td align="center">申请人</td>
				<td><%=sname%></td>
				<td align="center">库存部门</td>
				<td><%=kgd%></td>
			</tr>
			<tr height="25">
				<td align="center">库房</td>
				<td colspan="3"><%=shn%></td>
			</tr>
			<tr height="25">
				<td align="center">分类</td>
				<td align="center">数量</td>
				<td align="center">用途</td>
				<td align="center">备注</td>
			</tr>
		<%
			for(int i=0; i<fc.size(); i++) {			
		%>
			<tr height="25">
				<td><%=fc.get(i)%>--<%=sc.get(i) %></td>
				<td>&nbsp;<input type="text" name="applyCount" value=<%=applyCount.get(i)%> style="width:20%;" /> <%=unit.get(i) %></td>
				<td><%=purpose.get(i)%></td>
				<td><%=remarks.get(i)%></td>
			</tr>
		<%
			}
		 %>
			<tr height="25">
				<td align="center">审 核：</td>
				<td align="left"><input type="radio" name="verify" value="1"
					checked="checked" /> 通过 <input type="radio" name="verify"
					value="2" /> 不通过</td>
				<td align="center">审核意见</td>
				<td><s:textarea name="verifyRemarks" value="" cols="23"
						rows="4"></s:textarea>
				</td>
			</tr>
			<tr height="25">
				<%
					if (ps.getOutVerify() == 0) {
							out.println("<td align='center' style='color:red'> 提交库房主管审核：</td>");
				%>
				<td colspan='3'><select name="nextVerifyName"
					style="width:200px;">
						<option selected value="0">选择审核人</option>
						<%
							for (user u : verifyName) {
						%>
						<option value="<%=u.getUserName()%>"><%=u.getName()%></option>
						<%
							}
						%>
				</select></td>

				<%
					} else if (ps.getOutVerify() == 1) {
							out.println("<td align='center' style='color:red'> 提交库房管理员审核：</td>");
				%>
				<td colspan='3'><select name="nextVerifyName"
					style="width:200px;">
						<option selected value="0">选择审核人</option>
						<%
							for (user u : verifyName) {
						%>
						<option value="<%=u.getUserName()%>"><%=u.getName()%></option>
						<%
							}
						%>
				</select></td>
				<%
					} else {
							out.println("<td align='center' style='color:red' colspan='3'> 请联系物品领用人进行出库业务处理</td>");
				%>
				<td><s:hidden name="nextVerifyName"
						value="%{#request.ps.nextVerifyName}"></s:hidden></td>
			</tr>
			<%
				}
			%>


			<tr align="center" height="26">
				<td align="center" colspan="4"><s:submit name="submit"
						style="font-size:12px" value="审核确认"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
					<s:reset name="reset" style="font-size:12px" value="重新填写"></s:reset>
					<br>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>