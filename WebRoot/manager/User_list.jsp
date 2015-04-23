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
<title>无标题文档</title>
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
		//var json=JSON.stringify(str);  
		window.location.href="manager/User_deleteMultiple?userIDsstr="+str;
	});
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
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="deleteMuti"><span><img src="images/t03.png" /></span>批量删除</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input id="allChecks" type="checkbox" /></th>
        <th>用户编号</th>
        <th>用户名</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生年月</th>
        <th>联系方式</th>
        <th>email</th>
        <th>身份证号</th>
        <th>关系</th>
        <th>上次登录时间</th>
        <th>角色</th>
        <th>状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
       
        <s:iterator value="users" id="user">
        <tr>
	        <td><s:if test="#user.role>0"><input name="check" type="checkbox" value="<s:property value="#user.userID"></s:property>" /></s:if></td>
	        <td><s:property value="#user.userID"></s:property></td>
	        <td><s:property value="#user.userName"></s:property></td>
	        <td><s:property value="#user.name"></s:property></td>
	        <td><s:if test="#user.sex==0">男</s:if><s:if test="#user.sex==1">女</s:if></td>
	        <td><s:property value="#user.birthday"></s:property></td>
	        <td><s:property value="#user.mobile"></s:property></td> 
	        <td><s:property value="#user.email"></s:property></td> 
	        <td><s:property value="#user.id"></s:property></td>
	        <td><s:property value="#user.relation"></s:property></td>
	        <td><s:property value="#user.lastLoginTime"></s:property></td>
	        <td><s:if test="#user.role==0">管理员</s:if><s:if test="#user.role==1">普通家庭成员</s:if><s:if test="#user.role==2">家长</s:if></td>
	        <td><s:if test="#user.status==0">冻结</s:if><s:if test="#user.status==1">已激活</s:if></td>
	        <td><a href="manager/User_updateInput?user.userID=<s:property value="#user.userID"></s:property>"" class="tablelink">修改</a>
	        	<s:if test="#user.role>0"><a href="manager/User_delete?user.userID=<s:property value="#user.userID"></s:property>" class="tablelink"> 删除</a></s:if>
	        	<s:if test="#user.status==0"><a href="manager/User_active?user.userID=<s:property value="#user.userID"></s:property>&user.status=1" class="tablelink"> 激活</a></s:if>
	        	<s:if test="#user.status==1"><a href="manager/User_active?user.userID=<s:property value="#user.userID"></s:property>&user.status=0" class="tablelink"> 冻结</a></s:if>
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
