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
<link rel="stylesheet" type="text/css" href="/css/sub.css">
<script type="text/javascript" src="/js/jeff.js"></script>
<script type="text/javascript">
function add()
{
	var url = "/user!add.action";
	self.location = url;
}

function edit(id)
{	
	var url = "/user!edit.action?pojo.id="+id;
	self.location = url;
}
	
function del(id)
{
	var url = "/user!delete.action?pojo.id="+id;
	self.location = url;
}

function find()
{
	var searchText = document.getElementById("searchTexts").value;
	var url = "/user!search.action?searchContext="+searchText;
	self.location = url;			
}

function loadPaper()
{
	var current = <s:text name="paper.current" />;	//当前页
	var count = <s:text name="paper.count" />;	//总行数
	var maxs = <s:text name="paper.max" />; //最大页码
	var sizes = <s:text name="paper.size" />; //每页显示行数
	var kind = 'user';
	if(maxs==0){
		//alert("没有相关数据!");
		return false;
		}
	setPage({
		kind:kind, //子页名称
		allPageNum:maxs,    //最大页码
		curpageNum:current, //当前页数
		count:count,        //总行数
		sizes:sizes		//最大行数
	});
}

function load()
{
			var msg="<s:text name='message.message' />";
			var isRight="<s:text name='message.error' />";
			if(isRight == 0)
			{
				alert("删除成功！");
			}
			//var searchText=document.getElementById("searchTexts");
			//searchText.innerHTML=searchText.value;
			
			loadPaper();

	

}


</script>
</head>
  
<body onload="load()"> 

<div class="listtit">
	<h3></h3>
	<b>user.list</b>
	<span>
		<input type="text" id="searchTexts" value="输入关键字" onFocus="this.value=''"/>
		<i onclick="find()"></i>
	</span>
	<a href="javascript:add()">添 加</a>	
	
</div>
<div class="listcon">
	

	<table cellpadding="1" cellspacing="1" bgcolor="#cbcbcb">
		<tr>
			<td class="titletd"></td>
			<td class="titletd">用户名</td>
			<td class="titletd">备注</td>
			<td class="titletd"></td>
		</tr>
	
	
		<s:iterator value="dataList" status="it">
			<tr>
				<td><s:property value="#it.index+1"/></td>
				<td><s:property value="username"/></td>
				<td><s:property value="remark"/></td>
				<td>
				<a href="javascript:edit('<s:property value="id" />')" class="view">修改</a>
				<a href="javascript:del('<s:property value="id" />')">删除</a>
				</td> 
				
				
			</tr>
		</s:iterator>
	
	</table>
	
<div class="gopage" style="margin-right:10px;">
	<div id="page" style="float:left;margin-top:3px;" ></div>
	<input type="text" size=3 id="gotopage" 
	onkeypress = 'return /^\d$/.test(String.fromCharCode(event.keyCode))'
	oninput= 'this.value = this.value.replace(/\D+/g, "")'
	onpropertychange='if(!/\D+/.test(this.value)){return;};this.value=this.value.replace(/\D+/g, "")'
	onblur = 'this.value = this.value.replace(/\D+/g, "")' />
	<b onclick="gotopage('user',<s:text name='paper.max' />,<s:text name='paper.count' />,<s:text name="paper.size" />)" class="btn_gopage" >G0</b>
	<span>总数：<s:text name='paper.count' /> ，共 <s:text name="paper.max" /> 页</span>
</div>
</div>
</body>
</html>
