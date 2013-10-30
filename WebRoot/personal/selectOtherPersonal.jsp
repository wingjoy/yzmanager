<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.personal.bean.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>

<%
   user user=(user)session.getAttribute("us");
   if(user==null) response.sendRedirect("../index.jsp"); 
   
   List<firstClass> fc=new ArrayList<firstClass>(); 
   String systemName="2";
   fc=daoUtil.selectFirstClassId(user.getDepartment(),systemName);
   
    List<secondClass> sc=new ArrayList<secondClass>();
    sc=daoUtil.selectAllSecondClass2(user.getDepartment(),systemName);
   
    List<user> us=new ArrayList<user>();
    us=daoUtil.selectUser2(user.getDepartment());
    
        power pw=daoUtil.selectPower(user.getUserName().trim());

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
		
</head>
<body bgcolor="#E4FAF9">
  <%  
     int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();
     List<personal> ps=new ArrayList<personal>();
    
     pg=new PageSet(personalDao.selectPersonalSize(user.getDepartment()),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
    
     ps=personalDao.selectPersonal(user.getDepartment(),currentPage,pg.getPagesize());
  
  %>      
    <s:form name="myform" action="selectOtherPersonalByOption?currentPage=1" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>
          <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>
         
            <td >创建人:</td>
             <td  >
                  <select name="userName"  style="width:100px;" size="1"> 
           <option selected value="0"></option> 
         <% 
		   for(user su :us){
		    %> 
		  <option value="<%= su.getUserName()%>"><%=su.getName()%></option> 
		
		 <% }
        %> 
            </select>          
            
             </td>
        
              <td >&nbsp;&nbsp;人员分类：</td> 
              <td>
                <select name="firstCName" style="width:100px;" onChange="changelocation1(document.myform.firstCName.options[document.myform.firstCName.selectedIndex].value)" size="1"> 
              <option selected value="0"></option>    
               <% 
		   for(firstClass f1 :fc){
		    %> 
		  <option value="<%= f1.getId()%>"><%=f1.getFirstCName()%></option> 
		
		 <% }
        %>  
            </select>
            <select name="secondCName" style="width:100px;"  size="1"> 
              <option selected value="0"></option> 
                 </select>              
          </td> 
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
         <td>搜索:</td>
           <td>
            <select name="select"  style="width:100px;" size="1"> 
			           <option selected value="1">联系人</option> 
			           <option  value="2">手机号</option> 
			           <option  value="3">座机号</option> 
			           <option  value="4">单位名称</option> 
			           <option  value="5">单位地址</option>
			           <option  value="6">备注</option>  
           </select>
         <s:textfield name="search" size="20"></s:textfield></td>
          
        <td>&nbsp;&nbsp;添加日期:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:80px;" name="dateBegin" displayFormat="yyyy-MM-dd"  />                       
                到<struts:datetimepicker cssStyle="width:80px;" name="dateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td>
          
          <td>
          </td>
              <td> &nbsp;<s:submit style="font-size:14px" name="submit" value="查 找"></s:submit>  </td>                     
         </tr>
       <tr><td>&nbsp;</td></tr>
        </table>
      </s:form>
     
       
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="23" class="tableth" bgcolor="#8E8EFF" >
          <th>序号</th><th>添加日期</th><th>联系人</th><th>联系电话</th><th>单位</th><th>单位地址</th><th>创建部门</th><th>创建人</th><th>备注</th><th>详情</th><th>删除</th><th>修改</th>
          </tr>
          <%
           int i=1;
            for(personal a : ps){
              String dp=daoUtil.selectDepartment3(Integer.valueOf(a.getDepartment()).intValue());
              String sname=daoUtil.selectUser(a.getUserName().trim());
            out.println(
              "<tr height='23'>"+
              "<td align='center'>"+ i++ +"</td>"+
              "<td align='center'>"+CurrentDate.parseDate1(a.getRegisterDate().toString())+"</td>"+
              "<td align='center'>"+a.getContactName()+"</td>"+ 
              "<td align='center'>"+a.getMobilePhone()+"/"+a.getWorkPhone()+"</td>" + 
              "<td align='center'>"+a.getCompanyName()+"</td>" +   
              "<td align='center'>"+a.getCompanyAddress()+"</td>" +  
              "<td align='center'>"+dp+"</td>" +             
              "<td align='center'>"+sname+"</td>" + 
               "<td align='center'>&nbsp;"+a.getRemarks()+"</td>" +      
              "<td align='center'><a class='left-font01' href='detailPersonal.jsp?aId="+a.getId()+"' >>></a></td>");
              if(pw.isPmsdelete()){
                    out.println(
               "<td align='center'><a class='left-font01' href='deleteOtherPersonalAction.action?aId="+a.getId()+"' >>></a></td>");
               }else{
                        out.println(
               "<td align='center' style='color:red'>否</td>");
               }
               if(pw.isPmsmodify()){
                      out.println(
                       "<td align='center'><a class='left-font01' href='modifyPersonal.jsp?aId="+a.getId()+"' >>></a></td>");            
               }else{
                       out.println(
                       "<td align='center' style='color:red'>否</td>");            
               }
                out.println("</tr>");
              }                                      
           %>
         
       </table>
         <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="selectOtherPersonal.jsp?currentPage=1">首页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectOtherPersonal.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectOtherPersonal.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectOtherPersonal.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='seleOtherctPersonal.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='selectOtherPersonal.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
     
</body>
</html>