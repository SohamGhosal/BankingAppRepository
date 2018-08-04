<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <jsp:include page="WelcomeDefault.jsp" />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="css/Bank.css"%>
<%@include file="css/BankLogin.css"%>
<%@include file="css/W3.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="noBack();">
<c:if test="${not empty msg }">
		<script>
			alert("${msg}");
		</script>
	</c:if>
	<div><br><br><br>
	<p class="titleStyle">This Bank is a well known Bank</p>
	</div>
</body>
</html>