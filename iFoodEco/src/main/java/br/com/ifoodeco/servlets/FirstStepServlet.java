package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "This Sevlet get the first data to navegate on webPage", urlPatterns = { "/FirstStep" })
public class FirstStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public FirstStepServlet() {
		super();
	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_endereco.jsp");
    	rd.forward(request, response);
	}
}