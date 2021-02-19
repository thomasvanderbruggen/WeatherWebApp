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
<title>United States Weather Information Input</title>
</head>
<body>
<h1>United States City Input</h1>
<form action="getDomesticWeather" method="post"> 
Enter the City: 
<input type="text" name="userCity" size="25"> <br> 
Enter the State Abbreviation: 
<input type="text" name="userState" size="2"> <br>
<input type="submit" value ="Get Weather" /> 
</form>
</body>
</html>