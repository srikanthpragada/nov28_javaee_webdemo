package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DepartmentBean {
	private int id;
	private String name;
	private int managerId, locationId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public boolean add() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		     PreparedStatement ps = con.prepareStatement("insert into departments values(?,?,?,?)")) 
		{
		     ps.setInt(1, id);
		     ps.setString(2,name);
		     ps.setInt(3,managerId);
		     ps.setInt(4,locationId);
		     int count = ps.executeUpdate();
		     return count == 1;
		}
        catch(Exception ex) {
        	System.out.println(ex.getMessage());
        	return false;
        }
	}

}
