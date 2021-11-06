package br.com.ifoodeco.servlets;
import br.com.ifoodeco.entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifoodeco.dao.RestaurantDao;

@WebServlet(description = "This servlet create all data for restaurant", urlPatterns = { "/AddRestaurantServlet" })
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Restaurant restaurant;
	private List<Pix> pixList;
	private List<Packaging> packList;
	private List<PayMethod> payList; 

	@Override
	public void init(ServletConfig config) throws ServletException {
		  super.init();
		  restaurant = new Restaurant();
		  pixList = new ArrayList<Pix>();
		  packList = new ArrayList<Packaging>();
		  payList = new ArrayList<PayMethod>();
	}
	
	public void destroy() {
		  super.destroy();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		    
		//HttpSession session = request.getSession();
		
		setIntoRestaurant(request);
		
	    RestaurantDao.insertRestaurantDao(restaurant);
	}
	
	private void setIntoRestaurant(HttpServletRequest request) {
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
	    if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
            	String currentHeader = headerNames.nextElement();
            	
            	if (currentHeader.contains("pix")) {
            		//pixList.add(request.getHeader(currentHeader));
            	}
            	else if (currentHeader.contains("embalagem")) {     
            		packList.add(new Packaging(
            				request.getHeader(currentHeader)));
            	}
            	else if (currentHeader.contains("pagamento")) {
            		payList.add(new PayMethod(
            				request.getHeader(currentHeader)));
            	}
            }
	    }
		
		Address address = new Address(
				request.getAttribute("rua").toString()
				, Integer.parseInt(request.getAttribute("cep").toString())
				, Integer.parseInt(request.getAttribute("numero").toString())
				, request.getAttribute("complemento").toString());
		
		boolean scheduler = request.getAttribute("agendamento").toString().toUpperCase() == "SIM" ? true : false;
		
	    restaurant.setCnpjNumber(Integer.parseInt(request.getAttribute("cnpj").toString()));
	    restaurant.setAddress(address);
	    restaurant.setName(request.getAttribute("nome").toString());
	    restaurant.setNumber(Integer.parseInt(request.getAttribute("telefone").toString()));
	    restaurant.setEmailAddress(request.getAttribute("email").toString());
	    restaurant.setAgencyNumber(Integer.parseInt(request.getAttribute("agencia").toString()));
	    restaurant.setAccountNumber(Integer.parseInt(request.getAttribute("conta").toString()));
	    restaurant.setScheduledDelivery(scheduler);
	    restaurant.setPlan(request.getAttribute("plano").toString());
	    restaurant.setCategory(request.getAttribute("categoria").toString());
	    restaurant.setPixList(pixList);
	    restaurant.setPackList(packList);
	    restaurant.setPayList(payList);
	}
}