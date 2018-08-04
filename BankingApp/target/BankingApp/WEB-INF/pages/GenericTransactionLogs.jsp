<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
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
<title>Show Detailed statement</title>
</head>
<body  onload="noBack();">
<br><br>
<table class="w3-table-all w3-card-4">
<caption>Transaction Details</caption>
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
<td><fmt:formatDate type = "date" 
         dateStyle = "short" value = "${transaction.transDate}" /></td>
<td>${transaction.transDesc}</td>
</tr>
</c:if>
</c:forEach>
</table>
</body>
</html>