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
	var url = "/user!add.action";
	self.location = url;
}

function edit(id)
{
	var url = "/user!edit.action?user.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/user!delete.action?user.id="+id;
	self.location = url;
}
function load()
{
			var msg="<s:text name='message.message' />";
			var isRight="<s:text name='message.error' />";
			if(isRight == 0)
			{
				alert(msg);
			}
				
}

</script>
</head>
  
<body onload="load()"> 
	<br>user.list<br>
	
	<s:form action="user" method="post" namespace="/">
		<s:submit method="add" value="添加"></s:submit>
	</s:form>	


	
	<s:form action ="user" method="post" namespace="/">
		<s:textfield name="user.username"/>
		<s:submit method="find" value="查找"></s:submit>
	</s:form>
	

	<table border="1" >
		<tr>
			<td>用户名</td>
			<td>备注</td>
		</tr>	
	
	<s:iterator value="userList" >
		<tr>
			
			<td><s:property value="username"/></td>
			<td><s:property value="remark"/></td>
			<td><input type="button" onclick="edit(<s:property value="id" />)" value="修改" /></td>
			<td><input type="button" onclick="del(<s:property value="id" />)" value="删除"/></td> 
		</tr>
	</s:iterator>
	</table>
</body>
</html>
