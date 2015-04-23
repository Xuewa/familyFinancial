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
<title>还款</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script type ="text/javascript" src="js/myJS/Repayment_add.js"></script>
</head>
<body>
<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>债务管理</li>
    <li>还款</li>
    </ul>
    </div>
  
 <div class="formbody">
    <div class="formtitle"><span>还款信息</span></div>
    <form id="Repaymentform" action="houseHold/Repayment_add">
	    <ul class="forminfo">
		    <li>
		    	<label class="font" id="">贷款编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<s:property value="#session.loan.loanID"/>
		    	<input hidden="true" name="repayment.loanID" value="<s:property value='loan.loanID'/>"/>
		    </li>
		    <li>
		    	<label class="font" id="">本期罚款(元)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    	<input id="fineMoney" class="dfinput number requried" value=0 />
		    	<input name="repayment.fineMoney" id="fineMoney2" hidden="true" />
		    </li>
		    <li><label class="font" id="">本期还款本金(元)<em>*</em></label>
		    	<input name="repayment.rCapital" id="rCapital" readonly="true" class="dfinput" value=<s:property value='loan.capital/loan.lPeriod'></s:property> >
		    </li>
		    <li><label class="font" id="">本期还款利息(元)<em>*</em></label>
		    	<input name="repayment.rInterest" id="rInterest" readonly="true" class="dfinput" value=<s:property value='loan.periodInterest'></s:property> >
		    </li>
		    <li><label class="font">还款账户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="repayment.accountID" readonly="true" class="dfinput required" value="<s:property value='loan.accountID'/>"/>
		    </li>
		    <li><label class="font">每期还款金额(元)<em>*</em></label>
		    	<input name="repayment.rMoney" id="rMoney" class="dfinput" >
		    </li>
		    <li><label class="font">还款时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="repayment.rTime" id="rTime" class="dfinput required"/>
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
