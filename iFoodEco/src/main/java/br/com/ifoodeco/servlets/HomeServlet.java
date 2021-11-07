package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "This Sevlet get the first data to navegate on webPage", urlPatterns = { "/firstStep" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public HomeServlet() {
		super();
	}
		
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(true);
    	
    	session.setAttribute("userName", request.getParameter("nome"));
    	session.setAttribute("mailAddress", request.getParameter("email"));
    	session.setAttribute("phone", request.getParameter("telefone"));
    	
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_endereco.jsp");
    	rd.forward(request, response);
	}
}