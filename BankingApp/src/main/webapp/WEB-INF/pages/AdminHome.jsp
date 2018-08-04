<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="AdminDefault.jsp" />
<html>
<head>
<style type="text/css">
<%@include file="css/Bank.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="noBack();">
<div class="titleStyle">
<c:if test="${not empty msg }">
		<script>
			alert("${msg}");
		</script>
	</c:if>
	<p align="center">This Bank is a well known Bank.<br>Congratulations! You are an admin<br>Things you can do as an admin :</p>
	<br>
	<p align="center">
	<br>Add User<br>
	<br>Confirm User<br>
	<br>Confirm Other Request<br>
	<br>View Transactions<br>
	<br>
	<br>
	</p>
	<p align="center">You are in full control. So be careful and have fun!!!!</p>
	</div>
</body>
</html>