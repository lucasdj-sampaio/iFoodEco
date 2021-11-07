package br.com.ifoodeco.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This servlet get store data from webPage", urlPatterns = { "/thirdStep" })
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    public StoreServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
			
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");	
		restaurant.setName(request.getParameter("nomeLoja").toString());
		restaurant.setCategory(request.getParameter("categoria").toString());
		restaurant.setCnpjNumber(Long.parseLong(request.getParameter("cnpj").toString()
				.replace("-", "")
				.replace("/", "")
				.replace(".", "")
				.replace(" ", "").trim()));
		restaurant.setAgencyNumber(Integer.parseInt(request.getParameter("agencia").toString()
				.replace("-", "")
				.replace(" ", "").trim()));
		restaurant.setAccountNumber(Integer.parseInt(request.getParameter("conta")
				.replace("-", "")
				.replace(" ", "").trim()));
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("pagamento.jsp");
    	rd.forward(request, response);
	}
}