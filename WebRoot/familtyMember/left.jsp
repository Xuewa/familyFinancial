<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>普通家庭成员左菜单</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>

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
	<div class="lefttop"></div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>我的账户管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="index.html" target="rightFrame">添加账户</a><i></i></li>
        <li class="active"><cite></cite><a href="right.html" target="rightFrame">账户查看</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>日常收支管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">日常收支记账</a><i></i></li>
        <li><cite></cite><a href="#">日常收支查看</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="../images/leftico01.png" /></span>数据汇总</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">A</a><i></i></li>
        <li><cite></cite><a href="#">B</a><i></i></li>
        <li><cite></cite><a href="#">C</a><i></i></li>
        
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="../images/leftico03.png" /></span>个人信息管理</div>
    </dd>   
    
    </dl>
    
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
