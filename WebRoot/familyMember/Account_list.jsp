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
<title>查看个人的账户</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

$(function(){
	$("#allChecks").click(function(){
		var checks=$("[name='check']");
		checks.each(function()
		{
			var flag=$(this).prop("checked");
			$(this).prop("checked",!flag);
		});
	});
	
	$(".deleteMuti").click(function(){
		var checks=$("[name='check']:checked");
		var str="";  
		checks.each(function(){
			str+=$(this).val()+",";
		});
		str=str.substring(0,(str.length-1));
		if(str=="") return false;
		var userID=$("#userID").val();
		window.location.href="familyMember/Account_deleteMultiple?accountIDsstr="+str+"&account.ownerID="+userID;
	});
});
</script>

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
        <li class="deleteMuti"><span><img src="images/t03.png" /></span>批量删除</li>
        </ul>
    
    </div>
    
    <s:debug></s:debug>
    <input id="userID" hidden="true" value="<s:property value='userID'/>" />
    <table class="tablelist">
    	<thead>
	    	<tr>
	        <th><input id="allChecks" type="checkbox" /></th>
	        <th>序号</th>
	        <th>账户编号</th>
	        <th>账户类型</th>
	        <th>账户名称</th>
	        <th>账户号码</th>
	        <th>账户银行</th>
	        <th>余额</th>
	        <th>备注</th>
	        <th>状态</th>
	        <th>操作</th>
	        </tr>
        </thead>
        <tbody>
	        <s:iterator value="accounts" id="account" status="status">
	        <tr>
		        <td><input name="check" type="checkbox" value="<s:property value="#account.accountID"/>" /></td>
		        <td><s:property value="#status.index+1"/></td>
		        <td><s:property value="#account.accountID"/></td>
		        <td><s:if test="#account.type==0">现金账户</s:if><s:if test="#account.type==1">电子账户</s:if><s:if test="#account.type==2">银行账户</s:if></td>
		        <td><s:property value="#account.accountName"/></td>
		        <td><s:property value="#account.accountNum"/></td>
		        <td><s:if test="#account.bank==1">农业银行</s:if><s:if test="#account.bank==2">工商银行</s:if><s:if test="#account.bank==3">建设银行</s:if><s:if test="#account.bank==4">中国银行</s:if></td>
		        <td><s:property value="#account.tMoney"/></td> 
		        <td><s:property value="#account.notice"/></td> 
		        <td><s:if test="#account.status==0">冻结</s:if><s:if test="#account.status==1">已激活</s:if></td>
		        <td><a href="familyMember/Account_delete?account.accountID=<s:property value='#account.accountID'/>&account.ownerID=<s:property value='userID'/>" class="tablelink"> 删除</a>
		        	<s:if test="#account.status==0"><a href="familyMember/Account_active?account.accountID=<s:property value="#account.accountID"/>&account.status=1&account.ownerID=<s:property value='userID'/>" class="tablelink"> 激活</a></s:if>
		        	<s:if test="#account.status==1"><a href="familyMember/Account_active?account.accountID=<s:property value="#account.accountID"/>&account.status=0&account.ownerID=<s:property value='userID'/>" class="tablelink"> 冻结</a></s:if>
		        </td>
	        </tr> 
	        </s:iterator>
        </tbody>
    </table>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
