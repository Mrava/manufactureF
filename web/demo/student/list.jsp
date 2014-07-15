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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
<script type="text/javascript">
function add()
{
	var url = "/student!add.action";
	self.location = url;
}

function edit(id)
{
	var url = "/student!edit.action?student.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/student!delete.action?student.id="+id;
	self.location = url;
}

function valid_insert()
{
	
	return ture;
}

function valid_name_null()
{

}

</script>
</head>
  
<body> 
	<br>student.list<br>
	
	<s:form action="student" method="post" namespace="/">
		<s:submit method="add" value="add"></s:submit>
	</s:form>	
	
	<s:form action ="student" method="post" namespace="/">
		<s:textfield name="student.name"/>
		<s:submit method="find" value="find"></s:submit>
	</s:form>
	

	<table border="1" >
	<s:iterator value="studentList" >
		<tr>
			
			<td><s:property value="name"/></td>
			<td><s:property value="age"/></td>
			<td><s:property value="remark"/></td>
			<td><input type="button" onclick="edit(<s:property value="id" />)" value="edit" /></td>
			<td><input type="button" onclick="del(<s:property value="id" />)" value="delete"/></td> 
		</tr>
	</s:iterator>
	</table>
</body>
</html>
