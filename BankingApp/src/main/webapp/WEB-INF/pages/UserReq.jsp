<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<jsp:include page="AdminDefault.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@include file="css/Bank.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
</head>
<body onload="noBack();">
	<c:if test="${not empty msg}">
		<script>
			alert("${msg}");
		</script>
	</c:if>
<table align="center">
<tr>
<th>Service ID</th>
<th>Service Description</th>
<th>Account ID</th>
<th>Service Raised Date</th>
<th>Confirm</th>
</tr>
<c:forEach items="${UserReq}" var="ser">
<c:if test="${ser.serviceStatus=='Open'}">	
<f:form action="ConfirmReq" method="POST">
<tr>
<td><input type="hidden" name="serviceId" value="${ser.serviceId}"/>${ser.serviceId}</td>
<td>${ser.serviceDesc}</td>
<td>${ser.accId}</td>
<td>${ser.serviceRaiseDate}</td>
<td><button type="submit"/>Confirm Request</td>
<td><button type="button" onclick="<c:set var="serviceId" value="${ser.serviceId}" scope="session"/>;location.href='RejectRequest'"/>Reject</td>
</tr>
</f:form>
</c:if>
</c:forEach>
</table>
</body>
</html>