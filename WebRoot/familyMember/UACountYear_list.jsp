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
<title>年度统计</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- gvChart -->
<link href="css/tabs.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/gvChart/jsapi.js"></script>
<script type="text/javascript" src="js/gvChart/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="js/gvChart/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/gvChart/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/myJS/UACountYear_list.js""></script>
</head>
<body>
	<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>数据汇总</li>
    <li>年度统计</li>
    </ul>
    </div>
 
    <div class="tool" style="position:relative">
    		<span style="display:inline;font-size:17px;height:35px;;">
    			请选择统计的年份
    			<select id="timeRange" style="display:inline;height:30px;border:1px solid #000;">
    				<s:iterator value="years" id="yy">
    					<option value="<s:property value='#yy'/>"><s:property value="#yy"/></option>
    				</s:iterator>
    			</select> 
    		</span>
        	
        	<span class="go" style="position:absolute;top:5px;display:inline-block;margin-left: 10px;">
        		<a style="display:inline-block"><img src="images/search.png"></a>
        	</span>
    </div><br/>
    <div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:800px;">
		<div title="收入vs支出" style="padding:10px;">
			<h2 id="area">收入vs支出对比趋势图</h2>
			<table id="myTable1" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;收入&nbsp;&nbsp;统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>月 份 </th><th>1月</th><th>2月</th><th>3月</th><th>4月</th><th>5月</th><th>6月</th>
					<th>7月</th><th>8月</th><th>9月</th><th>10月</th><th>11月</th><th>12月</th>
				</tr>
				</thead>
				<tbody>
				<tr><th>收入</th>
					<s:iterator value="{'01','02','03','04','05','06','07','08','09','10','11','12'}" id="month">
						<s:set var="flag" value="false" />
						<s:iterator value="inUacss" id="uac" >
							<s:if test="#month==#uac.column">
								<s:set var="flag" value="true" />
								<td><s:property value="#uac.sumMoney" /></td>
							</s:if>
						</s:iterator>
						<s:if test="#flag==false">
							<td>0</td>
						</s:if>
					</s:iterator>
				</tr><tr><th>支出</th>
					<s:iterator value="{'01','02','03','04','05','06','07','08','09','10','11','12'}" id="month">
						<s:set var="flag" value="false" />
						<s:iterator value="outUacss" id="uac" >
							<s:if test="#month==#uac.column">
								<s:set var="flag" value="true" />
								<td><s:property value="#uac.sumMoney" /></td>
							</s:if>
						</s:iterator>
						<s:if test="#flag==false">
							<td>0</td>
						</s:if>
					</s:iterator>
				</tr><tr><th>实际(收入-支出)</th>
					<s:iterator value="aUacss" id="uac" >
						<td><s:property value="#uac.sumMoney" /></td>
					</s:iterator>
				</tr>
				</tbody>
			</table>
			<span class="totalsum">收入总计:<s:property value="insumTotal"/></span>
			<span class="totalsum">支出总计:<s:property value="outsumTotal"/></span>
			<span class="totalsum">实际总计:<s:property value="insumTotal-outsumTotal"/></span>
		</div>
		<div title="支出" style="padding:10px;">
			<h2 id="area">支出百分比饼图</h2>
			<table id="myTable2" class="tablelist">
	        	<caption><s:property value="beginTime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endTime"/>&nbsp;&nbsp;收入&nbsp;&nbsp;统计数据 (单位:元)</caption>
				<thead>
				<tr>
					<th>月 份 </th><th>1月</th><th>2月</th><th>3月</th><th>4月</th><th>5月</th><th>6月</th>
					<th>7月</th><th>8月</th><th>9月</th><th>10月</th><th>11月</th><th>12月</th>
				</tr>
				</thead>
				<tbody>
				<tr><th>金额总和</th>
					<s:iterator value="{'01','02','03','04','05','06','07','08','09','10','11','12'}" id="month">
						<s:set var="flag" value="false" />
						<s:iterator value="outUacss" id="uac" >
							<s:if test="#month==#uac.column">
								<s:set var="flag" value="true" />
								<td><s:property value="#uac.sumMoney" /></td>
							</s:if>
						</s:iterator>
						<s:if test="#flag==false">
							<td>0</td>
						</s:if>
					</s:iterator>
				</tr>
				</tbody>
			</table>
			<span class="totalsum">总计:<s:property value="outsumTotal"/></span>
		</div>
    </div>
    
    
     <input hidden="true" id="userID" value="<s:property value='userID'/>" />
	 <input name="role" hidden="true" id="role" value="<s:property value='role'/>" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
