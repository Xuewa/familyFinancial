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
<title>月度统计</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- gvChart -->
<link href="css/tabs.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/gvChart/jsapi.js"></script>
<script type="text/javascript" src="js/gvChart/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="js/gvChart/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/gvChart/jquery.easyui.min.js"></script>
<!-- yearmonth -->
<script type="text/javascript" src="js/yearmonth/yearmonth.js"></script>
<link href="css/yearmonth.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/myJS/UACountMonth_list.js"></script>
</head>


<body>
	<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>数据汇总</li>
    <li>月度统计</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
	<div class="tool" sytle="position:relative">
    		<span style="display:inline;font-size:17px;height:35px;">请选择统计的月份
    			<input id="timeRange" style="display:inline;height:30px;border:1px solid #000;"/>
    		</span>
        	<span class="go" style="position:absolute;top:23px;display:inline-block;margin-left: 10px;">
        		<a style="display:inline-block"><img style="padding-top:40px;" src="images/search.png"></a>
        	</span>
	</div>
	<br/>
    <div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:800px;">
		<div title="个人收入" style="padding:10px;">
			<h2 id="area">收入百分比饼图</h2>
			<table id="myTable1" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;收入&nbsp;&nbsp;统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>类别名称</th>
					<s:iterator value="inUacss" id="uac">
						<th><s:property value="#uac.column" /></th>
					</s:iterator>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th>金额总和</th>
						<s:iterator value="inUacss" id="uac">
							<td><s:property value="#uac.sumMoney" /></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
			<span class="totalsum">总计:<s:property value="insumTotal"/></span>
		</div>
		<div title="个人支出" style="padding:10px;">
			<h2 id="area">支出百分比饼图</h2>
			<table id="myTable2" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;支出 &nbsp;&nbsp; 统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>类别名称</th>
					<s:iterator value="outUacss" id="uac2">
						<th><s:property value="#uac2.column" /></th>
					</s:iterator>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th>金额总和</th>
						<s:iterator value="outUacss" id="uac2">
							<td><s:property value="#uac2.sumMoney" /></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
			<span class="totalsum">总计:<s:property value="outsumTotal"/></span>
		</div>
		
		<div title="还款" style="padding:10px;">
			<h2 id="area">还款百分比饼图</h2>
			<table id="myTable3" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;支出 &nbsp;&nbsp; 统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>贷款名称</th>
					<s:iterator value="reUacss" id="uac">
						<th><s:property value="#uac.column" /></th>
					</s:iterator>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th>金额总和</th>
						<s:iterator value="reUacss" id="uac">
							<td><s:property value="#uac.sumMoney" /></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
			<span class="totalsum">总计:<s:property value="resumTotal"/></span>
		</div>
		
		<div title="家庭收入" style="padding:10px;">
			<h2 id="area">收入百分比饼图</h2>
			<table id="myTable4" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;支出 &nbsp;&nbsp; 统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>类别名称</th>
					<s:iterator value="finUacss" id="uac">
						<th><s:property value="#uac.column" /></th>
					</s:iterator>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th>金额总和</th>
						<s:iterator value="finUacss" id="uac">
							<td><s:property value="#uac.sumMoney" /></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
			<span class="totalsum">总计:<s:property value="finsumTotal"/></span>
		</div>
		
		<div title="家庭支出" style="padding:10px;">
			<h2 id="area">支出百分比饼图</h2>
			<table id="myTable5" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;支出 &nbsp;&nbsp; 统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>类别名称</th>
					<s:iterator value="foutUacss" id="uac">
						<th><s:property value="#uac.column" /></th>
					</s:iterator>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th>金额总和</th>
						<s:iterator value="foutUacss" id="uac">
							<td><s:property value="#uac.sumMoney" /></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
			<span class="totalsum">总计:<s:property value="foutsumTotal"/></span>
		</div>
		
     </div>
</div>
    
     <input hidden="true" id="userID" value="<s:property value='userID'/>" />
     <input name="role" hidden="true" id="role" value="<s:property value='role'/>" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
