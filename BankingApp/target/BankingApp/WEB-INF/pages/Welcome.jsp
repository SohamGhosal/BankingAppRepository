<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<c:if test="${not empty msg }">
		<script>
			alert("${msg}");
		</script>
	</c:if>
	<ul>
		<li><a class="active" href="backToHome"><img
				src="resources/images/home.png"></a></li>
		<li><a
			onclick="document.getElementById('id01').style.display='block'">Transfer
				Money to another account<img src="resources/images/fundtransfer.png">
		</a></li>
		<li><a>View Transaction<img src="resources/images/view.png"></a>
			<ul class="dropdown">
				<li><a href="MiniStatement">Mini Statement</a></li>
				<li><a href="DetailedStatement">Detailed Statement</a></li>
			</ul></li>
		<li><a href="display">Request For CheckBook<img
				src="resources/images/checkbook.png"></a></li>
		<li><a>Get Service Status<img
				src="resources/images/status.png"></a>
			<ul class="dropdown">
				<li><a
					onclick="document.getElementById('id02').style.display='block'">Get
						Service Status By Service ID</a></li>
				<li><a href="displayacc">Get All Service Status</a></li>
			</ul></li>
		<li style="float:right"><a>Welcome ${cus.custName}!<img
				src="resources/images/face.gif" /></a>
			<ul class="dropdown">
				<li><a
					onclick="document.getElementById('id03').style.display='block'">View Profile</a></li>
				<li><a
					onclick="document.getElementById('id04').style.display='block'">Edit Details</a></li>
				<li><a
					onclick="document.getElementById('id05').style.display='block'">Change Password</a></li>
				<li><a href="logout" onclick="return confirmLogout();">Logout</a></li>
			</ul></li>
	</ul>

	<br>
	<br>
	<br>
	<br>

	<p style="background-color: white">This Bank is a well known Bank</p>
	<div id="id01" class="modal">
		<f:form action="FundTrans" method="post" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group">
					<label>Your account no : </label><label>${user.accId}</label> <input
						type="hidden" name="accId" value="${user.accId}" /> <br> <label>Payee
						account no : </label> <input name="payeeAccId" type="number"
						required="required" /> <label>Amount : </label> <input
						name="amount" type="number" required="required" />
				</div>
				<button type="submit">Complete Fund Transfer</button>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancel</button>
			</div>
		</f:form>
	</div>
	<div id="id02" class="modal">

		<f:form action="ByServiceid" method="post" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="serviceId">
					<label><b>Service ID</b></label> 
		<input type="number" name="serviceId" class="form-control" placeholder="Enter Service ID" required="required"/>
				</div>
				<button type="submit">Login</button>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id02').style.display='none'"
					class="cancelbtn">Cancel</button>
			</div>
		</f:form>
	</div>
	 <div id="id03" class="modal">
<table border="3" align="center">
<tr>
<td>Account Id:</td><td>${acc.accountId }</td>
</tr>
<tr>
<td>Customer Id:</td><td>${cus.customerId }</td>
</tr>
<tr>
<td>Customer Name:</td><td>${cus.custName }</td>
</tr>
<tr>
<td>Customer Email:</td><td>${cus.email }</td>
</tr>
<tr>
<td>PAN CARD:</td><td>${cus.panNo }</td>
</tr>
<tr>
<td>Address:</td><td>${cus.address }</td>
</tr>
<tr>
<td>Mobile No:</td><td>${cus.mobileNo }</td>
</tr>
<tr>
<td></td><td><a  href="backToHome"><img src="resources/images/home.png"></a></td>
</tr>
</table>
	</div>
	
	<div id="id04" class="modal">
	<f:form action="Update" modelAttribute="customer" method="post">
	<table border="3" align="center">
<tr>
<td>Account Id:</td><td>${acc.accountId }</td>
</tr>
<tr>
<td>Customer Id:</td><td>${cus.customerId }</td>
</tr>
<tr>
<td>Customer Name:</td><td>${cus.custName }</td>
</tr>
<tr>
<td>Customer Email:</td><td>${cus.email }</td>
</tr>
<tr>
<td>PAN CARD:</td><td>${cus.panNo }</td>
</tr>
<tr>
<td>Address:</td><td><f:input path="Address" value="${cus.address }" required="required" /> <small>Please Enter Updated </small></td>
</tr>
<tr>
<td>Mobile No:</td><td><f:input path="mobileNo" value="${cus.mobileNo }" required="required"/><small>Please Enter updated Mobile Number</small></td>
</tr>
<tr>
<tr>
					<td><input type="submit" value="Update" /></td>
					<td><input type="button" onclick="location.href='backToHome';" value="Back to Home" /></td>
</tr>
</table>
</f:form>
	</div> 
	<div id='id05' class="modal">
	<f:form action="ChangePwd" modelAttribute="accountholder" method="POST" onsubmit="return confirmPassword();">
	<table align="center" border=1>
		<tr>
			<td>Enter current password</td>
			<td><f:password path="Password" required="required"/></td>
		</tr>
		
		<tr>
			<td>Enter new password</td>
			<td><f:password id="pwd" path="transPassword" required="required"/></td>
		</tr>
		<tr>
			<td>Confirm new password</td>
			<td><input type="password" id="cnfpwd" required/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Change Password"/></td>
			<td><input type="button" onclick="location.href='backToHome';" value="Back to Home" /></td>
		</tr>
	</table>
</f:form>
	</div>
	<script>
		var modal1 = document.getElementById('id01');
		var modal2 = document.getElementById('id02');
		var modal3 = document.getElementById('id03');
		var modal4 = document.getElementById('id04');
		var modal5 = document.getElementById('id05');
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
		}
	</script>
</body>
</html>