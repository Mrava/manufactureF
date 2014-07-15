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
<script type="text/javascript" src="/js/lib/jquery.js"></script>
<script type="text/javascript" src="/js/jeff.js"></script>
<script type="text/javascript">
function load()
{
	var method="<s:text name='message.method' />";
	var error="<s:text name='message.error' />";
	if(method=="insert" && error == 0){
		document.getElementById("itemId").value = "";
		document.getElementById("quantity").value = "";
		alert("保存成功！");
	}	
	else if (method=="insert" && error==1)
	{
		alert("记录已存在");
	}
	else if (method=="update" && error==1)
	{
		alert("记录已存在");
	}
	
//检索input  事件加载 start
	var item_code = document.getElementById("item_code");
	var item_numero = document.getElementById("item_numero");
	var item_name = document.getElementById("item_name");
	
	item_code.onkeyup = function(){
		getJ(event,{divid:'bb_item2',inputid:'itemId',numero:'item_numero',code:'item_code',name:'item_name',indexBy:'indexByCode'});
		show('bb_item2');
	}
	item_code.onblur = function(){
		hidediv({divid:'bb_item2',inputid:'itemId',numero:'item_numero',code:'item_code',name:'item_name'});
	}
	
	
	item_numero.onkeyup = function(){
		getJ(event,{divid:'bb_item1',inputid:'itemId',numero:'item_numero',code:'item_code',name:'item_name',indexBy:'indexByNumero'});
		show('bb_item1');
	}
	item_numero.onblur = function(){
		hidediv({divid:'bb_item1',inputid:'itemId',numero:'item_numero',code:'item_code',name:'item_name'});
	}
	
	
	item_name.onkeyup = function(){
		getJ(event,{divid:'bb_item3',inputid:'itemId',numero:'item_numero',code:'item_code',name:'item_name',indexBy:'indexByName'});
		show('bb_item3');	
	}
	item_name.onblur = function(){
		hidediv({divid:'bb_item3',inputid:'itemId',numero:'item_numero',code:'item_code',name:'item_name'});
	}
	
//检索input  事件加载 end	
}
	
	function inputValid(){
		var itemId=document.getElementById("itemId").value;
		var code=document.getElementById("item_code").value;	
		var quantity=document.getElementById("quantity").value;
		if(code==null || code==""){
			alert("子类代码不能为空");
			return false;
		}else if(itemId==null || itemId==""){
			alert("请选择子类代码");
			return false;
		}else if(quantity==null || quantity==""){
			alert("数量不能为空");
			return false;
		}else if(!quantity.match("^[0-9]*$")){
			alert("数量只能为数字");
			return false;	
		}else{
			return true;
		}
	}
</script>

</head>
  
<body onload="load()">
<div class="listtit">
	<h2></h2>
	<b>BOM原料编辑</b>
	<a href="/bomRelation!list.action?pojo.parentId=<s:text name='pojo.parentId'/>" >返 回</a>
</div>
<div class="line"></div>  
	<div id="bb_item1" class="bbsearch"></div>
	<div id="bb_item2" class="bbsearch"></div>
	<div id="bb_item3" class="bbsearch"></div>
	<s:form action="bomRelation" method="post" namespace="/" onsubmit="return inputValid()">
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:hidden name="pojo.parentId"></s:hidden>
		<s:textfield value="%{pojo.parent.numero}" id="parent.numero" label="父类编号"  readonly="true"></s:textfield>
		<s:textfield value="%{pojo.parent.code}" id="parent.code" label="父类代码"  readonly="true"></s:textfield>
		<s:textfield value="%{pojo.parent.name}" id="parent.name" label="父类名称"  readonly="true"></s:textfield>
		
		<s:hidden name="pojo.itemId" id="itemId"  label="item.key"></s:hidden>
		<s:textfield value="%{pojo.item.numero}" id="item_numero" label="子类编码" autocomplete="off"></s:textfield>
		
		<s:textfield value="%{pojo.item.code}" id="item_code" label="子类代码" autocomplete="off"></s:textfield>
		<s:textfield value="%{pojo.item.code}" id="item_name" label="子类名称" autocomplete="off"></s:textfield>
		
		<s:textfield name="pojo.quantity" id="quantity" label="数量"
		onkeypress = 'return /^\d$/.test(String.fromCharCode(event.keyCode))'
		oninput= 'this.value = this.value.replace(/\D+/g, "")'
		onpropertychange='if(!/\D+/.test(this.value)){return;};this.value=this.value.replace(/\D+/g, "")'
		onblur = 'this.value = this.value.replace(/\D+/g, "")'></s:textfield>
		<s:submit method="save" value="保存"/>
		
	</s:form>

</body>
</html>
