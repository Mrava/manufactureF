// JavaScript Document
//设置框架自适应高度
function setindexHeight(){
	var con_right = $("#con_right").height();
	$("#iframecon").height(con_right-5);
}


function iframeSrc(x){
	document.getElementById("iframecon").src = x;
}

function changmenu(x){
	var submenu = document.getElementById("submenu"+x);
	var bx = document.getElementById("b"+x);
	if(bx.className == "jian"){
		submenu.style.display = "none";
		bx.className = "jia";
	}else{
		submenu.style.display = "block";
		bx.className = "jian";
	}
	
	
/*
	for(var i=1;i<=2;i++)
	{
		if(i==x){
			document.getElementById("submenu"+i).style.display = "block";
			document.getElementById("b"+i).className = "jian";
		} else {
			document.getElementById("submenu"+i).style.display = "none";
			document.getElementById("b"+i).className = "jia";
		}
	}
*/
}


function checkedlist(x){
	var con_left = document.getElementById("con_left").getElementsByTagName("a");
	for(var i=0;i<=con_left.length-1;i++){
		if(x==i){
		con_left[i].style.backgroundColor = "#fff";
		con_left[i].style.color = "#003399"
		}else{
		con_left[i].style.backgroundColor = "";
		con_left[i].style.color = ""
		}
	}
}

//================================
//billitem_edit.jsp  ajax jquery input框检索
//event:event,divid:bb,inputid:itemId,numero:item_numero,code:item_code,name:item_name
//================================
/*
function getB(event,t,opt){
	var nodes = t.parentNode.parentNode;
	var divid = opt.divid; //插入表单DIV  ID
	var inputid = opt.inputid; //表单INPUT ID
	var code = opt.code; //代码
	var name = opt.name; //名称
	var indexBy = opt.indexBy; //检索类型
	var theval = nodes.getElementsByTagName("input")[2].value;
	var url = "bom!"+indexBy+".action?searchContext="+theval;

	$.ajax({
	   url: url,
	   success: function(data){
		   var text = data.split(",");
		   if(text[0]==1){
			   nodes.getElementsByTagName("input")[1].value = text[1];
		   }else{
			   nodes.getElementsByTagName("input")[1].value = '';
			   }
	   }
	});	
}
*/
function getJ_Bill(event,opt){
	var divid = opt.divid; //插入表单DIV  ID
	var inputid = opt.inputid; //表单INPUT ID
	var code = opt.code; //代码
	var name = opt.name; //名称
	var indexBy = opt.indexBy; //检索类型
	var theval,url;	
	if(indexBy=='indexByCode'){
		theval = $("#"+code).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
	}else if(indexBy=='indexByName'){
		theval = $("#"+name).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
	}else {
		theval = $("#"+code).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
		}
		
	if(event.keyCode!=13&&event.keyCode!=16&&event.keyCode!=38&&event.keyCode!=40){
			$.getJSON(url,function(data){
				var str = "<ul><li class='tit'><font>bomid</font><font>代码</font><font>名称</font></li>";
				$(data).each(function(i){
					str = str+"<li class='dat' onmousedown='changval_bill(\""+code+"\",\""+inputid+"\",\""+name+"\", \""+data[i].code+"\",\""+data[i].id+"\",\""+data[i].name+"\")'><font>"+data[i].id+"</font><font> "+data[i].code+"</font><font>"+data[i].name+"</font></li>";
				});
				str = str +"</ul>";
				$("#"+divid).html(str);
			});
	}
		
}

//替换input内容
function changval_bill(code,inputid,name,new_code,new_id,new_name){
	$("#"+inputid).val(new_id);
	$("#"+code).val(new_code);
	$("#"+name).val(new_name);
}


//================================
//billitem_edit.jsp   ajax jquery input框检索  结束
//================================


//================================
//ajax jquery input框检索
//event:event,divid:bb,inputid:itemId,numero:item_numero,code:item_code,name:item_name
//================================

function getJ(event,opt){
	var divid = opt.divid; //插入表单DIV  ID
	var inputid = opt.inputid; //表单INPUT ID
	var numero = opt.numero; //编码
	var code = opt.code; //代码
	var name = opt.name; //名称
	var indexBy = opt.indexBy; //检索类型
	var theval,url;	
	if(indexBy=='indexByCode'){
		theval = $("#"+code).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
	}else if(indexBy=='indexByName'){
		theval = $("#"+name).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
	}else if(indexBy=='indexByNumero'){
		theval = $("#"+numero).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
	}else {
		theval = $("#"+code).val();
		url = "/bom!"+indexBy+".action?searchContext="+theval;
		}
		
	
	if(event.keyCode!=13&&event.keyCode!=16&&event.keyCode!=38&&event.keyCode!=40){
		if(divid=='bb_make'){
			$.getJSON(url,function(data){
				var str = "<ul><li class='tit'><font>编码</font><font>代码</font><font>名称</font></li>";
				$(data).each(function(i){
					str = str+"<li class='dat' onmousedown='changval(\""+numero+"\",\""+code+"\",\""+inputid+"\",\""+name+"\",  \""+data[i].numero+"\",\""+data[i].code+"\",\""+data[i].id+"\",\""+data[i].name+"\"),getMaterial()'><font>"+data[i].numero+"</font><font> "+data[i].code+"</font><font>"+data[i].name+"</font></li>";
				});
				str = str +"</ul>";
				$("#"+divid).html(str);
			});
		} else {
			$.getJSON(url,function(data){
				var str = "<ul><li class='tit'><font>编码</font><font>代码</font><font>名称</font></li>";
				$(data).each(function(i){
					str = str+"<li class='dat' onmousedown='changval(\""+numero+"\",\""+code+"\",\""+inputid+"\",\""+name+"\",  \""+data[i].numero+"\",\""+data[i].code+"\",\""+data[i].id+"\",\""+data[i].name+"\")'><font>"+data[i].numero+"</font><font> "+data[i].code+"</font><font>"+data[i].name+"</font></li>";
				});
				str = str +"</ul>";
				$("#"+divid).html(str);
			});
		}
	}
	
}


//替换input内容
function changval(numero,code,inputid,name,new_numero,new_code,new_id,new_name){
	$("#"+inputid).val(new_id);
	$("#"+numero).val(new_numero);
	$("#"+code).val(new_code);
	$("#"+name).val(new_name);
}
function show(divid){
	//var awidths = $("#item_code").css("width");
	var offsetLefts = document.body.offsetWidth*0.5-99+"px";
	$('#'+divid).css({width:"500px",left:offsetLefts});
	if(divid=='bb_makeadd1' || divid=='bb_makeadd2' || divid=='bb_makeadd3'){
		$('#'+divid).css({width:"500px",left:"90px"});
	}
	$('#'+divid).show(200);
}
function hidediv(opt){
	if($('#'+opt.inputid).val()==''){
		if(opt.numero!=''||opt.numero==null) $('#'+opt.numero).val('');
		$('#'+opt.code).val('');
		$('#'+opt.name).val('');
		$('#'+opt.divid).hide();
	} else {
		$('#'+opt.divid).hide();
		}
}

//================================
//ajax jquery input框检索  结束
//================================


//================================
// 翻页  开始
//================================
function setPage(opt){
	var allPageNum = opt.allPageNum; //总的页数
	var showPageNum = 7; //显示的页数
	var curpageNum = opt.curpageNum; // 当前的页数
	var pageDIvBox = document.getElementById("page");
	var count = opt.count; // 总数据行数
	var sizes = opt.sizes; // 最大行数
	var kind = opt.kind; //子页名称
	
	
	//左边或右边显示页码的个数
	var lrNum = Math.floor(showPageNum/2); 
	if(opt.allPageNum < opt.curpageNum){
		alert("没有找到您输入的页面!");
		setPage({
			kind:kind,
			allPageNum:allPageNum, //总页数
			curpageNum:1, //当前页数
			count:count,
			sizes:sizes
		});
		self.location = "/"+kind+"!list.action?paper.count="+count+"&paper.current="+1+"&paper.size="+sizes;
		return false;
	}
	
	
	//页面数小于等于显示页面数时
	if(allPageNum <= showPageNum){
		showPageNum = allPageNum;
	}
	
	if(curpageNum>1){
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#1';
			oA.innerHTML = '首页'
			pageDIvBox.appendChild(oA);
	} else {
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#1';
			oA.innerHTML = '首页'
			pageDIvBox.appendChild(oA);
	}
	
	if(curpageNum>1){
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#'+(curpageNum-1);
			oA.innerHTML = '上一页'
			pageDIvBox.appendChild(oA);
	} else {
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#'+curpageNum;
			oA.innerHTML = '上一页'
			pageDIvBox.appendChild(oA);
	}
	
	if(curpageNum<showPageNum-2 || allPageNum == showPageNum){
		for(var i=1;i<=showPageNum;i++){
			var oA = document.createElement('a');
			oA.className = 'actpage';
			oA.href = '#'+i;
			if(curpageNum==i){
				oA.innerHTML = "<font color='#ff0000'>" + i + "</font>"	
			}else{
				oA.innerHTML =  i;	
			}		
			pageDIvBox.appendChild(oA);
		}	
	}else{
		//倒数第3页的处理
		if(allPageNum-curpageNum<lrNum && curpageNum == allPageNum-2){
			for(var i=1;i<=showPageNum;i++){
			//	console.log((curpageNum - showPageNum + i));
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ (curpageNum - (showPageNum-2) + i);
				if(curpageNum == (curpageNum - (showPageNum-2) + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - (showPageNum-2) + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum - (showPageNum-2) + i);
				}
				pageDIvBox.appendChild(oA);
			}
		} else 
		//倒数第2页的处理
		if(allPageNum-curpageNum<lrNum && curpageNum == allPageNum-1){
			for(var i=1;i<=showPageNum;i++){
			//	console.log((curpageNum - showPageNum + i));
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ (curpageNum - (showPageNum-1) + i);
				if(curpageNum == (curpageNum - (showPageNum-1) + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - (showPageNum-1) + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum - (showPageNum-1) + i);
				}
				pageDIvBox.appendChild(oA);
			}
		}
		//最后一页的处理
		else if(allPageNum-curpageNum<lrNum && curpageNum == allPageNum){
			for(var i=1;i<=showPageNum;i++){
			//	console.log((curpageNum - showPageNum + i));
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ (curpageNum - showPageNum + i);
				if(curpageNum == (curpageNum - showPageNum + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - showPageNum + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum-showPageNum + i);
				}
				pageDIvBox.appendChild(oA);
			}
		}else{
			for(var i=1;i<=showPageNum;i++){
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ 	(curpageNum - (showPageNum-lrNum) + i);
				if(curpageNum == (curpageNum - (showPageNum-lrNum) + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - (showPageNum-lrNum) + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum - (showPageNum-lrNum) + i);
				}
				pageDIvBox.appendChild(oA);
			}
		}
	}
	
	if(curpageNum<allPageNum){
		for(var i=1;i<=2;i++){
			if(i==1){
				var oA = document.createElement('a');
				oA.href='#'+(parseInt(curpageNum)+1);
				oA.className = 'btn_gopage';
				oA.innerHTML = '下一页'
			}else{
				var oA = document.createElement('a');
				oA.className = 'btn_gopage';
				oA.href='#'+allPageNum;
				oA.innerHTML = '尾页'

			}
			pageDIvBox.appendChild(oA);
		}
	} else {
		
		for(var i=1;i<=2;i++){
			if(i==1){
				var oA = document.createElement('a');
				oA.href='#'+(parseInt(curpageNum)+1);
				oA.className = 'btn_gopage';
				oA.innerHTML = '下一页'
			}else{
				var oA = document.createElement('a');
				oA.className = 'btn_gopage';
				oA.href='#'+allPageNum;
				oA.innerHTML = '尾页'

			}
			pageDIvBox.appendChild(oA);
		}
	
	}
	

	var oA = document.getElementById('page').getElementsByTagName('a');
	

	//给页码添加点击事件
	for(var i=0;i<oA.length;i++){
		oA[i].onclick = function(){
			
			//当前点的页码
			var sHref = this.getAttribute('href').substring(1);	
		//	if (searchText != "")
		
			var url="/"+kind+"!list.action?paper.count="+count+"&paper.current="+sHref+"&paper.size="+sizes;
		//	alert(url);
		//	url=url + "?paper.count=?paper.current=?+&searchContext=?";

			self.location = url;
			//清空页数显示
			pageDIvBox.innerHTML = '';
			setPage({
				kind:kind,//子页名称
				allPageNum:allPageNum, //总页数
				curpageNum:sHref, //当前页数
				count:count,
				sizes:sizes
			})
		}
	}
}


	//跳转到当前页
function gotopage(kind,allPageNum,count,sizes){
		var x = document.getElementById("gotopage").value;
		var y = document.getElementById("page");
		//var allPageNum = allPageNum;
		//获取url /allPageNum/ 值
		if(x<=allPageNum){
			y.innerHTML = '';
			setPage({
				kind:kind, //子页名称
				allPageNum:allPageNum, //总页数
				curpageNum:x , //当前页数
				count:count,
				sizes:sizes
			})
			
			var	url="/"+kind+"!list.action?paper.count="+count+"&paper.current="+x+"&paper.size="+sizes;
			self.location = url;
		} else {
		alert("输入页码过大.")	
		}
	}

//================================
// 翻页  结束
//================================

//================================
//   右上  翻页  开始
//================================
function setPage_up(opt){
	var allPageNum = opt.allPageNum; //总的页数
	var showPageNum = 7; //显示的页数
	var curpageNum = opt.curpageNum; // 当前的页数
	var pageDIvBox = document.getElementById("page_up");
	var count = opt.count; // 总数据行数
	var sizes = opt.sizes; // 最大行数
	var kind = opt.kind; //子页名称
	
	
	//左边或右边显示页码的个数
	var lrNum = Math.floor(showPageNum/2); 
	if(opt.allPageNum < opt.curpageNum){
		alert("没有找到您输入的页面!");
		setPage({
			kind:kind,
			allPageNum:allPageNum, //总页数
			curpageNum:1, //当前页数
			count:count,
			sizes:sizes
		});
		self.location = "/"+kind+"!list.action?paper.count="+count+"&paper.current="+1+"&paper.size="+sizes;
		return false;
	}
	
	
	//页面数小于等于显示页面数时
	if(allPageNum <= showPageNum){
		showPageNum = allPageNum;
	}
	
	if(curpageNum>1){
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#1';
			oA.innerHTML = '首页'
			pageDIvBox.appendChild(oA);
	} else {
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#1';
			oA.innerHTML = '首页'
			pageDIvBox.appendChild(oA);
	}
	
	if(curpageNum>1){
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#'+(curpageNum-1);
			oA.innerHTML = '上一页'
			pageDIvBox.appendChild(oA);
	} else {
		var oA = document.createElement('a');
			oA.className = 'btn_gopage';
			oA.href='#'+curpageNum;
			oA.innerHTML = '上一页'
			pageDIvBox.appendChild(oA);
	}
	
	if(curpageNum<showPageNum-2 || allPageNum == showPageNum){
		for(var i=1;i<=showPageNum;i++){
			var oA = document.createElement('a');
			oA.className = 'actpage';
			oA.href = '#'+i;
			if(curpageNum==i){
				oA.innerHTML = "<font color='#ff0000'>" + i + "</font>"	
			}else{
				oA.innerHTML =  i;	
			}		
			pageDIvBox.appendChild(oA);
		}	
	}else{
		//倒数第3页的处理
		if(allPageNum-curpageNum<lrNum && curpageNum == allPageNum-2){
			for(var i=1;i<=showPageNum;i++){
			//	console.log((curpageNum - showPageNum + i));
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ (curpageNum - (showPageNum-2) + i);
				if(curpageNum == (curpageNum - (showPageNum-2) + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - (showPageNum-2) + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum - (showPageNum-2) + i);
				}
				pageDIvBox.appendChild(oA);
			}
		} else 
		//倒数第2页的处理
		if(allPageNum-curpageNum<lrNum && curpageNum == allPageNum-1){
			for(var i=1;i<=showPageNum;i++){
			//	console.log((curpageNum - showPageNum + i));
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ (curpageNum - (showPageNum-1) + i);
				if(curpageNum == (curpageNum - (showPageNum-1) + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - (showPageNum-1) + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum - (showPageNum-1) + i);
				}
				pageDIvBox.appendChild(oA);
			}
		}
		//最后一页的处理
		else if(allPageNum-curpageNum<lrNum && curpageNum == allPageNum){
			for(var i=1;i<=showPageNum;i++){
			//	console.log((curpageNum - showPageNum + i));
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ (curpageNum - showPageNum + i);
				if(curpageNum == (curpageNum - showPageNum + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - showPageNum + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum-showPageNum + i);
				}
				pageDIvBox.appendChild(oA);
			}
		}else{
			for(var i=1;i<=showPageNum;i++){
				var oA = document.createElement('a');
				oA.className = 'actpage';
				oA.href = '#'+ 	(curpageNum - (showPageNum-lrNum) + i);
				if(curpageNum == (curpageNum - (showPageNum-lrNum) + i)){
					oA.innerHTML = "<font color='#ff0000'>"+(curpageNum - (showPageNum-lrNum) + i)+"</font>";
				}else{
					oA.innerHTML = (curpageNum - (showPageNum-lrNum) + i);
				}
				pageDIvBox.appendChild(oA);
			}
		}
	}
	
	if(curpageNum<allPageNum){
		for(var i=1;i<=2;i++){
			if(i==1){
				var oA = document.createElement('a');
				oA.href='#'+(parseInt(curpageNum)+1);
				oA.className = 'btn_gopage';
				oA.innerHTML = '下一页'
			}else{
				var oA = document.createElement('a');
				oA.className = 'btn_gopage';
				oA.href='#'+allPageNum;
				oA.innerHTML = '尾页'

			}
			pageDIvBox.appendChild(oA);
		}
	} else {
		
		for(var i=1;i<=2;i++){
			if(i==1){
				var oA = document.createElement('a');
				oA.href='#'+(parseInt(curpageNum)+1);
				oA.className = 'btn_gopage';
				oA.innerHTML = '下一页'
			}else{
				var oA = document.createElement('a');
				oA.className = 'btn_gopage';
				oA.href='#'+allPageNum;
				oA.innerHTML = '尾页'

			}
			pageDIvBox.appendChild(oA);
		}
	
	}
	

	var oA = document.getElementById('page_up').getElementsByTagName('a');
	

	//给页码添加点击事件
	for(var i=0;i<oA.length;i++){
		oA[i].onclick = function(){
			
			//当前点的页码
			var sHref = this.getAttribute('href').substring(1);	
		//	if (searchText != "")
		
			var url="/"+kind+"!list.action?paper.count="+count+"&paper.current="+sHref+"&paper.size="+sizes;
		//	alert(url);
		//	url=url + "?paper.count=?paper.current=?+&searchContext=?";

			self.location = url;
			//清空页数显示
			pageDIvBox.innerHTML = '';
			setPage_up({
				kind:kind,//子页名称
				allPageNum:allPageNum, //总页数
				curpageNum:sHref, //当前页数
				count:count,
				sizes:sizes
			})
		}
	}
}


	//跳转到当前页
function gotopage_up(kind,allPageNum,count,sizes){
		var x = document.getElementById("gotopage_up").value;
		var y = document.getElementById("page_up");
		//var allPageNum = allPageNum;
		//获取url /allPageNum/ 值
		if(x<=allPageNum){
			y.innerHTML = '';
			setPage_up({
				kind:kind, //子页名称
				allPageNum:allPageNum, //总页数
				curpageNum:x , //当前页数
				count:count,
				sizes:sizes
			})
			
			var	url="/"+kind+"!list.action?paper.count="+count+"&paper.current="+x+"&paper.size="+sizes;
			self.location = url;
		} else {
		alert("输入页码过大.")	
		}
	}

//================================
// 翻页  结束  右上
//================================

//execl字符串日期转换成 yyyy-mm-dd
function Todate(num) {
	//Fri Oct 31 18:00:00 UTC+0800 2008 
	num = num + ""; //给字符串后就一个空格
	var date = "";
	var month = new Array();
	month["Jan"] = 1; month["Feb"] = 2; month["Mar"] = 3; month["Apr"] = 4;

	month["May"] = 5; month["Jun"] = 6; month["Jul"] = 7; month["Aug"] = 8;

	month["Sep"] = 9; month["Oct"] = 10; month["Nov"] = 11; month["Dec"] = 12;
	var week = new Array();
	week["Mon"] = "一"; week["Tue"] = "二"; week["Wed"] = "三"; week["Thu"] = "四";

	week["Fri"] = "五"; week["Sat"] = "六"; week["Sun"] = "日";
	str = num.split(" "); //根据空格组成数组
	date = str[5] + "-"; //就是在2008的后面加一个“-”

	//通过修改这里可以得到你想要的格式
	date = date + month[str[1]] + "-" + str[2]; 
	//+str[3] 为时间;
	//date=date+" 周"+week[str[0]];
	return date;
}






