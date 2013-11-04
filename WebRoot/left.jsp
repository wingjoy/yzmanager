<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %>  
<%@page import="java.util.*" %>  
<%@page import="com.yz.manager.storehouse.bean.houseManager" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<link href="css/css.css" rel="stylesheet" type="text/css" />
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<50;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="images/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<8;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="images/ico04.gif";
	}
}

</SCRIPT>

<% 
		user user=(user)session.getAttribute("us");
		if(user==null) response.sendRedirect("index.jsp"); 
		System.out.println("88888:"+user.getDepartment());
		String department=daoUtil.selectDepartment3(Integer.valueOf(user.getDepartment()).intValue());
		//power power=new power();
		
		power power=user.getPower();
			System.out.println("111111:"+power);
		boolean sm=false;
		boolean dm=false;
	
		 sm=power.isSystemManager();
		 dm=power.isDepartmentManager();
		 
		 boolean houseManager=false;
		 houseManager =daoUtil.selectHouseManagerByuser(user.getUserName());
	
%>
<body bgcolor="#E4FAF9">	   
      <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
           <td>
				<table  width="200" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="3"><img src="images/ico02.gif" width="55" height="55" /></td>
					<td width="75%" height="22" class="left-font01">您好：<span class="left-font02"><%= user.getName() %></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01" >
						部门：<span class="left-font02"><%= department%></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="logoutAction" target="_top" class="left-font01">退出系统</a>&nbsp;]</td>
				  </tr> 
				  <tr><td colspan="3"><hr></td></tr>
				</table>
		   </td>		
		 </tr>	
		 <tr>
		   <td>		
		     <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">						
			<% if(sm){			   
			    //  out.println("<table width='200' border='0' align='center' cellpadding='0' cellspacing='0'>");
			  	  out.println( "<tr><td width='8%'><img name='img1' id='img1' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"1\");'class='left-font05' target='main' >档案管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree1' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu1' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"1\");' href='archives/addArchives.jsp'>存档申请</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu2' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"2\");' href='archives/selectArchives.jsp?currentPage=1'>档案查询</a></td>"+
				"</tr>"+		
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu16' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"16\");' href='archives/applyArchivesState.jsp?averify=0&currentPage=1'>申请状态</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu15' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"15\");' href='archives/verifyArchives.jsp?currentPage=1'>存档审核</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);

			      out.println( "<tr><td width='8%'><img name='img2' id='img2' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"2\");'class='left-font05' target='main' >联系人管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree2' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu3' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"3\");' href='personal/addPersonal.jsp'>增加联系人</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu4' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"4\");' href='personal/selectPersonal.jsp?currentPage=1'>查询联系人</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	
			  	 out.println( "<tr><td width='8%'><img name='img3' id='img3' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"3\");' target='main' class='left-font05' >费用管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree3' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu5' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"5\");' href='expense/addexpense.jsp'>增加费用</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu6' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"6\");' href='expense/selectExpense.jsp?currentPage=1'>查询费用</a></td>"+
				"</tr>"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu18' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"18\");' href='expense/applyExpenseState.jsp?everify=0&currentPage=1'>申请状态</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu19' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"19\");' href='expense/verifyExpense.jsp?currentPage=1'>费用审核</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='21' ><img id='xiaotu20' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"20\");' href='expense/monthExpense.jsp'>人员费用汇总</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='21' ><img id='xiaotu21' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"21\");' href='expense/classExpenseCount.jsp'>分类费用汇总</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	
			  	 out.println( "<tr><td width='8%'><img name='img4' id='img4' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"4\");' target='main' class='left-font05'>办公用品管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree4' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu7' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"7\");' href='storehouse/inRegister.jsp'>入库登记</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu8' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"8\");' href='storehouse/inSelect.jsp?currentPage=1'>入库查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu33' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"33\");' href='storehouse/storeSelect.jsp?currentPage=1'>库存查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu34' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"34\");' href='storehouse/myInStore.jsp?currentPage=1&inVerify=0'>我的入库</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu35' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"35\");' href='storehouse/inStoreVerify.jsp?currentPage=1'>入库审批</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu36' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"36\");' href='storehouse/outRegister.jsp?'>出库登记</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu40' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"40\");' href='storehouse/manualOutRegister.jsp?'>手动出库</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu39' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"39\");' href='storehouse/outSelect.jsp?currentPage=1'>出库查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu37' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"37\");' href='storehouse/myOutStore.jsp?currentPage=1'>我的出库</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu38' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"38\");' href='storehouse/outStoreVerify.jsp?currentPage=1'>出库审批</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu41' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"41\");' href='storehouse/inStoreSum.jsp'>入库汇总</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu42' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"42\");' href='storehouse/outStoreSum.jsp'>出库汇总</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	 out.println( "<tr><td width='8%'><img name='img6' id='img6' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"6\");' target='main' class='left-font05'>客户管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree6' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu43' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"43\");' href='custom/addCustom.jsp'>增加客户</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu44' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"44\");' href='custom/selectCustom.jsp?currentPage=1'>客户查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu45' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"45\");' href='custom/customRectify.jsp?currentPage=1'>有误客户信息</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	
			  	 out.println( "<tr><td width='8%'><img name='img5' id='img5' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"5\");' target='main' class='left-font05' >系统管理</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree5' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu9' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"9\");' href='department/managerdDepartment.jsp?currentPage=1'>部门管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu10' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"10\");' href='user/managerUser.jsp?currentPage=1'>用户管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu14' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"14\");' href='gCompany/managerCompany.jsp' >挂账公司管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu17' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"17\");' href='paymode/managerPayMode.jsp' >付款方式管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu29' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"29\");' href='shouse/managerShouse.jsp' >库房管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu30' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"30\");' href='shouse/houseManager.jsp' >库房管理员管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu31' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"31\");' href='shouse/houseClassManager.jsp?currentPage=1' >库房物品分类管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu46' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"46\");' href='custom/customType.jsp' >客户类型管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu49' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"49\");' href='custom/customState.jsp' >客户状态管理</a></td>"+
				"</tr>"+
				
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu47' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"47\");' href='custom/customArea.jsp?currentPage=1' >客户区域管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu48' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"48\");' href='custom/userAreaManager.jsp?currentPage=1' >用户区域分配</a></td>"+
				"</tr>"+
				"<tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu12' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"12\");' href='power/managerPower.jsp?currentPage=1'>权限管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu11' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"11\");' href='class/managerClass.jsp?currentPage=1'>分类管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu13' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"13\");' href='user/modifyPassword.jsp'>密码修改</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			}else if(dm){			   
			    //  out.println("<table width='200' border='0' align='center' cellpadding='0' cellspacing='0'>");
			  	  out.println( "<tr><td width='8%'><img name='img1' id='img1' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"1\");' target='main' class='left-font05'>档案管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree1' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu1' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"1\");' href='archives/addArchives.jsp'>存档申请</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu2' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"2\");' href='archives/selectDpArchives.jsp?currentPage=1'>档案查询</a></td>"+
				"</tr>"+		
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu16' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"16\");' href='archives/applyArchivesState.jsp?averify=0&currentPage=1'>申请状态</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu15' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"15\");' href='archives/verifyArchives.jsp?currentPage=1'>存档审核</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);

			      out.println( "<tr><td width='8%'><img name='img2' id='img2' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"2\");' target='main' class='left-font05'>联系人管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree2' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu3' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"3\");' href='personal/addPersonal.jsp'>增加联系人</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu4' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"4\");' href='personal/selectDpPersonal.jsp?currentPage=1'>查询联系人</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	
			  	 out.println( "<tr><td width='8%'><img name='img3' id='img3' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"3\");' target='main' class='left-font05'>费用管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree3' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu5' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"5\");' href='expense/addexpense.jsp'>增加费用</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu6' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"6\");' href='expense/selectDpExpense.jsp?currentPage=1'>查询费用</a></td>"+
				"</tr>"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu18' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"18\");' href='expense/applyExpenseState.jsp?everify=0&currentPage=1'>申请状态</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu19' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"19\");' href='expense/verifyExpense.jsp?currentPage=1'>费用审核</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='21' ><img id='xiaotu20' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"20\");' href='expense/monthDpExpense.jsp'>人员费用汇总</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='21' ><img id='xiaotu21' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"21\");' href='expense/classDpExpenseCount.jsp'>分类费用汇总</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
 
			  	 out.println( "<tr><td width='8%'><img name='img4' id='img4' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"4\");' target='main' class='left-font05'>库存管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree4' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu7' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"7\");' href='storehouse/inRegister.jsp'>入库登记</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu8' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"8\");' href='storehouse/inDpSelect.jsp?currentPage=1'>入库查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu33' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"33\");' href='storehouse/storeDpSelect.jsp?currentPage=1'>库存查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu34' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"34\");' href='storehouse/myInStore.jsp?currentPage=1&inVerify=0'>我的入库</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu35' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"35\");' href='storehouse/inStoreVerify.jsp?currentPage=1'>入库审批</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu36' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"36\");' href='storehouse/outRegister.jsp?'>出库登记</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu40' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"40\");' href='storehouse/manualOutRegister.jsp?'>手动出库</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu39' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"39\");' href='storehouse/outDpSelect.jsp?currentPage=1'>出库查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu37' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"37\");' href='storehouse/myDpOutStore.jsp?currentPage=1'>我的出库</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu38' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"38\");' href='storehouse/outStoreVerify.jsp?currentPage=1'>出库审批</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu41' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"41\");' href='storehouse/inStoreSum.jsp'>入库汇总</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu42' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"42\");' href='storehouse/outStoreSum.jsp'>出库汇总</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	
			  	 	out.println( "<tr><td width='8%'><img name='img6' id='img6' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"6\");' target='main' class='left-font05'>客户管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree6' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
				"<tr>"+
				 " <td width='9%' height='20' ><img id='xiaotu43' src='images/ico06.gif' width='8' height='12' /></td>"+
				 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"43\");' href='custom/addCustom.jsp'>增加客户</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu44' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"44\");' href='custom/selectDpCustom.jsp?currentPage=1'>客户查询</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu45' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"45\");' href='custom/dpCustomRectify.jsp?currentPage=1'>有误客户信息</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			  	 out.println( "<tr><td width='8%'><img name='img5' id='img5' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"5\");' target='main' class='left-font05'>系统管理</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree5' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+			
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu10' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"10\");' href='user/managerDepartmentUser.jsp?currentPage=1'>用户管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu32' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"32\");' href='shouse/managerDpShouse.jsp'>库房管理</a></td>"+
				"</tr>"+	
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu33' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"33\");' href='shouse/houseDpManager.jsp'>库房管理员管理</a></td>"+
				"</tr>"+	
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu31' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"31\");' href='shouse/houseDpClassManager.jsp?currentPage=1' >库房物品分类管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu12' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"12\");' href='power/managerDpPower.jsp?currentPage=1'>权限管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu11' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"11\");' href='class/managerDpClass.jsp?currentPage=1'>分类管理</a></td>"+
				"</tr>"+
				"<tr>"+
				"<td width='9%' height='20' ><img id='xiaotu13' src='images/ico06.gif' width='8' height='12' /></td>"+
				"<td width='91%'>"+
				"<a target='main' class='left-font03' onClick='tupian(\"13\");' href='user/modifyPassword.jsp'>密码修改</a></td>"+
				"</tr>"+
                " </table></td></tr>"
			  	);
			}else{
			      boolean ams=power.isAms();
			      boolean pms=power.isPms();
			      boolean ems=power.isEms();
			      boolean ims=power.isIms();
			      boolean cms=power.isCms();
			      if(ams){	
			        out.println( "<tr><td width='8%'><img name='img1' id='img1' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"1\");' target='main' class='left-font05' >档案管理系统</a></td></tr>");
			  	    out.println( " <tr><td></td><td><table id='subtree1' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >");
			         if(power.isAmsadd()){
			             out.println(  
						"<tr>"+
						 " <td width='9%' height='20' ><img id='xiaotu1' src='images/ico06.gif' width='8' height='12' /></td>"+
						 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"1\");' href='archives/addArchives.jsp'>增加档案</a></td>"+
						"</tr>");
					 }	
			         if(power.isAmsSelectOther()){
					   out.println(   
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu2' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"2\");' href='archives/selectOtherArchives.jsp?currentPage=1'>查询档案</a></td>"
					  	);
			         }else if(power.isAmsselect()){
					   out.println(   
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu2' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"2\");' href='archives/selectMyArchives.jsp?currentPage=1'>查询档案</a></td>"
					  	);
			         }
	                 if(power.isAmsadd()){
					   out.println(   
						"<tr>"+
						 " <td width='9%' height='20' ><img id='xiaotu16' src='images/ico06.gif' width='8' height='12' /></td>"+
						 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"16\");' href='archives/applyArchivesState.jsp?averify=0&currentPage=1'>申请状态</a></td>"+
						"</tr>"
                      );
			         }
			         if(power.isAverify()){
					   out.println(   
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu15' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"15\");' href='archives/verifyArchives.jsp?currentPage=1'>存档审核</a></td>"+
						"</tr>"
                      );
			         }
				     out.println( " </table></td></tr>");  					  
			      }
			      if(pms){
				       out.println( "<tr><td width='8%'><img name='img2' id='img2' src='images/ico04.gif' width='8' height='11' /></td>"+
				  	  "<td width='92%'><a href='javascript:' onClick='list(\"2\");' target='main' class='left-font05' >人员管理系统</a></td></tr>");
				  	  out.println(
				  	      " <tr><td></td><td><table id='subtree2' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >");
					  if(power.isPmsadd()){
			             out.println(  
						   "<tr>"+
					 " <td width='9%' height='20' ><img id='xiaotu3' src='images/ico06.gif' width='8' height='12' /></td>"+
					 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"3\");' href='personal/addPersonal.jsp'>增加人员</a></td>"+
					"</tr>");
					 }	
					 if(power.isPmsSelectOther()){
						 out.println(
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu4' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"4\");' href='personal/selectOtherPersonal.jsp?currentPage=1'>查询人员</a></td>"+
						"</tr>"
					  	);
					 }else if(power.isPmsselect()){
					    out.println(
					    	"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu4' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"4\");' href='personal/selectMyPersonal.jsp?currentPage=1'>查询人员</a></td>"+
						"</tr>"
					  	);
					 }
				  	out.println( " </table></td></tr>");  		
			      }
			      if(ems){
			               out.println( "<tr><td width='8%'><img name='img3' id='img3' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"3\");' target='main' class='left-font05'>费用管理系统</a></td></tr>");
			  	  out.println(
			  	      " <tr><td></td><td><table id='subtree3' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >");
				
				if(power.isEmsadd()){
			             out.println(  
						   "<tr>"+
					 " <td width='9%' height='20' ><img id='xiaotu22' src='images/ico06.gif' width='8' height='12' /></td>"+
					 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"22\");' href='expense/addexpense.jsp'>增加费用</a></td>"+
					"</tr>");
					 }
			    if(power.isEmsSelectOther()){
						 out.println(
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu23' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"23\");' href='expense/selectOtherExpense.jsp?currentPage=1'>查询费用</a></td>"+
						"</tr>"
					  	);
					 }else if(power.isEmsselect()){
					    out.println(
					    	"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu24' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"24\");' href='expense/selectMyExpense.jsp?currentPage=1'>查询费用</a></td>"+
						"</tr>"
					  	);
					 } if(power.isEmsadd()){
					   out.println(   
						"<tr>"+
						 " <td width='9%' height='20' ><img id='xiaotu25' src='images/ico06.gif' width='8' height='12' /></td>"+
						 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"25\");' href='expense/applyExpenseState.jsp?everify=0&currentPage=1'>申请状态</a></td>"+
						"</tr>"
                      );
			         }
			         if(power.isEverify()){
					   out.println(   
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu26' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"26\");'href='expense/verifyExpense.jsp?currentPage=1'>费用审核</a></td>"+
						"</tr>"
                      );
			         }	
				      if(power.isEmsMonth()){
					   out.println(   
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu27' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"27\");'href='expense/monthMyExpense.jsp'>人员费用汇总</a></td>"+
						"</tr>"
                      );
			         }	
			          if(power.isEmsClass()){
					   out.println(   
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu28' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"28\");'href='expense/classMyExpenseCount.jsp'>分类费用汇总</a></td>"+
						"</tr>"
                      );
			         } 	
					 out.println(" </table></td></tr>"); 
			      }
			      
			       if(ims){
				       out.println( "<tr><td width='8%'><img name='img4' id='img4' src='images/ico04.gif' width='8' height='11' /></td>"+
				  	  "<td width='92%'><a href='javascript:' onClick='list(\"4\");' target='main' class='left-font05' >库存管理系统</a></td></tr>");
				  	  out.println(
				  	      " <tr><td></td><td><table id='subtree4' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >");
					  if(power.isImsInRegister()){
			             out.println(  
								   "<tr>"+
							 " <td width='9%' height='20' ><img id='xiaotu4' src='images/ico06.gif' width='8' height='12' /></td>"+
							 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"4\");' href='storehouse/inRegister.jsp'>入库登记</a></td>"+
							"</tr>"+
							"<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu34' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"34\");' href='storehouse/myInStore.jsp?currentPage=1&inVerify=0'>我的入库</a></td>"+
							"</tr>"
							);
					 }	
					 if(power.isImsOutRegister()){
						 out.println(
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu5' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"5\");' href='storehouse/outRegister.jsp'>出库登记</a></td>"+
						"</tr>"+
					  	"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu37' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"37\");' href='storehouse/myDpOutStore.jsp?currentPage=1'>我的出库</a></td>"+
						"</tr>"
					  	);
					 }
					  if(houseManager){
						 out.println(
									"<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu8' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"8\");' href='storehouse/inDpSelect.jsp?currentPage=1'>入库查询</a></td>"+
							"</tr>"+
							"<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu33' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"33\");' href='storehouse/storeDpSelect.jsp?currentPage=1'>库存查询</a></td>"+
							"</tr>"+
										"<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu40' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"40\");' href='storehouse/manualOutRegister.jsp?'>手动出库</a></td>"+
							"</tr>"+
							"<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu39' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"39\");' href='storehouse/outDpSelect.jsp?currentPage=1'>出库查询</a></td>"+
							"</tr>"+
					  	   "<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu41' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"41\");' href='storehouse/inStoreSum.jsp'>入库汇总</a></td>"+
							"</tr>"+
							"<tr>"+
							"<td width='9%' height='20' ><img id='xiaotu42' src='images/ico06.gif' width='8' height='12' /></td>"+
							"<td width='91%'>"+
							"<a target='main' class='left-font03' onClick='tupian(\"42\");' href='storehouse/outStoreSum.jsp'>出库汇总</a></td>"+
							"</tr>"
					  	);
					 }
				     if(power.isIverify()){
						 out.println(
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu6' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"6\");' href='storehouse/inStoreVerify.jsp?currentPage=1'>入库审批</a></td>"+
						"</tr>"+
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu6' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"6\");' href='storehouse/outStoreVerify.jsp?currentPage=1'>出库审批</a></td>"+
						"</tr>"
					  	);
					 }
				  	out.println( " </table></td></tr>");  		
			      }
			      
			        if(cms){
				       out.println( "<tr><td width='8%'><img name='img7' id='img7' src='images/ico04.gif' width='8' height='11' /></td>"+
				  	  "<td width='92%'><a href='javascript:' onClick='list(\"7\");' target='main' class='left-font05' >客户管理系统</a></td></tr>");
				  	  out.println(
				  	      " <tr><td></td><td><table id='subtree7' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >");
					  if(power.isCmsadd()){
			             out.println(  
						   "<tr>"+
					 " <td width='9%' height='20' ><img id='xiaotu51' src='images/ico06.gif' width='8' height='12' /></td>"+
					 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"51\");' href='custom/addCustom.jsp'>增加客户</a></td>"+
					"</tr>");
					 }	
					 if(power.isCmsSelectOther()){
						 out.println(
						"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu52' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"52\");' href='custom/selectOtherCustom.jsp?currentPage=1'>客户查询</a></td>"+
						"</tr>"
					  	);
					 }else if(power.isCmsselect()){
					    out.println(
					    	"<tr>"+
						"<td width='9%' height='20' ><img id='xiaotu52' src='images/ico06.gif' width='8' height='12' /></td>"+
						"<td width='91%'>"+
						"<a target='main' class='left-font03' onClick='tupian(\"52\");' href='custom/selectMyCustom.jsp?currentPage=1'>客户查询</a></td>"+
						"</tr>"
					  	);
					 }
					  out.println(  
						   "<tr>"+
					 " <td width='9%' height='20' ><img id='xiaotu53' src='images/ico06.gif' width='8' height='12' /></td>"+
					 "<td width='91%'><a target='main' class='left-font03' onClick='tupian(\"53\");' href='custom/myCustomRectify.jsp?currentPage=1'>有误客户信息</a></td>"+
					"</tr>");
				  	out.println( " </table></td></tr>");  		
			      }
			    out.println( "<tr><td width='8%'><img name='img5' id='img5' src='images/ico04.gif' width='8' height='11' /></td>"+
			  	  
			  	  "<td width='92%'><a href='javascript:' onClick='list(\"5\");' target='main' class='left-font05' >系统管理</a></td></tr>");
			  	  out.println(
			  	     " <tr><td></td><td><table id='subtree5' style='DISPLAY: none' width='80%' border='0' align='center' cellpadding='0' cellspacing='0' >"+
					"<tr>"+
					"<td width='9%' height='20' ><img id='xiaotu13' src='images/ico06.gif' width='8' height='12' /></td>"+
					"<td width='91%'>"+
					"<a target='main' class='left-font03' onClick='tupian(\"13\");' href='user/modifyPassword.jsp'>密码修改</a></td>"+
					"</tr>"+
	                " </table></td></tr>"
			  	); 
			 }
			 %>		
		   
		    </table>
		 </td>   
	    </tr>
	    </table>			
		
     
     
     
     
</body>
</html>