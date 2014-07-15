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
	if (method == "insert")
	{
		if(error == 0)
			alert( "保存成功！");
		else if(error == 1)
			alert("代码已存在");
	}	
	
//检索input  事件加载 start
	var bom_code = document.getElementById("bom_code");
	var bom_numero = document.getElementById("bom_numero");
	var bom_name = document.getElementById("bom_name");
	
	bom_code.onkeyup = function(){
		getJ(event,{divid:'bb_stock2',inputid:'pojo_id',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByCode'});
		show('bb_stock2');
	}
	bom_code.onblur = function(){
		hidediv({divid:'bb_stock2',inputid:'pojo_id',numero:'bom_numero',code:'bom_code',name:'bom_name'});
	}
	
	
	bom_numero.onkeyup = function(){
		getJ(event,{divid:'bb_stock1',inputid:'pojo_id',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByNumero'});
		show('bb_stock1');
		
	}
	bom_numero.onblur = function(){
		hidediv({divid:'bb_stock1',inputid:'pojo_id',numero:'bom_numero',code:'bom_code',name:'bom_name'});
	}
	
	
	bom_name.onkeyup = function(){
		getJ(event,{divid:'bb_stock3',inputid:'pojo_id',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByName'});
		show('bb_stock3');
		
	}
	bom_name.onblur = function(){
		hidediv({divid:'bb_stock3',inputid:'pojo_id',numero:'bom_numero',code:'bom_code',name:'bom_name'});
	}
	
//检索input  事件加载 end
}
	
	function inputValid(){
		var pojo_id=document.getElementById("pojo_id").value;
		var bom_code=document.getElementById("bom_code").value;
		var quantity=document.getElementById("quantity").value;
		if(pojo_id=="" || pojo_id==null){
			alert("请选择BOM");
			return false;
		}else if(bom_code=="" || bom_code==null){
			alert("代码不能为空");
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
	<b>库存增加Stock</b>
	<a href="stock!list.action">返 回</a>
</div>
<div class="line"></div> 
	<div id="bb_stock1" class="bbsearch"></div>
	<div id="bb_stock2" class="bbsearch"></div>
	<div id="bb_stock3" class="bbsearch"></div>
	<s:form action="stock" method="post" namespace="/" onsubmit="return inputValid()">
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:hidden name="pojo.bomId" id="pojo_id" label="id"></s:hidden>
		<s:textfield name="%{pojo.bom.numero}" id="bom_numero" label="BOM编号" autocomplete="off"></s:textfield>
		<s:textfield name="%{pojo.bom.code}" id="bom_code" label="BOM代码" autocomplete="off"></s:textfield>
		<s:textfield name="%{pojo.bom.name}" id="bom_name" label="BOM名称" autocomplete="off"></s:textfield>
		
		<s:textfield name="pojo.quantity" id="quantity" label="数量"
		onkeypress = 'return /^\d$/.test(String.fromCharCode(event.keyCode))'
		oninput= 'this.value = this.value.replace(/\D+/g, "")'
		onpropertychange='if(!/\D+/.test(this.value)){return;};this.value=this.value.replace(/\D+/g, "")'
		onblur = 'this.value = this.value.replace(/\D+/g, "")'
		></s:textfield>
		<s:submit method="save" value="保存"/>
	</s:form>
</body>
</html>
