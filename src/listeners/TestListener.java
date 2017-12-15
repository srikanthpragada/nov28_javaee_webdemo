package listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class TestListener implements ServletContextListener, HttpSessionListener {

   
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("Session Created");
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Session Destroyed");
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	System.out.println("Context Destroyed");
    	
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
       ServletContext ctx = sce.getServletContext();
       ctx.setAttribute("startedat", new Date());
       System.out.println("Context Initialized");
    }
	
}
