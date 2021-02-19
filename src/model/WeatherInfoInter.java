/**
 * @author Thomas Vanderbruggen - tvanderbruggen
 * CIS175 - Spring 2021
 * 2/18/2021
 */
package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class WeatherInfoInter {
	private String currentConditions;
	private double actualTemp; 
	private double feelsLike; 
	private double windSpeed; 
	private String windDirCardinal; 
	private int humidity; 
	private String city; 
	private String cityForURL; 
	private String country; 
	private final String API_KEY = ""; 
	public WeatherInfoInter() {} 
	public WeatherInfoInter(String city, String country) { 
		this.city = city; 
		this.country = country; 
		setWeather(); 
	}
	public String getCurrentConditions() {
		return currentConditions;
	}
	public void setCurrentConditions(String currentConditions) {
		this.currentConditions = currentConditions;
	}
	public double getActualTemp() {
		return actualTemp;
	}
	public void setActualTemp(double actualTemp) {
		this.actualTemp = actualTemp;
	}
	public double getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirCardinal() {
		return windDirCardinal;
	}
	public void setWindDirCardinal(String windDirCardinal) {
		this.windDirCardinal = windDirCardinal;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityForURL() {
		return cityForURL;
	}
	public void setCityForURL(String cityForURL) {
		this.cityForURL = cityForURL;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAPI_KEY() {
		return API_KEY;
	}
	public void setWeather() { 

		try {
			cityForURL = convertCityToURLCompliant(); 
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityForURL + "," + country +"&appid=" + API_KEY + "&units=imperial"); 
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setDoInput(true); 
			con.setRequestProperty("Content-Type", "0");
			con.connect(); 
			BufferedReader in = new BufferedReader (new InputStreamReader(con.getInputStream()));
			String inputLine; 
			StringBuffer content = new StringBuffer(); 
			while ((inputLine = in.readLine()) != null) { 
				content.append(inputLine); 
			}
			in.close();
			if (con.getResponseCode() != 200) { 
				System.out.println(con.getResponseCode());
			}
			JsonReader jReader = Json.createReader(new StringReader(content.toString()));
			
			JsonObject jsonResponse = jReader.readObject(); // inital JsonObject
			JsonArray tempArr = jsonResponse.getJsonArray("weather");
			JsonObject tempObj = tempArr.getJsonObject(0); 
			currentConditions = tempObj.getString("description"); // get Description value
			tempObj  = jsonResponse.getJsonObject("main"); // Switch to "main" JsonObject
			actualTemp = tempObj.getJsonNumber("temp").doubleValue(); // get temp value
			feelsLike = tempObj.getJsonNumber("feels_like").doubleValue(); //get feels like value
			humidity = tempObj.getJsonNumber("humidity").intValue(); //get humidity value
			
			tempObj = jsonResponse.getJsonObject("wind"); //change to "wind" jsonObject
			windSpeed = tempObj.getJsonNumber("speed").intValue(); 
			windDirCardinal = convertDegIntoCardinal(tempObj.getJsonNumber("deg").intValue()); //get wind direction value
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String convertCityToURLCompliant() { 
		String cityFixed = ""; 
		for (int i = 0; i < city.length(); i++) { 
			if (Character.isWhitespace(city.charAt(i))){ 
				cityFixed += "%20"; 
			}else { 
				cityFixed += city.charAt(i); 
			}
		}
		return cityFixed; 
	}
	public String convertDegIntoCardinal(int deg) { 
		String card;
		if (deg < 23){
			card = "N";
	    }else if (deg < 68){
	    	card = "NE";
	    }else if (deg < 113){
	    	card = "E";
	    }else if (deg < 158){
	    	card = "SE";
	    }else if (deg < 203) {
	    	card = "S";
	    }else if (deg < 248) {
	    	card = "SW";
	    }else if (deg < 293){
	    	card = "W";
	    }else if (deg < 333){
	    	card = "NW";
	    }else {
	    	card = "N";
	    }
		return card; 
	}
}
