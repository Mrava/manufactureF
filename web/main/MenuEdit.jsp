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
<link rel="stylesheet" type="text/css" href="/css/sub.css"></link>
<script type="text/javascript">
	
</script>
</head>
  
<body onload="load()">
<div class="listtit">
	<h2></h2>
	<b>菜单编辑</b>
	<a href="editMenu!list.action">返 回</a>
</div>
<div class="line"></div> 

	<s:form action="editMenu" method="post" namespace="/" onsubmit="">
		<s:token></s:token>
		<s:if test="pojo.parentId < 0 || pojo.id > 100  ">
			<s:select list="dataList" listValue="name" listKey="id" name="pojo.parentId" label="一级菜单">
			</s:select>
		</s:if>
		
		<s:hidden name="pojo.id"></s:hidden>
		<s:hidden name="pojo.idx"></s:hidden>
		
		<s:if test="pojo.parentId >= 0 && pojo.id < 100">
			<s:hidden name="pojo.parentId"></s:hidden>
		</s:if>
		
		<s:if test="pojo.parentId != 0">
			<s:textfield name="pojo.url" id="url" label="地址"></s:textfield>
		</s:if>
		
		<s:textfield name="pojo.name" id="name" label="名称"></s:textfield>
		<s:submit method="save" value="保存"/>
	</s:form>
</body>
</html>
