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

@WebServlet(description = "Get address data from ifood html page", urlPatterns = { "/secundStep" })
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddressServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Address address = new Address(request.getParameter("logradouro").toString()
				, Integer.parseInt(request.getParameter("cep").replace("-", ""))
				, Integer.parseInt(request.getParameter("numero"))
				, request.getParameter("complemento"));
		
		session.setAttribute("address", address);
		
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_proprietario.jsp");
    	rd.forward(request, response);
	}
}