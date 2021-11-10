package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifoodeco.dao.CategoryDao;
import br.com.ifoodeco.dao.PackagingDao;
import br.com.ifoodeco.dao.PayDao;
import br.com.ifoodeco.dao.PixDao;
import br.com.ifoodeco.dao.PlanDao;
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
		
		String jspFile;
		restaurant = RestaurantDao.getRestaurant(Long.parseLong(request.getParameter("cnpj")));
		int screen = Integer.parseInt(request.getParameter("screen"));
		
		request.setAttribute("restaurant", restaurant);
		
		switch(screen) {
			case 1:
				jspFile = "retorno_cadastro_index.jsp";
				request.setAttribute("planList", PlanDao.getAll());
				request.setAttribute("categoryList", CategoryDao.getAll());
				break;
			case 2:
				jspFile = "retorno_cadastro_embalagem.jsp";
				request.setAttribute("embList", PackagingDao.getAll());
				break;
			case 3:
				jspFile = "retorno_cadastro_pagamento.jsp";
				request.setAttribute("payList", PayDao.getAll());
				break;
			default:
				jspFile = "retorno_cadastro_index.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(jspFile);
	    rd.forward(request, response);
	}
}