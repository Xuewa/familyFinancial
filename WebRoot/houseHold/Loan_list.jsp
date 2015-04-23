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
<title>查看所有贷款</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/myJS/Loan_list.js"></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>我的账户管理</li>
    <li>账户查看</li>
    </ul>
    </div>
    <div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
        <!-- <li class="deleteMuti"><span><img src="images/t03.png" /></span></li>
         --></ul>
    
    </div>
    <s:debug></s:debug>
    <table class="tablelist">
    	<thead>
	    	<tr>
	        <th><input id="allChecks" type="checkbox" /></th>
	        <th>贷款编号</th>
	        <th>贷款账户</th>
	        <th>贷款本金</th>
	        <th>每期利息</th>
	        <th>每期还款金额</th>
	        <th>还款期数</th>
	        <th>还款总额</th>
	        <th>申请时间</th>
	        <th>每期时间间隔 </th>
	        <th>支出类别</th>
	        <th>备注</th>
	        <th>状态</th>
	        <th>操作</th>
	        </tr>
        </thead>
        <tbody id="loanList">
	        <s:iterator value="loans" id="loan" status="status">
	        <tr>
		        <td><input name="check" type="checkbox" value="<s:property value="#account.accountID"/>" /></td>
		        <td><s:property value="#loan.loanID"/></td>
		        <td><s:property value="#loan.accountID"/></td>
		        <td><s:property value="#loan.capital"/></td>
		        <td><s:property value="#loan.periodInterest"/></td>
		        <td><s:property value="#loan.periodMoney"/></td>
		        <td><s:property value="#loan.lPeriod"/></td>
		        <td><s:property value="#loan.lMoney"/></td>
		        <td><s:property value="#loan.lTime"/></td>
		        <td><s:property value="#loan.periodTime"/> 个月</td>
		        <td><s:property value="#loan.catgID"/></td>
		        <td><s:property value="#loan.note"/></td>
		        <td><s:if test="#loan.status==0">未还款</s:if><s:if test="#loan.status==1">还款中</s:if><s:if test="#loan.status==2">已还清</s:if></td>
		        <td><s:if test="#loan.status==0"><a href="houseHold/Loan_delete?loan.loanID=<s:property value='#loan.loanID'/>" class="tablelink"> 删除</a></s:if>
		        <s:if test="#loan.status==0"><a href="houseHold/Loan_updateInput?loan.loanID=<s:property value='#loan.loanID'/>" class="tablelink"> 修改</a></s:if>
		        <s:if test="#loan.status!=2"><a href="houseHold/Repayment_addInput?repayment.loanID=<s:property value='#loan.loanID'/>" class="tablelink"> 还款</a></s:if>
		        <a href="houseHold/Repayment_list?repayment.loanID=<s:property value='#loan.loanID'/>" class="tablelink"> 查看还款记录</a>
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
    <s:set scope="session" value="loan" var="loan"></s:set>
     <input id="userID" hidden="true" value="<s:property value='userID'/>" />
     <input hidden="true" id="totalCountinput" value="<s:property value='totalCount'/>"/>
	 <input hidden="true" id="nowPageinput" value="<s:property value='pageNum'/>"/>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
