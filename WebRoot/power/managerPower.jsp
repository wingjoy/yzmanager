<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="java.util.*" %> 
<%@page import="com.yz.manager.page.*" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�û�Ȩ�޹���</title>
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
<%
String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
   int totalsize=0;
     int totalPage=1;
     int currentPage=1;
     PageSet pg=new PageSet();

     pg=new PageSet(daoUtil.selectUserSize(),15);  
     
     totalsize=pg.getTotalsize();
     totalPage=pg.getTotalpage();
     currentPage=Integer.valueOf(request.getParameter("currentPage")).intValue();
	  List<user> u=new ArrayList<user>();
	  u=daoUtil.selectUser(currentPage,pg.getPagesize());
	  
	  HashMap<String,String> department=new LinkedHashMap<String,String>();
	  department=( HashMap<String,String>)daoUtil.selectDepartment();
	  request.setAttribute("department",department);
  %>    
    <s:form action="%{basepath}power/selectUserPowerByDAction?currentPage=1" method="post" theme="simple">
      <table class="left-font01" align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr>
             <td align="center"> </td>  
             <td align="left"> <s:select name="department" list="#request.department"  headerKey="-1" headerValue="���в���" listKey="key" listValue="value" ></s:select></td>
              <td> &nbsp;&nbsp; &nbsp;&nbsp;</td>  
              <td> <s:submit name="submit" value="�� ��"></s:submit>  </td>               
         </tr>
      
        </table>
      </s:form>
     
       <table class="left-font01" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
          <tr height="25" class="tableth" bgcolor="#8E8EFF">
          <th>�û���</th><th>����</th><th>���ڲ���</th><th>�޸�Ȩ��</th>
          </tr>
          <%
            for(user u1 : u){
            String sdp=daoUtil.selectDepartment3(Integer.valueOf(u1.getDepartment()).intValue());
            out.println(
              "<tr height='25'>"+         
              "<td align='center'>"+u1.getUserName()+"</td>"+
              "<td align='center'>"+u1.getName()+"</td>"+
              "<td align='center'>"+sdp+"</td>"          
              ); 
              if(u1.getUserName().equals("admin")) {
                  out.println(
              "<td align='center'>�����޸�</td>"+
              "</tr>");
              }                            
              else out.println(
                    "<td align='center'><a class='left-font01' href='"+basepath+"power/addpower.jsp?uname="+u1.getUserName()+"&dp="+u1.getDepartment()+"' >�޸�</a></td>"+
                    "</tr>");
            };     
        %>
         
       </table>
       <table class="tablelink" align="center">
           <tr align="right">
             <td>��<%= totalsize%>����¼|</td>
             <td>��<%= totalPage%>ҳ|</td>
             <td>��ǰ��<%= currentPage%>ҳ|</td>
             <td><a class="tablelink" href="<%=basepath %>power/managerPower.jsp?currentPage=1">��ҳ</a></td>
             <td><a class="tablelink" href="<%=basepath %>power/managerPower.jsp?currentPage=<%=pg.searchCurrentPage(currentPage-1) %>">��һҳ</a></td>
             <td><a class="tablelink" href="<%=basepath %>power/managerPower.jsp?currentPage=<%=pg.searchCurrentPage(currentPage+1)%>">��һҳ</a></td>
             <td><a class="tablelink" href="<%=basepath %>power/managerPower.jsp?currentPage=<%=totalPage %>">βҳ</a></td>
             <td>��ת����<select name="selectPage" onchange="document.location.href=this.value">           
             <%
                for(int j=1;j<=pg.getTotalpage();j++){
                if(j==currentPage){
                out.println(
                  "<option  selected value='"+basepath+"power/managerPower.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }else {
                 out.println(
                  "<option value='"+basepath+"power/managerPower.jsp?currentPage="+j+"'>&nbsp;&nbsp;"+j+"&nbsp;&nbsp;</option>");
                }
              }   
              %>           
             </select>ҳ</td>
           </tr>
         
         </table> 
   
     
</body>
</html>