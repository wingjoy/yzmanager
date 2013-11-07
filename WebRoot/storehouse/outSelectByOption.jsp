<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@page import="java.text.DecimalFormat"%> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>
<%
String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 request.setAttribute("basepath", basepath);
user user=(user)session.getAttribute("us");
      if(user==null) response.sendRedirect("../index.jsp"); 

      List<shouse> sh1=new ArrayList<shouse>();
      List<department> dp=new ArrayList<department>();
	  dp=daoUtil.selectDepartmentId();	
	  sh1=daoUtil.selectShouse();	
        List<department> dp6=new ArrayList<department>();
	  dp6=daoUtil.selectHaveHouseDepartmentId();	
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
<link href="<%=basepath %>/css/css.css" rel="stylesheet" type="text/css" />
 <link href="<%=basepath %>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
 <script type="text/javascript" src="<%=basepath %>/js/jquery.js"></script>
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<script language="javascript">
			function changelocation6(locationid){
			var onecount6;
			onecount6=0;
			subcat6=new  Array();  
			<%
			int count6=0;
			for(user u6: allUser){
			 %>
			 subcat6[<%=count6%>]=new Array("<%= u6.getUserName()%>","<%=u6.getName()%>","<%=u6.getDepartment()%>");
			 <%
			 count6 = count6 + 1 ; 	
			}
			%>
			onecount6=<%=count6%>;	
			document.myform.userName.length=0;
		    document.myform.userName.options[0]=new Option('ѡ��������','0'); 	
			var i6; 
			for(i6=0;i6<onecount6;i6++){
			if (subcat6[i6][2] == locationid) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat6[i6][1], subcat6[i6][0]); 
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
			document.myform.houseId.options[0]=new Option('ѡ��ⷿ','0'); 
			var i1; 
			for(i1=0;i1<onecount1;i1++){
			if (subcat1[i1][2] == locationid) 
			{ 
			document.myform.houseId.options[document.myform.houseId.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
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
		$(function(){
			$(".export").click(function(){
				$("[name='export']").val(1);
				$("#submit").trigger("click");
			});
		});
		</script>

</head>
<body bgcolor="#E4FAF9">
 <%
        String adp=(String)session.getAttribute("adp");
        String dp1=(String)session.getAttribute("dp1");
		String sh2=(String)session.getAttribute("sh1");
        String fc1=(String)session.getAttribute("fc1");
		String sc1=(String)session.getAttribute("sc1");
		String sdb1=(String)session.getAttribute("sdb");      
		String sde1=(String)session.getAttribute("sde");
		String vnm=(String)session.getAttribute("vnm");
		int totalsize=0;
        int totalPage=1;
        int currentPage=1;
        String outVerify="4";
        request.setAttribute("outVerify","4");
        PageSet pg=new PageSet();  
    
        List<outStoreHouse> sh=new ArrayList<outStoreHouse>();
        if(request.getAttribute("ep")!=null){
	     sh=(List<outStoreHouse>)request.getAttribute("ep");
	     int total=Integer.valueOf(request.getAttribute("totalCount").toString().trim()).intValue();
	     pg=new PageSet(total,15);  
	     totalsize=pg.getTotalsize();
	     totalPage=pg.getTotalpage();
	     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	     }else{   
	        currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	        int total=storeHouseDao.selectOutStoreByOptionInt(adp,vnm,dp1,sh2,fc1,sc1,sdb1,sde1,Integer.valueOf(outVerify).intValue());
	        pg=new PageSet(total,15);  
	        totalsize=pg.getTotalsize();
	        totalPage=pg.getTotalpage();
	        sh=storeHouseDao.selectOutStoreByOption(adp,vnm,dp1,sh2,fc1,sc1,sdb1,sde1,Integer.valueOf(outVerify).intValue(),currentPage,pg.getPagesize());
         }
  %>   
   <s:form name="myform" action="%{#request.basepath}storehouse/outSelectByOption?currentPage=1" method="post" theme="simple" >
      <table  class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
        <tr><td><s:hidden name="outVerify" value="%{#request.outVerify}"/>
        <s:hidden name="export" value="0"/>
        </td></tr>
       
       <tr>
		<td  align="center"> ���ò��ţ�</td>
             <td > 
             <select  name="applyDepartment"  style="width:200px;" onChange="changelocation6(document.myform.applyDepartment.options[document.myform.applyDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0">ѡ����</option> 
            <% 
		
		   for(department d1 :dp){
		    %> 
		  <option value="<%= d1.getDepartmentId()%>"><%=d1.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
            <td align="center" > &nbsp;&nbsp;������:</td>
             <td  >
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
          <td align="center"> ��Ʒ���ţ�</td>
             <td >
		                 <select  name="department" style="width:200px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
		              <option selected value="0">ѡ����</option> 
		            <% 
				
					   for(department d :dp6){
					    %> 
					  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
				  
				   <% }
		           %> 
		            </select>
            </td>
            <td align="center"> &nbsp;&nbsp;��Ʒ�ⷿ��</td>
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
						����:
					</td>
					<td>
						<select style="width: 200px;" name="firstCName"
							onChange="changelocation(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)"
							size="1">
							<option selected value="0">
								ѡ�����
							</option>
						</select>
					</td>
					<td align="center">
						&nbsp;&nbsp;��Ʒ���ƣ�
					</td>
					<td>
						<select style="width: 200px;" name="secondCName" size="1">
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
         <td align="center">����:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:100px;" name="addDateBegin" displayFormat="yyyy-MM-dd"  />                       
                ��<struts:datetimepicker cssStyle="width:100px;" name="addDateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td> 
            <td> &nbsp;&nbsp;&nbsp;<s:submit id="submit" cssClass="btn btn-primary" style="font-size:14px" name="submit" value="��  ��"></s:submit> </td><td>
             &nbsp;<a class="left-font01 export btn btn-primary" href="javascript:void(0)">���⵼��</a></td>                                                          
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
                int totalCount=0;  
                DecimalFormat dr=new DecimalFormat();
                dr.setMaximumFractionDigits(2);
		        out.println(
		             "<tr height='23'>"+
		              "<th>���</th><th>��������</th><th>���ò���</th><th>������</th><th>���ÿⷿ</th><th>��Ʒ����</th><th>��Ʒ����</th><th>��������</th><th>��λ</th><th>���������</th><th>�ⷿ�����</th><th>���Ա</th><th>����</th><th>ɾ��</th>"+
		             "</tr>"
		            );
		            int k=1;;
		            for(outStoreHouse e : sh){
                       String shn=daoUtil.selectShouseName(Integer.valueOf(e.getHouseId()).intValue());
                       String fn=daoUtil.selectFirstClass5(Integer.valueOf(e.getFirstCName()).intValue());
                       String sn=daoUtil.selectSecondClass8(e.getSecondCName());
                       String adp1=daoUtil.selectDepartment3(Integer.valueOf(e.getApplyDepartment()).intValue());
		             out.println(
		              "<tr height='23'>"+
		              "<td align='center'>"+ k++ +"</td>"+
		               "<td align='center'>&nbsp;"+CurrentDate.parseDate1(e.getOutDate().toString())+"</td>"+
		                "<td align='center'>&nbsp;"+adp1+"</td>" + 
		               "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getUserName())+"</td>"+
		              "<td align='center'>&nbsp;"+shn+"</td>" + 
		               "<td align='center'>&nbsp;"+fn+"</td>" + 
		               "<td align='center'>&nbsp;"+sn+"</td>" + 
		                "<td align='center'>&nbsp;"+e.getApplyCount()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getUnit()+"</td>" + 
		              "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getInVerifyName())+"</td>"+
		              "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getHouseVerifyName())+"</td>"+
		              "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getHouseManager())+"</td>");
		               out.println("<td align='center'><a class='left-font01' href='"+basepath+"storehouse/detailOutStore.jsp?aId="+e.getId()+"' >>></a></td>");
		               out.println(
		                "<td align='center'><a class='left-font01' href='"+basepath+"storehouse/deleteOutStoreAction.action?aId="+e.getId()+"'>>></a></td>");
		               out.println( "</tr>");
		                 totalCount=totalCount+e.getApplyCount();
		         } 
		         if(sc1!=null&&!sc1.equals("0")&sh.size()!=0){
		                String scname=daoUtil.selectSecondClass8(sh.get(0).getSecondCName());
		                 out.println( "<tr height='23'>");    
		                 out.println(
		                 "<td align='center'>"+k+"</td>");
		                  out.println(
		                 "<td align='center' colspan='6'><span style='color:red'>"+scname+"</span>&nbsp;������<span style='color:red'>"+totalsize+"</span>�Σ���<span style='color:red'>"+currentPage+"</span>ҳ�ϼ���������</td>");
		                  out.println(
		                 "<td align='center' style='color:red'>&nbsp;"+totalCount+"</td>");
		                  out.println(
		                 "<td align='center'>&nbsp;"+sh.get(0).getUnit()+"</td>");
		                  out.println(
		                 "<td align='center' colspan='6'>&nbsp;</td>");
		                 out.println( "</tr>");    
		               }
		         %>
         
       </table>
        <table class="tablelink">
           <tr align="right">
             <td>��<%= totalsize%>����¼&nbsp;|</td>
             <td>��<%= totalPage%>ҳ&nbsp;|</td>
             <td>��ǰ��<%= currentPage%>ҳ&nbsp;|</td>
             <td><a class="tablelink" href="<%=basepath %>storehouse/outSelectByOption.jsp?currentPage=1">��ҳ</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="<%=basepath %>storehouse/outSelectByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">��һҳ</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="<%=basepath %>storehouse/outSelectByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">��һҳ</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="<%=basepath %>storehouse/outSelectByOption.jsp?currentPage=<%=totalPage %>">βҳ</a>&nbsp;&nbsp;</td>
             <td>��ת����<select name="selectPage" onchange="document.location.href=this.value">         
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                 if(j==currentPage){
                   out.println(
                  "<option selected value='outSelectByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                 }else{
                 out.println(
                  "<option value='outSelectByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
              }
              }   
              %>           
             </select>ҳ</td>
           </tr>
         
         </table>
   
   
     
</body>
</html>