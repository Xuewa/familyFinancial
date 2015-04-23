<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆后欢迎页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<!--<script language="JavaScript" src="js/jquery.js"></script>  -->
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b><s:property value="#parameters.userName" />，您好，欢迎使用家庭理财系统</b><s:if test='{#parameters.email.length()>0}'>(<s:property value="''.equals(#parameters.email)"/>)</s:if>
    
    </div>
    <s:if test="#parameters.lastLoginTime.length()>0">
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：<s:property value="#parameters.lastLoginTime" /></i>
    </div></s:if> 
    
    <div class="xline"></div>
   
    <div class="welinfo"></div>
    </div>
    
    

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
