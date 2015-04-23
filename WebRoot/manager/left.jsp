<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员的左菜单</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<!--<script language="JavaScript" src="js/jquery.js"></script>  -->

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><!--<span></span>--></div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>用户信息管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="manager/User_add.jsp" target="rightFrame">录入用户信息</a><i></i></li>
        <li><cite></cite><a href="manager/User_list" target="rightFrame">用户信息查看</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>收支类别管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="manager/ItemCategory_addInput" target="rightFrame">添加收支类别</a><i></i></li>
        <li><cite></cite><a href="manager/ItemCategory_list" target="rightFrame">收支类别查看</a><i></i></li>
    </ul>     
  </dd> 

    </dl>
    
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>