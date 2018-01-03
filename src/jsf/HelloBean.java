package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean()
public class HelloBean {
	// message property 
	public String getMessage() {
		return "Hello Mojarra!";
	}
	
	// property topics of List<String>
	public List<String> getTopics() {
		ArrayList<String> topics = new ArrayList<>();
		topics.add("Forms");
		topics.add("Tags");
		topics.add("Life Cycle");
		topics.add("Ajax");
		return topics;
		
	}

}
