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
				alert("客户名称不能为空");
				return false;
			}else{
				return true;
			}
		}
	</script>
	
</head>
  
<body onload="load()"> 
	<br>custom.insert<br>
	<s:form action="custom" method="post" namespace="/" onsubmit="return onloads()">
		<s:token></s:token>
		<s:hidden name="custom.id"></s:hidden>
		<s:textfield name="custom.name" id="name" label="客户名称"></s:textfield>
		<s:textfield name="custom.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
		
	</s:form>
		<a href="custom!list.action">back</a>
</body>
</html>
