<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.yz.manager.dao.daoUtil"%>
<%@page import="com.yz.manager.bean.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.yz.manager.storehouse.bean.*" %> 

<%
	user user = (user) session.getAttribute("us");
	if (user == null)
		response.sendRedirect("index.jsp");
		
	  List<shouse> sh=new ArrayList<shouse>();
      List<department> dp=new ArrayList<department>();
	  dp=daoUtil.selectHaveHouseDepartmentId();	
	  sh=daoUtil.selectShouse();	
	  
	List<secondClass> sc = new ArrayList<secondClass>();
	sc = daoUtil.selectAllHouseSecondClass();
	
	List<user> us = new ArrayList<user>();
	us=daoUtil.selectAllIverifyName1();
	
	List<firstClass> fc = new ArrayList<firstClass>();
	fc = daoUtil.selectAllHouseFirstClass2();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>add personal</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	       type="text/css" />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
        <script language="javascript">
			var onecount1;
			onecount1=0;
			subcat1=new  Array();  
			<%
			int count1=0;
			for(shouse sf: sh){
			 %>
			 subcat1[<%=count1%>]=new Array("<%= sf.getId()%>","<%=sf.getHouseName()%>","<%=sf.getDepartment()%>");
			 <%
			 count1 = count1 + 1 ; 	
			}
			%>
			onecount1=<%=count1%>;
			function changelocation1(locationid){
			document.myform.houseId.length=0;
			document.myform.houseId.options[0]=new Option('选择库房','0'); 
			var i1; 
			for(i1=0;i1<onecount1;i1++){
			if (subcat1[i1][2] == locationid) 
			{ 
				if(subcat1[i1][1]=="办公室库房")
				document.myform.houseId.options[document.myform.houseId.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
			} 			   
			}	
			
			$("[name$='firstCName']").html("<option value='0'>选择物品分类</option>"); 	
			$("[name$='secondCName']").html("<option value='0'>选择物品</option>"); 
			}
			
     </script>
         
		<script language="javascript">
		var onecount4;
		onecount4=0;
		subcat4=new  Array();  
		<%
		int count4=0;
		for(firstClass f : fc){
		 %>
		 subcat4[<%=count4%>]=new Array("<%=f.getId()%>","<%=f.getFirstCName()%>","<%=f.getHouseId()%>");
		 <%
		 count4 = count4 + 1 ; 	
		}
		%>
		onecount4=<%=count4%>;
		function changelocation2(locationid){
			var i4;
			var selectContent  = "<option value='0'>选择物品分类</option>";
			for(i4=0;i4<onecount4;i4++){
				if (subcat4[i4][2] == locationid) {
					selectContent +="<option value='"+subcat4[i4][0]+"'>"+subcat4[i4][1]+"</option>";
					//.options[document.myform.firstCName.length] = new Option(subcat4[i4][1], subcat4[i4][0]); 
				} 
			} 	
			$("[name$='firstCName'").html(selectContent);
			$("[name$='secondCName']").html("<option value='0'>选择物品</option>");    
		}
		
		// add by gavin for 批量出库登记
		$(function(){
			var i = 0;
			$(".add-new").click(function(){
				$(this).closest("tr").before($("#recordTable .record")[0].outerHTML.replace(/%s/g,"'record"+(i++)+"'"));
			});
			$(".add-new-file").click(function(){
				$(this).closest("tr").before($("#fileTable .fileRecord")[0].outerHTML.replace(/%s/g,"'record"+(i++)+"'"));
			});
			$(".icon-remove").live("click",function(){
				$(this).closest("tr").remove();
			});
			$(".import-excel").click(function(){
				$('#fileModal').modal('show');
			});
			$(".add-new").trigger("click");
			$(".add-new-file").trigger("click");
		});
		</script>
        
        
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
		function changelocation3(select){
			var i;
			var selectContent  = "<option value='0'>选择物品</option>";
			for(i=0;i<onecount;i++){
				if (subcat[i][2] == $(select).val()){ 
					selectContent +="<option value='"+subcat[i][0]+"'>"+subcat[i][1]+"</option>";
					//document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat[i][1], subcat[i][0]); 
				} 
			} 
			$(select).closest("tr").find("[name$='secondCName']").html(selectContent);
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
				text-align: center !important;
			}
			
			.pointer{
				cursor: pointer;
			}
		</style>
</head>
<body bgcolor="#E4FAF9">

	<table align="center" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="actionmessage"><s:fielderror>
					<s:param>departmentnull</s:param>
				</s:fielderror></td>
			<td class="actionmessage"><s:fielderror>
					<s:param>housenull</s:param>
				</s:fielderror></td>
		</tr>
		<tr>
			<td class="actionmessage"><s:fielderror>
					<s:param>firstCNamenull</s:param>
				</s:fielderror></td>
			<td class="actionmessage"><s:fielderror>
					<s:param>secondCNamenull</s:param>
				</s:fielderror></td>
		</tr>
		<tr>
			<td class="actionmessage"><s:fielderror>
					<s:param>contnull</s:param>
				</s:fielderror></td>
			<td class="actionmessage"><s:fielderror>
					<s:param>unitPrice1</s:param>
				</s:fielderror></td>
		<tr>
			<td class="actionmessage"><s:fielderror>
					<s:param>number1</s:param>
				</s:fielderror></td>
			<td class="actionmessage"><s:fielderror>
					<s:param>totalPrice1</s:param>
				</s:fielderror></td>
		</tr>
		<tr>
			<td class="actionmessage"><s:actionmessage /></td>
		</tr>
		<tr>
			<td class="actionmessage"><s:fielderror>
					<s:param>total</s:param>
				</s:fielderror></td>
		</tr>
	</table>

	<s:form name="myform" action="inStoreAction" method="post"
		theme="simple">
		<s:token></s:token>
		<s:hidden name="userName" value="%{#session.us.userName}"></s:hidden>
		<s:hidden name="inDepartment" value="%{#session.us.department}"></s:hidden>

		<table class=" table table-striped">
			<tr>
				<td align="center">部门库房：</td>
				<td><select name="department" style="width:200px;"
					onChange="changelocation1(document.myform.department.options[document.myform.department.selectedIndex].value)"
					size="1">
						<option selected value="0">选择部门</option>
						<%
							for (department d : dp) {
									if ("办公室".equals(d.getDepartment())) {
						%>
						<option value="<%=d.getDepartmentId()%>"><%=d.getDepartment()%></option>
						<%
							}
								}
						%>
				</select></td>
				<td align="center">&nbsp;&nbsp;库房名称：</td>
				<td><select name="houseId" style="width:200px;"
					onChange="changelocation2(document.myform.houseId.options[document.myform.houseId.selectedIndex].value)"
					size="1">
						<option selected value="0">选择库房</option>
				</select></td>
			</tr>
		</table>
		<table class=" table table-striped table-bordered" align="center"
			border="0" cellspacing="0" cellpadding="0">
			<!-- added by gavincook for [批量入库登记] -->
			<tr>
				<td>物品分类</td>
				<td>物品名称</td>
				<td>规格</td>
				<td>数量</td>
				<td>单位</td>
				<td>单价</td>
				<td>总价</td>
				<td>审核人</td>
				<td>备注</td>
				<td>取消</td>
			</tr>
            <tr>
				<td colspan="10" align="center">
						<s:submit name="submit" cssClass="btn btn-primary" value="提交申请"></s:submit>
						<s:reset name="reset" cssClass="btn btn-primary"  value="重新输入"></s:reset>
						<input type="button" value="添加一个物品申请" class="btn btn-primary add-new">
						<input type="button" value="excel导入" class="btn btn-primary import-excel">
			    </td>
		   </tr>
		</table>
	</s:form>
	<table style="display: none;" id="recordTable">
	   <!-- 记录初始 -->
	        <tr class="record">
				<td><select name="storeHouses[%s].firstCName" onChange="changelocation3(this)" size="1">
						<option selected value="0">选择物品分类</option>
				</select></td>
				<td><select  name="storeHouses[%s].secondCName" size="1">
						<option selected value="0">选择物品</option>
				</select></td>
				<td align="center">
				    <input class = "width_50 red" type="text" name="storeHouses[%s].inContent" size="10" />
				</td>
				<td align="center">
				    <input class = "width_50 red" type="text" name="storeHouses[%s].inCount" size="5" />
				</td>
				<td align="center">
				    <input class = "width_50 red" type="text" name="storeHouses[%s].unit" size="5" />
				</td>
				<td align="center">
				    <input class = "width_50 red" type="text" name="storeHouses[%s].unitPrice" size="5" />
				</td>
				<td align="center">
				    <input class = "width_50 red" type="text" name="TstoreHouses[%s].totalPrice" size="5" />
				</td>
				<td>
				   <select  name="storeHouses[%s].inVerifyName" class="width_100" > 
	                  			 <% for(user u1 :us){ %> 
						  		 <option value="<%= u1.getUserName()%>"><%=u1.getName()%></option> 
						   		 <% }%> 
	            			</select>
				<td>
				    <textarea name="storeHouses[%s].inRemarks" cols="15" rows="2" class="width_100"> </textarea>
				</td>
				<td><i class="icon-remove pointer"></i></td>
			</tr>
		</table>
	  <!-- /记录初始 -->
	  
	  <div id="fileModal" class="modal hide fade">
	  		 <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="myModalLabel">Excel 导入</h3>
			  </div>
			 <div class="modal-body">
				 	<div id="content">
						<!-- enctype属性为表单定义了MIME编码方式，上传文件的表单enctype属性必须如此设置 -->
						<form id="uploadForm" name ="dsad"  action="../fileUpload_save.action" method="post" enctype="multipart/form-data">
							<table class=" table table-striped table-condensed" align="center"
								border="0" cellspacing="0" cellpadding="0">
								<tr class="fileRecord">
								    <td>
									   <input  type="file" name="file" />
									</td>
							    </tr>
								<tr>
									<td colspan="10" align="center">
									<input type="submit" class="btn btn-primary" value="导入" />
									<!-- <input type="button" value="添加一个文件上传栏目" class="btn btn-primary add-new-file"> -->
									</td>
								</tr>
							</table>
						</form>
						<!-- 添加文件栏目记录开始 -->
						<table style="display: none;" id="fileTable">
							<tr class="fileRecord">
								    <td>
									   <input  type="file" name="file" value="选择文件" />
									</td>
									<!-- <td style="text-align:center;">文件描述信息</td>
									<td>
									   <textarea  name="comment" cols="20" rows="3" > </textarea>
									</td>
									<td>
									    <i class="icon-remove  pointer"></i>
									</td> -->
							</tr>
						</table>
						<!-- 添加文件栏目记录结束 -->
					</div>
			  </div>
	  </div>
	  <s:debug></s:debug>
	</body>
</html>