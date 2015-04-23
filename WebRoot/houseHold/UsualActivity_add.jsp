<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日常生活记账</title>
<!--commons  -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jQuery-Timepicker-Addon/jquery-1.8.2.min.js"></script>

<!--validate -->
<script type ="text/javascript" src="js/jquery.validate.min.js"></script>
<!--datetime-->
	<!--datepicker_ui-->
<!-- <link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" /> -->
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>

<link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
<link href="js/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.css" type="text/css" />
	<!--datepicker_zh-->
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js" charset="utf-8" type="text/javascript"></script>
	<!--datetimepicke+zh-->
<script src="js/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.js" charset="utf-8" type="text/javascript"></script>
<script src="js/jQuery-Timepicker-Addon/jquery-ui-timepicker-zh-CN.js" charset="utf-8" type="text/javascript"></script>

<script src="js/myJS/UsualActivity_add.js" type="text/javascript"></script>
</head>

<body>
<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>日常收支管理</li>
    <li>日常收支记账</li>
    </ul>
    </div>
  <input hidden="true" id="userID" value="<s:property value='#session.user.userID' />"/>
 <div class="formbody">
    <div class="formtitle"><span>收支信息</span></div>
    <form id="UsualActivityform" action="houseHold/UsualActivity_add">
	    <ul class="forminfo">
	    	<li>
		    	<label class="font">收入或支出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="ua.inOrOut" id="inOrOut" class="dfinput required" >
		    		<option value="0">收入</option>
		    		<option value="1">支出</option>
		    	</select>
		    </li>
		    <li>
		    	<label class="font">所属收支父类别&nbsp;<em>*</em></label>
		    	<select name="" id="parentCatgID" class="dfinput required">
		    	</select>
		    </li>
		    <li>
		    	<label class="font">所属收支子类别&nbsp;<em>*</em></label>
		    	<select name="ua.catgID" id="catgID" class="dfinput required">
		    	
		    	</select>
		    </li>
		    <li>
		    	<label class="font">金&nbsp;&nbsp;&nbsp;额(单位:元)&nbsp;&nbsp;<em>*</em></label>
		    	<input name="ua.money" id="money" class="dfinput required"/>
		    </li>
		    <li><label class="font">账&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="ua.accountID" id="accountID" class="dfinput required">
		    	
		    	</select>
		    </li>
		    <li><label class="font">时&nbsp;&nbsp;&nbsp;&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="ua.time" id="time" class="dfinput required"/>
		    </li>
		    <li><label class="font">备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    	<input name="ua.note" id="note" class="dfinput">
		    </li>
		    <li>
		    	<input name="userID" id="userID" class="dfinput" value="<s:property value='#session.user.userID'/>" hidden="true"/>
		    </li>
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
 </div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
