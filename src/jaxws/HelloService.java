package jaxws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloService {
	
	@WebMethod
	public String getMessage() {
		return "Hello from Metro";
	}
	
	@WebMethod
	public String getToday() {
		return  new Date().toString();
	}

}
