<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.yz.manager.storehouse.bean.*" %> 
<%@page import="com.yz.manager.bean.department" %>  
  <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
      List<shouse> sh=new ArrayList<shouse>();
	  sh=daoUtil.selectShouse();	
	  List<department> department=new ArrayList<department>();
	  department=daoUtil.selectDepartmentId();	
     String dp=(String)session.getAttribute("dp");
     String sys=(String)session.getAttribute("sn");
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();    
     List<secondClass> sc=new ArrayList<secondClass>();
     if(request.getAttribute("ssc")!=null){
     sc=(List<secondClass>)request.getAttribute("ssc");
     int total=Integer.valueOf(request.getAttribute("totalCount").toString().trim()).intValue();
     pg=new PageSet(total,10);  
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage(); System.out.println("dfs="+totalsize);
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     }else{   
        currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
        int total=daoUtil.selectHouseSecondClass61(dp,sys);;
        pg=new PageSet(total,10);  
        totalsize=pg.getTotalsize();
        totalPage=pg.getTotalpage();
        sc=daoUtil.selectHouseSecondClass6(dp,sys,currentPage,pg.getPagesize());
     }
  %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类管理</title>
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
			document.myform.shouseName.length=0;
			document.myform.shouseName.options[0]=new Option('选择库房','-1'); 
			var i1; 
			for(i1=0;i1<onecount1;i1++){
			if (subcat1[i1][2] == locationid) 
			{ 
			document.myform.shouseName.options[document.myform.shouseName.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
			} 			   
			}		
			}
     </script>
</head>
<body bgcolor="#E4FAF9"> 
      
    <s:form name="myform" action="selectHouseSecondClassAction?currentPage=1" method="post" theme="simple">
      <table class="left-font01" width="60%" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>
          <td  align="center"> 库房部门：</td>
             <td > 
             <select  name="department" style="width:100px;" onChange="changelocation2(document.myform.department.options[document.myform.department.selectedIndex].value)" size="1"> 
              <option selected value="-1">选择部门</option> 
            <% 
		
		   for(department d :department){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
            </td>
            <td > 库房名称：</td>
             <td > 
             <select  name="shouseName" style="width:100px;"  > 
                 <option selected value="-1">选择库房</option> 
            </select>
            </td>
          
              <td> &nbsp;<s:submit name="submit" value="查 找"></s:submit>  </td>             
         </tr>
         <tr height="15"><td>&nbsp;</td></tr>
        </table>
      </s:form>
     
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
         <th>部门</th><th>库房</th><th>物品分类</th><th>物品名称</th><th>单价</th><th>单位</th><th>删除</th><th>修改</th>
          </tr>
          <%
            for(secondClass f : sc){
            String sdp=daoUtil.selectDepartment3(Integer.valueOf(f.getDepartment()).intValue());
            String s=daoUtil.selectShouseName(Integer.valueOf(f.getHouseId()).intValue());
            String fcn=daoUtil.selectFirstClass5(Integer.valueOf(f.getFirstCName()).intValue());
            out.println(
              "<tr height='25'>"+
              "<td align='center'>"+sdp+"</td>"+
              "<td align='center'>"+s+"</td>"+
              "<td align='center'>"+fcn+"</td>" +  
              "<td align='center'>"+f.getSecondCName()+"</td>" +  
               "<td align='center'>"+f.getUnitPrice()+"</td>" +  
                "<td align='center'>"+f.getUnit()+"</td>" +  
              "<td align='center'><a class='left-font01' href='deleteHouseSecondAction.action?sId="+f.getId()+"' >删除</a</td>"+
               "<td align='center'><a class='left-font01' href='modifyHouseSecondClass2.jsp?sId="+f.getId()+"' >修改</a</td>"+            
              "</tr>");
              }                       
           %>
         
       </table>
       <table class="tablelink" width="60%" align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="managerHouseSClassByOption.jsp?currentPage=1">首页</a></td>
             <td><a class="tablelink" href="managerHouseSClassByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a></td>
             <td><a class="tablelink" href="managerHouseSClassByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a></td>
             <td><a class="tablelink" href="managerHouseSClassByOption.jsp?currentPage=<%=totalPage %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='managerHouseSClassByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='managerHouseSClassByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
   
     
</body>
</html>