<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <jsp:include page="AdminDefault.jsp" />
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
<body onload="noBack();">
	<c:if test="${not empty msg}">
		<script>
			alert("${msg}");
		</script>
	</c:if>
	<br><br>
<table class="w3-table-all w3-card-4">
<caption>Chequebook Request Details</caption>
<tr>
<th>Customer Request ID </th>
<th>Customer's Name</th>
<th>Email</th>
<th>Mobile No.</th>
<th>Address</th>
<th>PAN NO.</th>
<th>Account Type</th>
<th>Account Balance</th>
<th>Customer's ChequeBook Status</th>
</tr>
<c:forEach items="${custReq}" var="cust">
<f:form action="ConfirmAcc" method="post">
<tr>
<td><input type="hidden" name="custReqId" value="${cust.custReqId }"/>${cust.custReqId }</td>
<td>${cust. custName }</td>
<td>${cust.email }</td>
<td>${cust.mobileNo }</td>
<td>${cust.address }</td>
<td>${cust.panNo }</td>
<td>${cust.accountType }</td>
<td>${cust.accountBal }</td>
<td>${cust.chequeStatus }</td>
<td><button type="submit" value="Confirm"></button></td>
</tr>
</f:form>
</c:forEach>
</table>
</body>
</html>