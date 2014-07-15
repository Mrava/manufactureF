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

<link rel="stylesheet" type="text/css" href="/css/sub.css">
<script type="text/javascript" src="/js/lib/jquery.js"></script>
<script type="text/javascript" src="/js/jeff.js"></script>
	
<script type="text/javascript">
function loadthis(){
	//setindexHeight();
}
function add(parentId)
{
	var url = "/editMenu!add.action?pojo.parentId="+parentId;
	self.location = url;
}
function edit(id,idx)
{
	var url = "/editMenu!edit.action?pojo.id=" + id + "&pojo.idx=" + idx;
	self.location = url;
}

function dels(id,parentId)
{
	var url = "/editMenu!dels.action?pojo.id=" + id+"&pojo.parentId="+parentId;
	if (confirm("是否要删除?"))
		self.location = url;
}
function del(id)
{
	var url = "/editMenu!delete.action?pojo.id=" + id;
	if (confirm("是否要删除?"))
		self.location = url;
}
</script>

</head>

<body onload="loadthis()"> 

<div class="listtit">
	<h3></h3>
	<b>左目录编辑</b>
	<a href="javascript:add(-1)">增加二级标签</a>		
	<a href="javascript:add(0)" style="margin-right:10px;">增加一级标签</a>
	
	
</div>
<center>
	
	<div class="listcon">
	<table cellpadding="1" cellspacing="1" bgcolor="#cbcbcb">
	  	<tr>
			<td class="titletd">一级标签：</td>
			<td class="titletd">操作：</td>
			<td class="titletd">二级标签 + 操作：</td>
		</tr>
		<s:iterator value="dataList" var="data">
		<tr>
			<td>
				<s:property value="name"/>
			</td>
			<td>
				<a href="javascript:edit('<s:property value="#data.id" />','<s:property value="#data.idx" />')" class="view">修改</a>
				&nbsp;&nbsp;
				<a href="javascript:dels('<s:property value="#data.id" />','<s:property value="#data.parentId" />')">删除</a>
			</td>
			<td>
				<table cellpadding="1" cellspacing="1" bgcolor="#cbcbcb">
					<s:iterator value="menuList" var="menu">
					<s:if test="#menu.parentId==#data.id">
					<tr>
					<td width="120"><s:property value="name"/></td>
					<td>
					<a href="javascript:edit('<s:property value="#menu.id" />','<s:property value="#menu.idx" />')" class="view">修改</a>
					&nbsp;&nbsp;
					<a href="javascript:del('<s:property value="#menu.id" />')">删除</a>
					</td>
					</tr>
					</s:if>
					</s:iterator>
					<tr>
					<td></td>
					<td><a href="javascript:add('<s:property value="#data.id" />')">添加</a></td>
					</tr>
				</table>
			</td>
		</tr>
		</s:iterator>
	</table>	
	</div>
</center>


</body>
</html>

