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

import br.com.ifoodeco.dao.RestaurantDao;

@WebServlet(description = "A Servlet how control some method about restaurant", urlPatterns = { "/AddRestaurantServlet" })
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RestaurantDao dao;
	private Restaurant restaurant;
	private List<Pix> pixList;
	private List<Packaging> packList;
	private List<PayMethod> payList; 

	@Override
	public void init(ServletConfig config) throws ServletException {
		  super.init();
		  dao = new RestaurantDao();
		  restaurant = new Restaurant();
		  pixList = new ArrayList<Pix>();
		  packList = new ArrayList<Packaging>();
		  payList = new ArrayList<PayMethod>();
	}
	
	public void destroy() {
		  super.destroy();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Restaurant restaurant = 
				dao.getRestaurant(Integer.parseInt(request.getHeader("restaurante").toString()));
		
		//Enviar DADOS JSP
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		    
	    setIntoRestaurant(request);
		
		dao.insertRestautantDao(restaurant);
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
		
		Adress adress = new Adress(
				request.getAttribute("rua").toString()
				, Integer.parseInt(request.getAttribute("cep").toString())
				, Integer.parseInt(request.getAttribute("numero").toString())
				, request.getAttribute("complemento").toString());
		
		boolean scheduler = request.getAttribute("agendamento").toString().toUpperCase() == "SIM" ? true : false;
		
	    restaurant.setCnpjNumber(Integer.parseInt(request.getAttribute("cnpj").toString()));
	    restaurant.setAdress(adress);
	    restaurant.setName(request.getAttribute("nome").toString());
	    restaurant.setNumber(Integer.parseInt(request.getAttribute("telefone").toString()));
	    restaurant.setEmailAdress(request.getAttribute("email").toString());
	    restaurant.setAgencyNumber(Integer.parseInt(request.getAttribute("agencia").toString()));
	    restaurant.setAccountNumber(Integer.parseInt(request.getAttribute("conta").toString()));
	    restaurant.setScheduledDelivery(scheduler);
	    restaurant.setPlain(request.getAttribute("plano").toString());
	    restaurant.setCategory(request.getAttribute("categoria").toString());
	    restaurant.setPixList(pixList);
	    restaurant.setPackList(packList);
	    restaurant.setPayList(payList);
	}
}