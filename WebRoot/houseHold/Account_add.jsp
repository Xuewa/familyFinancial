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
<title>账户录入</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script>
    $(function(){ 
    	$.extend(jQuery.validator.messages, {
   		 	required: "必填字段",
   		 	maxlength: $.validator.format("请输入一个 长度最多是 {0} 的字符串"),
			minlength: $.validator.format("请输入一个 长度最少是 {0} 的字符串"),
		});
		
       $("#type").change(function(){
       		var type=$(this).val();
       		if(type==1) {
       			$("label.error").hide();
       			$("#accountNumL").hide();//=$("#accountNumL").css("display","none");
       			$("#bankL").hide();
       			$("#bank").hide();
       			$("#accountNumL").hide();
       			$("#accountNum").hide();
       			
       			$("#accountNameL").show();
       			$("#accountName").show();
       		}else if(type==2) {
       			$("label.error").hide();	
       			$("#accountNameL").hide();
       			$("#accountName").hide();
       			
       			$("#accountNumL").show();
       			$("#accountNum").show();  
       			$("#bankL").show();
       			$("#bank").show();
       			$("#none").remove();
       		}else if(type==0){
       			$("label.error").hide();
       			$("#accountNumL").hide();
       			$("#accountNum").hide();
       			$("#accountNameL").hide();
       			$("#accountName").hide();
       			$("#bankL").hide();
       			$("#bank").hide();
       		}
       });
       $("#Accountform").validate();
       
       
        
    });
    
    
</script>
</head>

<body>
<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>我的账户管理</li>
    <li>添加账户</li>
    </ul>
    </div>
  
 <div class="formbody">
    <div class="formtitle"><span>账户信息</span></div>
    <form id="Accountform" action="houseHold/Account_add">
	    <ul class="forminfo">
		    <li>
		    	<label class="font">账户类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="account.type" id="type" class="dfinput required"/>
		    		<option value="0">现金账户</option>
		    		<option value="1">电子账户</option>
		    		<option value="2">银行账户</option>
		    	</select>
		    </li>
		    <li>
		    	<label class="font" id="accountNumL" style="display:none;">账户号码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="account.accountNum" id="accountNum" class="dfinput required" hidden="true" minlength="4"/>
		    </li>
		    <li><label class="font" id="bankL" style="display:none;">银行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="account.bank" id="bank" class="dfinput required" hidden="true">
		    		<option value="0" id="none">无</option>
		    		<option value="1">农业银行</option>
		    		<option value="2">工商银行</option>
		    		<option value="3">建设银行</option>
		    		<option value="4">中国银行</option>
		    	</select>
		    </li>
		    <li><label class="font" id="accountNameL" style="display:none;">账户名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="account.accountName" id="accountName" class="dfinput required" hidden="true" minlength="4"/>
		    </li>
		    <li><label class="font">余额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="account.tMoney" id="tMoney" class="dfinput required">
		    </li>
		    <li><label class="font">备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    	<input name="account.notice" id="notice" class="dfinput">
		    </li>
		    <li>
		    	<input name="account.ownerID" id="ownerID" class="dfinput" value="<s:property value='#session.user.userID'/>" hidden="true"/>
		    </li>
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
 </div>

<input  type="text" id=""  readonly="readonly" >

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
