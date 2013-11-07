<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="gb2312" %>
<%@ page import="com.yz.manager.bean.*" %>  
<%@ page import="com.yz.manager.dao.*" %> 
<%@ page import="com.yz.manager.date.*" %> 
<%@ page import="com.yz.manager.storehouse.bean.*" %> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>��������</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("[name$='inCount']").keyup(function(){
			var $tr = $(this).closest("tr");
			var $subTotal = $tr.find(".sub-total");
			if(/^\d+$/.test($(this).val())){
				$subTotal.html(($(this).val()*$tr.find(".unit-price").html()).toFixed(2));
			}else{
				$(this).val(0);
				$subTotal.html(0);
				alert("����������");
			}
			calcTotalPrice();
		});
		calcTotalPrice();
	});
	
	function calcTotalPrice(){
		var totalPrice = 0;
		$(".sub-total").each(function(index,e){
			totalPrice+=(+$(e).html());
		});
		$(".total-price").html(totalPrice.toFixed(2));
	}
</script>
<style type="text/css">
			.width_50{
				width:50px;
			}
			
			.width_100{
				width:100px;
			}
			
			.red{
				color:red !important;
			}
			
			.inline{
				white-space: nowrap;
			}
			
			td{
				vertical-align: middle !important;
				text-align: center !important;
			}
			
			.pointer{
				cursor: pointer;
			}
			
			.right{
				text-align: right;
				padding: 0 10px;
			}
			
			.left{
				text-align: left;
				padding: 0 10px;
			}
		</style>
</head>
<body bgcolor="#E4FAF9">
 <%
  user user=(user)session.getAttribute("us");
 String aId=(String)request.getParameter("aId");
  if(user==null) response.sendRedirect("../index.jsp"); 
    List<storeHouse> ps=new ArrayList<storeHouse>();
    if(aId!=null){
    ps=storeHouseDao.selectHouseForUser(user.getUserName(), aId); 
    }
    else {/* 
    String said=(String)request.getAttribute("said");
    if(said!=null) ps=storeHouseDao.selectHouse(said); 
     */}
    request.setAttribute("ps",ps); 
    String shn="",fc="",sc="",gd="",sname="",vname="";
    if(ps.size()>0){
	     shn=daoUtil.selectShouseName(Integer.valueOf(ps.get(0).getHouseId()).intValue());
	     fc=daoUtil.selectFirstClass5(Integer.valueOf(ps.get(0).getFirstCName()).intValue());
	     sc=daoUtil.selectSecondClass8(ps.get(0).getSecondCName());     
	     gd=daoUtil.selectDepartment3(Integer.valueOf(ps.get(0).getDepartment()).intValue());
	     sname=daoUtil.selectUser(ps.get(0).getUserName().trim());
	     vname=daoUtil.selectUser(ps.get(0).getInVerifyName().trim());
	    String status;
	    if(ps.get(0).getInVerify()==0)status="δ���";
	       else if(ps.get(0).getInVerify()==1)status="���ͨ��";
	            else status="���δͨ��"; 
    }
  %>
  
     <s:form action="verifyStoreAction" method="post" theme="simple">
       <table class="actionmessage" align="center" >
           <tr><td>&nbsp; <s:actionmessage/></td></tr>
      
       </table>
       <div style="width:80%;margin: 0 auto;">
        <input type="hidden" value="<%=aId %>" name="id"/>
       <table class="table table-striped table-bordered" width="80%"  align="center" border="1" cellspacing="0" cellpadding="0" >
              
          <tr height="25">
             <%--  <td align="center" width="15%">����</td><td width="35%"><%= CurrentDate.parseDate4(ps.getInDate().toString()) %></td> --%>
              <td colspan="2" width="15%" align="center">����</td><td colspan="2" width="35%"><%= gd%></td>
              <td colspan="2" align="center">�ⷿ</td><td colspan="2"><%= shn %></td>
          </tr>
            <tr height="25">
              <td colspan="2" align="center">�����</td><td colspan="2"><%= sname%></td>
               <td colspan="2" align="center">�����</td><td colspan="2"><%= vname%></td>
          </tr>
          <tr>
          	<td align="center">����</td>
          	<td>��Ʒ����</td>
          	<td>���</td>
          	<td>����</td>
          	<td>����</td>
          	<td>�ܼ�</td>
          	<td>״̬</td>
          	<td>��ע</td>
          </tr>
          <% for(storeHouse p:ps) {%>
          	<tr>
          		<td>
          		    <input type="hidden" value="<%=p.getId()%>" name="storeHouses['<%=p.getId()%>'].id"/> 
          		     <input type="hidden" value="<%=p.getSecondCName()%>" name="storeHouses['<%=p.getId()%>'].secondCName"/> 
          		    <%= daoUtil.selectFirstClass5(Integer.valueOf(p.getFirstCName()).intValue())%>
          		</td>
          	  <td><%= daoUtil.selectSecondClass8(p.getSecondCName())%></td>
          	  <td><%=p.getInContent()%></td>
          		<td><input style="width: 70%;" type="text" value="<%=p.getInCount()%>" name="storeHouses['<%=p.getId()%>'].inCount"/>
          		<%= p.getUnit()%></td>
          		<td><span class="unit-price"><%= p.getUnitPrice() %></span></td>
          		<td><span class="sub-total"><%=String.format("%.2f",p.getUnitPrice()*p.getInCount())%></span>Ԫ</td>
          		<td>
          			<%if(ps.get(0).getInVerify()==0){%>δ���
          			<%}else if(ps.get(0).getInVerify()==1){%>���ͨ��
          			<%}else{ %>
	                                                     ���δͨ��<%} %> 
          		</td>
          		<td><%= p.getInRemarks()==null?"":p.getInRemarks() %></td>
          	</tr>
          <% } %> 
	          <tr>
	          	<td colspan="5"><div class="red right">�ܼ�</div></td>
	          	<td colspan="3" class="red">
	          		<div class="left"><span class="total-price"></span>Ԫ</div>
	          	</td>
	          </tr>
             <tr height="25">	
            	<td align="center" colspan="2">
						�� �ˣ�
					</td>
					<td align="left" colspan="2">
						<input type="radio" name="inVerify" value="1" checked="checked" />
						ͨ��
						<input type="radio" name="inVerify" value="2" />
						��ͨ��
					</td>
					<td align="center" colspan="2">������</td>
					<td colspan="2"><s:textarea name="verifyRemarks" value="ͬ��" cols="23" rows="4"></s:textarea></td>
				</tr>
           <tr height="26">
            <td align="center" colspan="8" style="text-align:center;">
              <s:submit name="submit" style="font-size:12px" cssClass="btn btn-primary" value="���ȷ��"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
              <s:reset name="reset" style="font-size:12px" cssClass="btn btn-primary" value="������д"></s:reset>             
            <br></td>
          </tr>
       </table>
       </div>
   </s:form>
</body>
</html>