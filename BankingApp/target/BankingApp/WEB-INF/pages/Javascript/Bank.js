
function noBack()
{
	window.history.forward();
}
function confirmLogout()
{
	var r=confirm("Are you sure you want to log out? Your current session will be ended");
	if(r===true)
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