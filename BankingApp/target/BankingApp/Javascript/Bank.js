
function noBack()
{
	window.history.forward();
}
function confirmLogout()
{
	var r=confirm("Are you sure you want to log out? Your current session will be ended");
	if(r==true)
	{
		return true;
	}
	else
	{
		return false;
	}
}
function confirmPassword()
{
	var pwd=document.getElementById('pwd');
	var cnfpwd=document.getElementById('cnfpwd');
	if(pwd.value==cnfpwd.value)
	{
		var x=confirm("Do you really want to change the password?");
		if(x==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	else
	{
		alert("Password and confirm password doesn't match");
		return false;
	}
}
function confirmUpdate()
{
	var x=confirm("Are you sure you want to update the details?");
	if(x==true)
	{
		return true;
	}
	else
	{
		return false;
	}
}
function roleCheck()
{
	if(document.getElementById("user").checked)
	{
		document.getElementById("userId").style.display='block';
		document.getElementById("userid").setAttribute("required","required");
		document.getElementById("adminid").removeAttribute("required");
		document.getElementById("adminId").style.display='none';
	}
	else if(document.getElementById("admin").checked)
	{
		document.getElementById("adminId").style.display='block';
		document.getElementById("adminid").setAttribute("required","required");
		document.getElementById("userid").removeAttribute("required");
		document.getElementById("userId").style.display='none';
	}
	else
	{
		document.getElementById("adminId").style.display='none';
		document.getElementById("userId").style.display='none';
	}
}
function passWordCheck()
{
	var pwd=document.getElementById("password").val();
	var rpwd=document.getElementById("pswRepeat").val();
	if(pwd==rpwd)
		{
			return true;
		}
	else
		{
			return false;
		}
}