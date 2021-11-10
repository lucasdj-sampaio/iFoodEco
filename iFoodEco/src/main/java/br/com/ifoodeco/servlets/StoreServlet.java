package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifoodeco.entity.Category;
import br.com.ifoodeco.entity.Restaurant;
import br.com.ifoodeco.util.Util;

@WebServlet(description = "This servlet get store data from webPage", urlPatterns = { "/thirdStep" })
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    public StoreServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
			
		Category category = new Category();
    	category.setCategory(request.getParameter("categoria").toString());
		
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");	
		restaurant.setName(request.getParameter("nomeLoja").toString());
		restaurant.setCategory(category);
		restaurant.setCnpjNumber(Long.parseLong(Util.replaceChar(request.getParameter("cnpj").toString())));
		restaurant.setAgencyNumber(Integer.parseInt(Util.replaceChar(request.getParameter("agencia").toString())));
		restaurant.setAccountNumber(Integer.parseInt(Util.replaceChar(request.getParameter("conta"))));
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("pagamento.jsp");
    	rd.forward(request, response);
	}
}