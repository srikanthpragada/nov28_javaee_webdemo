<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="oracle.jdbc.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
</head>
<body>
	<form action="listjobs.jsp">
		Title <input type="text" name="title"  value="${param.title}" required="required" /> 
		<input type="submit"	value="Search" />
	</form>
	
	<%
	
	String title = request.getParameter("title");
	if ( title == null)
		return;  // stop JSP 
	%>

	<h2>List Of Jobs</h2>
	<table border="1" width="100%">
		<tr>
			<th>Title</th>
			<th>Min Salary</th>
			<th>Max Salary</th>
		</tr>


		<%
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where job_title like ?");
			crs.setString(1, "%" + title + "%");
			crs.execute();

			while (crs.next()) {
		%>

		<tr>
			<td><%=crs.getString("job_title")%></td>
			<td style="text-align: right"><%=crs.getString("min_salary")%></td>
			<td style="text-align: right"><%=crs.getString("max_salary")%></td>
		</tr>

		<%
			}
			crs.close();
		%>

	</table>

</body>
</html>