<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.custom.bean.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="struts" uri="/struts-dojo-tags" %>

<%
   user user=(user)session.getAttribute("us");
   if(user==null) response.sendRedirect("../index.jsp"); 
    power pw=user.getPower(); 
    List<user> us=new ArrayList<user>();
    us=daoUtil.selectUser2(user.getDepartment());

	 List<customArea> caUser = new ArrayList<customArea>();
	 caUser = daoUtil.selectUserAreaByUser();
	
	List<customType> ctype = new ArrayList<customType>();
	ctype = daoUtil.selectCustomType();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<struts:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户查询</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
	
			<script language="javascript">
			var onecount2;
			onecount2=0;
			subcat2=new  Array();  
			<%
			int count2=0;
			for(customArea sc1: caUser){
			 %>
			 subcat2[<%=count2%>]=new Array("<%= sc1.getId()%>","<%=sc1.getAreaName()%>","<%=sc1.getDepartment()%>");
			 <%
			 count2 = count2 + 1 ; 	
			}
			%>
			onecount2=<%=count2%>;
			function changelocation1(locationid){
			document.myform.areaName.length=0;
			var locationid2=locationid;
			var i2;
			document.myform.areaName.options[0]=new Option('选择用户区域','0'); 
			for(i2=0;i2<onecount2;i2++){
			if (subcat2[i2][2] == locationid2) 
			{ 
			document.myform.areaName.options[document.myform.areaName.length] = new Option(subcat2[i2][1], subcat2[i2][0]); 
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
     List<custom> cs=new ArrayList<custom>();
    
     pg=new PageSet(customDao.selectCustomSize(user.getDepartment(),false),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
    
     cs=customDao.selectCustom(user.getDepartment(),false,currentPage,pg.getPagesize());
  
  %>   
    <s:form name="myform" action="selectOtherCustomByOption?currentPage=1" method="post" theme="simple" >
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>
           <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>
            <td align="center" >添加人:</td>
             <td  >
                  <select name="userName"  style="width:100px;" onChange="changelocation1(document.myform.userName.options[document.myform.userName.selectedIndex].value)" size="1">  
        			   <option selected value="0">选择添加人</option> 
        			     <% 
		
		   for(user u : us){
		    %> 
		  <option value="<%= u.getUserName()%>"><%= u.getName()%></option> 
		
		 <% }
        %> 
        			   
                 </select>
             </td>
        
              <td align="center" > &nbsp;&nbsp;负责区域:</td>
             <td  >
                  <select name="areaName"  style="width:100px;" size="1"> 
        			   <option selected value="0">选择区域</option> 
                 </select>
             </td>
             
               <td align="center">
						&nbsp;&nbsp;客户类型:
					</td>
					<td>
						<select style="width:100px;" name="customType">	
						  <option selected value="0">选择客户类型</option> 
							<%
								for (customType f : ctype) {
							%>
							<option value="<%=f.getId()%>"><%=f.getTypeName()%></option>

							<%
								}
							%>
						</select>
				</td>
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
         <td align="center">条件搜索:</td>
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
          
        <td align="center">&nbsp;&nbsp;添加日期:</td>
           <td>
           	  <struts:datetimepicker  cssStyle="width:80px;" name="dateBegin" displayFormat="yyyy-MM-dd"  />                       
                到<struts:datetimepicker cssStyle="width:80px;" name="dateEnd" displayFormat="yyyy-MM-dd"  />                         
           </td>

              <td> &nbsp;&nbsp;&nbsp;&nbsp;<s:submit style="font-size:14px" name="submit" value="查 找"></s:submit>  </td>                     
         </tr>
       <tr><td>&nbsp;</td></tr>
        </table>
      </s:form>
     
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="23" class="tableth" bgcolor="#8E8EFF" >
          <th>序号</th><th>添加日期</th><th>区域</th><th>单位名称</th><th>联系人</th><th>联系电话</th><th>客户类型</th><th>添加部门</th><th>添加人</th><th>详情</th><th>删除</th><th>修改</th>
          </tr>
          <%
           int i=1;
            for(custom a : cs){
              String dp=daoUtil.selectDepartment3(Integer.valueOf(a.getDepartment()).intValue());
              String sname=daoUtil.selectUser(a.getUserName().trim());
              String ct=daoUtil.selectCustomTypeName(Integer.valueOf(a.getCustomType()).intValue());
              
              String an=daoUtil.selectCustomAreaName(Integer.valueOf(a.getAreaName()).intValue());
            out.println(
              "<tr height='23'>"+
              "<td align='center'>"+ i++ +"</td>"+
              "<td align='center'>&nbsp;"+CurrentDate.parseDate1(a.getAddDate().toString())+"</td>"+
              "<td align='center'>&nbsp;"+an+"</td>" +  
              "<td align='center'>&nbsp;"+a.getCompanyName()+"</td>" +   
              "<td align='center'>&nbsp;"+a.getContactName()+"</td>"+ 
              "<td align='center'>&nbsp;"+a.getMobilePhone()+"/"+a.getWorkPhone()+"</td>" +         
              "<td align='center'>&nbsp;"+ct+"</td>" +  
              "<td align='center'>&nbsp;"+dp+"</td>" +             
              "<td align='center'>&nbsp;"+sname+"</td>" + 
              "<td align='center'><a class='left-font01' href='detailCustom.jsp?aId="+a.getId()+"' >>></a></td>");
            
              if(pw.isCmsdelete()){
                    out.println(
               "<td align='center'><a class='left-font01' href='deleteOtherCustomAction.action?aId="+a.getId()+"' >>></a></td>");
               }else{
                        out.println(
               "<td align='center' style='color:red'>否</td>");
               }
               if(pw.isCmsmodify()){
                      out.println(
                       "<td align='center'><a class='left-font01' href='modifyCustom.jsp?aId="+a.getId()+"' >>></a></td>");            
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
             <td><a class="tablelink" href="selectOtherCustom.jsp?currentPage=1">首页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectOtherCustom.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectOtherCustom.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;</td>
             <td><a class="tablelink" href="selectOtherCustom.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='selectOtherCustom.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='selectOtherCustom.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
     
</body>
</html>