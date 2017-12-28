package jaxws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class JobsService {

	  @WebMethod
	  public Job[] getJobs() {
		  Job [] jobsArray = new Job[1];
		  
		  ArrayList<Job> jobs = new ArrayList<>();
          // get data from Jobs table and copy into jobs arraylist 
		  jobs.toArray(jobsArray);
		  return null;
	  }
	  @WebMethod
	  public Job[] getJobsByMinSalary(@WebParam int minSalary) {
		  return null;
	  }
	  @WebMethod
	  public boolean addJob(@WebParam Job job) {
		  System.out.println(job.getId());
		  System.out.println(job.getTitle());
		  return true; 
	  }
}
