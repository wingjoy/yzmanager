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
	power pw=user.getPower();
	   List<department> dp1=new ArrayList<department>();
	    List<shouse> sh=new ArrayList<shouse>();	   
	if(pw.isSystemManager()){
	   dp1=daoUtil.selectHaveHouseDepartmentId();
	     sh=daoUtil.selectShouse();		
	}else if(pw.isDepartmentManager()){
	    dp1.add(daoUtil.selectDepartmentOne(Integer.valueOf(user.getDepartment()).intValue()));
	    sh=daoUtil.selectShouse(user.getDepartment());
	}else{
	    dp1.add(daoUtil.selectDepartmentOne(Integer.valueOf(user.getDepartment()).intValue()));
	    sh=daoUtil.selectShouseManager(user.getUserName());
	}	
	 
      List<department> dp=new ArrayList<department>();
	  dp=daoUtil.selectDepartmentId();	
	 

	List<secondClass> sc = new ArrayList<secondClass>();
	sc = daoUtil.selectAllHouseSecondClass();
	
	List<user> us = new ArrayList<user>();
	us=daoUtil.selectAllIverifyName1();
	
	List<firstClass> fc = new ArrayList<firstClass>();
	fc = daoUtil.selectAllHouseFirstClass2();
	
	 List<user> allUser=new ArrayList<user>();
    allUser=daoUtil.selectUser();
    
    List<user> allKgName=new ArrayList<user>();
    allKgName=daoUtil.selectHouseManagerVerifyName();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>出库登记</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
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
			
			var onecount3;
			onecount3=0;
			subcat3=new  Array();  
			<%
			int count3=0;
			for(user u: us){
			 %>
			 subcat3[<%=count3%>]=new Array("<%= u.getUserName()%>","<%=u.getName()%>","<%=u.getDepartment()%>");
			 <%
			 count3 = count3 + 1 ; 	
			}
			%>
			onecount3=<%=count3%>;	
			document.myform.houseVerifyName.length=0;
		
			var i3; 
			for(i3=0;i3<onecount3;i3++){
			if (subcat3[i3][2] == locationid) 
			{ 
			document.myform.houseVerifyName.options[document.myform.houseVerifyName.length] = new Option(subcat3[i3][1], subcat3[i3][0]); 
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
		if (subcat4[i4][2] == locationid) 
		{ 
		document.myform.firstCName.options[document.myform.firstCName.length] = new Option(subcat4[i4][1], subcat4[i4][0]); 
		} 
		} 
		var onecount8;
			onecount8=0;
			subcat8=new  Array();  
			<%
			int count8=0;
			for(user kgu: allKgName){
			 %>
			 subcat8[<%=count8%>]=new Array("<%= kgu.getUserName()%>","<%=kgu.getName()%>","<%=kgu.getDepartment()%>");
			 <%
			 count8 = count8 + 1 ; 	
			}
			%>
			onecount8=<%=count8%>;
			document.myform.houseManager.length=0;
			var locationid=locationid;
			var i8;
			for(i8=0;i8<onecount8;i8++){
			if (subcat8[i8][2] == locationid) 
			{ 
			document.myform.houseManager.options[document.myform.houseManager.length] = new Option(subcat8[i8][1], subcat8[i8][0]); 
			} 
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
		 subcat5[<%=count5%>]=new Array("<%=s.getId()%>","<%=s.getCurrentCount()%>","<%=s.getUnit()%>");
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
		} 
		} 		   
		}
		</script>
		
		<script language="javascript">
			var onecount7;
			onecount7=0;
			subcat7=new  Array();  
			<%
			int count7=0;
			for(user user7: allUser){
			 %>
			 subcat7[<%=count7%>]=new Array("<%= user7.getUserName()%>","<%=user7.getName()%>","<%=user7.getDepartment()%>");
			 <%
			 count7 = count7 + 1 ; 	
			}
			%>
			onecount7=<%=count7%>;
			function changelocation7(locationid){
			
			document.myform.userName.length=0;
			var locationid7=locationid;
			var i7;
			document.myform.userName.options[0]=new Option('选择领用人','0'); 
			for(i7=0;i7<onecount7;i7++){
			if (subcat7[i7][2] == locationid7) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat7[i7][1], subcat7[i7][0]); 
			} 
			} 
			
			var onecount9;
			onecount9=0;
			subcat9=new  Array();  
			<%
			int count9=0;
			for(user u: us){
			 %>
			 subcat9[<%=count9%>]=new Array("<%= u.getUserName()%>","<%=u.getName()%>","<%=u.getDepartment()%>");
			 <%
			 count9 = count9 + 1 ; 	
			}
			%>
			onecount9=<%=count9%>;	
			document.myform.inVerifyName.length=0;
		
			var i9; 
			for(i9=0;i9<onecount9;i9++){
			if (subcat9[i9][2] == locationid) 
			{ 
			document.myform.inVerifyName.options[document.myform.inVerifyName.length] = new Option(subcat9[i9][1], subcat9[i9][0]); 
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
						<s:param>applyDepartmentnull</s:param>
					</s:fielderror>
			   </td>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>userNamenull</s:param>
					</s:fielderror>
			    </td>
			 </tr>
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
						<s:param>kucunbugou</s:param>
					</s:fielderror>
				
					<s:fielderror>
						<s:param>applyc</s:param>
					</s:fielderror>
			     </td>
			    <td class="actionmessage">
					<s:fielderror>
						<s:param>purposenull</s:param>
					</s:fielderror>
				 </td>
			<tr>
				<td class="actionmessage">
					<s:actionmessage />
				</td>
			</tr>
			
		</table>

		<s:form name="myform" action="manualOutStoreAction" method="post"
			theme="simple">
			<s:token></s:token>
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
          <td  align="center"> 领用部门：</td>
             <td > 
             <select  name="applyDepartment"  style="width:200px;" onChange="changelocation7(document.myform.applyDepartment.options[document.myform.applyDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0">选择领用部门</option> 
            <% 
		
		   for(department d1 :dp){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
         <td  align="center">
           领用人:</td>
            <td >
                  <select name="userName"  style="width:200px;" size="1"> 
           <option selected value="0">选择领用人</option> 
        
            </select>          
            
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
				
					   for(department d :dp1){
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
						&nbsp;&nbsp;申请数量：
					</td>
					<td align="center">
						<s:textfield name="applyCount" size="27"></s:textfield>
					</td>
					
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
			
				<tr>
				
					 <td align="center">
						部门审核：
					</td>
					<td > 
             <select  name="inVerifyName" style="width:200px;"  > 
                 <option selected value="0">选择部门审核人</option> 
            </select>
            </td>
            <td class="actionmessage">
					<s:fielderror>
						<s:param>inVerifyNamenull</s:param>
					</s:fielderror>
				</td>
				
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>

				<tr>
				
					 <td align="center">
						库房审核：
					</td>
					<td > 
             <select  name="houseVerifyName" style="width:200px;"  > 
                 <option selected value="0">选择库房审核人</option> 
            </select>
            </td>
				<td class="actionmessage">
					<s:fielderror>
						<s:param>houseVerifyNamenull</s:param>
					</s:fielderror>
				</td>
				</tr>
			
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
			
				<tr>
				
					 <td align="center">
						库管审核：
					</td>
					<td > 
             <select  name="houseManager" style="width:200px;"  > 
                 <option selected value="0">选择库管员</option> 
            </select>
            </td>
            <td class="actionmessage">
					<s:fielderror>
						<s:param>houseManagernull</s:param>
					</s:fielderror>
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
					<td colspan="2">
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
						<s:submit name="submit" cssClass="btn btn-primary" value="提交申请"></s:submit>
						&nbsp;&nbsp;
						<s:reset name="reset" cssClass="btn btn-primary" value="重新输入"></s:reset>
						<br>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>