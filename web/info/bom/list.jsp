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
	var url = "/bom!add.action";
	self.location = url;
}

function edit(id)
{
	var url = "/bom!edit.action?bom.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/bom!delete.action?bom.id="+id;
	self.location = url;
}
function more(code)
{
	var url = "/bomRelation!list.action?bomRelation.code="+code;
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
	<br>bom.list<br>
	
	<s:form action="bom" method="post" namespace="/">
		<s:submit method="add" value="添加"></s:submit>
	</s:form>	

	
	<s:form action ="bom" method="post" namespace="/">
		<s:textfield name="bom.name"/>
		<s:submit method="find" value="查找"></s:submit>
	</s:form>
	

	<table border="1" >
		<tr>
			<td>代码</td>
			<td>名称</td>
			<td>备注</td>	
		</tr>	
	<s:iterator value="bomList" >
		<tr>
			<td><s:property value="code"/></td>
			<td><s:property value="name"/></td>
			<td><s:property value="remark"/></td>
			<td><input type="button" onclick="edit(<s:property value="id" />)" value="修改" /></td>
			<td><input type="button" onclick="del(<s:property value="id" />)" value="删除"/></td>
			<td><input type="button" onclick="more('<s:property value="code" />')" value="更多"/></td> 
		</tr>
	</s:iterator>
	</table>
</body>
</html>
