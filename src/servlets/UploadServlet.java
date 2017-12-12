package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println( getServletContext().getRealPath("/"));
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Part p1 = request.getPart("namesFile");
		InputStream is = p1.getInputStream();
		Scanner s = new Scanner(is);
		out.println("<ul>");
		while (true) {
			try {
				String line = s.nextLine();
				if ( line.trim().length() > 0)
				    out.println("<li>" + line + "</li>");
			} catch (Exception ex) {
				break;
			}
		}
		out.println("</ul>");

	}

}
