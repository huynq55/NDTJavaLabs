package edu.java.spring;

import java.util.logging.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//
//    HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
//    obj.printMessage();
//    System.out.println(obj);
//
//    HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
//    obj2.printMessage();
//    System.out.println(obj == obj2);
//
    ((HelloWorld) context.getBean("helloWorld")).sayHello();
//    context.registerShutdownHook();
//    JavaClazz clazz = (JavaClazz) context.getBean("jee01");
    Logger LOGGER = Logger.getLogger(App.class.getName());
//    LOGGER.info("Map Implement is " + clazz.getStudents().getClass());
//    LOGGER.info("There are " + clazz.getStudents().size() + " in the class");
//    HelloClazz clazz = (HelloClazz) context.getBean("helloJavaClazz");
//    LOGGER.info("Total classes is " + clazz.getClazzes().size());

  }
}
