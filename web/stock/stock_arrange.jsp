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
function load()
{

}
function find()
{
	var searchText = document.getElementById("searchText").value;
	var url = "/stockArrange!find.action?searchContext="+searchText;
	self.location = url;			
}
</script>
</head>
  
<body onload="load()"> 

<div class="listtit">
	<h3></h3>
	<b>实时库存</b>
	<span>
		<input type="text" id="searchText" value="输入关键字" onfocus="this.value=''"/>
		<i onclick="find()"></i>
	</span>
</div>


<div class="listcon_future">	

<table cellpadding="0" cellspacing="0">
<s:iterator value="dataList" >
<tr>		
	<td >
		<table cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3" class="titletd">物料代码</td>
		</tr>
		<tr>
			<td colspan="3" class="titletd0"><s:text name="bom.code" /></td>
		</tr>
		</table>
	</td>
	<td >
		<table cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3" class="titletd">物料名称</td>
		</tr>
		<tr>
			<td colspan="3" class="titletd0"><s:text name="bom.name" /></td>
		</tr>
		</table>
	</td>
	<td>
		<table cellpadding="0" cellspacing="0">
		<tr>
			<td class="titletd2">项目</td>
		</tr>
		<tr>
			<td class="titletd3">物料纳入</td>
		</tr>
		<tr>
			<td class="titletd3">物料纳入累计</td>
		</tr>
		<tr>
			<td class="titletd3">生产用料</td>
		</tr>
		<tr>
			<td class="titletd3">生产用料累计</td>
		</tr>
		<tr>
			<td class="titletd3">物料差异</td>
		</tr>
		</table>
	</td>
	<td>
		<table cellpadding="0" cellspacing="0">
		<tr>
			<td class="titletd2">期初库存</td>
		</tr>
		<tr>
		  <td>&nbsp;</td>
		</tr>
		<tr>
		  <td>&nbsp;</td>
		</tr>
		<tr>
		  <td>&nbsp;</td>
		</tr>
		<tr>
		  <td>&nbsp;</td>
		</tr>
		<tr>
			<td class="titletd1"><s:text name="quantity" /></td>
		</tr>
		</table>
	</td>
			
			<s:set name="sumQuantity" value="quantity" />
			<s:set name="sumBuying" value="0" />
			<s:set name="sumMaking" value="0" />
			<s:set name="sumTaking" value="0" />
			<s:iterator value="processes">
			<s:set name="sumBuying" value="#sumBuying + buying" />
			<s:set name="sumMaking" value="#sumMaking + making" />
			<s:set name="sumTaking" value="#sumTaking + taking" />
			<s:set name="sumQuantity" value="#sumQuantity + #sumBuying - #sumTaking" />						
			
	<td>	
		<table cellpadding="0" cellspacing="0">
		<tr>
			<td class="titletd4" style="background:#ff9900;"><s:date name="tdate" format="M.dd"/></td>
		</tr>
		<tr>
			<td class="titletd4"><s:text name="buying" /></td>
		</tr>
		<tr>
			<td class="titletd4"><s:text name="#sumBuying" /></td>
		</tr>
		<tr>
			<td class="titletd4"><s:text name="taking" /> </td>
		</tr>
		<tr>
			<td class="titletd4"><s:text name="#sumTaking" /> </td>
		</tr>
		<tr>
			<td class="titletd4"><s:text name="#sumQuantity" /> </td>
		</tr>
		</table>
	</td>
	
	</s:iterator>
</tr>
</s:iterator>
</table>		

</div>
 
</body>
</html>
