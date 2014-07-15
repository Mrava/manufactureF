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
function load()
{
	
}
 				
function find()
{
	var searchText = document.getElementById("bomRelation_bomRelation_item").value;
	var url = "/bomMeterial!find.action?searchContext="+searchText;
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
		<input type="text" name="data.item" id="bomRelation_bomRelation_item" value="输入关键字" onFocus="this.value=''"/>
		<i id="bomRelation__find" onClick="find()"></i>
	</span>
	<a href="/bom!list.action" style="margin-right:20px;">返 回</a>
	
</div>

	
	
	
<div class="listcon">
	<table cellpadding="1" cellspacing="1" bgcolor="#cbcbcb">
	  <tr>
	  	<td class="titletd"></td>
	  	<td class="titletd">代码</td>
		<td class="titletd">名称</td>
	    <td class="titletd">子类代码</td>
	    <td class="titletd">子类名称</td>
	    <td class="titletd">数量</td>
	  </tr>

		<s:iterator value="dataList" status="it" >
			<tr>
				<td><s:property value="#it.index+1" /></td>
				<td><s:property value="parent.code" /></td>
				<td><s:property value="parent.name" /></td>
				<td><s:property value="item.code"/></td>
				<td><s:property value="item.name"/></td>
				<td><s:property value="quantity"/></td>
			</tr>
		</s:iterator>
	</table>
</div>
</body>
</html>
