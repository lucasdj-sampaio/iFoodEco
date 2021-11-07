package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This Sevlet get the first data to navegate on webPage", urlPatterns = { "/firstStep" })
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
      
	public HomeServlet() {
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		  super.init();
	}
		
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession(true);
    	
		restaurant = new Restaurant();
    	restaurant.setEmailAddress(request.getParameter("email").toString());
    	restaurant.setNumber(Long.parseLong(request.getParameter("telefone").toString()
    			.replace("(", "")
    			.replace(")", "")
    			.replace("-", "")
    			.replace(" ","").trim()));
    	
    	session.setAttribute("userName", request.getParameter("nome"));
    	session.setAttribute("restaurant", restaurant);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_endereco.jsp");
    	rd.forward(request, response);
	}
}