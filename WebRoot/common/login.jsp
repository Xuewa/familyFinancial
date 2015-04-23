<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录家庭理财系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<!--<script language="JavaScript" src="js/jquery.js"></script>  -->
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
		$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
		$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		}) 
		
		$('.loginbtn').click(function(){
			var userName=$('.loginuser').val();
			var password=$('.loginpwd').val();
			
			if(userName!=''&&password!='') {
				//alert('转入验证');//?????
				//location.href = 'loginAction?user.userName='+userName+'&user.password='+password;
				//location.href = '';
				return true;
			}else if(userName=='') {
				alert('请输入用户名');
				$('.loginuser').focus();
				return false;
			}else if(password==''){
				alert('请输入密码');
				$('.loginpwd').focus();
				return false;
			}
		})
	});  
	

</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录家庭理财系统</span>    
    <ul>
    <li><a href="#">首页</a></li>
    <li><a href="#">帮助</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">

    <form action="loginAction" method="post">
    	<ul>
    		<li><input name="user.userName"id="loginuser" type="text" class="loginuser" value="" onclick="JavaScript:this.value=''" /></li>
    		<li><input name="user.password" id="loginpwd" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li>
    		<li><input type="submit" class="loginbtn" value="登录"/><SPAN style="color:red;display:inline;margin-left:30px"><s:if test="msg!=null"><s:text name="msg"></s:text></s:if></SPAN></li>
    		
    	</ul>
    </form>
    
    
    </div>
    
    </div>
    
    <div class="loginbm">版权所有  2013  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>
	
    
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>