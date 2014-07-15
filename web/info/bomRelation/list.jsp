<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'more.jsp' starting page</title>
    
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
	var url = "/bomRelation!add.action?bomRelation.code=<s:text name='bomRelation.code' />";
	
	self.location = url;
}

function edit(id)
{
	var url = "/bomRelation!edit.action?bomRelation.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/bomRelation!delete.action?bomRelation.id="+id;
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
	<br>bomRelation.list<br>
	
	<input type="button" onclick="add()" value="添加" />
	
	<s:form action ="bomRelation" method="post" namespace="/">
		<s:textfield name="bomRelation.name"/>
		<s:submit method="find" value="查找"></s:submit>
	</s:form>
	

	<table border="1" >
		<tr>
			<td>代码</td>
			<td>子类代码</td>
			<td>数量</td>
		</tr>	
		<s:iterator value="bomRelationList" >
			<tr>
				<td><s:property value="code"/></td>
				<td><s:property value="item"/></td>
				<td>m<s:property value="quantity"/></td>
				<td><input type="button" onclick="edit(<s:property value="id" />)" value="修改" /></td>
				<td><input type="button" onclick="del(<s:property value="id" />)" value="删除"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
