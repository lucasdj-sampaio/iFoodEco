package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.ifoodeco.dao.RestaurantDao;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This servlet create all data for restaurant", urlPatterns = { "/getRestaurant" })
public class GetRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
	
	public void destroy() {
		  super.destroy();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		
		restaurant = RestaurantDao.getRestaurant(Long.parseLong(request.getParameter("cnpj")));
		
		request.setAttribute("restaurant", restaurant);
		
		RequestDispatcher rd = request.getRequestDispatcher("retorno_cadastro_index.jsp");
	    rd.forward(request, response);
	}
}