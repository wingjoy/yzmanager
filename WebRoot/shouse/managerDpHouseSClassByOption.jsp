<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.yz.manager.storehouse.bean.*" %> 
  <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
     List<shouse> sh=new ArrayList<shouse>();
	  sh=daoUtil.selectShouse(user.getDepartment());	

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
</head>
<body bgcolor="#E4FAF9"> 
      
    <s:form name="myform" action="selectDpHouseSecondClassAction?currentPage=1" method="post" theme="simple">
      <table class="left-font01" width="60%" align="center" border="0" cellspacing="0" cellpadding="0" >
         <s:hidden name="department" value="%{#session.us.department}" ></s:hidden>
          <tr>
            <td align="center">库房名称：
             <select  name="shouseName" style="width:100px;"  > 
                 <option selected value="-1">选择库房</option> 
                 <%
								for (shouse s : sh) {
							%>
							<option value="<%=s.getId()%>"><%=s.getHouseName()%></option>

							<%
								}
							%>
            </select>
          &nbsp;&nbsp;<s:submit name="submit" value="查 找"></s:submit>  </td> 
          
         </tr>
        <tr><td>&nbsp;</td></tr>
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
              "<td align='center'><a class='left-font01' href='deleteDpHouseSecondAction.action?sId="+f.getId()+"' >删除</a</td>"+
               "<td align='center'><a class='left-font01' href='modifyDpHouseSecondClass2.jsp?sId="+f.getId()+"' >修改</a</td>"+            
              "</tr>");
              }                       
           %>
         
       </table>
       <table class="tablelink" width="60%" align="center">
           <tr align="right">
             <td>共<%= totalsize%>条记录|</td>
             <td>共<%= totalPage%>页|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="managerDpHouseSClassByOption.jsp?currentPage=1">首页</a></td>
             <td><a class="tablelink" href="managerDpHouseSClassByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a></td>
             <td><a class="tablelink" href="managerDpHouseSClassByOption.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a></td>
             <td><a class="tablelink" href="managerDpHouseSClassByOption.jsp?currentPage=<%=totalPage %>">尾页</a></td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='managerDpHouseSClassByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='managerDpHouseSClassByOption.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table> 
   
     
</body>
</html>