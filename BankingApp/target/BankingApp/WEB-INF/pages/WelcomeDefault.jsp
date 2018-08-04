<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
<%@include file="css/Bank.css"%>
<%@include file="css/BankLogin.css"%>
</style>
<script type="text/javascript">
<%@include file="Javascript/Bank.js"%>
</script>
<title>Insert title here</title>
</head>
<body onload="noBack();">
	<div class="titleStyle" align="center">
		<label class="welcomeMsg">Soham's Bank</label>
		<ul>
			<li><a class="active" href="backToHome"><img
					src="resources/images/home.png"></a></li>
			<li><a
				onclick="document.getElementById('id01').style.display='block'">Transfer
					Money to another account<img
					src="resources/images/fundtransfer.png">
			</a></li>
			<li><a>View Transaction<img src="resources/images/view.png"></a>
				<ul class="dropdown">
					<li><a href="MiniStatement">Mini Statement</a></li>
					<li><a href="DetailedStatement">Detailed Statement</a></li>
				</ul></li>
			<li><a href="addrequest">Request For CheckBook<img
					src="resources/images/checkbook.png"></a></li>
			<li><a>Get Service Status<img
					src="resources/images/status.png"></a>
				<ul class="dropdown">
					<li><a
						onclick="document.getElementById('id02').style.display='block'">Get
							Service Status By Service ID</a></li>
					<li><a href="displayacc">Get All Service Status</a></li>
				</ul></li>
			<li style="float: right"><a>Welcome ${cus.custName}!<img
					src="resources/images/face.gif" /></a>
				<ul class="dropdown">
					<li><a
						onclick="document.getElementById('id03').style.display='block'">View/Edit
							Profile</a></li>
					<li><a
						onclick="document.getElementById('id04').style.display='block'">Change
							Password</a></li>
					<li><a href="logout" onclick="return confirmLogout();">Logout</a></li>
				</ul></li>
		</ul>
	</div>
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

		<f:form action="ByServiceid" method="post"
			class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="serviceId">
					<label><b>Service ID</b></label> <input type="number"
						name="serviceId" class="form-control"
						placeholder="Enter Service ID" required="required" />
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
		<f:form role="form" action="Update" modelAttribute="customer"
			method="post" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id03').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label class="registerMsg">View/Edit Details</label>
				<hr>
				<label><b>Account Id : </b></label><label>${acc.accountId}</label><br>
				<label><b>Customer Id : </b></label><label>${cus.customerId}</label><br>
				<label><b>Customer Name : </b></label><label>${cus.custName}</label><br>
				<label><b>Customer Email : </b></label><label>${cus.email}</label><br>
				<label><b>PAN No. : </b></label><label>${cus.panNo}</label><br>
				<label><b>Address : </b></label>
				<f:input path="Address" value="${cus.address}" required="required"
					onclick="updateDetails();" />
				<br> <label><b>Mobile No: </b></label>
				<f:input path="mobileNo" value="${cus.mobileNo}" required="required"
					onclick="updateDetails();" />
			</div>
			<div class="clearfix">
				<button type="submit" id="updateBtn" class="updateBtn"
					disabled="disabled">Update</button>
				<button type="button"
					onclick="document.getElementById('id03').style.display='none'"
					class="cancelDetailsbtn">Cancel</button>
			</div>
		</f:form>
	</div>
	<div id='id04' class="modal">
		<f:form role="form" action="ChangePwd" modelAttribute="accountholder"
			method="POST" class="modal-content animate"
			onsubmit="return confirmPassword();">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id04').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label class="registerMsg">Update Password</label>
				<hr>
				<label><b>Old Password : </b></label>
				<f:password path="Password" required="required" />
				<br> <label><b>New Password : </b></label>
				<f:password id="pwd" path="transPassword" required="required" />
				<label><b>Confirm new password</b></label> <input type="password"
					id="cnfpwd" required />
				<div class="clearfix">
					<button type="submit" class="updatePwdBtn"
						onclick="confirmPassword();">Update Passowrd</button>
					<button type="button"
						onclick="document.getElementById('id04').style.display='none'"
						class="cancelDetailsbtn">Cancel</button>
				</div>
			</div>
		</f:form>
	</div>
	<script>
		var modal1 = document.getElementById('id01');
		var modal2 = document.getElementById('id02');
		var modal3 = document.getElementById('id03');
		var modal4 = document.getElementById('id04');
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
		}
	</script>
</body>
</html>