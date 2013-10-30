<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="com.yz.manager.archives.bean.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>
<%
      user user=(user)session.getAttribute("us");
      if(user==null) response.sendRedirect("../index.jsp"); 
      
      String averify=(String)request.getParameter("averify");  
  //    String averify1=(String)request.getAttribute("averify");	
      request.setAttribute("averify",averify);
      List<secondClass> sc=new ArrayList<secondClass>();
      sc=daoUtil.selectSecondClassId(user.getDepartment());
     
      List<user> u=new ArrayList<user>();
      u=daoUtil.selectDoubleUserId();	
      List<firstClass> fc=new ArrayList<firstClass>();
	  String department=user.getDepartment().trim();
	  String systemName="1";
      fc=daoUtil.selectFirstClassId(department,systemName);
	  List<department> sdp=new ArrayList<department>();
	  sdp=daoUtil.selectDepartmentId();	  

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>档案查询</title>
	<script language="javascript">
		var onecount;
		onecount=0;
		subcat=new  Array();  
		<%
		int count=0;
		for(secondClass s : sc){
		 %>
		 subcat[<%=count%>]=new Array("<%= s.getId()%>","<%=s.getSecondCName()%>","<%=s.getFirstCName()%>");
		 <%
		 count = count + 1 ; 	
		}
		%>
		onecount=<%=count%>;
		function changelocation(locationid){
		document.myform.secondCName.length=0;
		var locationid=locationid;
		var i;
		document.myform.secondCName.options[0]=new Option('选择二级分类','0'); 
		for(i=0;i<onecount;i++){
		if (subcat[i][2] == locationid) 
		{ 
		document.myform.secondCName.options[document.myform.secondCName.length] = new Option(subcat[i][1], subcat[i][0]); 
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
		for(user u1 : u){
		 %>
		 subcat3[<%=count3%>]=new Array("<%= u1.getUserName()%>","<%=u1.getName()%>","<%=u1.getDepartment()%>");
		 <%
		 count3 = count3 + 1 ; 	
		}
		%>
		onecount3=<%=count3%>;
		function changelocation3(locationid3){
		document.myform.saveArName.length=0;
		var locationid3=locationid3;
		var k;
		document.myform.saveArName.options[0]=new Option('选择存档用户','0'); 
		for(k=0;k<onecount3;k++){
		if (subcat3[k][2] == locationid3) 
		{ 
		document.myform.saveArName.options[document.myform.saveArName.length] = new Option(subcat3[k][1], subcat3[k][0]); 
		} 
		} 		   
		}
		</script>
</head>
<body bgcolor="#E4FAF9">
 <%
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
  //   int a1= Integer.valueOf(request.getAttribute("averify")).intValue();  
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
	        int total=archivesDao.selectApplyArByOptionInt(fc1,sc1,sd1,sa1,sdb1,sde1,fn1,Integer.valueOf(averify).intValue(),user.getUserName());
	        pg=new PageSet(total,15);  
	        totalsize=pg.getTotalsize();
	        totalPage=pg.getTotalpage();
	        ar=archivesDao.selectApplyArByOption(fc1,sc1,sd1,sa1,sdb1,sde1,fn1,Integer.valueOf(averify).intValue(),user.getUserName(),currentPage,pg.getPagesize());
         }

  %>   
    <s:form name="myform" action="applyArchivesByOption?currentPage=1" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
      <tr><td><s:hidden name="averify" value="%{#request.averify}"/></td></tr>
          <tr>
              <td >系统分类：</td> 
              <td>
                <select name="firstCName" style="width:120px;" onChange="changelocation(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)" size="1"> 
              <option selected value="0"></option>
               <% 
		
		   for(firstClass f :fc){
		    %> 
		  <option value="<%= f.getId()%>"><%=f.getFirstCName()%></option> 
		
		 <% }
        %>      
            </select>
            <select name="secondCName" style="width:120px;"  size="1"> 
              <option selected value="0"></option> 
                 </select>              
          </td>      
      
        <td > &nbsp;&nbsp;存档部门：</td>
             <td > 
             <select  name="saveArDepartment"  style="width:120px;" onChange="changelocation3(document.myform.saveArDepartment.options[document.myform.saveArDepartment.selectedIndex].value)" size="1"> 
              <option selected value="0"></option>      
        <% 
		
		   for(department d :sdp){
		    %> 
		  <option value="<%= d.getDepartmentId()%>"><%=d.getDepartment()%></option> 
		
		 <% }
        %> 
            </select>
        </td>
         <td>&nbsp;&nbsp;存档人:</td>
         <td >
            <select name="saveArName" style="width:120px;" size="1"> 
              <option selected value="0"></option>   
            </select>   
          
         </td>
         </tr>
           <tr><td>&nbsp;</td></tr>
         <tr>
        <td>存档日期:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:120px;" name="saveArDateBegin" displayFormat="yyyy-MM-dd"  />                       
                到<struts:datetimepicker cssStyle="width:120px;" name="saveArDateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td>          
           <td>&nbsp;&nbsp;文件名称:</td>
          <td> <s:textfield name="fileName" size="22"></s:textfield></td>
          
          <td>
          </td>
              <td> &nbsp;<s:submit style="font-size:14px" name="submit" value="查 找"></s:submit>  </td>                     
         </tr>
      
        </table>
      </s:form>
  
   
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr  class="tableth">
          <%
            if("0".equals(averify)){
             out.println(
               "<td><a target='main' class='left-font01' style='color : red' href='applyArchivesState.jsp?averify=0&currentPage=1'>未审核</a></td>"+
               "<td>&nbsp;&nbsp;&nbsp;&nbsp;</td> "
             );
            }else{
               out.println(
               "<td><a target='main' class='left-font01'  href='applyArchivesState.jsp?averify=0&currentPage=1'>未审核</a></td>"+
               "<td>&nbsp;&nbsp;&nbsp;&nbsp;</td> "
             );
            }
            
            if("1".equals(averify)){
             out.println(
               "<td><a target='main' class='left-font01' style='color : red' href='applyArchivesState.jsp?averify=1&currentPage=1'>审核通过</a></td>"+
               "<td>&nbsp;&nbsp;&nbsp;&nbsp;</td> "
             );
            }else{
               out.println(
               "<td><a target='main' class='left-font01'  href='applyArchivesState.jsp?averify=1&currentPage=1'>审核通过</a></td>"+
               "<td>&nbsp;&nbsp;&nbsp;&nbsp;</td> "
             );
            }
             if("2".equals(averify)){
             out.println(
               "<td><a target='main' class='left-font01' style='color : red' href='applyArchivesState.jsp?averify=2&currentPage=1'>审核未通过</a></td>"+
               "<td>&nbsp;&nbsp;&nbsp;&nbsp;</td> "
             );
            }else{
               out.println(
               "<td><a target='main' class='left-font01'  href='applyArchivesState.jsp?averify=2&currentPage=1'>审核未通过</a></td>"+
               "<td>&nbsp;&nbsp;&nbsp;&nbsp;</td> "
             );
            }
           %>             
         </tr>
      
        </table>
    
     
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          
          <%
		          if("0".equals(averify)){
		            out.println(
		             "<tr height='23' class='tableth'bgcolor='#8E8EFF' >"+
		             "<th>序号</th><th>文件名称</th><th>文件电子版</th><th>档案编号</th><th>交档人</th><th>交档日期</th><th>状态</th><th>详情</th><th>删除</th>"+
		             "</tr>"
		            );
		            int j=1;;
		            for(archives a : ar){
		           
		            out.println(
		              "<tr height='23'>"+
		              "<td align='center'>"+ j++ +"</td>"+
		              "<td align='center'>"+a.getFileName()+"</td>"+
		              "<td align='center'><a href='"+ a.getFileDir()+"' >下载</a></td>"+  
		              "<td align='center'>"+a.getFileNumber()+"</td>" + 
		              "<td align='center'>"+a.getGiveArName()+"</td>" + 
		              "<td align='center'>"+CurrentDate.parseDate1(a.getArDate().toString())+"</td>"+
		              "<td align='center'>未审核</td>" +   
		              "<td align='center'><a class='left-font01' href='detailArchives.jsp?aId="+a.getId()+"' >>></a></td>"+         
		              "<td align='center'><a class='left-font01'  href='deleteArchivesAction1.action?aId="+a.getId()+"&averify=0' >>></a></td>"+           
		              "</tr>");
		              }   
		             }                     
		             else if("1".equals(averify)){
		            out.println(
		             "<tr height='23' class='tableth'bgcolor='#8E8EFF'>"+
		             " <th>序号</th><th>文件名称</th><th>文件电子版</th><th>档案编号</th><th>交档人</th><th>交档日期</th><th>状态</th><th>存档人</th><th>存档日期</th><th>详情</th>"+
		             "</tr>"
		            );
		            int i=1;
		            for(archives a : ar){
		             String sname=daoUtil.selectUser(a.getSaveArName());
		            out.println(
		              "<tr height='23'>"+
		               "<td align='center'>"+ i++ +"</td>"+
		              "<td align='center'>"+a.getFileName()+"</td>"+
		              "<td align='center'><a href='"+ a.getFileDir()+"' >下载</a></td>"+  
		              "<td align='center'>"+a.getFileNumber()+"</td>" + 
		              "<td align='center'>"+a.getGiveArName()+"</td>" + 
		              "<td align='center'>"+CurrentDate.parseDate1(a.getArDate().toString())+"</td>"+
		              "<td align='center'>通过</td>" +  
		              "<td align='center'>"+sname+"</td>" + 
		              "<td align='center'>"+CurrentDate.parseDate1(a.getSaveArDate().toString())+"</td>"+     
		              "<td align='center'><a class='left-font01' href='detailArchives.jsp?aId="+a.getId()+"' >>></a></td>"+     
		              "</tr>");
		              }   
		             }                     
		            else if("2".equals(averify)){
		            out.println(
		             "<tr height='23'>"+
		             "<th>序号</th><th>文件名称</th><th>文件电子版</th><th>档案编号</th><th>交档人</th><th>交档日期</th><th>状态</th><th>详情</th><th>删除</th>"+
		             "</tr>"
		            );
		            int k=1;
		            for(archives a : ar){
		           
		            out.println(
		              "<tr height='23' class='tableth'bgcolor='#8E8EFF'>"+
		               "<td align='center'>"+ k++ +"</td>"+
		              "<td align='center'>"+a.getFileName()+"</td>"+
		              "<td align='center'><a href='"+ a.getFileDir()+"' >下载</a></td>"+  
		              "<td align='center'>"+a.getFileNumber()+"</td>" + 
		              "<td align='center'>"+a.getGiveArName()+"</td>" + 
		              "<td align='center'>"+CurrentDate.parseDate1(a.getArDate().toString())+"</td>"+
		              "<td align='center'>未通过</td>" +  
		               "<td align='center'><a class='left-font01' href='detailArchives.jsp?aId="+a.getId()+"' >>></a></td>"+     
		              "<td align='center'><a class='left-font01' href='deleteArchivesAction1.action?aId="+a.getId()+"&averify=2' >>></a></td>"+
		              "</tr>");
		              }   
		             }  
		      
		           %>
         
       </table>
        <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="applyArchivesStateByOption.jsp?averify=<%=averify %>&currentPage=1">首页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="applyArchivesStateByOption.jsp?averify=<%=averify %>&currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="applyArchivesStateByOption.jsp?averify=<%=averify %>&currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="applyArchivesStateByOption.jsp?averify=<%=averify %>&currentPage=<%=totalPage %>">尾页</a>&nbsp;&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">         
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                 if(j==currentPage){
                   out.println(
                  "<option selected value='applyArchivesStateByOption.jsp?averify="+averify+"&currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                 }else{
                 out.println(
                  "<option value='applyArchivesStateByOption.jsp?averify="+averify+"&currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
              }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
   
     
</body>
</html>