package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.sql.rowset.CachedRowSet;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import oracle.jdbc.rowset.OracleCachedRowSet;

@Path("/employees")
public class Employees {

	@GET
	public String getEmployees() throws Exception {
		JsonArrayBuilder employees = Json.createArrayBuilder();

		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees");
			crs.execute();

			while (crs.next()) {
				JsonObjectBuilder employee = Json.createObjectBuilder();
				employee.add("id", crs.getInt("employee_id"));
				employee.add("fullname", crs.getString("first_name") + " " + crs.getString("last_name"));
				employee.add("salary", crs.getInt("salary"));
				employees.add(employee.build());
			}
		}
		return employees.build().toString();
	}

	@GET
	@Path("{id}")
	public String getEmployee(@PathParam("id") int id) throws Exception {

		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees where employee_id = ?");
			crs.setInt(1, id);
			crs.execute();

			if (crs.next()) {
				JsonObjectBuilder employee = Json.createObjectBuilder();
				employee.add("id", crs.getInt("employee_id"));
				employee.add("fullname", crs.getString("first_name") + " " + crs.getString("last_name"));
				employee.add("salary", crs.getInt("salary"));
				return employee.build().toString();
			} else
				throw new NotFoundException();
		}
	}

	@DELETE
	@Path("{id}")
	public void deleteEmployee(@PathParam("id") int id) throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			PreparedStatement ps = con.prepareStatement("delete from employees where employee_id = ?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count == 0)
				throw new NotFoundException();  // 404

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new InternalServerErrorException();  // 500 

		}

	}
	
	@PUT
	@Path("{id}")
	public void updateEmployee(@PathParam("id") int id, @FormParam("salary") int salary) throws Exception {
		System.out.println(id);
		System.out.println(salary);
		
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			PreparedStatement ps = con.prepareStatement("UPDATE employees set salary = ? where employee_id = ?");
			ps.setInt(1, salary);
			ps.setInt(2, id);
			int count = ps.executeUpdate();
			if (count == 0)
				throw new NotFoundException();  // 404

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new InternalServerErrorException();  // 500 

		}

	}

}
