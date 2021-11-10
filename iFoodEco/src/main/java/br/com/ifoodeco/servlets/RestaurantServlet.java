package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifoodeco.dao.CategoryDao;
import br.com.ifoodeco.dao.PlanDao;
import br.com.ifoodeco.dao.RestaurantDao;
import br.com.ifoodeco.entity.Plan;
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
		
		Plan plan = new Plan();
    	plan.setPlan(request.getParameter("plano").toString());
			
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");
		restaurant.setPlan(plan);
		
		session.removeAttribute("restaurant");
		request.setAttribute("restaurant", restaurant);
		request.setAttribute("planList", PlanDao.getAll());
		request.setAttribute("categoryList", CategoryDao.getAll());
		
		if (RestaurantDao.insertRestaurantDao(restaurant)) {
			RequestDispatcher rd = request.getRequestDispatcher("retorno_cadastro_index.jsp");
	    	rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    	rd.forward(request, response);
		}
	}
}