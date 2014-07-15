<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	

<script type="text/javascript" language="javascript" src="/js/lib/jquery.js" ></script>	
	
<script type="text/javascript">


function student()
{
	$.ajax({
		type: "post", 
		url: "/bomMaterial!findByParentId.action",
		data: "pojo.parentId=140" ,
		success: showResult 
	});
	
}

function student2()
{
	alert("test2");	
}

function showResult(result)
{
	alert(result);
	var obj = jQuery.parseJSON(result);
	
	var list = document.getElementById("list");
	list.innerHTML = "<input value='test' type='button' />";
}

</script>
</head>
  
<body > 

	<input value="ajax" type="button" onclick="student();" /> 
	
	<div id="list">
		
	
	</div>
</body>
</html>
