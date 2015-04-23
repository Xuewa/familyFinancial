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
<title>家庭理财系统-家长界面</title>
</head>

<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="common/top.jsp?userName=<s:property value="user.userName"/>" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="houseHold/left.jsp?userID=<s:property value='user.userID'/>&role=<s:property value='user.role'/>" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="common/main.jsp?userName=<s:property value="user.userName"/>&&email=<s:property value="user.email"/>&lastLoginTime=<s:property value='user.lastLoginTime'/>" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
<body>
</body>
</html>

