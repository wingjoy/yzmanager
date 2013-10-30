<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addArchivesSuccess</title>
</head>
<body>

 <h3>增加档案成功：</h3>
 <h3><s:property value="fileName"/>    </h3>
 <h3><s:property value="arDate"/>    </h3>
    
    
    <tr>
             <td> 袋  号：</td>
             <td align="center"> <s:textfield name="fileCoverNumber" size="30"></s:textfield></td>
         </tr>
          <tr>
             <td> 保存年限：</td>
             <td align="center"> <s:textfield name="saveYears" size="30"></s:textfield></td>
         </tr> 
</body>
</html>