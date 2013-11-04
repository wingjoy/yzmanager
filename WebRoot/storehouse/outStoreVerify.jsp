<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*"%>
<%@page import="com.yz.manager.dao.*"%>
<%@page import="com.yz.manager.date.*"%>
<%@page import="com.yz.manager.page.*"%>
<%@page import="com.yz.manager.storehouse.bean.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出库审核</title>
</head>
<body bgcolor="#E4FAF9">
	<%
		user user = (user) session.getAttribute("us");
		if (user == null)
			response.sendRedirect("../index.jsp");

		PageSet pg = new PageSet(
				storeHouseDao.selectVerifyOutStoreSize(user.getUserName()),
				15);
		int totalsize = pg.getTotalsize();
		int totalPage = pg.getTotalpage();
		int currentPage = Integer.valueOf(
				request.getParameter("currentPage")).intValue();
		List<outStoreHouse> sh = new ArrayList<outStoreHouse>();
		sh = storeHouseDao.selectVerifyOutStore(user.getUserName(),
				currentPage, pg.getPagesize());
	%>
	<table class="actionmessage" width="100%" align="center" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td align="center"><s:actionmessage></s:actionmessage>
			</td>
		</tr>
	</table>

	<table class="table table-bordered" width="100%" align="center" border="1"
		cellspacing="0" cellpadding="0">

		<%
			/* out.println("<tr height='23' class='tableth'bgcolor='#8E8EFF'>"
					+ "<th>序号</th><th>申请日期</th><th>领用部门</th><th>领用人</th><th>领用库房</th><th>物品分类</th><th>物品名称</th><th>申请数量</th><th>单位</th><th>审核</th>"
					+ "</tr>"); */
			out.println("<tr height='23'>"
					+ "<th>序号</th><th>领用人</th><th>审核</th>"
					+ "</tr>");
			int k = 1;
			;

			Map<String, String> map = new HashMap<String, String>();
			for (outStoreHouse e : sh) {
				//String shn = daoUtil.selectShouseName(Integer.valueOf(e.getHouseId()).intValue());
				//String fn = daoUtil.selectFirstClass5(Integer.valueOf(e.getFirstCName()).intValue());
				//String sn = daoUtil.selectSecondClass8(e.getSecondCName());
				//String dp = daoUtil.selectDepartment3(Integer.valueOf(e.getApplyDepartment()).intValue());
				//String date = CurrentDate.parseDate1(e.getApplyDate().toString());
				//String count = "" + e.getApplyCount();
				//String unit = e.getUnit();
				String userName = daoUtil.selectUser(e.getUserName());
				String aid = "" + e.getId();

				if(map.containsKey(userName)) {
					map.put(userName, map.get(userName) + "/" + aid);
				}
				else {
					map.put(userName, aid);
				}
			}
			Set s = map.keySet();
			Iterator i = s.iterator();
			while (i.hasNext()) {
				String str = (String) i.next();
				out.println("<tr height='23'>"
						+ "<td align='center'>"
						+ k++
						+ "</td>"
						+ "<td align='center'>&nbsp;"
						+ str
						+ "</td>"
						+ "<td align='center'><a class='left-font01' href='verifyOutStoreDetail.jsp?aId="
						+ map.get(str) + "' >>></a></td>" + "</tr>");
			}
		%>

	</table>
	<table class="tablelink">
		<tr align="right">
			<td>共<%=totalsize%>条记录&nbsp;|</td>
			<td>共<%=totalPage%>页&nbsp;|</td>
			<td>当前第<%=currentPage%>页&nbsp;|</td>
			<td><a class="tablelink" href="outStoreVerify.jsp?currentPage=1">首页</a>&nbsp;&nbsp;</td>
			<td><a class="tablelink"
				href="outStoreVerify.jsp?currentPage=<%=pg.searchCurrentPage(currentPage - 1)%>">上一页</a>&nbsp;&nbsp;</td>
			<td><a class="tablelink"
				href="outStoreVerify.jsp?currentPage=<%=pg.searchCurrentPage(currentPage + 1)%>">下一页</a>&nbsp;&nbsp;</td>
			<td><a class="tablelink"
				href="outStoreVerify.jsp?currentPage=<%=totalPage%>">尾页</a>&nbsp;&nbsp;</td>
			<td>跳转到第<select name="selectPage"
				onchange="document.location.href=this.value">
					<%
						for (int j = 1; j <= pg.getTotalpage(); j++) {
							if (j == currentPage) {
								out.println("<option  selected value='outStoreVerify.jsp?currentPage="
										+ j
										+ "'>&nbsp;&nbsp;"
										+ j
										+ "&nbsp;&nbsp;</option>");
							} else {
								out.println("<option value='outStoreVerify.jsp?currentPage="
										+ j
										+ "'>&nbsp;&nbsp;"
										+ j
										+ "&nbsp;&nbsp;</option>");
							}
						}
					%>
			</select>页</td>
		</tr>

	</table>



</body>
</html>