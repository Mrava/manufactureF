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
			var name=document.getElementById("name").value;
			if(name=="" || name==null){
				alert("供应商名称不能为空");
				return false;
			}else{
				return true;
			}
		}
	</script>
	
</head>
  
<body onload="load()"> 
	<br>provider.insert<br>
	<s:form action="provider" method="post" namespace="/"  onsubmit="return onloads()">
		<s:token></s:token>
		<s:hidden name="provider.id"></s:hidden>
		<s:textfield name="provider.name"  id="name" label="供应商名称"></s:textfield>
		<s:textfield name="provider.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
		
	</s:form>
		<a href="provider!list.action">back</a>
</body>
</html>
