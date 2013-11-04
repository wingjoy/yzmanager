<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="gb2312"%>
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
       List<department> dp3=new ArrayList<department>();
	  dp3=daoUtil.selectHaveHouseDepartmentId();	
	  sh=daoUtil.selectShouse();	
	  
	List<secondClass> sc = new ArrayList<secondClass>();
	sc = daoUtil.selectAllHouseSecondClass();
	
	List<user> us = new ArrayList<user>();
	us=daoUtil.selectDpAllIverifyName(user.getDepartment());
	
	List<firstClass> fc = new ArrayList<firstClass>();
	fc = daoUtil.selectAllHouseFirstClass2();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>出库登记</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="../js/jquery.js"></script>
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
			function changelocation2(locationid){
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
		function changelocation4(locationid){
			var locationid=locationid;
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
				$(this).closest("tr").prev().before($("#recordTable .record")[0].outerHTML.replace(/%s/g,"'record"+(i++)+"'"));
			});
			$(".icon-remove").live("click",function(){
				$(this).closest("tr").remove();
			});
			$("[name$='applyCount']").live("keyup",function(){
				var $tr = $(this).closest("tr");
				var unitPrice = $tr.find("[name$='unitPrice']").val();
				var currentCount = $tr.find("[name$='currentCount']").val();
				if(parseInt($(this).val())>parseInt(currentCount)){
					alert("申请数量不能大于库存量.");
					$(this).val("");
					$tr.find("[name$='PriceCount']").val("");
					return false;
				}
				$tr.find("[name$='PriceCount']").val(unitPrice*$(this).val());
				var totalPrice = 0;
				$("[name$='PriceCount']").each(function(index,e){
					totalPrice+=+($(e).val());
				});
				$(".total-price").html(totalPrice);
			});
			$(".add-new").trigger("click");
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
		function changelocation(select){
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
		
		 
		<script language="javascript">
		var onecount5;
		onecount5=0;
		subcat5=new  Array();  
		<%
		int count5=0;
		for(secondClass s : sc){
		
		 %>
		 subcat5[<%=count5%>]=new Array("<%=s.getId()%>","<%=s.getCurrentCount()%>","<%=s.getUnit()%>","<%=s.getUnitPrice()%>");
		 <%
		 count5 = count5 + 1 ; 	
		}
		%>
		onecount5=<%=count5%>;
		function changelocation5(select){
		var i5;
		for(i5=0;i5<onecount5;i5++){
			if (subcat5[i5][0] == $(select).val()){ 
				var $tr = $(select).closest("tr");
				$("[name$='currentCount']",$tr).val(subcat5[i5][1]); 
				$("[name$='unit']",$tr).val(subcat5[i5][2]); 
				$("[name$='unitPrice']",$tr).val(subcat5[i5][3]); 
				
			//document.myform.PriceCount.value=parseInt(document.myform.unitPrice.value)*parseInt(document.myform.applyCount.value);
			} 
		} 		   
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
	
		<table align="center" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>departmentnull</s:param>
					</s:fielderror>
			   </td>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>housenull</s:param>
					</s:fielderror>
			    </td>
			 </tr>
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
						<s:param>purposenull</s:param>
					</s:fielderror>
				 </td>
				 <td class="actionmessage">
					<s:fielderror>
						<s:param>applyc</s:param>
					</s:fielderror>
			     </td>
			   
			<tr>
				<td class="actionmessage">
					<s:actionmessage />
				</td>
			</tr>
			<tr>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>kucunbugou</s:param>
					</s:fielderror>
				</td>
			</tr>
		</table>

		<s:form name="myform" action="outStoreAction" method="post"
			theme="simple">
			<s:token></s:token>
			<s:hidden name="userName" value="%{#session.us.userName}"></s:hidden>
			<s:hidden name="applyDepartment" value="%{#session.us.department}"></s:hidden>
			
			<table  class=" table table-striped">
				 <tr>
         		 <td align="center"> 部门库房：</td>
             	 <td >
		                 <select  name="department" style="width:200px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
		              <option selected value="0">选择部门</option> 
		            <%for(department d :dp3){ if("办公室".equals(d.getDepartment())){%> 
					  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
				    <%} }%> 
		            </select>
            	</td>
            	<td align="center"> &nbsp;&nbsp;库房名称：</td>
             	<td > 
	             <select  name="houseId" style="width:200px;" onChange="changelocation4(document.myform.houseId.options[document.myform.houseId.selectedIndex].value)" size="1" > 
	                 <option selected value="0">选择库房</option> 
	             </select>
            	</td>
            </tr>
			</table>
	
			<table class=" table table-striped table-bordered" align="center" border="0" cellspacing="0"
				cellpadding="0">
				<!-- added by gavincook for [批量出库登记] -->
				<tr>
					<td>物品分类</td>
					<td>物品名称</td>
					<td>库存数量</td>
					<td>单价</td>
					<td>申请数量</td>
					<td>申请总额</td>
					<td>部门审核</td>
					<td>用途</td>
					<td>备注</td>
					<td>操作</td>
				</tr>
				
				<!-- /added by gavincook for [批量出库登记] -->
				
				<!-- commentted by gavincook  -->
				<%-- <tr>
					<td align="center">
						物品分类：
					</td>
					<td>
						<select style="width: 200px;" name="firstCName"
							onChange="changelocation(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)"
							size="1">
							<option selected value="0">
								选择物品分类
							</option>
						</select>
					</td>
					<td align="center">
						&nbsp;&nbsp;物品名称：
					</td>
					<td>
						<select style="width: 200px;" name="secondCName" onChange="changelocation5(document.myform.secondCName.options[document.myform.secondCName.selectedIndex].value)" size="1">
							<option selected value="0">
								选择物品
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
						库存数量：
					</td>
					<td >
						<s:textfield style='color:red' name="currentCount" size="10" readonly="true"></s:textfield>
						<s:textfield style='color:red' name="unit" size="5" readonly="true"></s:textfield>	
					</td>
					
					<td align="center">
						单价：
					</td>
					<td >
						<s:textfield style='color:red' name="unitPrice" size="10" readonly="true"></s:textfield>
						
					</td>
                       <td align="center">
						&nbsp;&nbsp;申请数量：
					</td>
					<td align="center">
						<s:textfield name="applyCount" size="27"></s:textfield>
					</td>
					</td>
                       <td align="center">
						&nbsp;&nbsp;申请总金额：
					</td>
					<td align="center">
						<s:textfield name="PriceCount" size="27"></s:textfield>
					</td>
					
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
			
				<tr>
				
					 <td align="center">
						&nbsp;&nbsp;部门审核：
					</td>
					<td > 
             <select  name="inVerifyName" style="width:200px;"  > 
                  <% 
				
					   for(user u1 :us){
					    %> 
					  <option value="<%= u1.getUserName()%>"><%=u1.getName()%></option> 
				  
				   <% }
		           %> 
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
						用途：
					</td>
					<td colspan="3">
						<s:textarea name="purpose" cols="30" rows="5"></s:textarea>
					</td>
			
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				
					<td align="center">
						备 注：
					</td>
					<td colspan="3">
						<s:textarea name="outRemarks" value="" cols="30" rows="5"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr> --%> <!-- commentted by gavincook  -->
				<tr>
					<td colspan="5"><div class="right red">总金额</div></td>
					<td colspan="5"><div class="left red total-price"></div></td>
				</tr>
				<tr>
					<td colspan="10" align="center">
						<s:submit name="submit" cssClass="btn btn-primary" value="提交申请"></s:submit>
						<s:reset name="reset" cssClass="btn btn-primary"  value="重新输入"></s:reset>
						<input type="button" value="添加一个物品申请" class="btn btn-primary add-new">
					</td>
				</tr>
			</table>
		</s:form>
		
		<!-- 记录初始 -->
		<table style="display: none;" id="recordTable">
			<tr class="record">
						<td>
							<select style="width: 140px;" name="outStoreHouses[%s].firstCName"
								onChange="changelocation(this)"
								size="1">
								<option selected value="0">
									选择物品分类
								</option>
							</select>
						</td>
						<td>
							<select style="width: 140px;" name="outStoreHouses[%s].secondCName" onChange="changelocation5(this)" size="1">
								<option selected value="0">
									选择物品
								</option>
							</select>
						</td>
						<td class="inline">
							<input class = "width_50 red" type="text" name="outStoreHouses[%s].currentCount" size="10" readonly/>
							<input class = "width_50 red" type="text" name="outStoreHouses[%s].unit" size="5" readonly/>
						</td>
						<td class="width_50"> 
							<input  class = "width_50 red" type="text"  name="outStoreHouses[%s].unitPrice" size="10" readonly/>
						</td>
						<td>
							<input type="text"  name="outStoreHouses[%s].applyCount" size="27" class="width_50"/>
						</td>
						<td>
							<input type="text"  name="outStoreHouses[%s].PriceCount" size="27" class="width_50"/>
						</td>
						<td>
							 <select  name="outStoreHouses[%s].inVerifyName" class="width_100" > 
	                  			 <% for(user u1 :us){ %> 
						  		 <option value="<%= u1.getUserName()%>"><%=u1.getName()%></option> 
						   		 <% }%> 
	            			</select>
						</td>
						<td>
							<textarea name="outStoreHouses[%s].purpose" cols="15" rows="2" class="width_100"></textarea>
						</td>
						<td>
							<textarea name="outStoreHouses[%s].outRemarks" cols="15" rows="2" class="width_100"> </textarea>
						</td>
						<td><i class="icon-remove pointer"></i></td>
					</tr>
			</table>
		<!-- /记录初始 -->
	</body>
</html>