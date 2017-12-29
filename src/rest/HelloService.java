package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloService {

	@GET
	public String  get() {
		return "Hello from Rest";
	}
	
	@GET
	@Path("{name}")
	public String  getName(@PathParam("name") String name) {
		return "Hello, " + name + "  from Rest";
	}
}
