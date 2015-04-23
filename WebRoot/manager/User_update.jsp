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
<title>用户修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script>
    $(function(){ 
       $('#birthday').datepicker({
           maxDate:0,
        });
        
       $('#Userform').validate();
    });
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>用户信息管理</li>
    <li>用户信息查看</li>
    </ul>
    </div>
    
 <div class="formbody">
 <s:debug></s:debug>
    <div class="formtitle"><span>用户信息</span></div>
    <form id="Userform" action="manager/User_update">
	    <ul class="forminfo">
	    	<li>
		    	<label class="font">用户ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    	<s:property value="user.userID"></s:property></li>
		    	<input name="user.userID"  hidden="true" value="<s:property value="user.userID"></s:property>"/>
		    <li><label class="font">用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="user.userName"  class="dfinput required" minlength="2" maxlength="6" value="<s:property value='user.userName'/>"/></li>
			<li><label class="font">姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<input name="user.name" class="dfinput required" minlength="2"  value="<s:property value='user.name'/>"/></li>
			<li><label class="font">联系方式&nbsp;<em>*</em></label>
				<input name="user.mobile" class="dfinput required" minlength="11" maxlength="11" size="11"  value="<s:property value='user.mobile'/>"/></li>
			<li><label class="font">email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<input name="user.email" class="dfinput required email"  value="<s:property value='user.email'/>"/></li>
			<s:if test="user.role>0">
			<li><label class="font">角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
				<select name="user.role" class="required dfinput"/>
					<option value="1" <s:if test='user.role==1'>selected="true"</s:if>>普通家庭成员</option>&nbsp;&nbsp;&nbsp;&nbsp;
					<option value="2" <s:if test='user.role==2'>selected="true"</s:if>>家长</option>
				</select>
			</li>
			</s:if>
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    
 </div>






<input  type="text" id=""  readonly="readonly" >

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
