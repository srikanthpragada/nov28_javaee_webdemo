package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycleDemo extends HttpServlet {
	int count=0;
	public LifeCycleDemo() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		System.out.println(config.getInitParameter("database"));
	}

	public void destroy() {
		System.out.println("destory()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() " + ++count);
	}

}
