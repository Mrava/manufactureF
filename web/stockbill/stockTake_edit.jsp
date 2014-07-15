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
<script type="text/javascript" src="/js/jeff.js"></script>	
<script type="text/javascript" src="/js/lib/jquery.js"></script>	
<script type="text/javascript">
var num = 1; //记数参数
function addtr(){
	var tbmain = document.getElementById("tbmain");
	var i = tbmain.rows.length;
	var x = tbmain.insertRow(i);
	
	x.insertCell(0).innerHTML = "<input type='text' name='pojos["+num+"].tdate' />";
	x.insertCell(1).innerHTML = "<input type='text' name='pojos["+num+"].itemId' id='bill_id_"+num+"' />";
	x.insertCell(2).innerHTML = "<input type='text' name='pojos["+num+"].code' id='bill_code_"+num+"' class='searchcode' onkeyup=\"getJ_Bill(event,{divid:'billdiv',inputid:'bill_id_"+num+"',code:'bill_code_"+num+"',name:'bill_name_"+num+"',indexBy:'indexByCode'}),show('billdiv')\" onblur=\"hidediv({divid:'billdiv',inputid:'bill_id_"+num+"',code:'bill_code_"+num+"',name:'bill_name_"+num+"'})\" />"
	x.insertCell(3).innerHTML = "<input type='text' name='pojos["+num+"].bom.name' id='bill_name_"+num+"' />";
	x.insertCell(4).innerHTML = "<input type='text' name='pojos["+num+"].quantity' />";
	x.insertCell(5).innerHTML = "<input type='text' name='pojos["+num+"].client' />";
	x.insertCell(6).innerHTML = "<input type='text' name='pojos["+num+"].billno' />";
	x.insertCell(7).innerHTML = "<input type='text' name='pojos["+num+"].remark' />";
	x.insertCell(8).innerHTML = "<input type='button' value='删'  onclick='deltr(this)' />";
	num = num+1;
}
function deltr(r){
	var i=r.parentNode.parentNode.rowIndex;
	document.getElementById("tbmain").deleteRow(i);
}

function readexecl(){ 
var material = document.getElementById("quantity_table1").parentNode;
var tempStr = "<div id='quantity_table1'><table cellpadding='0' cellspacing='0' id='tbmain'><tr><td class='tit'>日期</td><td class='tit'>BomID</td><td class='tit'>Bom代码</td><td class='tit'>Bom名称</td><td class='tit'>数量</td><td class='tit'>客户</td><td class='tit'>单号</td><td class='tit'>备注</td><td class='tit'></td></tr>"; 
var filePath= document.getElementById("upfile").value; 
var oXL = new ActiveXObject("Excel.application"); 
var oWB = oXL.Workbooks.open(filePath); 
oWB.worksheets(1).select(); 
var oSheet = oWB.ActiveSheet; 

try{ 
	for(var i=2;i<=oSheet.UsedRange.Rows.Count;i++){ 

		var a1 = oSheet.Cells(i,1).value==null?"无数据":Todate(oSheet.Cells(i,1).value);
		var a2 = oSheet.Cells(i,2).value==null?"无数据":oSheet.Cells(i,2).value;
		var a3 = oSheet.Cells(i,3).value==null?"无数据":oSheet.Cells(i,3).value;
		var a4 = oSheet.Cells(i,4).value==null?"无数据":oSheet.Cells(i,4).value;
		var a5 = oSheet.Cells(i,5).value==null?"无数据":oSheet.Cells(i,5).value;
		var a6 = oSheet.Cells(i,6).value==null?"无数据":oSheet.Cells(i,6).value;
		var a7 = oSheet.Cells(i,7).value==null?"无数据":oSheet.Cells(i,7).value;
		var a8 = oSheet.Cells(i,8).value==null?"无数据":oSheet.Cells(i,8).value; 
		
		tempStr+=("<tr><td>"+a1+"</td><td id='bomid_"+i+"'></td><td>"+a2+"</td><td>"+a3+"</td><td>"+a4+"</td><td>"+a6+"</td><td>"+a7+"</td><td>"+a8+"<td><input type='button' value='删'  onclick='deltr(this)'/></td></tr>"); 
	}
	tempStr += "</table></div>";
} 
catch(e){ 
//alert(e); 
material.innerHTML = tempStr;
} 
	material.innerHTML = tempStr;   	
	oXL.Quit(); 
	CollectGarbage();
	
	intExecl();//处理导入EXECL表
} 

function intExecl(){
	var tbmain = document.getElementById("tbmain");
	for(var i=2;i<=tbmain.rows.length;i++){
		var bomid_td = document.getElementById("bomid_"+i);
		var code_td = bomid_td.parentNode.getElementsByTagName("td")[2].innerHTML;
	    var url = "bom!getIdByCode.action?searchContext="+code_td;
			$.ajax({
			   url: url,
			   spanid: i,
			   success: function(data){
				   var text = data.split(",");
				   var bomid_td1 = document.getElementById("bomid_"+this.spanid);
				   if(text[0]==1){
						bomid_td1.innerHTML = text[1];
				   }else if(text[0]>1){
						bomid_td1.innerHTML = ">1";
				   }else {
						bomid_td1.innerHTML = "=0";
				   }
			   }
			});	
	}
}

function loadkeyup(){
$(".searchcode").keyup(function(){
	getB(event,this,{divid:'billitem',inputid:'billitemId',code:'billitem_code',name:'billitem_name',indexBy:'getIdByCode'});
});
}
function loadThis(){
	
}
</script>
</head>
  
<body onload="loadThis()"> 
<div class="listtit">
	<h2></h2>
	<b>库存增加</b>
	<a href="stockBillItem!list.action">返 回</a>
</div>
<div class="line"></div> 
	<div class="controlbar">
	<input type="button" value="增加一行" onclick="addtr()" style="float:left;">
	<input type="file" id="upfile" style="float:right;margin-right:10px;" onchange="readexecl()" /> 
	</div>

	<s:form action="stockBillItem" method="post" namespace="/">
		<s:token></s:token>
		<tr><td>
		
		<div id="quantity_table1">
		  <table cellpadding='0' cellspacing='0' id="tbmain">
		    <tr>
		      <td class='tit'>日期</td>
		      <td class='tit'>BomID</td>
		      <td class='tit'>Bom代码</td>
		      <td class='tit'>Bom名称</td>
		      <td class='tit'>数量</td>
		      <td class='tit'>客户</td>
		      <td class='tit'>单号</td>
		      <td class='tit'>备注</td>
			  <td class='tit'>&nbsp;</td>
		    </tr>
		    <tr>
		      <td><input type="text" name="pojos[0].tdate" /></td>
		      <td><input type="text" name="pojos[0].itemId" id="bill_id_0" /></td>
		      <td>
			  <input type="text" name="pojos[0].bom.code" id="bill_code_0" class="searchcode" onkeyup="getJ_Bill(event,{divid:'billdiv',inputid:'bill_id_0',code:'bill_code_0',name:'bill_name_0',indexBy:'indexByCode'}),show('billdiv')" onblur="hidediv({divid:'billdiv',inputid:'bill_id_0',code:'bill_code_0',name:'bill_name_0'})"/>
			  <div id="billdiv" class="bbsearch"></div>
			  </td>
		      <td><input type="text" name="pojos[0].bom.name" id="bill_name_0" /></td>
		      <td><input type="text" name="pojos[0].quantity" /></td>
		      <td><input type="text" name="pojos[0].client" /></td>
		      <td><input type="text" name="pojos[0].billno" /></td>
		      <td><input type="text" name="pojos[0].remark" /></td>
			  <td><input type="button" value="删"  onclick="deltr(this)"/></td>
		    </tr>
		  </table>
		  </div>
		  </td>
		  </tr>
		  <s:submit method="insertBatch" value="保存"></s:submit>
	</s:form>

</body>
</html>
