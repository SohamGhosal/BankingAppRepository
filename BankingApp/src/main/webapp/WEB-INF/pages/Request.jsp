<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:include page="Welcome.jsp" />
<title>Insert title here</title>
</head>
<body onload="noBack();">
<center>
<f:form action="addrequest" method="post" modelAttribute="bank">
<c:if test="${not empty msg}">
<script type="text/javascript">alert("${msg}");</script>
<%  response.setHeader("Refresh", "5;url=Welcome.jsp"); %>
</c:if>
<table>
<tr>
<td><input type="submit" id="req" value="Request For CheckBook"/></td>
</tr>
<c:if test="${not empty statement }">
<tr><td><p>${statement}</p></td></tr>
<script>
document.getElementById("req").disabled=true;
</script>
</c:if>
</table>
</f:form>
</center>
</body>
</html>