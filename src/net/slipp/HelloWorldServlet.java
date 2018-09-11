package net.slipp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="HelloWorld", urlPatterns = {"/helloworld", "/hello", "/hello/world"})
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = -4328064704664826938L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		PrintWriter out = resp.getWriter();
		out.print(name + "<h1>Hello World !</h1>");
	}
}
