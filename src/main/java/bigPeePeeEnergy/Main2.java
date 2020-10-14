package bigPeePeeEnergy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Main2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RubricaService rubrica;

	public Main2() throws IOException {
		super();
		this.rubrica = new RubricaService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = this.rubrica.handleRequest(request);
		ServletContext context = getServletContext();
		
		System.out.println("request was made" + url);
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
