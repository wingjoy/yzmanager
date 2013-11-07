<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>
<%
String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
      user user=(user)session.getAttribute("us");
      if(user==null) response.sendRedirect("../index.jsp"); 

      List<shouse> sh1=new ArrayList<shouse>();
      List<department> dp=new ArrayList<department>();
	  dp=daoUtil.selectDepartmentId();	
	  sh1=daoUtil.selectShouse();	
       List<department> dp1=new ArrayList<department>();
	  dp1=daoUtil.selectHaveHouseDepartmentId();	
	  List<firstClass> fc = new ArrayList<firstClass>();
	  fc = daoUtil.selectAllHouseFirstClass2();
	  
	  List<secondClass> sc = new ArrayList<secondClass>();
	  sc = daoUtil.selectAllHouseSecondClass();
	  
	  List<user> us = new ArrayList<user>();
	  us=daoUtil.selectAllIverifyName1();
	  
	  List <user> allUser=new ArrayList<user>();
	  allUser=daoUtil.selectUser();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	       type="text/css" />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<struts:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script language="javascript">
			var onecount5;
			onecount5=0;
			subcat5=new  Array();  
			<%
			int count5=0;
			for(user u5: allUser){
			 %>
			 subcat5[<%=count5%>]=new Array("<%= u5.getUserName()%>","<%=u5.getName()%>","<%=u5.getDepartment()%>");
			 <%
			 count5 = count5 + 1 ; 	
			}
			%>
			onecount5=<%=count5%>;	
			function changelocation3(locationid){
			document.myform.userName.length=0;
		    document.myform.userName.options[0]=new Option('选择入库人','0'); 	
			var i5; 
			for(i5=0;i5<onecount5;i5++){
			if (subcat5[i5][2] == locationid) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat5[i5][1], subcat5[i5][0]); 
			} 			   
			}			
     		}
			
     </script>
         
	 <script language="javascript">
			var onecount1;
			onecount1=0;
			subcat1=new  Array();  
			<%
			int count1=0;
			for(shouse sf: sh1){
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
			document.myform.inVerifyName.length=0;
		    document.myform.inVerifyName.options[0]=new Option('选择审核人','0'); 	
			var i3; 
			for(i3=0;i3<onecount3;i3++){
			if (subcat3[i3][2] == locationid) 
			{ 
			document.myform.inVerifyName.options[document.myform.inVerifyName.length] = new Option(subcat3[i3][1], subcat3[i3][0]); 
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
		document.myform.secondCName.options[0]=new Option('选择物品分类','0'); 
		for(i=0;i<onecount;i++){
		if (subcat[i][2] == locationid) 
		{ 
		document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat[i][1], subcat[i][0]); 
		} 
		} 		   
		}
		</script>

</head>
<body bgcolor="#E4FAF9">
 <%
     String inVerify="1";
     request.setAttribute("inVerify","1");
     PageSet pg=new PageSet(storeHouseDao.selectStoreByVerifySize(user.getUserName(),Integer.valueOf(inVerify).intValue()),15);  
     int totalsize=pg.getTotalsize();
     int totalPage=pg.getTotalpage();
     int currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     List<storeHouse> sh=new ArrayList<storeHouse>();
    
     sh=storeHouseDao.selectHouseByVerify(user.getUserName(),Integer.valueOf(inVerify).intValue(),currentPage,pg.getPagesize());
     
  %>   
    <s:form name="myform" action="inSelectByOption?currentPage=1" method="post" theme="simple" >
      <table  class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
        <tr><td><s:hidden name="inVerify" value="%{#request.inVerify}"/></td></tr>
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
            <td align="center"> &nbsp;&nbsp;&nbsp;&nbsp;库房名称：</td>
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
						&nbsp;&nbsp;&nbsp;&nbsp;物品名称：
					</td>
					<td>
						<select style="width: 200px;" name="secondCName" size="1">
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
		<td align="center"> 入库部门：</td>
             <td >
		                 <select  name="inDepartment" style="width:200px;" onChange="changelocation3(document.myform.inDepartment.options[document.myform.inDepartment.selectedIndex].value)" size="1"> 
		              <option selected value="0">选择部门</option> 
		            <% 
				
					   for(department d :dp){
					    %> 
					  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
				  
				   <% }
		           %> 
		            </select>
            </td>
		 <td align="center"> &nbsp;&nbsp;&nbsp;&nbsp;入库人：</td>
             <td > 
             <select  name="userName" style="width:200px;"  > 
                 <option selected value="0">选择入库人</option> 
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
						库房审核人：
					</td>
					<td > 
             <select  name="inVerifyName" style="width:200px;"  > 
                 <option selected value="0">选择审核人</option> 
            </select>
            </td>
             
         <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;日期:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:100px;" name="addDateBegin" displayFormat="yyyy-MM-dd"  />                       
                到<struts:datetimepicker cssStyle="width:100px;" name="addDateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td> 
            <td> &nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" cssClass="btn btn-primary" value="查  找"></s:submit> 
                 &nbsp;<!-- <a class="left-font01" href="inSelectExportAction.action">入库导出</a> --></td>   
      </tr>
          <tr>
					<td>
						&nbsp;
					</td>
				</tr>
        </table>
      </s:form>
  
       <table class="table table-striped table-bordered table-hover" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          
          <%
		        out.println(
		             "<tr height='23'>"+
		              "<th>序号</th><th>添加日期</th><th>入库人</th><th>库房</th><th>物品分类</th><th>物品名称</th><th>规格</th><th>单价</th><th>数量</th><th>单位</th><th>总价</th><th>审核人</th><th>详情</th><th>删除</th>"+
		             "</tr>"
		            );
		            int k=1;;
		            for(storeHouse e : sh){
                       String shn=daoUtil.selectShouseName(Integer.valueOf(e.getHouseId()).intValue());
                       String fn=daoUtil.selectFirstClass5(Integer.valueOf(e.getFirstCName()).intValue());
                       String sn=daoUtil.selectSecondClass8(e.getSecondCName());
		             out.println(
		              "<tr height='23'>"+
		              "<td align='center'>"+ k++ +"</td>"+
		               "<td align='center'>&nbsp;"+CurrentDate.parseDate1(e.getInDate().toString())+"</td>"+
		               "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getUserName())+"</td>"+
		              "<td align='center'>&nbsp;"+shn+"</td>" + 
		               "<td align='center'>&nbsp;"+fn+"</td>" + 
		               "<td align='center'>&nbsp;"+sn+"</td>" + 
		                "<td align='center'>&nbsp;"+e.getInContent()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getUnitPrice()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getInCount()+"</td>"+
		              "<td align='center'>&nbsp;"+e.getUnit()+"</td>"+
		              "<td align='center'>&nbsp;"+e.getTotalPrice()+"</td>"+
		               "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getInVerifyName())+"</td>");
		               out.println("<td align='center'><a class='left-font01' href='"+basepath+"storehouse/detailStore.jsp?aId="+e.getId()+"' >>></a></td>");
		               out.println(
		                "<td align='center'><a class='left-font01'onClick='alert('删除可能会影响数据库，你确定删除么？')' href='"+basepath+"storehouse/deleteStoreAction.action?aId="+e.getId()+"'>>></a></td>");
		               out.println( "</tr>");
		         } 
		         %>
         
       </table>
        <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="<%=basepath%>storehouse/inSelect.jsp?currentPage=1">首页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="<%=basepath%>storehouse/inSelect.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="<%=basepath%>storehouse/inSelect.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="<%=basepath%>storehouse/inSelect.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">         
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                 if(j==currentPage){
                   out.println(
                  "<option selected value='"+basepath+"storehouse/inSelect.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                 }else{
                 out.println(
                  "<option value='"+basepath+"storehouse/inSelect.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
              }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
   
     
</body>
</html>