<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>南航上海基地办公综合管理系统</title>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body background="images/bjtp.jpg" bgcolor="0a4187" >
		<s:form action="loginSystemAction" method="post" theme="simple">

			<table   align="center" border="0" cellspacing="0" cellpadding="0">
			<tr height="160"></tr>
			 <tr>
			 <td colspan="3" align="center" class="xayz">南航上海基地办公综合管理系统</td>
			 </tr>
			 <tr height="25"><td></td></tr>
				<tr>
					<td class="username-password">
						用户账号：
					</td>
					<td >
						<s:textfield style="width:160px; height:16px;" name="userName" size="30"></s:textfield>
					</td>
					<td class="username-password-error">
						<s:fielderror>
							<s:param>userNameError</s:param>
						</s:fielderror>
						<s:fielderror>
							<s:param>usernotuse</s:param>
						</s:fielderror>
					</td>
				
				</tr>
				<tr height="10"></tr>
				<tr>
					<td class="username-password">
						用户密码：
					<td >
						<s:password style="width:160px; height:16px;" name="userPassword" size="30"></s:password>
					</td>
					<td class="username-password-error">
						<s:fielderror>
							<s:param>userPasswordError</s:param>
						</s:fielderror>
					</td>
				</tr>
				<tr height="5"></tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;</td>
					<td>
						&nbsp;&nbsp;&nbsp;<s:submit name="submit" style="font-size:14px" value="确  定"></s:submit>
						&nbsp;&nbsp;&nbsp;<s:reset name="reset" style="font-size:14px" value="重  置"></s:reset>
					</td>
					<td>&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>