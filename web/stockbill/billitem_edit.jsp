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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
</head>
  
<body> 
	<s:form action="stockBillItem" method="post" namespace="/">
		<s:token></s:token>
			日期；BomID；Bom名称；数量；客户; 单号; 备注；
		
		<br/>
		<input type="text" name="pojos[0].tdate" />
		<input type="text" name="pojos[0].itemId" />
		<input type="text" name="pojos[0].bom.name" />
		<input type="text" name="pojos[0].quantity" />
		<input type="text" name="pojos[0].client" />
		<input type="text" name="pojos[0].billno" />
		<input type="text" name="pojos[0].remark" />
		<br />
		<input type="text" name="pojos[1].tdate" />
		<input type="text" name="pojos[1].itemId" />
		<input type="text" name="pojos[1].bom.name" />
		<input type="text" name="pojos[1].quantity" />
		<input type="text" name="pojos[1].client" />
		<input type="text" name="pojos[1].billno" />
		<input type="text" name="pojos[1].remark" />
		<br />

		<s:submit method="insertBatch" value="保存"></s:submit>
	</s:form>

</body>
</html>
