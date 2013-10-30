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
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�¶���������</title>
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
			document.myform.houseId.options[0]=new Option('ѡ��ⷿ','0'); 
			var i1; 
			for(i1=0;i1<onecount1;i1++){
			if (subcat1[i1][2] == locationid) 
			{ 
			document.myform.houseId.options[document.myform.houseId.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
			} 			   
			}	
			
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
			document.myform.userName.length=0;
			
			var i7;
			document.myform.userName.options[0]=new Option('ѡ��������','0'); 
			for(i7=0;i7<onecount7;i7++){
			if (subcat7[i7][2] == locationid) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat7[i7][1], subcat7[i7][0]); 
			} 
			} 
			
			document.myform.firstCName.length=0;
			document.myform.firstCName.options[0]=new Option('ѡ����Ʒ����','0'); 	
			
			document.myform.secondCName.length=0;
			document.myform.secondCName.options[0]=new Option('ѡ����Ʒ','0'); 
			}
     </script>
      <script language="javascript">
			var onecount22;
			onecount22=0;
			subcat22=new  Array();  
			<%
			int count22=0;
			for(shouse sf: sh){
			 %>
			 subcat22[<%=count22%>]=new Array("<%= sf.getId()%>","<%=sf.getHouseName()%>","<%=sf.getDepartment()%>");
			 <%
			 count22 = count22 + 1 ; 	
			}
			%>
			onecount22=<%=count22%>;
			function changelocation3(locationid){
			document.myform.houseId.length=0;
			document.myform.houseId.options[0]=new Option('ѡ��ⷿ','0'); 
			var i22; 
			for(i22=0;i22<onecount22;i22++){
			if (subcat22[i22][2] == locationid) 
			{ 
			document.myform.houseId.options[document.myform.houseId.length] = new Option(subcat22[i22][1], subcat1[i22][0]); 
			} 			   
			}	
			document.myform.firstCName.length=0;
			document.myform.firstCName.options[0]=new Option('ѡ����Ʒ����','0'); 	
			
			document.myform.secondCName.length=0;
			document.myform.secondCName.options[0]=new Option('ѡ����Ʒ','0'); 
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
		document.myform.firstCName.options[0]=new Option('ѡ����Ʒ����','0'); 
		for(i4=0;i4<onecount4;i4++){
		if (subcat4[i4][2] == locationid) 
		{ 
		document.myform.firstCName.options[document.myform.firstCName.length] = new Option(subcat4[i4][1], subcat4[i4][0]); 
		} 
		} 

			document.myform.secondCName.length=0;
			document.myform.secondCName.options[0]=new Option('ѡ����Ʒ','0'); 	   
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
		document.myform.secondCName.options[0]=new Option('ѡ����Ʒ','0'); 
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
  
     int inStoreCount []=(int[])request.getAttribute("sum");
  
     String sdp=daoUtil.selectDepartment3(Integer.valueOf((String)request.getAttribute("dp")).intValue());

      String fcm=(String)request.getAttribute("fcm");
       String scm=(String)request.getAttribute("scm");
      firstClass dfc=new firstClass();
      dfc=daoUtil.selectFirstClass4(Integer.valueOf(fcm).intValue());
       String name="";
       if(!"".equals((String)request.getAttribute("name"))) name=daoUtil.selectUser((String)request.getAttribute("name"));
      String adpname=daoUtil.selectDepartment3(Integer.valueOf(user.getDepartment()).intValue());
       if(!"".equals((String)request.getAttribute("adp"))) adpname=daoUtil.selectDepartment3(Integer.valueOf((String)request.getAttribute("adp")).intValue());
      secondClass dsc=new secondClass();
      dsc=daoUtil.selectSecondClass3(Integer.valueOf(scm).intValue());

  %>   
    <s:form name="myform" action="outStoreSumByOption" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
     
      <tr>
          <td  align="center"> ���ò��ţ�</td>
             <td > 
             <select  name="applyDepartment"  style="width:200px;" onChange="changelocation2(document.myform.applyDepartment.options[document.myform.applyDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0">ѡ�����ò���</option> 
            <% 
		
		   for(department d1 :department){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
   
         <td  align="center">
          &nbsp;&nbsp;&nbsp; �����ˣ�</td>
            <td >
                  <select name="userName"  style="width:200px;" size="1"> 
           <option selected value="0">ѡ��������</option> 
            </select>          
            
           </td>
         </tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
	 <tr>
	        <td  align="center"> �ⷿ���ţ�</td>
             <td > 
             <select  name="department"  style="width:200px;" onChange="changelocation3(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
              <option selected value="0">ѡ��ⷿ����</option> 
            <% 
		
		   for(department d1 :department1){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
        
            <td align="center"> &nbsp;&nbsp;&nbsp;�ⷿ���ƣ�</td>
             <td > 
             <select  name="houseId" style="width:200px;" onChange="changelocation4(document.myform.houseId.options[document.myform.houseId.selectedIndex].value)" size="1" > 
                 <option selected value="0">ѡ��ⷿ</option> 
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
						  ��Ʒ���ࣺ
					</td>
					<td>
						<select style="width: 200px;" name="firstCName"
							onChange="changelocation(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)"
							size="1">
							<option selected value="0">
								ѡ����Ʒ����
							</option>
						</select>
					</td>
		  
					<td align="center">
						&nbsp;&nbsp;&nbsp;��Ʒ���ƣ�
					</td>
					<td>
						<select style="width: 200px;" name="secondCName" onChange="changelocation5(document.myform.secondCName.options[document.myform.secondCName.selectedIndex].value)" size="1">
							<option selected value="0">
								ѡ����Ʒ
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
		  <td  align="center"> ͳ����ݣ�</td>
           <td>
           	  <select  name="year" style="width:200px;" > 
              <option value="2012">2012</option>  
              <option value="2013" selected>2013</option>  
              <option value="2014" >2014</option>  
              <option value="2015">2015</option>  
            </select>
           </td>   	
            <td align="center">
						&nbsp;&nbsp;&nbsp;ͳ�����ݣ�
		   </td>
		   <td align="center">
						<input type="radio" name="content" value="1" checked="checked" />
						����&nbsp;
						<input type="radio" name="content" value="0" />
						����
					</td>
		
              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" value="�� ��"></s:submit>  </td>                     
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
           <th align="center">���ò���</th> <th align="center">�ⷿ����</th><th align="center">�ⷿ</th><th align="center">��Ʒ����</th><th align="center">��Ʒ����</th><th align="center">1��</th><th align="center">2��</th><th align="center">3��</th><th align="center">4��</th><th align="center">5��</th><th align="center">6��</th><th align="center">7��</th><th align="center">8��</th><th align="center">9��</th><th align="center">10��</th><th align="center">11��</th><th align="center">12��</th><th align="center">���������ϼ�</th>
          </tr>
          <%     
               
                 int ccount=0;
                 String sname="�������޿ⷿ";
 
                    sname=daoUtil.selectShouseName(Integer.valueOf(dfc.getHouseId()).intValue());

			             out.println(
				              "<tr  height='25'>");
				             
				        out.println( "<td align='center' width='7%' rowspan='"+2 +"'>"+adpname+"<br>"+name+"</td>");
				              		out.println( "<td align='center' width='7%' rowspan='"+2 +"'>"+sdp+"<br></td>");

				         out.println( "<td align='center' width='7%'>"+sname+"</td>");
				           
					     out.println(
					              "<td align='center'width='10%'>"+dfc.getFirstCName()+"</td>");
			                 
			             out.println(
			                       "<td align='center' width='10%'>"+dsc.getSecondCName()+"</td>");
			                for(int i=0; i<12;i++){
		                          out.println(	           
					              "<td align='center' >&nbsp;"+inStoreCount[i]+"</td>");
		                           ccount=ccount + inStoreCount[i];   
		                     }    
		                           out.println(	           
					              "<td align='center' style='color:red'>&nbsp;"+ccount+"</td>");    
					              ccount=0;
					            out.println("</tr>");     
     
           %>
         
       </table>
          <table>
         <tr><td>&nbsp;</td></tr>
          <tr><td>&nbsp;</td></tr>
       </table>
         
</body>
</html>