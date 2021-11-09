package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ifoodeco.dao.RestaurantDao;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This servlet create all data for restaurant", urlPatterns = { "/addRestaurant" })
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
	
	public void destroy() {
		  super.destroy();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
			
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");
		restaurant.setPlan(request.getParameter("plano").toString());
		session.removeAttribute("restaurant");
		
		if (RestaurantDao.insertRestaurantDao(restaurant)) {
			RequestDispatcher rd = request.getRequestDispatcher("getRestaurant?cnpj=" + restaurant.getCnpjNumber());
	    	rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    	rd.forward(request, response);
		}
	}
}