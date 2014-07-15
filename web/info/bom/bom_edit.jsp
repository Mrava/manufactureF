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
<link rel="stylesheet" type="text/css" href="/css/sub.css"></link>
<script type="text/javascript">
	function load()
	{
		showError();	
	}
	
	function inputValid(){
		var name=document.getElementById("name").value;
		var code=document.getElementById("code").value;
		var typeId=document.getElementById("typeId").value;
		var numero=document.getElementById("numero").value;
		
		if(name=="" || name==null){
			alert("名称不能为空");
			return false;
		}else if(code=="" || code==null){
			alert("代码不能为空");
			return false;
		}else if(numero=="" || numero==null){
			alert("编号不能为空");
			return false;
		}else if(typeId=="" || typeId==null){
			alert("类型不能为空");
			return false;
		}else{
			return true;
		}
	}
	
	function showError()
	{
		var method="<s:text name='message.method' />";
		var error="<s:text name='message.error' />";
		if (method == "save")
		{
			if(error == 0)
				alert( "保存成功！");
			else if(error == 1)
				alert("代码已存在");
		}
	}
</script>
</head>
  
<body onload="load()">
<div class="listtit">
	<h2></h2>
	<b>BOM编辑</b>
	<a href="bom!list.action">返 回</a>
</div>
<div class="line"></div> 

	<s:form action="bom" method="post" namespace="/" onsubmit="return inputValid()">
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:textfield name="pojo.numero" id="numero" label="编号"></s:textfield>
		<s:textfield name="pojo.code" id="code" label="代码"></s:textfield>
		<s:textfield name="pojo.name" id="name" label="名称"></s:textfield>
		<s:select name="pojo.typeId" label="类型" list="typeList"  headerKey="-1" headerValue="--请选择..." listKey="id" listValue="name"></s:select>
		<s:textfield name="pojo.remark" label="备注"></s:textfield>
		<s:submit method="save" value="保存"/>
	</s:form>
</body>
</html>
