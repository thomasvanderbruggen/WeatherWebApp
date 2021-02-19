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
<title>Domestic Weather Results!</title>
</head>
<body>
<p> Weather Information for ${weatherInfo.getCity()}, ${weatherInfo.getState()} <br>
Conditions: ${weatherInfo.getCurrentConditions()}<br>
Actual Temperature: ${weatherInfo.getActualTemp()} ° Fahrenheit<br>
Feels like: ${weatherInfo.getFeelsLike()} ° Fahrenheit<br>
Humidity: ${weatherInfo.getHumidity()}%<br>
<br>
Wind Speed: ${weatherInfo.getWindSpeed()} MPH<br>
Wind Direction: ${weatherInfo.getWindDirCardinal()}<br>
</body>
<a href="interrequest.jsp">Find international weather information</a>
<a href="domesticrequest.jsp">Find domestic weather information</a>
</html>