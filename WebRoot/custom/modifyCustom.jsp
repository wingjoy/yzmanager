<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@page import="com.yz.manager.bean.*" %>  
<%@page import="com.yz.manager.dao.*" %> 
<%@page import="com.yz.manager.date.*" %> 
<%@page import="com.yz.manager.custom.bean.*" %> 
<%@page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息修改</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
  if(user==null) response.sendRedirect("../index.jsp"); 
  custom ps=new custom();
    String aId=(String)request.getParameter("aId");
    
    if(aId!=null){
    ps=customDao.selectCustom(aId); 
    }
    else {
    String said=(String)request.getAttribute("said");
    if(said!=null) ps=customDao.selectCustom(said);
    }
    List<customState> cs = new ArrayList<customState>();
	cs = daoUtil.selectCustomState();
    request.setAttribute("ps",ps); 
              String dp=daoUtil.selectDepartment3(Integer.valueOf(ps.getDepartment()).intValue());
              String sname=daoUtil.selectUser(ps.getUserName().trim());
              String ct=daoUtil.selectCustomTypeName(Integer.valueOf(ps.getCustomType()).intValue());         
              String an=daoUtil.selectCustomAreaName(Integer.valueOf(ps.getAreaName()).intValue());
  %>
     <s:form action="modifyCustomAction" method="post" theme="simple">
       <table class="actionmessage" align="center" >
         <tr><td>&nbsp;</td></tr>
       <tr><td>&nbsp;</td></tr>
       <tr><td>&nbsp;</td></tr>
      <tr><td class="actionmessage"> <s:actionmessage/></td></tr>
      
            <tr><td>&nbsp;</td></tr>
       </table>
       <table class="left-font01" width="100%"  align="center" border="1" cellspacing="0" cellpadding="0" >
               <s:hidden name="id" value="%{#request.ps.id}" ></s:hidden>
          <tr height="25">   
              <td align="center" width="15%">客户区域</td><td width="35%">&nbsp;<%= an %></td><td align="center" width="15%">客户类型</td><td width="35%">&nbsp;<%= ct%></td>
          </tr>
           <tr height="25">
              <td align="center" width="15%">客户状态</td>
              <td>	
						<select style="width:218px;" name="customState" size="1">
						  	<%
								for (customState s1 : cs) {
								  if(s1.getId()==ps.getCustomState()){
							%>
							<option value="<%=s1.getId()%>" selected><%=s1.getStateName()%></option>

							<%
							      }else{
							      %>
							<option value="<%=s1.getId()%>" ><%=s1.getStateName()%></option>

							<%
							      }
								}
							%>
						  
						</select>

					</td>
              <td align="center">单位名称</td><td><%= ps.getCompanyName() %></td> 
          </tr>
           
            <tr height="25">
              <td align="center">单位地址</td><td><s:textfield size="40" name="companyAddress" value="%{#request.ps.companyAddress}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center" width="15%">联系人</td><td><s:textfield name="contactName" value="%{#request.ps.contactName}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
            <tr height="25">
              <td align="center">邮编地址</td><td><s:textfield name="zipCode" value="%{#request.ps.zipCode}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center">职位</td><td><s:textfield name="post" value="%{#request.ps.post}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
            <tr height="25">
              <td align="center">手机号码</td><td><s:textfield name="mobilePhone" value="%{#request.ps.mobilePhone}" ></s:textfield><span class="xiugai">*可修改</span></td><td align="center">座机号码</td><td><s:textfield name="workPhone" value="%{#request.ps.workPhone}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
          <tr height="25">
              <td align="center">传真</td><td><s:textfield name="fax" value="%{#request.ps.fax}" ></s:textfield><span class="xiugai">*可修改</span></td>
              <td align="center">电子邮箱</td><td><s:textfield name="mail" value="%{#request.ps.mail}" ></s:textfield><span class="xiugai">*可修改</span></td>
          </tr>
           <tr height="25">
              <td align="center">QQ号码</td><td><s:textfield name="qq" value="%{#request.ps.qq}" ></s:textfield><span class="xiugai">*可修改</span></td>
              <td align="center">添加部门</td><td><%= dp %></td>
          </tr> 
           <tr height="25">
              <td align="center">添加人</td><td><%= sname %></td>
              <td align="center">添加日期</td><td><%= CurrentDate.parseDate4(ps.getAddDate().toString()) %></td>
         
          </tr>
          <tr height="25">
            <td align="center">
						&nbsp;&nbsp;客户信息纠正：
					</td>
					<td  colspan="3">
						<input type="radio" name="rectify" value="0" checked="checked" />
						不需要丢正&nbsp;&nbsp;
						<input type="radio" name="rectify" value="1" />
						需要纠正（反馈给信息添加人）
					</td>
          </tr>
              <tr height="25">
              <td  align="center">备注</td><td colspan="3"><s:textarea name="remarks" value="%{#request.ps.remarks}" cols="40" rows="4" ></s:textarea><span class="xiugai">*可修改</span></td>
          </tr>
           <tr height="25">
            <td align="center" colspan="4">
              <s:submit name="submit" style="font-size:14px"value="修  改"></s:submit>&nbsp;&nbsp;
              <s:reset name="reset" style="font-size:14px"value="重  置"></s:reset>             
            <br></td>
          </tr>
       </table>
   </s:form>
</body>
</html>