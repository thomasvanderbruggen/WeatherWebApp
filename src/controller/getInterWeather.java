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

import model.WeatherInfoInter;

/**
 * Servlet implementation class getInterWeather
 */
@WebServlet("/getInterWeather")
public class getInterWeather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getInterWeather() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("userCity"); 
		String country = request.getParameter("userCountry"); 
		WeatherInfoInter weatherInfo = new WeatherInfoInter(city, country); 
		request.setAttribute("weatherInfo", weatherInfo); 
		
		getServletContext().getRequestDispatcher("/interresult.jsp").forward(request, response); 
	}

}
