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
<title>贷款信息修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script>
    $(function(){ 
    	$('#lTime').datepicker({
    	 	maxDate: 0
    	});
    
    	$.extend($.validator.messages, {
   		 	required: "必填字段",
   		 	number: "必须填写数字",
   		 	maxlength: $.validator.format("请输入一个 长度最多是 {0} 的字符串"),
			minlength: $.validator.format("请输入一个 长度最少是 {0} 的字符串"),
		});
		
		/*$函数=====获取二级收支类别======
		由于$()二级菜单必须等待一级菜单加载完成才可以加载，故直接放入一级加载的函数的后半部分*/
		$.extend({'parentCatgIDChange':function(){
			$.ajax({
				  url: "json/ItemCategory_secondClassList",
				  data: "inOrOut=1&parentCatgID="+$("#parentCatgID").val(),
				  success: function(data){
				  		var ics=data.itemCategories;
				  		var icID=$("#icID").val();
				  		$("#catgID").html("");
				  		if(ics==''){ alert("无二级类别");return;}
				  		$(ics).each(function (i, value) {  
                    		$("#catgID").append("<option value='"+value.catgID+"'>"+value.catgName+"</option>");
                		});
                		$("#catgID").val(icID);
				  		$("#icID").val("");  
				  },
			});   
		}});
		
		/*$函数=====获取一级收支类别======*/
		$.extend({'InOrOutChange':function(){
			$.ajax({
				  url: "json/ItemCategory_addInput",
				  data: "inOrOut=1&type=1",
				  success: function(data){
				  		var ics=data.itemCategories;
				  		$("#parentCatgID").html("");
				  		if(ics==''){ alert("无一级类别");return;}
				  		$(ics).each(function (i, value) {  
                    		$("#parentCatgID").append("<option value='"+value.catgID+"'>"+value.catgName+"</option>");
                		}); 
                		$.parentCatgIDChange();  
				  },
			});   
		}});
		
		$.InOrOutChange();
		
		$("#parentCatgID").change(function(){
       		$.parentCatgIDChange();  	/*$函数调用方式*/  
        });
		
		 /*$函数=====获取用户的所有账户======*/
		$.extend({'allAccounts':function(){
			$.ajax({
				  url: "json/Account_list",
				  data: "userID="+$("#userID").val()+"&type=1",
				  success: function(data){
				  		var accounts=data.accounts;
				  		$("#accountID").html("");
				  		if(accounts==""){ alert("用户没有可以使用的绑定账户");return;}
				  		$(accounts).each(function (i, value) {  
				  			var accounttype="";
				  			var accountName=value.accountName==null?"":value.accountName;
				  			var accountNum=value.accountNum==null?"":value.accountNum;
				  			if(value.type==0) accounttype="现金账户";
				  			else if(value.type==1) accounttype="电子账户";
				  			else if(value.type==2) accounttype="银行账户";
                    		$("#accountID").append("<option value='"+value.accountID+"'>"+accountName+accountNum+"("+accounttype+")</option>");
                		}); 
				  },
			});   
		}});
		
		$.allAccounts();
        $("#Loanform").validate();
        
    });
    
    
</script>
</head>

<body>
<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>债务管理</li>
    <li>贷款信息修改</li>
    </ul>
    </div>
  
 <div class="formbody">
 <input hidden="true" id="userID" value="<s:property value='#session.user.userID' />"/>
 <input hidden="true" id="picID" value="<s:property value='pic.catgID' />"/>
 <input hidden="true" id="icID" value="<s:property value='loan.catgID' />"/>
 <input hidden="true" id="uaAccountID" value="<s:property value='loan.accountID' />"/>
    <div class="formtitle"><span>贷款信息</span></div>
    <form id="Loanform" action="houseHold/Loan_update">
	    <ul class="forminfo">
	    	<li>
		    	<label class="font" id="">贷款编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<s:property value="loan.loanID"/> 
		    	<input name="loan.loanID" hidden="true" value="<s:property value='loan.loanID'/>"/>
		    </li>
		    <li>
		    	<label class="font" id="">贷款本金(元)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.capital" value="<s:property value='loan.capital'/>"class="dfinput required number"/>
		    </li>
		    <li>
		    	<label class="font" id="">每期利息(元)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.periodInterest"  value="<s:property value='loan.periodInterest'/>" class="dfinput required number"/>
		    </li>
		    <li><label class="font" id="">贷款期数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.lPeriod" value="<s:property value='loan.lPeriod'/>" class="dfinput required number"/>
		    </li>
		    <li><label class="font" id="">申请时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="loan.lTime" id="lTime" value="<s:property value='loan.lTime'/>" class="dfinput required"/>
		    </li>
		    <li><label class="font">每期时间间隔(月)<em>*</em></label>
		    	<input name="loan.periodTime" value="<s:property value='loan.periodTime'/>" class="dfinput required number">
		    </li>
		    <li><label class="font">每期还款金额(元)<em>*</em></label>
		    	<input name="loan.periodMoney" value="<s:property value='loan.periodMoney'/>" class="dfinput required number">
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
		    	<input name="loan.note" value="<s:property value='loan.note'/> " class="dfinput">
		    </li>
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
 </div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
