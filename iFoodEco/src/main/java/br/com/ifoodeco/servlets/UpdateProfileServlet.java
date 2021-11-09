package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.ifoodeco.dao.RestaurantDao;
import br.com.ifoodeco.entity.Address;
import br.com.ifoodeco.entity.Restaurant;
import br.com.ifoodeco.util.Util;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	Address address = new Address(request.getParameter("logradouro").toString()
				, Integer.parseInt(Util.replaceChar(request.getParameter("cep")))
				, Integer.parseInt(request.getParameter("numero"))
				, request.getParameter("complemento"));
				
		restaurant = RestaurantDao
				.getRestaurant(Long.parseLong(Util.replaceChar(request.getParameter("cnpj"))));
		
		restaurant.setAddress(address);
		restaurant.setEmailAddress(request.getParameter("email").toString());
    	restaurant.setNumber(Long.parseLong(Util.replaceChar(request.getParameter("telefone").toString())));
    	restaurant.setPlan(request.getParameter("plano").toString());
    	restaurant.setName(request.getParameter("nomeLoja").toString());
		restaurant.setCategory(request.getParameter("categoria").toString());
		
		RestaurantDao.updateRestaurantDao(restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("getRestaurant?cnpj=" + restaurant.getCnpjNumber());
    	rd.forward(request, response);
	}
}
