<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="css/BankLogin.css"%>
<%@include file="css/Bank.css"%>
</style>
<script type="text/javascript">
	
<%@include file="Javascript/Bank.js"%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="noBack();">
<div class="titleStyle" align="center">
		<label class="welcomeMsg">Soham's Bank</label>
	<ul>
		<li><a href="adminhome"><img
				src="resources/images/home.png"></a></li>
		<li><a href="Register">Add an Account<img
				src="resources/images/imgavt.png"></a></li>
		<li><a href="CnfUsrReq">Confirm Request<img
			src="resources/images/checkbook.png" /></a></li>
		<li><a>View Customers<img src="resources/images/status.png"></a>
		<ul class="dropdown">
		<li><a onclick="document.getElementById('id01').style.display='block'" style="width: auto;">View A specific Customer</a></li>
		<li><a href="ViewAllCustomers" style="width: auto;">View All Customers</a></li>
		</ul></li>
		<li><a>Get Transaction Logs<img src="resources/images/view.png"></a>
			<ul class="dropdown">
				<li><a onclick="document.getElementById('id02').style.display='block'" style="width: auto;">Get Transaction Logs for An Account</a></li>
				<li><a href="getAllLogs">Get All Transaction Logs</a></li>
			</ul></li>
		<li style="float: right"><a>Welcome ${ba.adminId}!<img
				src="resources/images/face.gif" /></a>
			<ul class="dropdown">
				<li><a onclick="document.getElementById('id03').style.display='block'" style="width: auto;">View Profile</a></li>
				<li><a onclick="document.getElementById('id04').style.display='block'" style="width: auto;">Change Password</a></li>
				<li><a href="adminLogout" onClick="return confirmLogout();">Logout</a></li>
			</ul>
			</li>
			</ul>
			</div>
			<br><br>
	<div id="id01" class="modal">

		<form action="ViewCustomer" method="post" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="customerId">
					<label><b>Customer ID</b></label>
					<input type="number" class="form-control" name="customerId" placeholder="Enter Six Digit Customer ID" required />
				</div>
				<button type="submit">View Customer</button>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
			</div>
		</form>
	</div>
	<div id="id02" class="modal">

		<form action="getLog" method="post" class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group" id="customerId">
					<label><b>Account ID</b></label>
					<input type="number" class="form-control" name="accountId" placeholder="Enter Six Digit Account ID" required />
				</div>
				<button type="submit">Login</button>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
			</div>
		</form>
	</div>
	<div id="id03" class="modal">

		<form class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id03').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="resources/images/imgavt.png" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<div class="form-group">
					<label>Admin ID : </label><label>${ba.adminId }</label>
					<label>Permission : </label><label>Full Access</label>
					</div>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button" onclick="document.getElementById('id03').style.display='none'" class="cancelbtn">Cancel</button>
			</div>
		</form>
	</div>
	<div id="id04" class="modal">

		<form class="modal-content animate">
		<div class="imgcontainer">
				<span onclick="document.getElementById('id04').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
			<div class="form-group">
			<label>For Security Reason Contact with your DBA for password change</label>
			</div>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancelbtn">Cancel</button>
			</div>
		</form>
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