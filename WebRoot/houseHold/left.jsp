<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>家长左菜单</title>
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
        <li><cite></cite><a href="Account_add.jsp" target="rightFrame">添加账户</a><i></i></li>
        <li><cite></cite><a href="Account_list?userID=<s:property value='#parameters.userID' />" target="rightFrame">账户查看</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>日常收支管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="UsualActivity_add.jsp" target="rightFrame">日常收支记账</a><i></i></li>
        <li><cite></cite><a href="UsualActivity_list?userID=<s:property value='#parameters.userID' />" target="rightFrame">日常收支查看</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="../images/leftico01.png" /></span>债务管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="Loan_add.jsp" target="rightFrame">添加贷款信息</a><i></i></li>
        <li><cite></cite><a href="Loan_list" target="rightFrame">查看所有贷款</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="../images/leftico01.png" /></span>数据汇总</div>
    <ul class="menuson">
        <li><cite></cite><a href="UACountMonth_monthCount?userID=<s:property value='#parameters.userID' />&role=<s:property value='#parameters.role' />" target="rightFrame">月度统计</a><i></i></li>
        <li><cite></cite><a href="UACountMonth_yearCount?userID=<s:property value='#parameters.userID' />&role=<s:property value='#parameters.role' />" target="rightFrame">年度统计</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="../images/leftico03.png" /></span>个人信息管理</div>
     <ul class="menuson">
        <li><cite></cite><a href="User_loadByID?user.userID=<s:property value='#parameters.userID' />" target="rightFrame">我的资料查看</a><i></i></li>
    </ul>
    </dd>   
    
    </dl>
    
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
