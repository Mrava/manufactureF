<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
</head>
  
<body> 
	<br>makeplan.insert<br>
	<s:form action="make" method="post" namespace="/">
		<s:token></s:token>
		<s:hidden name="make.id"></s:hidden>
		<s:textfield name="make.indexId"></s:textfield>
		<s:textfield name="make.bomcode"></s:textfield>
		<s:textfield name="make.quantity"></s:textfield>
		<s:textfield name="make.TDate"></s:textfield>
		<s:submit method="save" />
		
	</s:form>

</body>
</html>
