package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listcookies")
public class ListCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String st = "<body><h3>List of Cookies</h3><table border='1' cellpadding='5'> <tr><th>Name<th>Value</tr>";

		for (Cookie c : request.getCookies()) {
			st = st + "<tr><td>" + c.getName() + "<td>" + c.getValue() + "</tr>";
		}
		st = st + "</table></body>";
		out.println(st);
	}

}
