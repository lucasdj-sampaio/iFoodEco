package br.com.ifoodeco.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ifoodeco.entity.Packaging;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This servlet get packaging data from webPage", urlPatterns = { "/fifthStep" })
public class PackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    public PackServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Packaging> packList = new ArrayList<Packaging>();
		
    	request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
			
		for (String pack : request.getParameterValues("embalagem")) {
			packList.add(new Packaging(pack));
		}
				
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");
		restaurant.setPackList(packList);
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("planos.jsp");
    	rd.forward(request, response);
    }
}