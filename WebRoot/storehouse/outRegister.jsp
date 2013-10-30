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
			document.myform.houseId.options[document.myform.houseId.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
			} 			   
			}	
			
			document.myform.firstCName.length=0;
			document.myform.firstCName.options[0]=new Option('选择物品分类','0'); 	
			
			document.myform.secondCName.length=0;
			document.myform.secondCName.options[0]=new Option('选择物品','0'); 
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
		document.myform.firstCName.length=0;
		var locationid=locationid;
		var i4;
		document.myform.firstCName.options[0]=new Option('选择物品分类','0'); 
		for(i4=0;i4<onecount4;i4++){
		//if (subcat4[i4][2] == locationid) 
		//{ 
		document.myform.firstCName.options[document.myform.firstCName.length] = new Option(subcat4[i4][1], subcat4[i4][0]); 
		//} 
		} 	
			document.myform.secondCName.length=0;
			document.myform.secondCName.options[0]=new Option('选择物品','0'); 	   
		}
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
		function changelocation(locationid){
		document.myform.secondCName.length=0;
		var locationid=locationid;
		var i;
		document.myform.secondCName.options[0]=new Option('选择物品','0'); 
		for(i=0;i<onecount;i++){
		if (subcat[i][2] == locationid) 
		{ 
		document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat[i][1], subcat[i][0]); 
		} 
		} 		   
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
		function changelocation5(locationid){
		var locationid=locationid;
		var i5;
		for(i5=0;i5<onecount5;i5++){
		if (subcat5[i5][0] == locationid) 
		{ 
		document.myform.currentCount.value=subcat5[i5][1]; 
		document.myform.unit.value=subcat5[i5][2]; 
		document.myform.unitPrice.value=subcat5[i5][3]; 
		//document.myform.PriceCount.value=parseInt(document.myform.unitPrice.value)*parseInt(document.myform.applyCount.value);
		} 
		} 		   
		}
		</script>

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
	
			<table class="left-font01" align="center" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				 <tr>
          <td align="center"> 部门库房：</td>
             <td >
		                 <select  name="department" style="width:200px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
		              <option selected value="0">选择部门</option> 
		            <% 
				
					   for(department d :dp3){
					    %> 
					  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
				  
				   <% }
		           %> 
		            </select>
            </td>
            <td align="center"> &nbsp;&nbsp;库房名称：</td>
             <td > 
             <select  name="houseId" style="width:200px;" onChange="changelocation4(document.myform.houseId.options[document.myform.houseId.selectedIndex].value)" size="1" > 
                 <option selected value="0">选择库房</option> 
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