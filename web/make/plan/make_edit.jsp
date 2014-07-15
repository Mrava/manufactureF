<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
function getMaterial() {
	var parentId = document.getElementById("bomId").value;
	if (parentId != "") {
		$.ajax({
			url : "/bomMaterial!findByParentId.action?pojo.parentId="+ parentId,
			success : showMaterial
		});
	}
}

function showMaterial(result)
{
	var data = jQuery.parseJSON(result);
	var material = document.getElementById("quantity_table");
	var quantity = document.getElementById("quantity").value;
	var html = "";
	if(data==null || data==""){
		html += "<div style='clear:both;' id='quantity_table'>无</div>";
	} else if(quantity==""){
		html += "<div style='clear:both;' id='quantity_table'>无</div>";
	} else {
		html += "<div style='clear:both;' id='quantity_table'>";
		html += "<table cellpadding='0' cellspacing='0'><tr><td class='tit'></td><td class='tit'>代码</td><td class='tit'>名称</td><td class='tit'>单位用量</td><td class='tit'>计算用量</td><td class='tit'>计划用量</td></tr>";
		for(var i =0; i<data.length; i++)
		{
			html += "<tr>";
			html += "<td><input type='hidden' name='materials["+i+"].bomId' value='"+data[i].itemId+"'></input></td>";
			html += "<td><input class='quantity' type='text' readonly='true' value='"+data[i].item.code+"'></input></td>";
			html += "<td><input class='quantity' type='text' readonly='true' value='"+data[i].item.name+"'></input></td>";
			html += "<td><input class='quantity' type='text' name='materials["+i+"].unit' readonly='true' value='"+data[i].quantity+"'></input></td>";
			html += "<td><input class='quantity' type='text' readonly='true' value='"+data[i].quantity*quantity+"'></input></td>";
			html += "<td><input class='quantity' name='materials["+i+"].quantity' value='"+data[i].quantity*quantity+"' /></td>";
			html += "</tr>";
		}
		html += "</table>";
		html += "</div>";
	}
	material.innerHTML = html;
}

function showMaterialUpdate() {
	var material = document.getElementById("quantity_table");
	var html = "<table>";
	html += "<tr> <td class='tit'>代码</td> <td class='tit'>BOM名称</td> <td class='tit'>单位用量</td> <td class='tit'>计算用量</td> <td class='tit'>生产用量</td> </tr>";
	<s:iterator value="materials" status="it">
		html += "<tr>";
		html += "<input type='hidden' class='quantity' name='materials[" + <s:property value='#it.index' /> + "].indexId' value='" + <s:text name='indexId' /> + "' />";
		html += "<input type='hidden' class='quantity' name='materials[" + <s:property value='#it.index' /> + "].bomId' value='" + <s:text name='bomId' /> + "' />";
		html += "<td><input class='quantity' readonly='true' value='<s:text name='bom.code' />' /></td>";
		html += "<td><input class='quantity' readonly='true' value='<s:text name='bom.name' />' /></td>";
		html += "<td><input class='quantity' readonly='true' name='materials[" + <s:property value='#it.index' /> + "].unit' value='<s:text name='unit' />' /></td>";
		html += "<td><input class='quantity' readonly='true' value='" + <s:text name='planUnit' /> + "' /></td>";
		html += "<td><input class='quantity' name='materials[" + <s:property value='#it.index' /> + "].quantity' value='" + <s:text name='quantity' /> + "' /></td>";
		html += "</tr>";
	</s:iterator>
	html += "</table>";
	material.innerHTML = html;
}

function load() {
	var method = "<s:text name='message.method' />";
	var error = "<s:text name='message.error' />";
	if (method == "insert" && error == 0) {
		document.getElementById("bomCode").value = "";
		document.getElementById("quantity").value = "";
		alert("保存成功！");
	} else if (method == "insert" && error == 1) {
		alert("记录已存在");
	} else if (method == "update" && error == 1) {
		alert("记录已存在");
	}

	if (method == "edit")
		showMaterialUpdate();
}

function inputValid() {
	var bomId = document.getElementById("bomId").value;
	var bom_code = document.getElementById("bom_code").value;
	var tdate = document.getElementById("tdate").value;
	var quantity = document.getElementById("quantity").value;
	if (bomId == null || bomId == "") {
		alert("请选择BOM");
		return false;
	} else if (bom_code == null || bom_code == "") {
		alert("代码不能为空");
		return false;
	} else if (tdate == null || tdate == "") {
		alert("日期不能为空");
		return false;
	} else if (quantity == null || quantity == "") {
		alert("数量不能为空");
		return false;
	} else if (!quantity.match("^[0-9]*$")) {
		alert("数量只能为数字");
		return false;
	} else {
		return true;
	}
}
</script>
</head>

<body onload="load()">
	<div class="listtit">
		<h2></h2>
		<b>生产计划--编辑</b>
		<a href="/makePlan!list.action">返回</a>
	</div>
	<div class="line"></div>
	<div id="bb_make" class="bbsearch"></div>
	<s:form action="makePlan" method="post" namespace="/" onsubmit="return inputValid()">
		<s:token></s:token>
		<s:hidden name="pojo.id"></s:hidden>
		<s:hidden name="pojo.bomId" id="bomId" label="BomId"></s:hidden>
		<s:textfield value="%{pojo.bom.numero}" id="bom_numero" label="BOM编号"></s:textfield>
		<s:textfield value="%{pojo.bom.code}" id="bom_code" label="BOM代码"
			onkeyup="getJ(event,{divid:'bb_make',inputid:'bomId',numero:'bom_numero',code:'bom_code',name:'bom_name',indexBy:'indexByCode'}),show('bb_make')"
			onblur="hidediv({divid:'bb_make',inputid:'bomId',numero:'bom_numero',code:'bom_code',name:'bom_name'})"
			autocomplete="off"></s:textfield>
		<s:textfield value="%{pojo.bom.name}" id="bom_name" label="BOM名称"></s:textfield>

		<s:textfield name="pojo.tdate" id="tdate" label="日期">
			<s:param name="value">
				<s:date name="pojo.tdate" format="yyyy-MM-dd" />
			</s:param>
		</s:textfield>

		<s:textfield name="pojo.quantity" id="quantity" label="数量"
			onkeypress='return /^\d$/.test(String.fromCharCode(event.keyCode))'
			oninput='this.value = this.value.replace(/\D+/g, "")'
			onpropertychange='if(!/\D+/.test(this.value)){return;};this.value=this.value.replace(/\D+/g, "")'
			onblur='this.value = this.value.replace(/\D+/g, "")' onkeyup='getMaterial()'>
		</s:textfield>

		<tr>
			<td>原料：</td>
			<td>
				<div  id="quantity_table"  style="border:none;"></div>
			</td>
		</tr>

		<s:submit method="save" vale="保存" />

	</s:form>


</body>
</html>
