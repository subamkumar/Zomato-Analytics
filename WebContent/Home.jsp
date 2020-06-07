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

</head>
<body>
	<div class="container">
			
			
				<img alt="logo" src="spoonlogo.png" style="margin-left:0px;float:left;width:200px;height:200px;">
			
				<img alt="image" src="zomato-image.jpg" style="float:left;width:80%;height:200px;">
			
				<div style="clear:both;"></div>
				
			<div style='background-image: url("bg-zomato.jpg");width:98%;padding:30px;margin-top:10px;height:350px;'>
				<h1 style="color:#fff;margin-top:100px;font-size:70px;margin-left:150px;">Our mission is to ensure nobody has a bad meal</h1>
			</div>
			
			<div class="row" style="margin-top:20px;font-size:20px;">
				<div class="col-md-3" /*style="text-align:center;*/">
					<h2>Country-Wise-Restaurants</h2>
					<a href="/adbm/index.jsp">1. DOUGHNUT</a>
					<br>
					<a href="/adbm/index4.jsp">2. BAR</a>
				</div>
				<div class="col-md-3" /*style="text-align:center;*/">
				<h2>Country-Wise-App-Usage</h2>
					<a href="/adbm/index1.jsp">1. DOUGHNUT</a><br>
					<a href="/adbm/index5.jsp">2. BAR</a>
				</div>
				<div class="col-md-3" /*style="text-align:center;*/">
					<h2>Restaurants-Ratings-View</h2>
					<a href="/adbm/index3.jsp">1. DOUGHNUT</a><br>
					<a href="/adbm/index6.jsp">2. BAR</a>
				</div>
				<div class="col-md-3" /*style="text-align:center;*/">
					<h2>Restaurants-Price-View</h2>
					<a href="/adbm/index7.jsp">1. DOUGHNUT</a><br>
					<a href="/adbm/index8.jsp">2. BAR</a>
				</div>
			</div>
			<center>
			<form action="/adbm/Upload.jsp" method="post" enctype="multipart/form-data">
				<input type="file" name="fileName">
				<input type="submit" value="upload"/>
			</form>
			</center>
	</div>





</body>
</html>