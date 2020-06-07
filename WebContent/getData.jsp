<%@page import="adbm.connect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		if(request.getMethod() == "GET")
		{
			
			String param = request.getParameter("q");
			System.out.println("Param: "+ param);
			if(Integer.parseInt(param) == 1)
			{
				connect con = new connect();
				out.print(con.getCountryRestaurants());
			}
			else
			{
				out.print("sdsdjhg");
			}
		}
	%>
</body>
</html>