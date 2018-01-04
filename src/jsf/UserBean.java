package jsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
public class UserBean {

	private String name, password, message;

	
	@Size(min= 5, message ="Username must be >= 5 chars")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(min= 5, message ="Password must be >= 5 chars")
	// @Pattern( regexp = ".*[0-9].*", message = "Password must have a digit")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Return value page to go to
	// Action Controller 
	public String login() {
		if (name.equals("admin") && password.equals("admin"))
			return "home"; // home.xhtml
		else {
			message = "Sorry! Invalid Login!";
			return "login";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
