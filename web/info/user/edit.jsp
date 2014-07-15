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
	<script type="text/javascript">
		function load()
		{
			var msg="<s:text name='message.message' />";
			var isRight="<s:text name='message.error' />";
			if(isRight > 0){
				alert(msg);
			}else if(isRight == 0){
				alert(msg);
			}	
		}
		function onloads(){
			var username=document.getElementById("username").value;
			var password=document.getElementById("password").value;
			var password1=document.getElementById("password1").value;
			if(username=="" || username==null){
				alert("用户名不能为空");
				return false;
			}else if(password=="" || password==null){
				alert("密码不能为空");
				return false;
			}else if(password!=password1){
				alert("两次密码不一致");
				return false;
			}else{
				return true;
			}
		}
	</script>
</head>
  
<body onload="load()"> 
	<br>user.insert<br>
	<s:form action="user" method="post" namespace="/"  onsubmit="return onloads()">
		<s:token></s:token>
		<s:hidden name="user.id"></s:hidden>
		<s:textfield name="user.username" id="username" label="用户名"></s:textfield>
		<s:password name="user.password" id="password" label="密码" ></s:password>
		<s:password id="password1" label="确认密码"></s:password>
		<s:textfield name="user.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
		
	</s:form>
		<a href="user!list.action">back</a>
</body>
</html>
