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
<link rel="stylesheet" type="text/css" href="/css/sub.css">
<script type="text/javascript">
	function load()
	{
		var msg="<s:text name='message.message' />";
		var isRight="<s:text name='message.error' />";
		if(isRight == 1){
			alert("供应商名称已存在！");
		}else if(isRight == 0){
			alert("保存成功");
		}	
	}
	function inputValid(){
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
  
<body onLoad="load()"> 
<div class="listtit">
	<h2></h2>
	<b>provider.insert</b>
	<a href="provider!list.action">返 回</a>
</div>
<div class="line"></div>

	<s:form action="provider" method="post" namespace="/"  onsubmit="return inputValid()">
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:textfield name="pojo.name"  id="name" label="供应商名称"></s:textfield>
		<s:textfield name="pojo.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
		
	</s:form>

</body>
</html>
