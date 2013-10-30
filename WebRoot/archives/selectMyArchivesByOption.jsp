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
   fc=daoUtil.selectFirstClassId(user.getDepartment(),systemName);
    
    List<secondClass> sc=new ArrayList<secondClass>();
     sc=daoUtil.selectAllSecondClass2(user.getDepartment(),systemName);
  
    List<user> us=new ArrayList<user>();
    us=daoUtil.selectUser();
    List<department> department=new ArrayList<department>();
	 department=daoUtil.selectDepartmentId();	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>档案查询</title>

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
			for(user user3: us){
			 %>
			 subcat3[<%=count3%>]=new Array("<%= user3.getUserName()%>","<%=user3.getName()%>","<%=user3.getDepartment()%>");
			 <%
			 count3 = count3 + 1 ; 	
			}
			%>
			onecount3=<%=count3%>;
			function changelocation3(locationid){
			document.myform.giveArName.length=0;
			var locationid3=locationid;
			var i3;
			document.myform.giveArName.options[0]=new Option('','0'); 
			for(i3=0;i3<onecount3;i3++){
			if (subcat3[i3][2] == locationid3) 
			{ 
			document.myform.giveArName.options[document.myform.giveArName.length] = new Option(subcat3[i3][1], subcat3[i3][0]); 
			} 
			} 		   
			}
			</script>

</head>
<body bgcolor="#E4FAF9">
 <%
     // System.out.println("1111=="+request.getAttribute("gd1").toString());
        String gd1=(String)session.getAttribute("gd1");
		String ga1=(String)session.getAttribute("ga1");
		String fc1=(String)session.getAttribute("fc1");
		String sc1=(String)session.getAttribute("sc1");
		String sd1=(String)session.getAttribute("sd1");
		String sa1=(String)session.getAttribute("sa1");
		String sdb1=(String)session.getAttribute("sdb");      
		String sde1=(String)session.getAttribute("sde");
		String fn1=(String)session.getAttribute("fn1"); 
      
       
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();    
     List<archives> ar=new ArrayList<archives>();
     if(request.getAttribute("ar")!=null){
     ar=(List<archives>)request.getAttribute("ar");
     int total=Integer.valueOf(request.getAttribute("totalCount").toString().trim()).intValue();
     pg=new PageSet(total,15);  
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     }else{   
        currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
        int total=archivesDao.selectArByOptionInt(gd1,ga1,fc1,sc1,sd1,sa1,sdb1,sde1,fn1);
        pg=new PageSet(total,15);  
        totalsize=pg.getTotalsize();
        totalPage=pg.getTotalpage();
        ar=archivesDao.selectArByOption(gd1,ga1,fc1,sc1,sd1,sa1,sdb1,sde1,fn1,currentPage,pg.getPagesize());
     }
   
  %>   
    <s:form name="myform" action="selectMyArchivesByOption?currentPage=1" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <s:hidden name="saveDepartment" value="%{#session.us.department}" ></s:hidden>
           <s:hidden name="saveArName" value="%{#session.us.userName}" ></s:hidden>
          <tr>
             <td> 交档部门：</td>
             <td > 
             <select  name="giveDepartment"  style="width:100px;" onChange="changelocation3(document.myform.giveDepartment.options[document.myform.giveDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0"></option> 
            <% 
		
		   for(department d :department){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
         <td  align="center">&nbsp;&nbsp;&nbsp;交档人:</td>
         <td >
            <select name="giveArName" style="width:100px;" size="1"> 
              <option selected value="0"></option>   
                <% 
		   for(user su2 :us){
		    %> 
		  <option value="<%= su2.getUserName()%>"><%=su2.getName()%></option> 
		
		 <% }
        %>   
            </select>   
          
         </td> 
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
       
               <td  align="center"> 系统分类：</td> 
              <td>
                <select name="firstCName" style="width:100px;" onChange="changelocation1(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)" size="1"> 
              <option selected value="0"></option>  
               <% 
		   for(firstClass fc2 :fc){
		    %> 
		  <option value="<%= fc2.getId()%>"><%=fc2.getFirstCName()%></option> 
		
		 <% }
        %>    
            </select>
            <select name="secondCName" style="width:100px;"  size="1"> 
              <option selected value="0"></option> 
                 </select>              
          </td> 
           <td>&nbsp;&nbsp;&nbsp;文件名称:</td>
          <td> <s:textfield name="fileName" size="20"></s:textfield></td>
              
           </tr>
            <tr><td>&nbsp;</td></tr>
           <tr>
          
          <td  align="center">  存档日期:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:100px;" name="saveArDateBegin" displayFormat="yyyy-MM-dd"  />                       
                到<struts:datetimepicker cssStyle="width:100px;" name="saveArDateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td>
              <td> &nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" value="查   找"></s:submit>  </td>                     
         </tr>
       <tr><td>&nbsp;</td></tr>
        </table>
      </s:form>     
  
     
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="23" class="tableth" bgcolor="#8E8EFF" >
          <th>序号</th><th>存档日期</th><th>文件名称</th><th>文件电子版</th><th>档案编号</th><th>交档部门</th><th>交档人</th><th>存档部门</th><th>存档人</th><th>详情</th>
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
              "</tr>");
              }                       
           %>
         
       </table>
         <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="selectMyArchivesByOption.jsp?currentPage=1">首页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="selectMyArchivesByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="selectMyArchivesByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="selectMyArchivesByOption.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='selectMyArchivesByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='selectMyArchivesByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
     
</body>
</html>