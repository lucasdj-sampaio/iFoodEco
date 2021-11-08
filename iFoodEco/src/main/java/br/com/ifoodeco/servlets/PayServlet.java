package br.com.ifoodeco.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ifoodeco.entity.PayMethod;
import br.com.ifoodeco.entity.Pix;
import br.com.ifoodeco.entity.Restaurant;

@WebServlet(description = "This servlet get payment data from webPage", urlPatterns = { "/fourthStep" })
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurant restaurant;
       
    public PayServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PayMethod> payList = new ArrayList<PayMethod>();
		List<Pix> pixList = new ArrayList<Pix>();
    	
    	request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
			
		for (String pay : request.getParameterValues("pagamento")) {
			payList.add(new PayMethod(pay));
		}
		
		createPixList(request, pixList);
		
		restaurant = (Restaurant)request.getSession(false).getAttribute("restaurant");
		restaurant.setPayList(payList);
		restaurant.setPixList(pixList);
		
		session.removeAttribute("restaurant");
		session.setAttribute("restaurant", restaurant);
		
    	RequestDispatcher rd = request.getRequestDispatcher("embalagem.jsp");
    	rd.forward(request, response);
	}
    
    private static void createPixList(HttpServletRequest request, List<Pix> pixList) {
    	Enumeration<String> variables = request.getParameterNames();
    	
    	while(variables.hasMoreElements()) {
    		String currentParameter = variables.nextElement();
    		
    		if (currentParameter.equals("cnpjPix")) {
    			pixList.add(new Pix(request.getParameter("cnpjPix").toString()
						, request.getParameter("cnpjPixValor").toString()
						.replace("-", "")
						.replace("/", "")
						.replace(".", "")
						.replace(" ", "").trim()));
    		}
    		else if (currentParameter.equals("emailPix")) {
				pixList.add(new Pix(request.getParameter("emailPix").toString()
						, request.getParameter("emailPixValor").toString()));
    		}
    		else if (currentParameter.equals("celularPix")) {
				pixList.add(new Pix(request.getParameter("celularPix").toString()
						, request.getParameter("celularPixValor").toString()
						.replace("(", "")
		    			.replace(")", "")
		    			.replace("-", "")
		    			.replace(" ","").trim()));
    		}
    		else if (currentParameter.equals("aleatoriaPix")) {
				pixList.add(new Pix(request.getParameter("aleatoriaPix").toString()
						, request.getParameter("aleatoriaPixValor").toString()));	
    		}
    	}
    }
}