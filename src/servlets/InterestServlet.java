package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/interest")
public class InterestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String samount = request.getParameter("amount");
		if (samount == null) {
			out.println("<h2>Sorry! Loan amount is missing!</h2>");
		} else {
			int amount = Integer.parseInt(samount);

			double interest = amount * 0.15;
			out.printf("<h2>Interest = %f </h2>", interest);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
