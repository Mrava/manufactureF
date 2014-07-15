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
function add()
{
	var url = "/provider!add.action";
	self.location = url;
}

function edit(id)
{
	var url = "/provider!edit.action?provider.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/provider!delete.action?provider.id="+id;
	self.location = url;
}

function load()
		{
			var msg="<s:text name='message.message' />";
			var isRight="<s:text name='message.error' />";
			if(isRight == 0){
				alert(msg);
				}
				
		}
</script>
</head>
  
<body onload="load()"> 
	<br>provider.list<br>
	
	<s:form action="provider" method="post" namespace="/">
		<s:submit method="add" value="添加"></s:submit>
	</s:form>	

	
	<s:form action ="provider" method="post" namespace="/">
		<s:textfield name="provider.name"/>
		<s:submit method="find" value="查找"></s:submit>
	</s:form>
	

	<table border="1" >
		<tr>
			<td>供应商名称</td>
			<td>备注</td>
		</tr>	
	<s:iterator value="providerList" >
		<tr>
			
			<td><s:property value="name"/></td>
			<td><s:property value="remark"/></td>
			<td><input type="button" onclick="edit(<s:property value="id" />)" value="修改" /></td>
			<td><input type="button" onclick="del(<s:property value="id" />)" value="删除"/></td> 
		</tr>
	</s:iterator>
	</table>
</body>
</html>
