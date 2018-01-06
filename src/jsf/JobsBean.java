package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class JobsBean {
	
	public  List<Job> getJobs() {
	
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (crs.next()) {
				Job j = new Job();
				j.setId( crs.getString(1));
				j.setTitle( crs.getString(2));
				jobs.add(j);
			}
			return jobs;
		}
		catch(Exception ex) {
			return null;
		}

	}

}
