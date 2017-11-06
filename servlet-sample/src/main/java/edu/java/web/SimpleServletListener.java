package edu.java.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SimpleServletListener implements ServletContextListener {

  public void contextInitialized(ServletContextEvent servletContextEvent) {
    System.out.println("\n\n ServletContextListener started\n\n");
  }

  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    System.out.println("\n\n ServletContextListener destroyed\n\n");
  }
}
