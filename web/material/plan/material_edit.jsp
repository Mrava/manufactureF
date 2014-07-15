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
<script type="text/javascript" src="/js/lib/jquery.js"></script>
<script type="text/javascript" src="/js/jeff.js"></script>
<script type="text/javascript">
function load()
{
	var method="<s:text name='message.method' />";
	var error="<s:text name='message.error' />";
	if(method=="insert" && error == 0){
		document.getElementById("bomCode").value = "";
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
	var bom_code = document.getElementById("bom_code");
	var bom_numero = document.getElementById("bom_numero");
	var bom_name = document.getElementById("bom_name");
	
	bom_code.onkeyup = function(){
		getJ(event,{divid:'bb_material2',inputid:'bomCode',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByCode'});
		show('bb_material2');
	};
	bom_code.onblur = function(){
		hidediv({divid:'bb_material2',inputid:'bomCode',numero:'bom_numero',code:'bom_code',name:'bom_name'});
	};
	
	
	bom_numero.onkeyup = function(){
		getJ(event,{divid:'bb_material1',inputid:'bomCode',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByNumero'});
		show('bb_material1');
		
	};
	bom_numero.onblur = function(){
		hidediv({divid:'bb_material1',inputid:'bomCode',numero:'bom_numero',code:'bom_code',name:'bom_name'});
	};
	
	
	bom_name.onkeyup = function(){
		getJ(event,{divid:'bb_material3',inputid:'bomCode',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByName'});
		show('bb_material3');		
	};
	bom_name.onblur = function(){
		hidediv({divid:'bb_material3',inputid:'bomCode',numero:'bom_numero',code:'bom_code',name:'bom_name'});
	};
	
//检索input  事件加载 end
}
	
	function inputValid(){
		var bomCode=document.getElementById("bomCode").value;
		var bom_code=document.getElementById("bom_code").value;
		var tdate=document.getElementById("tdate").value;
		var quantity=document.getElementById("quantity").value;
		if(bomCode==null || bomCode==""){
			alert("请选择BOM");
			return false;
		}else if(bom_code==null || bom_code==""){
			alert("代码不能为空");
			return false;
		}else if(tdate==null || tdate==""){
			alert("日期不能为空");
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
	<b>原料计划.insert</b>
	<a href="/materialPlan!list.action">返 回</a>
</div>
<div class="line"></div> 
	<div id="bb_material1" class="bbsearch"></div>
	<div id="bb_material2" class="bbsearch"></div>
	<div id="bb_material3" class="bbsearch"></div>
	<s:form action="materialPlan" method="post" namespace="/" onsubmit="return inputValid()">
		<div >
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:hidden name="pojo.bomId" id="bomCode" label="bomId"></s:hidden>
		<s:textfield value="%{pojo.bom.numero}" id="bom_numero" label="BOM编号" autocomplete="off"></s:textfield>
		<s:textfield value="%{pojo.bom.code}" id="bom_code" label="BOM代码" autocomplete="off"></s:textfield>
		<s:textfield value="%{pojo.bom.name}" id="bom_name" label="BOM名称" autocomplete="off"></s:textfield>
		
		<s:textfield name="pojo.quantity" id="quantity" label="数量"
		onkeypress = 'return /^\d$/.test(String.fromCharCode(event.keyCode))'
		oninput= 'this.value = this.value.replace(/\D+/g, "")'
		onpropertychange='if(!/\D+/.test(this.value)){return;};this.value=this.value.replace(/\D+/g, "")'
		onblur = 'this.value = this.value.replace(/\D+/g, "")'></s:textfield>
		
		<s:textfield name="pojo.tdate" id="tdate" label="日期" >
			<s:param name="value"><s:date name="pojo.tdate" format="yyyy-MM-dd" /></s:param>
		</s:textfield>
		
		<s:submit method="save" value="保存"/>
		</div>
	</s:form>

</body>
</html>
