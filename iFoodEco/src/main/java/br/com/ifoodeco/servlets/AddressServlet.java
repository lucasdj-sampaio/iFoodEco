package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifoodeco.entity.Address;
import br.com.ifoodeco.entity.Restaurant;
import br.com.ifoodeco.util.Util;

@WebServlet(description = "Get address data from ifood html page", urlPatterns = { "/secondStep" })
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    public AddressServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		
		Address address = new Address(request.getParameter("logradouro").toString()
				, Integer.parseInt(Util.replaceChar(request.getParameter("cep")))
				, Integer.parseInt(request.getParameter("numero"))
				, request.getParameter("complemento"));
		
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");	
		restaurant.setScheduledDelivery("on".equals(request.getParameter("entregaAgendada")) ? true : false);
		restaurant.setAddress(address);
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_proprietario.jsp");
    	rd.forward(request, response);
	}
}