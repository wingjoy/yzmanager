<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add system</title>
</head>
<body>

 <h1 align="center">增加系统</h1>
   
 
    <s:form action="addsystemAction" method="post" theme="simple">
        <s:token></s:token>
       <table  align="center" border="0" cellspacing="0" cellpadding="0" >
          <tr >
             <td> 系统名：</td>
             <td align="center"> <s:textfield name="systemName" size="30" ></s:textfield></td>
         </tr>
       
          <tr>
            <td align="right">
              
            </td>
            <td align="center">
              <s:submit name="submit" value="提 交"></s:submit>
              <s:reset name="reset" value="重 置"></s:reset>             
            </td>
          </tr>
       </table>
       
       
       </s:form>
           
     
</body>
</html>