<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的资料查看</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript">
	$(function(){
		$(".updatePassword").click(function(){
			var updatePasswordAlls=$("#updatePasswordAlls");
			if(updatePasswordAlls.css("display")=="none") 
				updatePasswordAlls.show();
			else 
				updatePasswordAlls.hide();
			return false;
		});
		
		$(".validateNewPassword").click(function(){
			if($("#newPassword").val()=="") {
				alert("请输入新密码");
				$("#newPassword").focus();
				return false;
			}
			if($("#newPassword").val().length!=6){
				alert("请输入6位新密码");
				$("#newPassword").val("");
				$("#newPassword").focus();
				return false;
			}
			//alert($("#userID").val());
			window.location.href="familyMember/User_updatePassword?user.userID="+$("#userID").val()+"&user.password="+$("#newPassword").val();
		});
		
		
	});
</script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>个人信息管理</li>
    <li>我的资料查看</li>
    </ul>
    </div>
    <s:debug></s:debug>
 <div class="formbody">
    <div class="formtitle"><span>用户信息</span></div>
    <div >
	    <ul class="forminfo">
	    	<li>
		    	<label class="font2" >用户ID
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<s:property value="user.userID"/></label>
		    </li><li>
		    	<label class="font2">用户名
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<s:property value="user.userName"/></label>
		    </li><li>
		    	<label class="font2">密码
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<s:property value="user.password"/>
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<span class="updatePassword" style="display:inline">更改密码</span></label>
		    </li><li>
		    	<label class="font2" id="updatePasswordAlls" style="display:none">请输入新密码
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input class="dfinput" id="newPassword" type="password" onclick="this.value=''">
		    	<input type="submit" class="btn validateNewPassword" value="确定"></label>
		    </li><li><label class="font2">性别
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<s:if test="user.sex==0" >男</s:if>
		    	<s:if test="user.sex==1" >女</s:if></label>
			</li><li><label class="font2">姓名
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.name"/></label>
			</li><li><label class="font2">出生年月
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.birthday"/></label>
			</li><li><label class="font2">联系方式
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.mobile"/></label>
			</li><li><label class="font2">email
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.email"/></label>
			</li><li><label class="font2">身份证号
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.id" /></label>
			</li><li><label class="font2">关系
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.relation"/></label>
			</li><li><label class="font2">角色
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:if test="user.role==1">普通家庭成员</s:if><s:if test="user.role==2">家长</s:if></label>
			</li><li><label class="font2">最后登录时间
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="user.lastLoginTime"></s:property></label>
			</li>
	    </ul>
    </div>
    <input hidden="true" id="userID" value="<s:property value='user.userID'/>" />
 </div>






<input  type="text" id=""  readonly="readonly" >

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
