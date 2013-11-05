<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="com.yz.manager.bean.*"%>
<%@page import="com.yz.manager.dao.*"%>
<%@page import="com.yz.manager.date.*"%>
<%@page import="com.yz.manager.storehouse.bean.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>��������</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basepath %>bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basepath %>js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		
		$(".apply-count").keyup(function(){
			var $tr = $(this).closest("tr");
			var $subTotal = $tr.find(".sub-total");
			if(/^\d*$/.test($(this).val())){
				$subTotal.html(($(this).val()*$tr.find(".unit-price").html()).toFixed(2));
			}else{
				$(this).val(0);
				$subTotal.html(0);
				alert("����������");
			}
			calcTotalPrice();
		});
		calcTotalPrice();
	});
	
	function calcTotalPrice(){
		var totalPrice = 0;
		$(".sub-total").each(function(index,e){
			totalPrice+=(+$(e).html());
		});
		$(".total-price").html(totalPrice.toFixed(2));
	}
</script>
<style type="text/css">
			.width_50{
				width:50px;
			}
			
			.width_100{
				width:100px;
			}
			
			.red{
				color:red !important;
			}
			
			.inline{
				white-space: nowrap;
			}
			
			td{
				vertical-align: middle !important;
			}
			
			.pointer{
				cursor: pointer;
			}
			
			.right{
				text-align: right;
				padding: 0 10px;
			}
			
			.left{
				text-align: left;
				padding: 0 10px;
			}
		</style>
</head>
<body bgcolor="#E4FAF9">
	<%
		user user = (user) session.getAttribute("us");
		if (user == null)
			response.sendRedirect("../index.jsp");
		List<outStoreHouse> pss = new ArrayList<outStoreHouse>();
		outStoreHouse ps = new outStoreHouse();
		String aId = (String) request.getParameter("aId");
		String[] aIds = null;
		if (aId != null) {
			aIds = aId.split("/");
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
		<table class="actionmessage" align="center" border="0">
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

			<!-- �������г���id -->
			<input type="hidden" name="aId" value=<%=aId %> style="width:0; height:0" />
		</table>
		<table class="table table-bordered"  style="width:80%" align="center" border="1"
			cellspacing="0" cellpadding="0">
			<s:hidden name="id" value="%{#request.ps.id}"></s:hidden>
			<s:hidden name="outVerify" value="%{#request.ps.outVerify}"></s:hidden>
			<tr height="25">
				<td align="center" width="16%">��������</td>
				<td width="34%" colspan="2"><%=CurrentDate.parseDate4(ps.getApplyDate().toString())%></td>
				<td width="16%" align="center">���벿��</td>
				<td width="34%" colspan="2"><%=sqgd%></td>
			</tr>
			<tr height="25">
				<td align="center">������</td>
				<td colspan="2"><%=sname%></td>
				<td align="center">��沿��</td>
				<td colspan="2"><%=kgd%></td>
			</tr>
			<tr height="25">
				<td align="center" >�ⷿ</td>
				<td colspan="5"><%=shn%></td>
			</tr>
			<tr height="25">
				<td align="center">����</td>
				<td align="center">����</td>
				<td align="center">����</td>
				<td align="center">�ܼ�</td>
				<td align="center">��;</td>
				<td align="center">��ע</td>
			</tr>
		<%
		int i=0;
			for(outStoreHouse p:pss) {	
				secondClass s = daoUtil.selectSecondClass3(Integer.valueOf(p.getSecondCName()).intValue());
		%>
			<tr height="25">
				<td><%=daoUtil.selectFirstClass5(Integer.valueOf(p.getFirstCName()).intValue())%>--<%= s.getSecondCName()%></td>
				<td>&nbsp;<input type="text" class="apply-count" name=<%=aIds[i] %> value=<%=p.getApplyCount()%> style="width:20%;" /> <%=p.getUnit() %></td>
				<td><span class="unit-price"><%= s.getUnitPrice() %></span></td>
          		<td><span class="sub-total"><%=String.format("%.2f", s.getUnitPrice()*p.getApplyCount())%></span>Ԫ</td>
				<td><%=purpose.get(i)%></td>
				<td><%=remarks.get(i)%></td>
			</tr>
		<%
			i++;}
		 %>
		  <tr>
	          	<td colspan="3"><div class="red right">�ܼ�</div></td>
	          	<td colspan="3" class="red">
	          		<div class="left"><span class="total-price"></span>Ԫ</div>
	          	</td>
	          </tr>
			<tr height="25">
				<td align="center">�� �ˣ�</td>
				<td align="left" colspan="2"><input type="radio" name="verify" value="1"
					checked="checked" /> ͨ�� <input type="radio" name="verify"
					value="2" /> ��ͨ��</td>
				<td align="center">������</td>
				<td colspan="2"><s:textarea name="verifyRemarks" value="" cols="23"
						rows="4"></s:textarea>
				</td>
			</tr>
			<tr height="25">
				<%
					if (ps.getOutVerify() == 0) {
							out.println("<td align='center' style='color:red'> �ύ�ⷿ������ˣ�</td>");
				%>
				<td colspan='5'><select name="nextVerifyName"
					style="width:200px;">
						<option selected value="0">ѡ�������</option>
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
							out.println("<td align='center' style='color:red'> �ύ�ⷿ����Ա��ˣ�</td>");
				%>
				<td colspan='5'><select name="nextVerifyName"
					style="width:200px;">
						<option selected value="0">ѡ�������</option>
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
							out.println("<td align='center' style='color:red' colspan='3'> ����ϵ��Ʒ�����˽��г���ҵ����</td>");
				%>
				<td>&nbsp;<s:hidden name="nextVerifyName"
						value="%{#request.ps.nextVerifyName}"></s:hidden></td>
			</tr>
			<%
				}
			%>


			<tr align="center" height="26" >
				<td align="center" colspan="6" style="text-align: center;"><s:submit name="submit"
						style="font-size:12px" cssClass="btn btn-primary" value="���ȷ��"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
					<s:reset name="reset" cssClass="btn btn-primary" style="font-size:12px" value="������д"></s:reset>
					<br>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>