<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.archives.bean.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>

<%
   user user=(user)session.getAttribute("us");
   if(user==null) response.sendRedirect("../index.jsp"); 
   
   List<firstClass> fc=new ArrayList<firstClass>(); 
   String systemName="1";
   fc=daoUtil.selectFirstClassId(systemName);
    
    List<secondClass> sc=new ArrayList<secondClass>();
    sc=daoUtil.selectAllSecondClass(systemName);
    
    List<user> us=new ArrayList<user>();
    us=daoUtil.selectUser();
    
     List<user> us2=new ArrayList<user>();
     us2=daoUtil.selectDoubleUserId();	
    
    List<department> department=new ArrayList<department>();
	 department=daoUtil.selectDepartmentId();	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>档案查询</title>
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
			document.myform.secondCName.length=0;
			document.myform.secondCName.options[0]=new Option('','0'); 
			
			document.myform.giveArName.length=0;
			var locationid=locationid;
			var i;
			document.myform.giveArName.options[0]=new Option('','0'); 
			for(i=0;i<onecount;i++){
			if (subcat[i][2] == locationid) 
			{ 
			document.myform.giveArName.options[document.myform.giveArName.length] = new Option(subcat[i][1], subcat[i][0]); 
			} 
			} 		   
			
			var onecount1;
			onecount1=0;
			subcat1=new  Array();  
			<%
			int count1=0;
			for(firstClass sf: fc){
			 %>
			 subcat1[<%=count1%>]=new Array("<%= sf.getId()%>","<%=sf.getFirstCName()%>","<%=sf.getDepartment()%>");
			 <%
			 count1 = count1 + 1 ; 	
			}
			%>
			onecount1=<%=count1%>;
			document.myform.firstCName.length=0;
			var i1;
			document.myform.firstCName.options[0]=new Option('','0'); 
			for(i1=0;i1<onecount1;i1++){
			if (subcat1[i1][2] == locationid) 
			{ 
			document.myform.firstCName.options[document.myform.firstCName.length] = new Option(subcat1[i1][1], subcat1[i1][0]); 
			} 			   
			}		
			}
			</script>
			
			<script language="javascript">
			var onecount2;
			onecount2=0;
			subcat2=new  Array();  
			<%
			int count2=0;
			for(secondClass sc1: sc){
			 %>
			 subcat2[<%=count2%>]=new Array("<%= sc1.getId()%>","<%=sc1.getSecondCName()%>","<%=sc1.getFirstCName()%>");
			 <%
			 count2 = count2 + 1 ; 	
			}
			%>
			onecount2=<%=count2%>;
			function changelocation1(locationid){
			document.myform.secondCName.length=0;
			var locationid2=locationid;
			var i2;
			document.myform.secondCName.options[0]=new Option('','0'); 
			for(i2=0;i2<onecount2;i2++){
			if (subcat2[i2][2] == locationid2) 
			{ 
			document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat2[i2][1], subcat2[i2][0]); 
			} 
			} 		   
			}
			</script>
			
			<script language="javascript">
			var onecount3;
			onecount3=0;
			subcat3=new  Array();  
			<%
			int count3=0;
			for(user user3: us2){
			 %>
			 subcat3[<%=count3%>]=new Array("<%= user3.getUserName()%>","<%=user3.getName()%>","<%=user3.getDepartment()%>");
			 <%
			 count3 = count3 + 1 ; 	
			}
			%>
			onecount3=<%=count3%>;
			function changelocation3(locationid){
			document.myform.saveArName.length=0;
			var locationid3=locationid;
			var i3;
			document.myform.saveArName.options[0]=new Option('','0'); 
			for(i3=0;i3<onecount3;i3++){
			if (subcat3[i3][2] == locationid3) 
			{ 
			document.myform.saveArName.options[document.myform.saveArName.length] = new Option(subcat3[i3][1], subcat3[i3][0]); 
			} 
			} 		   
			}
			</script>

</head>
<body bgcolor="#E4FAF9">
 <%  
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();
     List<archives> ar=new ArrayList<archives>();
    
     pg=new PageSet(archivesDao.selectArchivesSize(user.getDepartment()),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
    
     ar=archivesDao.selectArchives(user.getDepartment(),currentPage,pg.getPagesize());
  
  %>   
    <s:form name="myform" action="selectArchivesByOption?currentPage=1" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>
          <td  align="center"> 交档部门：</td>
             <td > 
             <select  name="giveDepartment" style="width:100px;" style="width:100px;" onChange="changelocation(document.myform.giveDepartment.options[document.myform.giveDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0"></option> 
            <% 
		
		   for(department d :department){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
            <td > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交档人:</td>
             <td  >
                  <select name="giveArName"  style="width:100px;" size="1"> 
           <option selected value="0"></option> 
         <% 
		   for(user su :us){
		    %> 
		  <option value="<%= su.getUserName()%>"><%=su.getName()%></option> 
		
		 <% }
        %> 
            </select>          
            
             </td>
        
              <td > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统分类：</td> 
              <td>
                <select name="firstCName" style="width:100px;" onChange="changelocation1(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)" size="1"> 
              <option selected value="0"></option>     
            </select>
            <select name="secondCName" style="width:100px;"  size="1"> 
              <option selected value="0"></option> 
                 </select>              
          </td> 
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
        <td > 存档部门：</td>
             <td > 
             <select  name="saveDepartment"  style="width:100px;" onChange="changelocation3(document.myform.saveDepartment.options[document.myform.saveDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0"></option> 
            <% 
		
		   for(department d :department){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
         <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存档人:</td>
         <td >
            <select name="saveArName" style="width:100px;" size="1"> 
              <option selected value="0"></option>   
                <% 
		   for(user su2 :us2){
		    %> 
		  <option value="<%= su2.getUserName()%>"><%=su2.getName()%></option> 
		
		 <% }
        %>   
            </select>   
          
         </td>
        <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存档日期:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:100px;" name="saveArDateBegin" displayFormat="yyyy-MM-dd"  />                       
                到<struts:datetimepicker cssStyle="width:100px;" name="saveArDateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td>
           </tr>
            <tr><td>&nbsp;</td></tr>
           <tr>
           <td>文件名称:</td>
          <td> <s:textfield name="fileName" size="20"></s:textfield></td>
          
          <td>
          </td>
              <td> &nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" value="查 找"></s:submit>  </td>   
           
              <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="left-font01" href="archiveExportAction.action">档案导出</a></td>                                       
         </tr>
       <tr><td>&nbsp;</td></tr>
        </table>
      </s:form>
     
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="23" class="tableth" bgcolor="#8E8EFF" >
          <th>序号</th><th>存档日期</th><th>文件名称</th><th>文件电子版</th><th>档案编号</th><th>交档部门</th><th>交档人</th><th>存档部门</th><th>存档人</th><th>详情</th><th>删除</th><th>修改</th>
          </tr>
          <%
           int i=1;
            for(archives a : ar){
              String dp=daoUtil.selectDepartment3(Integer.valueOf(a.getDepartment()).intValue());
              String sdp=daoUtil.selectDepartment3(Integer.valueOf(a.getSaveArDepartment()).intValue());
              String sname=daoUtil.selectUser(a.getSaveArName().trim());
            out.println(
              "<tr height='23'>"+
              "<td align='center'>"+ i++ +"</td>"+
              "<td align='center'>"+CurrentDate.parseDate1(a.getSaveArDate().toString())+"</td>"+
              "<td align='center'>"+a.getFileName()+"</td>");
              if(a.getFileDir()==null){
                 out.println(
               "<td align='center'>无电子文档</td>");
              }else{
                 out.println(
               "<td align='center'><a class='left-font01' href='"+ a.getFileDir()+"' >下载</a></td>");
              }           
                out.println(         
              "<td align='center'>"+a.getFileNumber()+"</td>" + 
               "<td align='center'>"+dp+"</td>" +    
              "<td align='center'>"+a.getGiveArName()+"</td>" +   
               "<td align='center'>"+sdp+"</td>" +               
              "<td align='center'>"+sname+"</td>" +   
              "<td align='center'><a class='left-font01' href='detailArchives.jsp?aId="+a.getId()+"' >>></a></td>"+
              "<td align='center'><a class='left-font01' href='deleteArchivesAction.action?aId="+a.getId()+"' >>></a></td>"+
               "<td align='center'><a class='left-font01' href='modifyArchives.jsp?aId="+a.getId()+"' >>></a></td>"+             
              "</tr>");
              }                       
           %>
         
       </table>
         <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="selectArchives.jsp?currentPage=1">首页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectArchives.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectArchives.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectArchives.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='selectArchives.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='selectArchives.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
     
</body>
</html>