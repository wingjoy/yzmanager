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
	  sh1=daoUtil.selectShouse();	
      List<department> dp6=new ArrayList<department>();
	  dp6=daoUtil.selectHaveHouseDepartmentId();	
	  List<firstClass> fc = new ArrayList<firstClass>();
	  fc = daoUtil.selectAllHouseFirstClass2();
	  
	  List<secondClass> sc = new ArrayList<secondClass>();
	  sc = daoUtil.selectAllHouseSecondClass();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basepath %>bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
		document.myform.secondCName.options[0]=new Option('选择物品','0'); 
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
        String dp1=(String)session.getAttribute("dp1");
		String sh2=(String)session.getAttribute("sh1");
        String fc1=(String)session.getAttribute("fc1");
		String sc1=(String)session.getAttribute("sc1");
		String systemName="0";
		int totalsize=0;
        int totalPage=1;
        int currentPage=1;
        PageSet pg=new PageSet();  
    
        List<secondClass> sh=new ArrayList<secondClass>();
        if(request.getAttribute("ep")!=null){
	     sh=(List<secondClass>)request.getAttribute("ep");
	     int total=Integer.valueOf(request.getAttribute("totalCount").toString().trim()).intValue();
	     pg=new PageSet(total,15);  
	     totalsize=pg.getTotalsize();
	     totalPage=pg.getTotalpage();
	     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	     }else{   
	        currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	        int total=storeHouseDao.selectStoreSize(dp1,sh2,fc1,sc1,systemName);
	        pg=new PageSet(total,15);  
	        totalsize=pg.getTotalsize();
	        totalPage=pg.getTotalpage();
	        sh=storeHouseDao.selectStoreByOption(dp1,sh2,fc1,sc1,systemName,currentPage,pg.getPagesize());
         }
  %>   
    <s:form name="myform" action="storeCountByOption?currentPage=1" method="post" theme="simple" >
      <table  class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
    
          <tr>
          <td align="center"> 部门库房：</td>
             <td >
		                 <select  name="department" style="width:200px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
		              <option selected value="0">选择部门</option> 
		            <% 
				
					   for(department d :dp6){
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
						<select style="width: 200px;" name="secondCName" size="1">
							<option selected value="0">
								选择物品
							</option>
						</select>

					</td>
               <td> &nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" cssClass="btn btn-primary" value="查  找"></s:submit>  </td>                     
				</tr>
              <tr>
					<td>
						&nbsp;
					</td>
				</tr>
        </table>
      </s:form>
       
       <table class="table table-bordered" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          
          <%
		        out.println(
		             "<tr height='23' >"+
		              "<th>序号</th><th>部门</th><th>库房</th><th>物品分类</th><th>物品名称</th><th>单价</th><th>入库数量</th><th>现存数量</th><th>出库数量</th><th>单位</th>"+"</tr>" );
		            int k=1;;
		            for(secondClass e : sh){
		               String sdp=daoUtil.selectDepartment3(Integer.valueOf(e.getDepartment()).intValue());
                       String shn=daoUtil.selectShouseName(Integer.valueOf(e.getHouseId()).intValue());
                       String fn=daoUtil.selectFirstClass5(Integer.valueOf(e.getFirstCName()).intValue());
		             out.println(
		              "<tr height='23'>"+
		              "<td align='center'>"+ k++ +"</td>"+
		               "<td align='center'>&nbsp;"+sdp+"</td>"+
		              "<td align='center'>&nbsp;"+shn+"</td>" + 
		               "<td align='center'>&nbsp;"+fn+"</td>" + 
		               "<td align='center'>&nbsp;"+e.getSecondCName()+"</td>" + 
		                 "<td align='center'>&nbsp;"+e.getUnitPrice()+"</td>" + 
		                "<td align='center'>&nbsp;"+e.getInCount()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getCurrentCount()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getOutCount()+"</td>"+
		              "<td align='center'>&nbsp;"+e.getUnit()+"</td></tr>");
		         } 
		         %>
         
       </table>
        <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="storeSelectByOption.jsp?currentPage=1">首页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="storeSelectByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="storeSelectByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="storeSelectByOption.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">         
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                 if(j==currentPage){
                   out.println(
                  "<option selected value='storeSelectByOption.jsp?&currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                 }else{
                 out.println(
                  "<option value='storeSelectByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
              }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
   
     
</body>
</html>