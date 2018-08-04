<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="titleStyle" align="center">
		<label class="welcomeMsg">Soham's Bank</label>
		<c:if test="${not empty error}">
			<script>
				alert("${error}");
			</script>
		</c:if>
		<ul>
		<li><a class="active" href="#">Home</a></li>
		<li><a onClick="document.getElementById('id01').style.display='block'">Login</a></li>
		<li><a onclick="document.getElementById('id02').style.display='block'">Sign Up</a></li>
		<li><a onclick="document.getElementById('id05').style.display='block'">Admin Login</a></li>
		<!-- <li><a onclick="document.getElementById('id06').style.display='block'">Know Your Credential</a></li> -->
		<li style="float:right"><a onclick="document.getElementById('id06').style.display='block'">About</a></li>
		</ul>
	</div>
	<div id="id01" class="modal">

		<f:form role="form" action="loginuser" method="Post"
			modelAttribute="accountholder" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="userId">
					<label><b>UserID</b></label>
					<f:input path="userId" type="number" class="form-control"
						id="userid" placeholder="Enter Six Digit User ID"
						required="required" />
					<f:errors path="userId" class="form-control" />
				</div>

				<label><b>Password</b></label>
				<f:password path="password" id="psw" placeholder="Enter password" />
				<label> <input type="checkbox" checked="checked">
					Remember me
				</label>
				<button type="submit">Login</button>
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtnLogin">Cancel</button>
			</div>

			<div class="container" style="background-color: #f1f1f1" id="myLinks">

				Not a member? <a
					onclick="document.getElementById('id02').style.display='block'"
					style="color: red">Sign Up</a>
					<a style="padding-left: 14em"
					onclick="document.getElementById('id04').style.display='block'"
					style="color: red">Forgot Password?</a><br>
				<p>
					By creating an account you agree to our <a
						onclick="document.getElementById('id03').style.display='block'">Terms
						& Privacy</a>.
				</p>


			</div>
		</f:form>
	</div>
	<br>
	<br>
	<!--SignUp Page  -->

	<div id="id02" class="modal">
		<f:form role="form" action="registerUser" method="post"
			modelAttribute="customerRequest" class="modal-content animate"
			onsubmit="passWordCheck();">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label class="registerMsg">Sign Up</label>
				<p>Please fill in this form to create an account.</p>
				<hr>
				<label><b>First Name : </b></label> <input type="text"
					placeholder="First Name" name="fname" required /> <label><b>Last
						Name : </b></label> <input type="text" placeholder="Last Name" name="lname"
					required /> <label><b>Email</b></label>
				<f:input type="text" path="email" placeholder="Enter Email"
					name="email" required="required" />
				<label><b>Phone No. : </b></label>
				<f:input type="tel" path="mobileNo"
					placeholder="Enter your 10 digit mobile no" name="mobileNo"
					required="required" />
				<br> <label><b>Address : </b></label>
				<f:textarea path="address" required="required" />
				<br> <label><b>PAN No. : </b></label>
				<f:input type="text" path="panNo" placeholder="Enter your PAN no."
					name="panNo" required="required" />
				<br> <label><b>Choose Security Question : </b></label>
				<f:select path="secretQuest">
					<c:forEach items="${secretQuest}" var="secretQid">
						<f:option value="${secretQid.securityQuest}" required="required" />
					</c:forEach>
				</f:select>
				<br> <label><b>Answer : </b></label>
				<f:input type="text" path="ans" placeholder="Answer the Question"
					required="required" />
				<br> <label>Choose Account Type : </label>
				<f:radiobutton path="accountType" value="savings"
					required="required" />
				Savings
				<f:radiobutton path="accountType" value="current"
					required="required" />
				Current<br> <label>Minimum Account Balance</label>
				<f:input type="number" path="accountBal" required="required" />
				<br> <label>Do you want chequebook?</label>
				<f:checkbox path="chequeStatus" value="yes" />
				<br> <input type="checkbox" checked="checked"
					style="margin-bottom: 15px"> <label>Remember me</label>
				<p>
					By creating an account you agree to our <a
						onclick="document.getElementById('id03').style.display='block'">Terms
						& Privacy</a>.
				</p>
				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id02').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Sign Up</button>
				</div>
			</div>
		</f:form>
	</div>
	<div id="id03" class="modal">
		<form role="form" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id03').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label>No Terms  Conditions</label>
			</div>
		</form>
	</div>
	<div id="id04" class="modal">

		<f:form role="form" action="ForgotAccount" method="post"
			modelAttribute="accountholder" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id04').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="userId">
					<label><b>UserID</b></label>
					<f:input path="userId" type="number" class="form-control"
						id="userid" placeholder="Enter Six Digit User ID"
						required="required" />
					<f:errors path="userId" />
				</div>
				<button type="submit">Login</button>
				<button type="button"
					onclick="document.getElementById('id04').style.display='none'"
					class="cancelbtnLogin">Cancel</button>
			</div>
		</f:form>
	</div>
	<div id="id05" class="modal">
		<f:form role="form" action="adminLogin" method="Post"
			modelAttribute="bankAdmin" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id05').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="adminId">
					<label><b>Admin ID</b></label>
					<f:input type="text" name="adminId" path="adminId"
						class="form-control" placeholder="Enter Admin ID" id="adminid"
						required="required" />
				</div>

				<label><b>Password</b></label>
				<f:password path="adminPassword" id="psw"
					placeholder="Enter password"  required="required" />
				<label> <input type="checkbox" checked="checked">
					Remember me
				</label>
				<button type="submit">Admin Login</button>
				<button type="button"
					onclick="document.getElementById('id05').style.display='none'"
					class="cancelbtnLogin">Cancel</button>
			</div>
		</f:form>
	</div>
	<%--  <div id="id07" class="modal">
		<f:form role="form" action="knowCredentials" method="post" class="modal-content animate" modelAttribute="customerRequest">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id07').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="userId">
					<label><b>Customer ID : </b></label>
					<f:input type="number" path="custReqId" class="form-control"
						name="customerId" placeholder="Enter Six Digit Customer ID"
						required="required"/>
						<label><b>Email ID : </b></label>
						<f:input type="email" path="email" class="form-control"
					 placeholder="Enter Six Digit Customer ID"
						required="required"/>
				</div>
				<button type="submit">Login</button>
				<button type="button"
					onclick="document.getElementById('id07').style.display='none'"
					class="cancelbtnLogin">Cancel</button>
			</div>
		</f:form>
	</div> --%>
	<div id="id06" class="modal">
		<form role="form" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id06').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<p>Created by Soham Ghosal</p>
			</div>
		</form>
	</div>
	<script>
		var modal1 = document.getElementById('id01');
		var modal2 = document.getElementById('id02');
		var modal3 = document.getElementById('id03');
		var modal4 = document.getElementById('id04');
		var modal5 = document.getElementById('id05');
		var modal6 = document.getElementById('id06');
		//When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal1) {
				modal1.style.display = "none";
			}
			if (event.target == modal2) {
				modal2.style.display = "none";
			}
			if (event.target == modal3) {
				modal3.style.display = "none";
			}
			if (event.target == modal4) {
				modal4.style.display = "none";
			}
			if (event.target == modal5) {
				modal5.style.display = "none";
			}
			if (event.target == modal6) {
				modal6.style.display = "none";
			}
		}
	</script>
</body>
</html>