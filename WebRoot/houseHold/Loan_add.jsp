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
<title>贷款信息录入</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script type ="text/javascript" src="js/myJS/Loan_add.js"></script>
</head>
<body>
<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>债务管理</li>
    <li>添加贷款信息</li>
    </ul>
    </div>
  
 <div class="formbody">
    <div class="formtitle"><span>贷款信息</span></div>
    <form id="Loanform" action="houseHold/Loan_add">
	    <ul class="forminfo">
		    <li>
		    	<label class="font" id="">贷款本金(元)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.capital" id="capital" class="dfinput required number"/>
		    </li>
		    <li>
		    	<label class="font" id="">每期利息(元)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.periodInterest" id="periodInterest" class="dfinput required number"/>
		    </li>
		    <li><label class="font" id="">贷款期数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.lPeriod" id="lPeriod" class="dfinput required number"/>
		    </li>
		    <li><label class="font" id="">申请时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.lTime" id="lTime" class="dfinput required"/>
		    </li>
		    <li><label class="font">每期时间间隔(月)<em>*</em></label>
		    	<input name="loan.periodTime" id="periodTime" class="dfinput required number">
		    </li>
		    <li><label class="font">每期还款金额(元)<em>*</em></label>
		    	<input name="loan.periodMoney" id="periodMoney" class="dfinput required number">
		    </li>
		    <li><label class="font">绑定账户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="loan.accountID" id="accountID" class="dfinput required">
		    	</select>
		    </li>
		    <li><label class="font">父支出类别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="parentCatgID" id="parentCatgID" class="dfinput required"></select>
		    </li>
		    <li><label class="font">二级支出类别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="loan.catgID" id="catgID" class="dfinput required">
		    	</select>
		    </li>
		    <li><label class="font">备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    	<input name="loan.note" id="note" class="dfinput">
		    </li>
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
 </div>

<input  type="text" id=""  readonly="readonly" >
<input  id="userID"  hidden="true" value="<s:property value='#session.user.userID'/>" >
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
