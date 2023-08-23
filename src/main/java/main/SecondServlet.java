package main;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SecondServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Hello Second Servlet</h1>");
		printWriter.println("<a href=\"/HelloWorld\">To Home</a>");
		printWriter.println("<a href=\"ThirdServlet\">To ThirdServlet</a>");

		String test = (String) getServletContext().getAttribute("test");
		printWriter.println("<h1>" + test + "</h1>");
		
		HttpSession httpSession = request.getSession(true);
		printWriter.println("<h1>" + httpSession.getAttribute("testSession") + "</h1>");

		printWriter.println("<h1>" + request.getAttribute("reqAttr") + "</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
