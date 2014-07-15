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

<script type="text/javascript">

function load()
{

}
function find()
{
	var searchText = document.getElementById("searchText").value;
	var url = "/stockFucture!find.action?bom.name="+searchText;
	self.location = url;			
}


</script>
</head>
  
<body onLoad="load()"> 

<!-- 
<s:set name="bridge" value="1" ></s:set>

<s:if test="#bridge == message.error">

	<s:property value="message.message" />

</s:if>
 --> 

<div class="listtit">
	<h3></h3>
	<b>实时库存</b>
	<span>
		<input type="text" id="searchText" value="输入关键字" onFocus="this.value=''"/>
		<i onclick="find()"></i>
	</span>
	
</div>


<div class="listcon_future">	

<table cellpadding="0" cellspacing="0" bgcolor="#ffffff">
	<s:set name="bomId" value="0" />
	<s:set name="quantity" value="0" />
	<s:set name="tdate" value="0" />
				
	<s:iterator value="dataList" >
		
		<s:if test="#bomId != id.bomId && #bomId == 0">
			<tr>
		</s:if>
		<s:if test="#bomId != id.bomId && #bomId != 0">
		   </tr><tr>
		</s:if>
		
		<s:if test="#bomId != id.bomId">
			<s:set name="quantity" value="id.extant" />
			<s:set name="tdate" value="id.tdate" />
			<td>
				<table>
				<tr>
					<td class="titletd1" rowspan="4"><s:property value="bom.code"/></td>
				</tr>
				</table>
			</td>
			<td>
				
				<table>
				<tr>
					<td class="titletd2">库存</td>
				</tr>
				<tr>
					<td rowspan="3" class="titletd3"><s:property value="id.extant" /></td>
				</tr>
				</table>
			</td>
			<td>
				<table>
				<tr>
					<td class="titletd">增减</td>
				</tr>
				<tr>
					<td class="titletd">生产</td>
				</tr>
				<tr>
					<td class="titletd">到货</td>
				</tr>
				<tr>
					<td class="titletd">用料</td>
				</tr>
				<tr>
					<td class="titletd">浮动</td>
				</tr>
				</table>
			</td>
		</s:if>
		<s:if test="#bomId == id.bomId">
			<td>
				<table class="future_dataTable" cellpadding="1" cellspacing="1">
				<tr>
					<td class="titletd4"><s:date name="id.tdate" format="M.dd" /></td>
				</tr>
				<s:if test="id.stockType == 1">
					<tr>
						<td><s:property value="id.make"/> </td>
					</tr>
					<tr>
						<td><s:property value="id.bought"/> </td>
					</tr>
					<tr>
						<td><s:property value="id.used"/> </td>
					</tr>
					
					
					<s:if test="id.tdate >= #tdate" >
						<s:set name="quantity" value="#quantity + id.make" />
						<s:set name="quantity" value="#quantity + id.bought" />
						<s:set name="quantity" value="#quantity - id.used" />
						<tr>
							<td><s:property value="#quantity"/></td>
						</tr>	
					</s:if>
					<s:else>
						<tr>
							<td>&nbsp;</td>
						</tr>	
					</s:else>
					
				</s:if> 
				
				</table>
			</td>
		</s:if>
		
		
		<s:set name="bomId" value="id.bomId" />
	</s:iterator>
	</tr>
</table>

</div>
 
</body>
</html>
