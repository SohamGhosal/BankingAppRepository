<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
<%@include file="css/BankLogin.css"%>
<%@include file="css/Bank.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body onload="noBack();">
<h1 align="center"><b>WELCOME TO THE BANK</b></h1>
	<c:if test="${not empty error}">
		<script>
			alert("${error}");
		</script>
	</c:if>
<div id="id04" class="modal" style="display:block;">

		<f:form role="form" action="ForgotAccount" method="post"
			modelAttribute="accountholder" class="modal-content animate">
			<div class="imgcontainer" >
			 <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group">
					<label><b>UserID</b></label>
					<f:input path="userId" type="number" class="form-control" placeholder="Enter Six Digit User ID" required="required"/>
					<f:errors class="form-control" path="userId"/>
				</div>
				<button type="submit">Submit</button>
				<button type="reset"
					class="cancelbtnLogin">Cancel</button>
			</div>
		</f:form>
	</div>
</body>
</html>