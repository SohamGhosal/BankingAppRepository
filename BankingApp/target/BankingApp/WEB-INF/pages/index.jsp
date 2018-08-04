<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="noBack();">
<c:if test="${not empty pwd }">
<script>
	alert("Your password has been changed your new password is : ${pwd}");</script>
	</c:if>
<c:if test="${not empty msg }">
<script>
	alert("${msg}");</script>
	</c:if>	
<div align="center">You will be redirected in a few seconds....</div>
<%  response.setHeader("Refresh", "5;url=index.jsp"); %>
</body>
</html>