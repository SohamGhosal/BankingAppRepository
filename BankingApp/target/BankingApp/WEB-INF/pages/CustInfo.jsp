<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<jsp:include page="AdminDefault.jsp" />
<html>
<head>
<style type="text/css">
<%@include file="css/BankLogin.css"%>
<%@include file="css/Bank.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="noBack();">
	<table align="center">
		<tr>
			<th>Customer ID</th>
			<th>Account ID</th>
			<th>Customer Email</th>
			<th>Customer Address</th>
			<th>Customer PAN No.</th>
			<th>Customer Mobile No.</th>
		</tr>
		<c:forEach items="${custInfo}" var="ser">
				<tr>
					<td>${ser.customerId}</td>
					<td>${ser.accountId}</td>
					<td>${ser.email}</td>
					<td>${ser.address}</td>
					<td>${ser.panNo}</td>
					<td>${ser.mobileNo }</td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>