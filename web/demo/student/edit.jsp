<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache"></meta>
	<meta http-equiv="cache-control" content="no-cache"></meta>
	<meta http-equiv="expires" content="0"></meta>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"></meta>
	<meta http-equiv="description" content="This is my page"></meta>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
</head>
  
<body> 
	<br>student.insert</br>
	<s:form action="student" method="post" namespace="/">
		<s:token></s:token>
		<s:hidden name="student.id"></s:hidden>
		 <s:textfield name="student.name"></s:textfield>
		age: <s:textfield name="student.age"></s:textfield>
		remark: <s:textfield name="student.remark"></s:textfield>
		<s:submit method="save" />
		
	</s:form>

</body>
</html>
