<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADBMS Project</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	function auth()
	{
		var Username = document.getElementById("user").value;
		var Password = document.getElementById("pass").value;
		//alert("User: "+ Username);
		//alert("Pass: "+ Password);
		
		if(Username == "" || Password == "")
		{
			alert("Empty Enter Valid Credential");	
			return false;
		}
		else
		{
			if(Username == "admin" && Password == "admin@123")
			{
				return true;	
			}
			else
			{
				alert("Enter Valid Credentials");
				document.getElementById("user").value = "";
				document.getElementById("pass").value = "";
				return false;
			}
				
		}
	}


</script>
</head>
<body>
	<div class="container">
		<center>
		<div style="margin-top:200px;text-align:center;border:0px solid black;padding:10px;width:300px;">
		
		<center>
			<h1 style="font-family:algerian;">LOGIN</h1>
			<form action="Home.jsp" method="POST" onSubmit="return auth()">
				<input type="text" id="user" placeholder="Username"/><br><br>
				<input type="password" id="pass" placeholder="Password"/><br><br>
				<button>Log In</button>
			</form>
		</center>	
		</div>
		</center>	
	<div>
</body>
</html>