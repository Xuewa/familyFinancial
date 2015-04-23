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
<title>收支类别列表</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/myJS/ItemCategory_list.js"></script>
</head>
<body>
	<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>收支类别管理</li>
    <li>收支类别查看</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<li class="inputList"><span><img src="images/income.gif" /></span>查询收入</li>
        <li class="outputList"><span><img src="images/expend.gif" /></span>查询支出</li>
        <li class="deleteMuti"><span><img src="images/t03.png" /></span>批量删除</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input id="allChecks" type="checkbox" /></th>
        <th>收支类别编号</th>
        <th>收支类别名</th>
        <th>收入/支出</th>
        <th>所属父类</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="itemCategoriesList">
        <s:iterator value="itemCategories" id="itemCategory" >
        <s:if test="#itemCategory.parentCatgID==null"><tr></s:if>
        <s:if test="#itemCategory.parentCatgID!=null"><tr class="odd"></s:if>
	        <td><input name="check" type="checkbox" value="<s:property value="#itemCategory.catgID"/>" /></td>
	        <td><s:property value="#itemCategory.catgID"/></td>
	        <td><s:property value="#itemCategory.catgName"/></td>
	        <td><s:if test="#itemCategory.inOrOut==0">收入</s:if><s:if test="#itemCategory.inOrOut==1">支出</s:if></td>
	        <td><s:property value="#itemCategory.parentCatgID"/></td>
	        <td><a href="manager/ItemCategory_updateInput?itemCategory.catgID=<s:property value="#itemCategory.catgID"/>" class="tablelink">修改</a>
	        	<a href="manager/ItemCategory_delete?itemCategory.catgID=<s:property value="#itemCategory.catgID"/>" class="tablelink"> 删除</a>
	        </td>
        </tr> 
        </s:iterator>
        </tbody>
    </table>
    
  
    <div class="pagin">
    	<s:set name="totalPage" value="(totalCount%10)==0?(totalCount/10):(totalCount/10)+1"></s:set>
    	<div class="message">共<i class="blue"><s:property value="totalCount"/> </i>条记录，共<i> <s:property value="#totalPage"/> </i>页，当前显示第&nbsp;<i class='blue'><s:property value="pageNum"/></i>页</div>
        <ul class="paginList">
        </ul>
    </div>
    </div>
     <input hidden="true" id="inOrOut" value="<s:property value='inOrOut'/>" />
     <input hidden="true" id="totalPageinput" value="<s:property value='#totalPage'/>"/>
	 <input hidden="true" id="nowPageinput" value="<s:property value='pageNum'/>"/>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
