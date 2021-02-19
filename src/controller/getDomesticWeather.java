/**
 * @author Thomas Vanderbruggen - tvanderbruggen
 * CIS175 - Spring 2021
 * 2/18/2021
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WeatherInfoDomestic;

/**
 * Servlet implementation class getDomesticWeather
 */
@WebServlet("/getDomesticWeather")
public class getDomesticWeather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDomesticWeather() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = request.getParameter("userCity"); 
		String state = request.getParameter("userState"); 
		WeatherInfoDomestic weatherInfo = new WeatherInfoDomestic(city, state); 
		
		request.setAttribute("weatherInfo", weatherInfo);
		
		getServletContext().getRequestDispatcher("/domesticresult.jsp").forward(request, response);
		
	}

}
