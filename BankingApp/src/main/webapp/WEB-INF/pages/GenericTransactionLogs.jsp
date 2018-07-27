<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>  
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
<title>Show Detailed statement</title>
</head>
<body  onload="noBack();">
<h2 align="center">Detailed Statement</h2>

<table border="1" align="center">
<c:if test="${tLog=='mini' }">
<th>TransactionId</th>
<th>AccountId</th>
<th>Amount</th>
</c:if>
<c:if test="${tLog=='detailed' }">
<tr>
<th>TransactionId</th>
<th>AccountId</th>
<th>Amount</th>
<th>Transaction Type</th>
<th>Date of Transaction</th>
<th>Description</th>
</tr>
</c:if>
<c:forEach items="${transaction}" var="transaction">
<c:if test="${tLog=='mini' }">
<tr>
<td>${transaction.transId}</td>
<td>${transaction.accountNo}</td>
<td>${transaction.transAmt}</td>
</tr>
</c:if>
<c:if test="${tLog=='detailed' }">
<tr>
<td>${transaction.transId}</td>
<td>${transaction.accountNo}</td>
<td>${transaction.transAmt}</td>
<td>${transaction.transType}</td>
<td>${transaction.transDate}</td>
<td>${transaction.transDesc}</td>
</tr>
</c:if>
</c:forEach>
</table>
</body>
</html>