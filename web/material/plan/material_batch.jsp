<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.text.*" %>
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
var n=1;
function addtr(){
	var tbmain = document.getElementById("tbmain");
	var i = tbmain.rows.length;
	var x = tbmain.insertRow(i);
	
	x.insertCell(0).innerHTML = "<input type='text' style='display:none;' name='pojos["+n+"].id' value='"+n+"'/><input type='text' name='pojos["+n+"].bomId' id='bomCode_"+n+"' />";
	
	//x.insertCell(2).innerHTML = "<input type='text' name='pojos["+n+"].bom.code' id='bom_code_"+n+"' />";
	
	x.insertCell(1).innerHTML = "<input type='text' name='pojos["+n+"].code' id='bom_code_"+n+"' class='searchcode' onkeyup=\"getJ_Bill(event,{divid:'billdiv',inputid:'bomCode_"+n+"',code:'bom_code_"+n+"',name:'bom_name_"+n+"',indexBy:'indexByCode'}),show('billdiv')\" onblur=\"hidediv({divid:'billdiv',inputid:'bomCode_"+n+"',code:'bom_code_"+n+"',name:'bom_name_"+n+"'})\" />"
	
	x.insertCell(2).innerHTML = "<input type='text' name='pojos["+n+"].bom.name' id='bom_name_"+n+"'/>";
	x.insertCell(3).innerHTML = "<input type='text' name='pojos["+n+"].bom.numero' id='bom_numero_"+n+"'/>";
	x.insertCell(4).innerHTML = "<input type='text' name='pojos["+n+"].quantity' />";
	x.insertCell(5).innerHTML = "<input type='text' name='pojos["+n+"].tdate' value='<s:date name='pojo.tdate' format='yyyy-MM-dd' />' />";
	x.insertCell(6).innerHTML = "<input type='button' value='删'  onclick='deltr(this)' />";
	n= n+1;
	
	
}

function deltr(r){
	var i=r.parentNode.parentNode.rowIndex;
	document.getElementById("tbmain").deleteRow(i);
}


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
}

function readexecl()
{ 
	var material = document.getElementById("quantity_table1").parentNode;
	var tempStr = "<div id='quantity_table1'><table cellpadding='0' cellspacing='0' id='tbmain'>"+
		"<tr> <td class='tit' style='display:none;'></td>"+
			"<td class='tit' style='display:none;'></td>"+
			"<td class='tit'>BOM编号</td>"+
			"<td class='tit'>BOM代码</td>"+
			"<td class='tit'>BOM名称</td>"+
			"<td class='tit'>数量</td>"+
			"<td class='tit'>日期</td>"+
			"<td class='tit'>&nbsp;</td></tr>";
	var filePath= document.getElementById("upfile").value; 
	var oXL = new ActiveXObject("Excel.application"); 
	var oWB = oXL.Workbooks.open(filePath); 
	oWB.worksheets(1).select(); 
	var oSheet = oWB.ActiveSheet; 
	try{ 
		var m = 0;
		var date ;
		for(var j=7; j<=oSheet.UsedRange.Columns.Count; j++){	
			for(var i=5;i<=oSheet.UsedRange.Rows.Count;i++){ 
				var a2 = oSheet.Cells(i,2).value==null?"无数据":oSheet.Cells(i,2).value;
				var a3 = oSheet.Cells(i,3).value==null?"无数据":oSheet.Cells(i,3).value;
				var a4 = oSheet.Cells(i,4).value==null?"无数据":oSheet.Cells(i,4).value;
				var a6 = oSheet.Cells(4,j).value==null?"无数据":Todate(oSheet.Cells(4,j).value);
			
				var a5 = oSheet.Cells(i,j).value;
				if (a5 == null || a5 == 0)
					continue;
				m = m + 1;
				tempStr += ("<tr> <td  style='display:none;'><input type='hidden' name='pojos["+(m-1)+"].id' value='"+(m-1)+"'></td>"+
				"<td  id='bomid_"+ m +"'><input type='text' name='pojos["+(m-1)+"].bomId' value='1'></td>"+
				"<td ><input type='text' name='pojos["+(m-1)+"].bom.numero' value="+a2+" ></td>"+
				"<td ><input type='text' name='pojos["+(m-1)+"].bom.code' value="+a3+" ></td>"+
				"<td ><input type='text' name='pojos["+(m-1)+"].bom.name' value="+a4+" ></td>"+
				"<td ><input type='text' name='pojos["+(m-1)+"].quantity' value="+a5+" ></td>"+
				"<td ><input type='text' name='pojos["+(m-1)+"].tdate' value="+a6+"></td>"+
				"<td >&nbsp;</td></tr>");
			//var a = oSheet.Cells(i,8).value.toString()=="undefined"?"":oSheet.Cells(i,8).value; 
			//tempStr+=("<tr><td>"+Todate(oSheet.Cells(i,1).value)+"</td><td>"+oSheet.Cells(i,2).value+"</td><td>"+oSheet.Cells(i,3).value+"</td><td>"+oSheet.Cells(i,4).value+"</td><td>"+oSheet.Cells(i,5).value+"</td><td>"+oSheet.Cells(i,6).value+"</td><td>"+oSheet.Cells(i,8).value+"<td><input type='button' value='删'  onclick='deltr(this)'/></td></tr>"); 
			//加入input中
			//tempStr+=("<tr><td><input type='text' value='"+oSheet.Cells(i,1).value+"' /></td><td><input type='text' value='"+oSheet.Cells(i,2).value+"' /></td><td><input type='text' value='"+oSheet.Cells(i,3).value+"' /></td><td><input type='text' value='"+oSheet.Cells(i,4).value+"' /></td><td><input type='text' value='"+oSheet.Cells(i,5).value+"' /></td><td><input type='text' value='"+oSheet.Cells(i,6).value+"' /></td><td><input type='text' value='"+oSheet.Cells(i,8).value+"' /><td><input type='button' value='删'  onclick='deltr(this)'/></td></tr>"); 
			}
		}
	tempStr += "</table></div>";
	} catch(e){ 
	//alert(e); 
	material.innerHTML = tempStr;
	} 
	material.innerHTML = tempStr;  oXL.Quit(); 
	intExecl();//处理导入EXECL表
} 

function intExecl()
{
	var tbmain = document.getElementById("tbmain");
	for(var i=2;i<=tbmain.rows.length;i++){
		var bomid_td = document.getElementById("bomid_"+(i-1));
		var code_td = bomid_td.parentNode.getElementsByTagName("input")[3].value;
		var idd = bomid_td.parentNode.getElementsByTagName("input")[2].value;
	    var url = "bom!getIdByCode.action?searchContext="+code_td;
			$.ajax({
			   url: url,
			   spanid: i-1,
			   success: function(data){
				   //alert(data);
				   var text = data.split(",");
				   var bomid_td1 = document.getElementById("bomid_"+this.spanid);
				   if(text[0]==0){
						bomid_td1.parentNode.getElementsByTagName("input")[1].value = this.spanid;
				   }else if(text[0]>1){
						bomid_td1.parentNode.getElementsByTagName("input")[1].value = text[1];
				   }else {
					   bomid_td1.parentNode.getElementsByTagName("input")[1].value = text[1];
				   }
			   }
			});	
	}
} 

</script>
</head>
  
<body > 
<div class="listtit">
	<h2></h2>
	<b>批量原料计划.insert</b>
	<a href="/materialPlan!list.action">返 回</a>
</div>
<div class="line"></div> 
	<div class="controlbar">
	<input type="button" value="增加一行" onclick="addtr()" style="float:left;">
	
	<input type="button" onClick="readexecl();" value="读取"  style="float:right;">
	<input type="file" id="upfile" style="float:right;margin-right:10px;" /> 
	
	</div>
	<div id="bb_material1" class="bbsearch"></div>
	<div id="bb_material2" class="bbsearch"></div>
	<div id="bb_material3" class="bbsearch"></div>
	<s:form action="materialPlan" method="post" namespace="/">
		<s:token></s:token>		
		<tr><td>
		<div id="quantity_table1">
		  <table cellpadding='0' cellspacing='0' id="tbmain">
		    <tr>
		      
		      <td class='tit'>BOM编号</td>
		      <td class='tit'>BOM代码</td>
		      <td class='tit'>BOM名称</td>
			  <td class='tit'>编码</td>
		      <td class='tit'>数量</td>
		      <td class='tit'>日期</td>
			  <td class='tit'>&nbsp;</td>
		    </tr>
		    <tr>
		      <td><input type="hidden" name="pojos[0].id" /><input type="text" name="pojos[0].bomId" id="bomCode_0"/></td>
		      <td>
			  <input type="text" name="pojos[0].bom.code" id="bom_code_0" class="searchcode" onkeyup="getJ_Bill(event,{divid:'billdiv',inputid:'bomCode_0',code:'bom_code_0',name:'bom_name_0',indexBy:'indexByCode'}),show('billdiv')" onblur="hidediv({divid:'billdiv',inputid:'bomCode_0',code:'bom_code_0',name:'bom_name_0'})"/>
			  <div id="billdiv" class="bbsearch"></div>
			  </td>
  		      <td><input type="text" name="pojos[0].bom.name" id="bom_name_0"/></td>
			  <td><input type="text" name="pojos[0].bom.numero" id="bom_numero_0"/></td>
		      <td><input type="text" name="pojos[0].quantity" /></td>
		      <td><input type="text" name="pojos[0].tdate" value="<s:date name="pojo.tdate" format="yyyy-MM-dd" />"/></td>
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
