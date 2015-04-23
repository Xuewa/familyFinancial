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
<title>收支类别修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
<script type ="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type ="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type ="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type ="text/javascript" src="js/jquery.validate.js"></script>
<script type ="text/javascript" src="js/myJS/ItemCategory_update.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>收支类别管理</li>
    <li>添加收支类别</li>
    </ul>
    </div>
  
 <div class="formbody">
    <div class="formtitle"><span>收支类别信息</span></div>
    <form id="ItemCategoryform" action="manager/ItemCategory_update">
	    <ul class="forminfo">
	    	<li>
		    	<label class="font">收支类别名编号&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<s:property value="itemCategory.catgID"/></li>
		    	<input name="itemCategory.catgID"  hidden="true" value="<s:property value="itemCategory.catgID"/>"/>
		    <li>
		    	<label class="font">收支类别名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<input name="itemCategory.catgName" id="catgName" class="dfinput" value="<s:property value="itemCategory.catgName"/>"/>
		    </li>
		    <li>
		    	<label class="font">收入或支出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="itemCategory.inOrOut" id="inOrOut" class="dfinput" />
		    		<option value="0" <s:if test='itemCategory.inOrOut==0'>selected="true"</s:if>>收入</option>
		    		<option value="1" <s:if test='itemCategory.inOrOut==1'>selected="true"</s:if>>支出</option>
		    	</select>
		    </li>
		    <li><label class="font">父类别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>*</em></label>
		    	<select name="itemCategory.parentCatgID" id="parentCatgID" class="dfinput">
		    		<option value="" <s:if test='itemCategory.parentCatgID==null'>selected="true"</s:if>>无</option>
		    	<s:iterator value="itemCategories" id="ic">
		    		<option value="<s:property value='#ic.catgID'/>" <s:if test='itemCategory.parentCatgID==#ic.catgID'>selected="true"</s:if>>
		    			<s:property value="#ic.catgName"/>
		    		</option>
		    	</s:iterator>
		    	</select>
		    </li>
		    <input id="oldinOrOut"  hidden="true" value="<s:property value='itemCategory.inOrOut'/>"/>
		    <input id="oldparentCatgID"  hidden="true" value="<s:property value='itemCategory.parentCatgID'/>"/>
		    <input name="parentChange" id="parentChange"  hidden="true" />
		    <li><label class="font">&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
 </div>

<input  type="text" id=""  readonly="readonly" >

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
