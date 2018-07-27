<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="Welcome.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<center>
<table>
<tr>
<th>Service ID</th>
<th>Service Description</th>
<th>Account ID</th>
<th>Service Raised Date</th>
<th>Service Status</th>
</tr>
<tr>
<td>${ser.serviceId}</td>
<td>${ser.serviceDesc}</td>
<td>${ser.accId}</td>
<td>${ser.serviceRaiseDate}</td>
<td>${ser.serviceStatus}</td>
</tr>
</table>
</center>
</body>
</html>