<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日常收支列表</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--<script type="text/javascript" src="js/jquery.js"></script>-->
<script type ="text/javascript" src="js/jQuery-Timepicker-Addon/jquery-1.8.2.min.js"></script>
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
<script type="text/javascript" src="js/myJS/UsualActivity_list.js"></script>
</head>

<body>
	<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>日常收支管理</li>
    <li>日常收支查看</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<li class="dayList"><span><img src="images/dayweekmonth/day.png" /></span>今日收支</li>
        <li class="weekList"><span><img src="images/dayweekmonth/week.png" /></span>本周收支</li>
        <li class="monthList"><span><img src="images/dayweekmonth/month.png" /></span>本月收支</li>
        </ul>&nbsp;&nbsp;&nbsp;
        <span style="display:inline;font-size:17px;height:35px;">
        	请选择开始时间:
        	<input style="display:inline;height:30px;border:1px solid #000;"id="beginTimeinput" >
        </span>
        <span style="display:inline;font-size:17px;height:35px;">
        	请选择结束时间:
        	<input style="display:inline;height:30px;border:1px solid #000;" id="endTimeinput" >
        </span>
    	<span class="go" style="position:absolute;top:23px;display:inline-block;margin-left: 10px;">
        	<a style="display:inline-block"><img style="padding-top:40px;" src="images/search.png"></a>
        </span>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input id="allChecks" type="checkbox" /></th>
        <th>日常收支编号</th>
        <th>收入/支出</th>
        <th>用户</th>
        <th>账户</th>
        <th>所属收支类别</th>
        <th>金额</th>
        <th>时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="uaList">
        <s:iterator value="uass" id="ua" >
        <tr>
	        <td><input name="check" type="checkbox" value="<s:property value="#ua.usualActivityID"/>" /></td>
	        <td><s:property value="#ua.usualActivityID"/></td>
	        <td><s:if test="#ua.inOrOut==0">收入</s:if><s:if test="#ua.inOrOut==1">支出</s:if></td>
	        <td><s:property value="#ua.userID"/></td><!-- user要改 -->
	        <td><s:property value="#ua.accountID"/></td><!-- account要改 -->
	        <td><s:property value="#ua.catgID"/></td><!-- 要改，本来是catgID -->
	        <td><s:property value="#ua.money"/></td>
	        <td><s:property value="#ua.time"/></td>
	        <td><s:property value="#ua.note"/></td>
	        <td><a href="familyMember/UsualActivity_updateInput?ua.usualActivityID=<s:property value='#ua.usualActivityID'/>" class="tablelink">修改</a>
	        	<a href="familyMember/UsualActivity_delete?ua.usualActivityID=<s:property value='#ua.usualActivityID'/>&userID=<s:property value='userID' />" class="tablelink"> 删除</a>
	        </td>
        </tr> 
        </s:iterator>
        </tbody>
    </table>
    
  
    <div class="pagin">
    	<div class="message">
    	</div>
        <ul class="paginList">
        </ul>
    </div>
    
    </div>
     <input hidden="true" id="userID" value="<s:property value='userID'/>" />
     <input hidden="true" id="beginTime" value="<s:property value='beginTime'/>" />
     <input hidden="true" id="endTime" value="<s:property value='endTime'/>" />
     <!--<input hidden="true" id="totalPageinput" value="<s:property value='#totalPage'/>"/>-->
     <input hidden="true" id="totalCountinput" value="<s:property value='totalCount'/>"/>
	 <input hidden="true" id="nowPageinput" value="<s:property value='pageNum'/>"/>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
