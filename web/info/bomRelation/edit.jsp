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
			var item=document.getElementById("item").value;
			var code=document.getElementById("code").value;
			var quantity=document.getElementById("quantity").value;
			if(code=="" || code==null){
				alert("代码不能为空");
				return false;
			}else if(item=="" || item==null){
				alert("子类代码不能为空");
				return false;
			}else if(quantity=="" || quantity==null){
				alert("数量不能为空");
				return false;
			}else if(!quantity.match("^[0-9]*$")){
				alert("数量只能为数字");
				return false;	
			
			}else{
				return true;
			}
		}
	</script>
	
</head>
  
<body onload="load()"> 
	<br>bomRelation.insert<br>
	<s:form action="bomRelation" method="post" namespace="/" onsubmit="return onloads()">
		<s:token></s:token>
		<s:hidden name="bomRelation.id"></s:hidden>
		<s:textfield name="bomRelation.code" id="code"  label="代码"  readonly="true"></s:textfield>
		<s:textfield name="bomRelation.item" id="item" label="子类代码"></s:textfield>
		<s:textfield name="bomRelation.quantity" id="quantity" label="数量"></s:textfield>
		<s:submit method="save" value="保存"/>
		
	</s:form>
		<a href="/bomRelation!list.action?bomRelation.code=<s:text  name='bomRelation.code'/>" > back</a>
</body>
</html>
