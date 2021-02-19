<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<style> 
	*{
		font-family: sans-serif;
	}
</style>
<meta charset="ISO-8859-1">
<title>International Weather Results</title>
</head>
<body>
<h1>Weather Results for ${weatherInfo.getCity()}, ${weatherInfo.getCountry()}</h1>
<p> Conditions: ${weatherInfo.getCurrentConditions()}<br> 
Actual Temperature: ${weatherInfo.getActualTemp()}° Fahrenheit <br> 
Feels Like: ${weatherInfo.getFeelsLike()}° Fahrenheit<br> 
Humidity: ${weatherInfo.getHumidity()}%<br> 
<br> 
Wind Speed: ${weatherInfo.getWindSpeed()} MPH <br> 
Wind Direction: ${weatherInfo.getWindDirCardinal()}<br> 
</body>
<a href="interrequest.jsp">Find international weather information</a><br>
<a href="domesticrequest.jsp">Find domestic weather information</a>
</html>