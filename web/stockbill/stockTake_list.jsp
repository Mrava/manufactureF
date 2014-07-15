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
	
	
<script type="text/javascript">
function add()
{
	var url = "/stockBought!add.action";
	self.location = url;
}

function edit(id)
{
	var url = "/stockBought!edit.action?pojo.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/stockBought!delete.action?pojo.id="+id;
	self.location = url;
}

function find()
{
	var searchText = document.getElementById("searchText").value;
	var url = "/stockBought!search.action?searchContext="+searchText;
	self.location = url;			
}

</script>
</head>
  
<body> 
<div class="listtit">
	<h3></h3>
	<b>进货入库</b>
	<span>
		<input type="text" id="searchText" value="输入关键字" onFocus="this.value=''"/>
		<i onClick="find()"></i>
	</span>
	<a href="javascript:add()">添 加</a>	
	
</div>

<div class="listcon">
	<table cellpadding="1" cellspacing="1" bgcolor="#cbcbcb">
	<tr>
			<td></td>
			<td>BOM编号</td>
			<td>BOM代码</td>
			<td>BOM名称</td>
			<td>数量</td>
			<td>日期</td>
			<td>备注</td>
			<td></td>
	</tr>
		
	<s:iterator value="dataList" status="it" >
		<tr>
			<td><s:property value="#it.index+1"/></td>
			<td><s:property value="bom.numero"/></td>
			<td><s:property value="bom.code"/></td>
			<td><s:property value="bom.name"/></td>
			<td><s:property value="quantity"/></td>
			<td><s:date name="tdate" format="yyyy-MM-dd"/></td>
			<td><s:property value="remark"/></td>
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
