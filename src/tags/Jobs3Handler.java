package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Jobs3Handler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		JspFragment body = getJspBody();
		PageContext ctx = (PageContext) getJspContext();
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();

			while (crs.next()) {
		        // create attributes
				ctx.setAttribute("id", crs.getString("job_id"));
				ctx.setAttribute("title", crs.getString("job_title"));
				ctx.setAttribute("minSalary", crs.getString("min_salary"));
				ctx.setAttribute("maxSalary", crs.getString("max_salary"));
				
				body.invoke(out);  // process body and send output to client
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
