package com.david.spring.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringServletContextListener
 *
 */
public class SpringServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SpringServletContextListener() {
       
    }

	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	
	public void contextInitialized(ServletContextEvent sce) {
		//1.��ȡspring�����ļ�������
		ServletContext servletContext = sce.getServletContext();
		String location = servletContext.getInitParameter("configLocation");
		//2.����IOC����
		ApplicationContext ac=new ClassPathXmlApplicationContext(location);
		//3.��IOC��������ServletContext��һ��������
		servletContext.setAttribute("ApplicationContext", ac);
		
	}
	
}
