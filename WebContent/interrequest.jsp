<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style> 
	*{
		font-family: sans-serif;
	}
</style>
<meta charset="ISO-8859-1">
<title>International Weather Request</title>
</head>
<body>
<h1> International Location Input</h1>
<form action="getInterWeather" method="post">   
Enter the city: 
<input type="text" name="userCity" size="30"> <br> 
Enter the Country Abbreviation (UK, CA, MX, DE, etc): 
<input type="text" name="userCountry" size="2"> <br> 
<input type="submit" value="Get Weather" /> 
</form>
</body>
</html>