<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="WelcomeDefault.jsp" />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="css/Bank.css"%>
<%@include file="css/W3.css"%>
</style>
<script type="text/javascript">
<%@include file="Javascript/Bank.js"%>

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  onload="noBack();">
<br><br>
<table class="w3-table-all w3-card-4" >
<caption>Service Details</caption>
<tr>
<th>Service ID</th>
<th>Service Description</th>
<th>Account ID</th>
<th>Service Raised Date</th>
<th>Service Status</th>
</tr>
<a:forEach items="${acclist}" var="acc">
<tr>
<td>${acc.serviceId}</td>
<td>${acc.serviceDesc}</td>
<td>${acc.accId}</td>
<td><fmt:formatDate type = "date" 
         dateStyle = "short" value = "${acc.serviceRaiseDate}" /></td>
<td>${acc.serviceStatus}</td>
</tr>
</a:forEach>
</table>
</body>
</html>