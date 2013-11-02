<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件列表显示页面</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body>
	<div>
		<table
			style="align:center; text-align:center;font-size: 20px; width:90%;">
			<tr>
				<td width="100%" colspan="8">文件列表</td>
			</tr>
			<c:forEach items="${request.filelist}" var="file">
				<tr>
					<td>编号</td>
					<td>${file.id}</td>
					<td>上传者</td>
					<td>${file.userName}</td>
					<td>文件名</td>
					<td>${file.fileName}</td>
					<td>文件路径</td>
					<td>${file.filePath}</td>
					<td>备注</td>
					<td>${file.comment}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
