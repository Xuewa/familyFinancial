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
<title>用户录入</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script type ="text/javascript" src="js/myJS/User_add.js"></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>用户信息管理</li>
    <li>录入用户信息</li>
    </ul>
    </div>
    <s:debug></s:debug>
 <div class="formbody">
    <div class="formtitle"><span>用户信息</span></div>
    <form id="Userform" action="manager/User_add">
	    <ul class="forminfo">
		    <li>
		    	<label class="font">用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="user.userName" id="userName"class="dfinput"/></li>
		    <li>
		    	<label class="font">密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="user.password"  type="password" class="dfinput"/></li>
		    <li><label class="font">性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<cite><input name="user.sex" type="radio" value="0" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;<input name="user.sex" type="radio" value="1" />女</cite></li>
			<li><label class="font">姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<input name="user.name" id="name" class="dfinput" /></li>
			<li><label class="font">出生年月&nbsp;<em>*</em></label>
				<input name="user.birthday" id="birthday" class="dfinput" /></li>
			<li><label class="font">联系方式&nbsp;<em>*</em></label>
				<input name="user.mobile" id="mobile" class="dfinput"/></li>
			<li><label class="font">email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<input name="user.email" id="email" class="dfinput" /></li>
			<li><label class="font">身份证号&nbsp;<em>*</em></label>
				<input name="user.id" id="id" class="dfinput" /></li>
			<!--可选  --><li><label class="font">关系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<input name="user.relation" type="text" class="dfinput"/></li>
			
			<li><label class="font">角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<select name="user.role" class="dfinput"/>
					<option value="1" >普通家庭成员</option>&nbsp;&nbsp;&nbsp;&nbsp;
					<option value="2">家长</option>
				</select>
			</li>
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    
 </div>






<input  type="text" id=""  readonly="readonly" >

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
