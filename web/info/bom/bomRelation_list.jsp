<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>My JSP 'more.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/css/sub.css">
<script type="text/javascript">
function add()
{
	var url = "/bomRelation!add.action?pojo.parentId=<s:text name='pojo.parentId' />";
	self.location = url;
}

function edit(id)
{
	var url = "/bomRelation!edit.action?pojo.id="+id;
	self.location = url;
}
	
function del(id)
{
	if (confirm("是否要删除?"))
	{
		var url = "/bomRelation!delete.action?pojo.id="+id;
		self.location = url;
	}
}
function load()
		{
			var method="<s:text name='message.method' />";
			var error="<s:text name='message.error' />";
			if(method=="delete" && error == 0)
				alert("删除成功！");
				
			else if (method == "update" && error == 0)
				alert("修改成功！");
 				
		}
function search()
{
	var searchText = document.getElementById("bomRelation_bomRelation_item").value;
	var url = "/bomRelation!find.action?bomRelation.item="+searchText;
	self.location = url;			
}

</script>
</head>
  
<body onLoad="load()"> 

<div class="listtit">
	<h3></h3>
	<b>BOM原料列</b>
	<span>
		<input type="hidden" name="pojo.parentId" />
		<input type="text" name="bomRelation.item" id="bomRelation_bomRelation_item" value="输入关键字" onFocus="this.value=''"/>
		<i id="bomRelation__find" onClick="find()"></i>
	</span>
	<a href="/bom!list.action">返 回</a>
	<a href="javascript:add()" style="margin-right:20px;">添 加</a>	

	
</div>


	
	
	
	
<div class="listcon">
	<table cellpadding="1" cellspacing="1" bgcolor="#cbcbcb">
	  <tr>
	  	<td class="titletd"></td>
	  	<td class="titletd">父类编号</td>
	  	<td class="titletd">父类代码</td>
	  	<td class="titletd">父类名称</td>
	    <td class="titletd">子类编号</td>
	    <td class="titletd">子类代码</td>
	    <td class="titletd">子类名称</td>
	    <td class="titletd">数量</td>
		<td class="titletd">操作</td>
	  </tr>

		<s:iterator value="dataList" status="it" >
			<tr>
				<td><s:property value="#it.index+1" /></td>
				<td><s:property value="parent.numero" /></td>
				<td><s:property value="parent.code" /></td>
				<td><s:property value="parent.name" /></td>
				<td><s:property value="item.numero" /></td>
				<td><s:property value="item.code" /></td>
				<td><s:property value="item.name" /></td>
				<td><s:property value="quantity"/></td>
				<td class="td_control">
				<a href="javascript:edit('<s:property value="id" />')" class="view">修改</a>
				<a href="javascript:del('<s:property value="id" />')">删除</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
</body>
</html>
