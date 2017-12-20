<%@ page import="java.sql.*,oracle.jdbc.rowset.*" contentType="text/xml"%>
<%
	// Thread.sleep(5000);
	String empid = request.getParameter("empid");
	// connect to oracle using thin driver

	OracleCachedRowSet crs = new OracleCachedRowSet();
	crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	crs.setUsername("hr");
	crs.setPassword("hr");
	crs.setCommand("select first_name,salary from employees where employee_id = ?");
	crs.setString(1, empid);
	crs.execute();

	if (crs.next()) { // found
		out.println("<employee><name>");
		out.println(crs.getString(1));
		out.println("</name><salary>");
		out.println(crs.getInt(2));
		out.println("</salary></employee>");
	} else {
		out.println("<error>Employee ID Not Found</error>");
	}

	crs.close();
%>
