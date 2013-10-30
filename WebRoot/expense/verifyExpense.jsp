<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@page import="com.yz.manager.expense.bean.*" %> 
<%@page import="java.util.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>费用审核</title>
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  
     PageSet pg=new PageSet(expenseDao.selectExpenseSize2(user.getUserName()),15);  
     int totalsize=pg.getTotalsize();
     int totalPage=pg.getTotalpage();
     int currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
     List<expense> ep=new ArrayList<expense>();
     ep=expenseDao.selectExpense2(user.getUserName(),currentPage,pg.getPagesize());
  %>   
  <table class="actionmessage" width="100%"  align="center" border="0" cellspacing="0" cellpadding="0" >
        <tr><td align="center"> <s:actionmessage></s:actionmessage></td></tr>
     </table>   
       
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          
          <%
		        out.println(
		             "<tr height='23' class='tableth'bgcolor='#8E8EFF'>"+
		             "<th>序号</th><th>添加日期</th><th>经办人</th><th>内容</th><th>单价</th><th>数量</th><th>单位</th><th>总价</th><th>付款方式</th><th>挂账公司</th><th>备注</th><th>审核</th>"+
		             "</tr>"
		            );
		            int k=1;;
		            for(expense e : ep){
                       String cm=daoUtil.selectGCompanyName(Integer.valueOf(e.getCompany()).intValue());
                       String pm=daoUtil.selectPayModeName(Integer.valueOf(e.getPayMode()).intValue());   
		             out.println(
		              "<tr height='23'>"+
		              "<td align='center'>"+ k++ +"</td>"+
		               "<td align='center'>&nbsp;"+CurrentDate.parseDate1(e.getAddDate().toString())+"</td>"+
		              "<td align='center'>&nbsp;"+daoUtil.selectUser(e.getUserName())+"</td>"+
		              "<td align='center'>&nbsp;"+e.getContent()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getUnitPrice()+"</td>" + 
		              "<td align='center'>&nbsp;"+e.getNumber()+"</td>"+
		              "<td align='center'>&nbsp;"+e.getUnit()+"</td>"+
		              "<td align='center'>&nbsp;"+e.getTotalPrice()+"</td>"+
		              "<td align='center'>&nbsp;"+pm+"</td>"+
		              "<td align='center'>&nbsp;"+cm+"</td>"+
		              "<td align='center'>&nbsp;"+e.getRemarks()+"</td>");   
		              out.println(
		              "<td align='center'><a class='left-font01' href='verifyExpenseDetail.jsp?aId="+e.getId()+"' >>></a></td>"+                 
		              "</tr>");
		              }   
		         %>
         
       </table>
         <table class="tablelink">
           <tr align="right">
             <td>共<%= totalsize%>条记录&nbsp;|</td>
             <td>共<%= totalPage%>页&nbsp;|</td>
             <td>当前第<%= currentPage%>页&nbsp;|</td>
             <td><a class="tablelink" href="verifyExpense.jsp?currentPage=1">首页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="verifyExpense.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">上一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="verifyExpense.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">下一页</a>&nbsp;&nbsp;</td>
             <td><a class="tablelink" href="verifyExpense.jsp?currentPage=<%=totalPage %>">尾页</a>&nbsp;&nbsp;</td>
             <td>跳转到第<select name="selectPage" onchange="document.location.href=this.value">        
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                 if(j==currentPage){
                      out.println(
                  "<option  selected value='verifyExpense.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                 }else{
                 out.println(
                  "<option value='verifyExpense.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>页</td>
           </tr>
         
         </table>
   
   
     
</body>
</html>