package br.com.ifoodeco.servlets;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This servlet get payment data from webPage", urlPatterns = { "/fourthStep" })
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    public PayServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		
		Enumeration<String> teste = request.getHeaderNames();
		
		while(teste.hasMoreElements()) 
		{
			System.out.println(teste.nextElement());
		}
			
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");	
		
		String[] payment = request.getParameterValues("pagamento");
		
		for (String pay : payment) {
			System.out.println(pay);
		}
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("pagamento.jsp");
    	rd.forward(request, response);
	  }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
			
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");	
		
		String[] payment = request.getParameterValues("pagamento");
		
		for (String pay : payment) {
			System.out.println(pay);
		}
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("pagamento.jsp");
    	rd.forward(request, response);
	}
}