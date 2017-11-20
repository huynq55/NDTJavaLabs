package edu.java.spring;

import java.util.logging.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld implements DisposableBean {

  private final static Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());
  private String message;

  @Autowired(required = true)
  @Qualifier("helloJavaClazz2")
  private HelloClazz clazz;

  public void sayHello() {
    clazz.printMessage();
    LOGGER.info("From HelloWorld: " + message);
  }

  @Required
  public void setMessage(String value) {
    this.message = value;
  }

  public void initMessage() {
    System.out.println("Calling init method HelloWorld...");
    message = "Hihihehe HelloWorld";
  }

  public HelloWorld(String name, HelloClazz clazz) {
    message = "From HelloWorld constructor: " + name + " : " + clazz.getMessage();
  }

  public HelloWorld() {
    message = "HelloWorld message created from constructor";
  }

  public void setClazz(HelloClazz clazz) {
    this.clazz = clazz;
  }

  public void destroy() throws Exception {
    message = null;
    System.out.println("Message (in HelloWorld) is null");
  }
}
