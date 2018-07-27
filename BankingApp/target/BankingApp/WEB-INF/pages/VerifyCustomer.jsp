<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="css/Bank.css"%>
<%@include file="css/BankLogin.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="noBack();">
	<h1 align="center">Welcome To The Bank</h1>
	<div class="modal" style="display:block ;">
		<f:form role="form" action="ShowCredentials" modelAttribute="customerRequest"  class="modal-content animate">
			<div class="imgcontainer">
			<img src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group">
					<label>${cr.secretQues}</label>
					<f:input path="secretQues" value="${cr.secretQues}" type="hidden" />
					<br> <label>Answer :</label>
					<f:input path="ans" required="required" />
					<button type="submit">Submit</button>
					<button type="reset" class="cancelbtnLogin">Clear</button>
				</div>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<a href="index.jsp">Back to Home</a>
			</div>

		</f:form>
	</div>
</body>
</html>