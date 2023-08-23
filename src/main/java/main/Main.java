package main;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet(value = "/", asyncSupported = true)
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
	@Inject
	private HelloWorld hello;

	/**
	 * Default constructor.
	 */
	public Main() {
		System.out.println("Construction main");
		// TODO Auto-generated constructor stub
		count = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("testSession", "testSession");

		String fullName = getServletContext().getInitParameter("fullName");

		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Hello World</h1>");
		printWriter.println("<h1>Hits: " + ++count + "</h1>");
		printWriter.println(String.format("<h2>Name: %s</h2>", fullName));
		printWriter.println("<a href=\"SecondServlet\">To SecondServlet</a>");
		printWriter.println("<a href=\"ThirdServlet\">To ThirdServlet</a>");

		getServletContext().setAttribute("test", "testValue");

//		Request Scope
//		request.setAttribute("reqAttr", "TestReqAttr");
//		request.getRequestDispatcher("ThirdServlet").forward(request, response);

//		AsyncContext
//		System.out.println("59 " + new Date().getTime());
//		AsyncContext asyncContext = request.startAsync(request, response);
//
//		new Thread(() -> {
//			System.out.println("61 " + new Date().getTime());
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			System.out.println("69 " + new Date().getTime());
//			asyncContext.complete();
//		}).start();	

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}

		printWriter.println(String.format("<h2>Value: %s</h2>", hello.get()));
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
