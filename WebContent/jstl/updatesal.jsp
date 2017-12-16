<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>

	<form action="updatesal.jsp">
		Employee Id <br /> <input type="text" name="id" value="${param.id}" />
		<p />
		Employee Salary <br /> <input type="text" name="salary" value="${param.salary}" />
		<p />
		<input type="submit" value="Update" />
	</form>

	<c:if test="${!empty param.id}">

		<sql:setDataSource var="oracle"
			driver="oracle.jdbc.driver.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:XE" user="hr" password="hr" />

		<sql:update dataSource="${oracle}" var="uc">
            update employees set salary = ?  where employee_id = ?
            <sql:param value="${param.salary}" />
		    <sql:param value="${param.id}" />
		</sql:update>

		<c:if test="${uc > 0 }">
             Updated Successfully!
        </c:if>

	</c:if>


</body>
</html>