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
			var code=document.getElementById("code").value;
			if(name=="" || name==null){
				alert("名称不能为空");
				return false;
			}else if(code=="" || code==null){
				alert("代码不能为空");
				return false;
			}else{
				return true;
			}
		}
	</script>
</head>
  
<body onload="load()"> 
	

	<br>bom.insert<br>
	<s:form action="bom" method="post" namespace="/" onsubmit="return onloads()">
		<s:token></s:token>
		<s:hidden name="bom.id"></s:hidden>
		<s:textfield name="bom.code" id="code" label="代码"></s:textfield>
		<s:textfield name="bom.name" id="name" label="名称"></s:textfield>
		<s:textfield name="bom.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
	</s:form>
		<a href="bom!list.action">back</a>
</body>
</html>
