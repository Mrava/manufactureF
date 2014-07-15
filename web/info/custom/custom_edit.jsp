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
	function inputValid(){
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
  
<body onLoad="load()"> 
<div class="listtit">
	<h2></h2>
	<b>用户添加</b>
	<a href="custom!list.action">返 回</a>
</div>
<div class="line"></div>

<s:form action="custom" method="post" namespace="/" onsubmit="return inputValid()">
	<s:token></s:token>
	<s:hidden name="pojo.id"></s:hidden>
	<s:textfield name="pojo.name" id="name" label="客户名称"></s:textfield>
	<s:textfield name="pojo.remark" label="备注"></s:textfield>
	<s:submit method="save" value="保存"/>
</s:form>

</body>
</html>
