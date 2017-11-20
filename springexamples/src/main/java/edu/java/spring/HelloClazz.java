package edu.java.spring;

import java.util.List;
import org.springframework.beans.factory.DisposableBean;

public class HelloClazz implements DisposableBean {

  private String message;

  private List<JavaClazz> clazzes;

  public void setClazzes(List<JavaClazz> clazzes) {
    this.clazzes = clazzes;
  }

  public List<JavaClazz> getClazzes() {
    return clazzes;
  }

  public void setMessage(String message) {
    this.message = "Call From Setter: " + message;
  }

  public String getMessage() {
    return message;
  }

  public void printMessage() {
    System.out.println("Your Message: " + message);
  }

  private void initMessage() {
    System.out.println("Calling init method...");
    message = "From init method: Say hello bean!";
  }

  public void destroy() {
    message = null;
    System.out.println("Message is null");
  }

  public HelloClazz(int person) {
    message = "From Constructor: Say hello to " + person + " person(s)!";
  }

  public HelloClazz(HelloClazz clazz) {
    message = clazz.message;
  }

  public HelloClazz() {
    message = "From Constructor: Say hello to everyone!";
  }

}
