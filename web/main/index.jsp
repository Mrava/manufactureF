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

<link rel="stylesheet" type="text/css" href="/css/style.css" />

<script type="text/javascript" src="/js/lib/jquery.js"></script>
<script type="text/javascript" src="/js/jeff.js"></script>
	
<script type="text/javascript">
function loadthis(){
	//setindexHeight();
}
</script>

</head>

<body onload="loadthis()"> 
<div class="top_wrap">
	<div class="top">
	  <div class="logo"></div>
	  <div class="userinfo">
	  	<b></b>
		<span>
			admin<br />
			2014-5-14 &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">注销</a>
		</span>
	  </div>
	</div>
</div>

<div class="con_left" id="con_left" style="overflow:auto;">
	<s:set name="idx" value="-1" />
				
	<s:iterator value="list" var="lts" status="its">
		<div class="leftmenu">
				<i class="jian" id="b<s:property value='#lts.idx'/>" onclick="changmenu(<s:property value='idx'/>)"></i>
				<b><s:property value="name"/></b>
					<span id="submenu<s:property value='#lts.idx'/>">
						<s:iterator value="menuList"  var="menulist" status="menuits">
							<s:if test="#menulist.parentId==#lts.id">
								<s:set name="idx" value="#idx + 1" />
									<a href="javascript:iframeSrc('<s:property value='url'/>')" onclick="checkedlist(<s:property value='#idx'/>),this.blur()"><s:property value="name"></s:property></a>
							</s:if>
						</s:iterator>
					</span>
		</div>
	</s:iterator>
</div>

<div class="con_right" id="con_right">
	<iframe src="/main/welcome.jsp" frameborder="0" width="100%" height="99%" id="iframecon" name="iframecon"></iframe>
</div>


</body>
</html>

