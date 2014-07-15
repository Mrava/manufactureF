<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/css/sub.css">
<script type="text/javascript">
	function load()
	{
		var msg="<s:text name='message.message' />";
		var isRight="<s:text name='message.error' />";
		if(isRight == 1){
			alert("用户名已存在！");
		}else if(isRight == 0){
			alert("保存成功！");
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
<div class="listtit">
	<h2></h2>
	<b>user.insert</b>
	<a href="user!list.action">返 回</a>
</div>
<div class="line"></div> 
	<s:form action="user" method="post" namespace="/"  onsubmit="return inputValid()">
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:textfield name="pojo.username" id="username" label="用户名"></s:textfield>
		<s:password name="pojo.password" id="password" label="密码" ></s:password>
		<s:password id="password1" label="确认密码"></s:password>
		<s:textfield name="pojo.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
	</s:form>	
</body>
</html>
