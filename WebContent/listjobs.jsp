<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="oracle.jdbc.rowset.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
</head>
<body>

<h2>List Of Jobs</h2>

<%
   OracleCachedRowSet crs = new OracleCachedRowSet();
   crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
   crs.setUsername("hr");
   crs.setPassword("hr");
   crs.setCommand("select * from jobs");
   crs.execute();
   
   while(crs.next()) {
	   out.println( crs.getString("job_title") + "<br/>");
   }
   crs.close();
%>

</body>
</html>