<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<jsp:include page="AdminDefault.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
<%@include file="css/BankLogin.css"%>
<%@include file="css/Bank.css"%>
<%@include file="css/W3.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<title>Insert title here</title>
</head>
<body onload="noBack();">
<div class="modal" id="id09" style="display:block;">
	<f:form role="form" class="modal-content animate">
		<div class="imgcontainer">
				<span onclick="location.href='adminhome'"
					class="close" title="Close Modal">&times;</span>
		</div>
		<br>
		<br>
		<div class="container">
			<div class="clearfix">
			<button type="button" onclick="location.href='CnfUser'" id="btnCnf">Confirm A Request</button>
			<button type="button" onclick="document.getElementById('id07').style.display='block'">Register A New Account</button>
			</div>
		</div>
	</f:form>
</div>
<div id="id07" class="modal">
	<f:form role="form" action="registerUser" method="post"
			modelAttribute="customerRequest" class="modal-content animate" onsubmit="passWordCheck();">
						<div class="imgcontainer">
				<span onclick="document.getElementById('id07').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label class="registerMsg">Sign Up</label>
				<p>Please fill in this form to create an account.</p>
				<hr>
				<label><b>First Name : </b></label>
				<input type="text" placeholder="First Name" name="fname" required/>
				<label><b>Last Name : </b></label>
				<input type="text" placeholder="Last Name" name="lname" required/>	
				<label><b>Email</b></label>
				<f:input type="text" path="email" placeholder="Enter Email" name="email" required="required"/>
				<label><b>Phone No. : </b></label>
				<f:input type="tel" path="mobileNo" placeholder="Enter your 10 digit mobile no" name="mobileNo" required="required"/><br>
				<label><b>Address : </b></label>
				<f:textarea path="address" required="required"/><br>
				<label><b>PAN No. : </b></label>
				<f:input type="text" path="panNo" placeholder="Enter your PAN no." name="panNo" required="required"/><br>
				<label><b>Choose Security Question : </b></label>
				<f:select path="secretQuest">
				<c:forEach items="${secretQuest}" var="secretQid">
				<f:option value="${secretQid.securityQuest}" required="required"/>
				</c:forEach>
				</f:select><br>
				<label><b>Answer : </b></label>
				<f:input type="text" path="answer" placeholder="Answer the Question" required="required"/><br>
				<label>Choose Account Type : </label>
				<f:radiobutton path="accountType" value="savings" required="required"/>Savings
				<f:radiobutton path="accountType" value="current" required="required"/>Current<br>
				<label>Minimum Account Balance</label>
				<f:input type="number" path="accountBal" required="required"/><br>
				<label>Do you want chequebook?</label><f:checkbox path="chequeStatus" value="yes"/><br>
				<input type="checkbox" checked="checked" style="margin-bottom: 15px">
				<label>Remember me</label>
				<p>
					By creating an account you agree to our <a onclick="document.getElementById('id08').style.display='block'">Terms <%="&"%> Privacy</a>.
				</p>
				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id07').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Sign Up</button>
				</div>
			</div>
		</f:form>
	</div>
	<div id="id08" class="modal">
	<form class="modal-content animate">
						<div class="imgcontainer">
				<span onclick="document.getElementById('id08').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
	<p>No Terms <%="&"%> Conditions</p>
	</div>
	</form>
	</div>
	<script>
		var modal1 = document.getElementById('id07');
		var modal2 = document.getElementById('id08');
		//When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal1) {
				modal1.style.display = "none";
			}
			if (event.target == modal2) {
				modal2.style.display = "none";
			}
		}
	</script>
</body>
</html>