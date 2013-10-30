<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %>  
<%@page import="java.util.*" %>
<%@page import="com.yz.manager.expense.bean.*" %>  
<%@page import="java.text.DecimalFormat"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.yz.manager.expense.bean.*" %>  
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>

<%
   user user=(user)session.getAttribute("us");
   if(user==null) response.sendRedirect("../index.jsp"); 
  
    List<user> us=new ArrayList<user>();
    us=daoUtil.selectUser();
    
   String systemName="3";
 
    List<department> department=new ArrayList<department>();
	department=daoUtil.selectDepartmentId();	
	
	List<gCompany> g=new ArrayList<gCompany>();	
	g=daoUtil.selectGCompany();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月度费用汇总</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
			var onecount;
			onecount=0;
			subcat=new  Array();  
			<%
			int count=0;
			for(user user1: us){
			 %>
			 subcat[<%=count%>]=new Array("<%= user1.getUserName()%>","<%=user1.getName()%>","<%=user1.getDepartment()%>");
			 <%
			 count = count + 1 ; 	
			}
			%>
			onecount=<%=count%>;
			function changelocation(locationid){
			document.myform.userName.length=0;
			var locationid=locationid;
			var i;
			document.myform.userName.options[0]=new Option('','0'); 
			for(i=0;i<onecount;i++){
			if (subcat[i][2] == locationid) 
			{ 
			document.myform.userName.options[document.myform.userName.length] = new Option(subcat[i][1], subcat[i][0]); 
			} 
			} 		   
			}
			</script>	
</head>
<body bgcolor="#E4FAF9">
 <%  
      double expenseCount [][]={};
      String sdp="";
       String cmName=(String)request.getAttribute("cmName"); 
      List<firstClass> dfc=new ArrayList<firstClass>();
     
       List<secondClass> dsc=new ArrayList<secondClass>();
     
    if(request.getAttribute("count1")!=null){
        expenseCount = (double[][])request.getAttribute("count1");
        sdp=daoUtil.selectDepartment3(Integer.valueOf(user.getDepartment()).intValue());
        dfc=daoUtil.selectFirstClass3(user.getDepartment(),systemName);
        dsc=daoUtil.selectSecondClass6(user.getDepartment(),systemName);   
   }else if(request.getAttribute("count2")!=null){
        expenseCount = (double[][])request.getAttribute("count2");
        sdp=daoUtil.selectDepartment3(Integer.valueOf((String)request.getAttribute("dp")).intValue());
        dfc=daoUtil.selectFirstClass3((String)request.getAttribute("dp"),systemName);
        dsc=daoUtil.selectSecondClass6((String)request.getAttribute("dp"),systemName);
   }
  %>   
    <s:form name="myform" action="classExpenseCountByOption" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>
          <td  align="center"> 部门：</td>
             <td > 
             <select  name="department" style="width:80px;" onChange="changelocation(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
              <option selected value="0"></option> 
            <% 
		
		   for(department d :department){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
            <td > &nbsp;&nbsp;经办人:</td>
             <td  >
                  <select name="userName"  style="width:80px;" size="1"> 
           <option selected value="0"></option>  
            </select>           
             </td>
            <td>&nbsp;统计年份:</td>
           <td>
           	  <select  name="year" style="width:80px;" > 
              <option value="2012">2012</option>  
              <option value="2013" selected>2013</option>  
              <option value="2014" >2014</option>  
              <option value="2015">2015</option>  
            </select>
           </td>
            <td align="center">
						&nbsp;&nbsp;费用性质：
		   </td>
		   <td align="center">
						<input type="radio" name="nature" value="报销" checked="checked" />
						报销&nbsp;
						<input type="radio" name="nature" value="借款" />
						借款
					</td>
		 <td align="center">
						&nbsp;&nbsp;挂账公司：
					</td>
					<td align="center">
					 <select  name="gCompany" style="width:80px;"> 
              <option selected value="0"></option> 
            <% 
		
		   for(gCompany d :  g){
		    %> 
		  <option value="<%= d.getId()%>"><%=d.getCompanyName()%></option> 
		
		 <% }
        %> 
            </select>				
					</td>
              <td> &nbsp;<s:submit style="font-size:14px" name="submit" value="查 找"></s:submit>  </td>                     
         </tr>
       <tr><td>&nbsp;</td></tr>
        </table>
      </s:form>
     
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height='25' class="tableth" bgcolor="#8E8EFF" >
          <th align="center">部门</th><th align="center">一级分类</th><th align="center">二级分类</th><th align="center">1月</th><th align="center">2月</th><th align="center">3月</th><th align="center">4月</th><th align="center">5月</th><th align="center">6月</th><th align="center">7月</th><th align="center">8月</th><th align="center">9月</th><th align="center">10月</th><th align="center">11月</th><th align="center">12月</th><th align="center">合计</th>
          </tr>
          <%    
                
                int p=0; 
                 double rcount[]=new double[12];
                 double ccount=0;
                 double totalCount=0;
                 double classCount=0;
                 DecimalFormat dr=new DecimalFormat();
                 dr.setMaximumFractionDigits(2);
               if(dfc.size()==0){
                         out.println("<tr  height='25'><td align='center'width='10%'>&nbsp;"+sdp+"<br>("+cmName+")</td>");
						 out.println("<td align='center'width='10%' colspan='2'>&nbsp;</td>");       
					                for(int i=0; i<12;i++){
				                          out.println("<td align='center'>&nbsp;</td>");
				                     }  
				        out.println("<td align='center'>&nbsp;</td></tr>");               
               }else{
		                for(int j=0;j<dfc.size();j++){  
		                   int m=daoUtil.selectSecondClassSize(String.valueOf(dfc.get(j).getId()));            
		                    int l=0;
		                   for(int k=0;k<dsc.size();k++){           
					          if(dsc.get(k).getFirstCName().equals(String.valueOf(dfc.get(j).getId()))){
					             out.println(
						              "<tr  height='25'>");
						              if(k==0){
						              		out.println( "<td align='center' width='7%' rowspan='"+dsc.size()+dfc.size()+1 +"'>"+sdp+"<br>("+cmName+")</td>");
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
							              "<td align='center'>&nbsp;"+dr.format(expenseCount[p][i])+"</td>");
							               rcount[i]=rcount[i]+expenseCount[p][i];
				                           ccount=ccount + expenseCount[p][i];   
				                     }
				                         classCount=classCount+ccount;  
				                         p++; 
				                           out.println(	           
							              "<td align='center'>&nbsp;"+dr.format(ccount)+"</td>");    
							              ccount=0;
							   }
							              out.println("</tr>");     
		
		                    } 
		                     out.println(	           
							 "<tr height='25'><td align='center' colspan='2'>&nbsp小计</td>");
							
				                          out.println(	 
				                          "<td align='center' colspan='12'>&nbsp</td>"+          
							              "<td align='center' style='color:red'>&nbsp;"+dr.format(classCount)+"</td>");
					                     classCount=0;
					  }
					   out.println(	           
							 "<tr height='25'><td align='center' colspan='2'>&nbsp;总计</td>");
							  for(int i=0; i<12;i++){
				                          out.println(	           
							              "<td align='center'>&nbsp;"+dr.format(rcount[i])+"</td>");
							              totalCount=totalCount+rcount[i];
				              }   
				               out.println(	           
			  		              "<td align='center' style='color:red'>&nbsp;"+dr.format(totalCount)+"</td></tr>");	      
		           }
		   %>
		         
       </table>
         <table>
         <tr><td>&nbsp;</td></tr>
          <tr><td>&nbsp;</td></tr>
       </table>
         
</body>
</html>