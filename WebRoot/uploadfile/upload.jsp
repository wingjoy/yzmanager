<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�ļ��ϴ�</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script language="JavaScript">
	// add by gavin for ��������Ǽ�
	$(function() {
		$(".add-new").click(function() {
			$(this).closest("tr").before($("#recordTable .record").clone());
		});
		$(".icon-remove").live("click", function() {
			$(this).closest("tr").remove();
		});
		$(".add-new").trigger("click");
	});
</script>
     <style type="text/css">			
			.red{
				color:red !important;
			}
			
			.inline{
				white-space: nowrap;
			}
			
			.coment{
				vertical-align: middle !important;
				text-align: left !important;
			}
			
			td{
				vertical-align: middle !important;
				text-align: center !important;
			}
			
			.pointer{
				cursor: pointer;
			}
		</style>
</head>

<body>
	<div id="content">
	 <div style="width: 100%; height:100px;">
	    <%-- <%! String message =request.getParameter("message"); %>
	    <%
	        if(!(message.equals("")||message.equals(null)))
	           
	     %> --%>
	    ${message}
	 </div>
		<!-- enctype����Ϊ��������MIME���뷽ʽ���ϴ��ļ��ı�enctype���Ա���������� -->
		<form id="uploadForm" action="fileUpload!save.action" method="post"
			enctype="multipart/form-data">
			<table class=" table table-striped table-condensed" align="center"
				border="0" cellspacing="0" cellpadding="0">
				<tr>
				   <td style="width: 100%;" colspan="3" align="center">�ļ��ϴ�ҳ��</td>
				</tr>
				<tr>
					<td colspan="10" align="center">
					<input type="submit" class="btn btn-success" value="�ϴ��ļ�" />
					<input type="reset" class="btn btn-warning" value="����ѡ��" />
					<input type="button" value="���һ���ļ��ϴ���Ŀ" class="btn btn-primary add-new">
					<input type="button" class="btn btn-primary" onclick="window.location.href='fileUpload!list.action'" value="�鿴�ļ��б�">
					</td>
				</tr>
			</table>
		</form>
		<!-- ����ļ���Ŀ��¼��ʼ -->
		<table style="display: none;" id="recordTable">
			<tr class="record">
				    <td>
					   <input  type="file" name="file" value="ѡ���ļ�" />
					</td>
					<td style="text-align:center;">�ļ�������Ϣ</td>
					<td>
					   <textarea  name="comment" cols="20" rows="3" > </textarea>
					</td>
					<td>
					    <i class="icon-remove  pointer"></i>
					</td>
			</tr>
		</table>
		<!-- ����ļ���Ŀ��¼���� -->
	</div>
	<input type="button" onclick="window.location.href='fileUpload!list.action'" value="�鿴�ļ��б�">
	<s:debug></s:debug>
</body>
</html>
