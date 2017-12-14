<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

  <jsp:useBean id="dept" class="beans.DepartmentBean" scope="request"></jsp:useBean>
  <jsp:setProperty property="*" name="dept"/>
  <%
      dept.add();
      out.println("Added Successfully!");
  %>

</body>
</html>