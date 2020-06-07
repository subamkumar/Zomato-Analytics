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
	
		
			
		<%
			
				if(request.getMethod() == "POST")
				{
					Runtime r = Runtime.getRuntime();
		  			Process p = null;
		  			String command = "mongoimport --db zomato --collection restaurants --type csv --file C:/Users/Owner/Desktop/zomato.csv --headerline";
		  			try {
		   				p = r.exec(command);
		   				System.out.println("Reading csv into Database");

		  			} catch (Exception e){
		   			System.out.println("Error executing " + command + e.toString());
		  		}
				out.print("File Uploaded Successfully");
				}	
			
			
		%>
		<center>
		<a href="/adbm/Home.jsp">HOME</a>
		</center>	
	
	</div>
</body>
</html>