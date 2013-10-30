<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %>  
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.storehouse.bean.*" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>

<%
   user user=(user)session.getAttribute("us");
   if(user==null) response.sendRedirect("../index.jsp"); 
  
    List<user> us=new ArrayList<user>();
    us=daoUtil.selectUser();

   String systemName="0";
    List<secondClass> sc = new ArrayList<secondClass>();
	sc = daoUtil.selectAllHouseSecondClass();
	
	List<firstClass> fc = new ArrayList<firstClass>();
	fc = daoUtil.selectAllHouseFirstClass2();
    
    List<department> department=new ArrayList<department>();
	department=daoUtil.selectDepartmentId();	
	 List<department> department1=new ArrayList<department>();
	    power pw=user.getPower();
	    if(pw.isSystemManager()){
	       department1=daoUtil.selectHaveHouseDepartmentId();
	    }else{
	       	department1.add(daoUtil.selectDepartmentOne(Integer.valueOf(user.getDepartment()).intValue()));
	    }
     List<shouse> sh=new ArrayList<shouse>();
	 sh=daoUtil.selectShouse();	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<struts:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月度数量汇总</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
	 <script language="javascript">
			var onecount7;
			onecount7=0;
			subcat7=new  Array();  
			<%
			int count7=0;
			for(user user7: us){
			 %>
			 subcat7[<%=count7%>]=new Array("<%= user7.getUserName()%>","<%=user7.getName()%>","<%=user7.getDepartment()%>");
			 <%
			 count7 = count7 + 1 ; 	
			}
			%>
			onecount7=<%=count7%>;
			function changelocation5(locationid){
			document.myform.userName.length=0;
			
			var i7;
			document.myform.userName.options[0]=new Option('选择入库人','0'); 
			for(i7=0;i7<onecount7;i7++){
			if (subcat7[i7][2] == locationid) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat7[i7][1], subcat7[i7][0]); 
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
			for(shouse sf: sh){
			 %>
			 subcat5[<%=count5%>]=new Array("<%= sf.getId()%>","<%=sf.getHouseName()%>","<%=sf.getDepartment()%>");
			 <%
			 count5 = count5 + 1 ; 	
			}
			%>
			onecount5=<%=count5%>;
			function changelocation2(locationid){
			document.myform.houseId.length=0;
			document.myform.houseId.options[0]=new Option('选择库房','0'); 
			var i5; 
			for(i5=0;i5<onecount5;i5++){
			if (subcat5[i5][2] == locationid) 
			{ 
			document.myform.houseId.options[document.myform.houseId.length] = new Option(subcat5[i5][1], subcat5[i5][0]); 
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
  
     int inStoreCount [][]=(int[][])request.getAttribute("sum");
  
     String sdp="";
     String s1=daoUtil.selectDepartment3(Integer.valueOf((String)request.getAttribute("dp")).intValue());
     if("0".equals((String)request.getAttribute("dp1"))){
        sdp=s1;
     }else{
        sdp= daoUtil.selectDepartment3(Integer.valueOf((String)request.getAttribute("dp1")).intValue());
     }
     String hId=(String)request.getAttribute("hId");
      List<firstClass> dfc=new ArrayList<firstClass>();
      dfc=daoUtil.selectFirstClass3((String)request.getAttribute("dp"),hId,systemName);
      String name="";
       if(!"".equals((String)request.getAttribute("name"))) name=daoUtil.selectUser((String)request.getAttribute("name"));
       List<secondClass> dsc=new ArrayList<secondClass>();
      dsc=daoUtil.selectSecondClass61((String)request.getAttribute("dp"),hId,systemName);

  %>   
        <s:form name="myform" action="inStoreSumByOption" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
      <tr>
          <td  align="center"> 入库部门：</td>
             <td > 
             <select  name="department1"  style="width:200px;" onChange="changelocation5(document.myform.department1.options[document.myform.department1.selectedIndex].value)" size="1"> 
              <option selected value="0">选择部门</option> 
            <% 
		
		   for(department d1 :department){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
   
         <td  align="center">
          &nbsp;&nbsp;&nbsp; 入库人：</td>
            <td >
                  <select name="userName"  style="width:200px;" size="1"> 
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
        <td  align="center"> 库房部门：</td>
             <td > 
             <select  name="department"  style="width:200px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
              <option selected value="0">选择部门</option> 
            <% 
		
		   for(department d1 :department1){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
            <td align="center">  &nbsp;&nbsp;&nbsp;库房名称：</td>
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
						 &nbsp;&nbsp;&nbsp;物品名称：
					</td>
					<td>
						<select style="width: 200px;" name="secondCName"  size="1">
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
		  <td  align="center">统计年份：</td>
           <td>
           	  <select  name="year" style="width:200px;" > 
              <option value="2012">2012</option>  
              <option value="2013" selected>2013</option>  
              <option value="2014" >2014</option>  
              <option value="2015">2015</option>  
            </select>
           </td>   	
            <td align="center">
						 &nbsp;&nbsp;&nbsp;统计内容：
		   </td>
		   <td align="center">
						<input type="radio" name="content" value="1" checked="checked" />
						数量&nbsp;
						<input type="radio" name="content" value="0" />
						费用
					</td>
		
              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" value="查 找"></s:submit>  </td>                     
         </tr>
         <tr>
      	<td>
						&nbsp;
					</td>
				</tr>
        </table>
      </s:form>
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height='25' class="tableth" bgcolor="#8E8EFF" >
          <th align="center">入库部门</th><th align="center">库房</th><th align="center">物品分类</th><th align="center">物品名称</th><th align="center">1月</th><th align="center">2月</th><th align="center">3月</th><th align="center">4月</th><th align="center">5月</th><th align="center">6月</th><th align="center">7月</th><th align="center">8月</th><th align="center">9月</th><th align="center">10月</th><th align="center">11月</th><th align="center">12月</th><th align="center">入库数量合计</th>
          </tr>
          <%     
                 int p=0; 
                 int ccount=0;
                 int s=0;
                 String sname="本部门无库房";
                  int sSize=0;
                for(int j=0;j<dfc.size();j++){ 
                   int m=daoUtil.selectSecondClassSize(String.valueOf(dfc.get(j).getId())); 
                   if(s==0){
                    sname=daoUtil.selectShouseName(Integer.valueOf(dfc.get(j).getHouseId()).intValue());
                    sSize=daoUtil.selectSecondClassSizeByHouseId(dfc.get(j).getHouseId());      
                   }
                  
                    int l=0;
                   for(int k=0;k<dsc.size();k++){         
			          if(dsc.get(k).getFirstCName().equals(String.valueOf(dfc.get(j).getId()))){
			             out.println(
				              "<tr  height='25'>");
				              if(k==0){
				              		out.println( "<td align='center' width='7%' rowspan='"+dsc.size() +"'>"+sdp+"<br>"+name+"</td>");
				              }
				               if(s==0){
				              		out.println( "<td align='center' width='7%' rowspan='"+sSize +"'>"+sname+"</td>");
				              }
				              if(l==0){
					              out.println(
					              "<td align='center'width='10%' rowspan='"+m+"'>"+dfc.get(j).getFirstCName()+"</td>");
			                      l++;
			                   }
			                   out.println(
			                       "<td align='center' width='10%'>"+dsc.get(k).getSecondCName()+"</td>");
			                for(int i=0; i<12;i++){
		                          out.println(	           
					              "<td align='center' >&nbsp;"+inStoreCount[p][i]+"</td>");
		                           ccount=ccount + inStoreCount[p][i];   
		                     }    
		                          s++;
		                  		  p++; 
		                  		 
		                           out.println(	           
					              "<td align='center' style='color:red'>&nbsp;"+ccount+"</td>");    
					              ccount=0;
					   }         
					              out.println("</tr>");     

                    } 
                    if(s==sSize){
		                  		     s=0;
		                  		  }   
			  }
           %>
         
       </table>
          <table>
         <tr><td>&nbsp;</td></tr>
          <tr><td>&nbsp;</td></tr>
       </table>
         
</body>
</html>