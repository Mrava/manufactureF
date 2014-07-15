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
<link rel="stylesheet" type="text/css" href="/css/login.css" />
<script type="text/javascript" src="/js/jeff.js"></script>	
</head>
  
<body> 
<div class="logo_wrap">
	<b class="logo"></b>
</div>
<div class="con_wrap">
	<div class="con">
	<s:form action="login" method="post" namespace="/">
		<s:token></s:token>
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:password name="password" label="密 码"></s:password>
		<s:submit method="login" value="登 录"></s:submit>
	</s:form>
	</div>
</div>
</body>
</html>
   