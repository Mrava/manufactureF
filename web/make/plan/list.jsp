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
	var url = "/make!add.action";
	self.location = url;
}

function edit(id)
{
	var url = "/make!edit.action?makeplan.id="+id;
	self.location = url;
}
	
function del(id)
{	alert(id);
	var url = "/make!delete.action?makeplan.id="+id;
	self.location = url;
}
</script>
</head>
  
<body> 
	<br>makeplan.list<br>
	


	<table border="1" >
	<s:iterator value="makeplanList" >
		<tr>
			
			<td><s:property value="id"/></td>
			<td><s:property value="indexId"/></td>
			<td><s:property value="bomCode"/></td>
			<td><s:property value="quantity"/></td>
			<td><s:property value="TDate"/></td>
			<td><input type="button" onclick="edit(<s:property value="id" />)" value="edit" /></td>
			<td><input type="button" onclick="del(<s:property value="id" />)" value="delete"/></td> 
		</tr>
	</s:iterator>
	</table>
</body>
</html>
