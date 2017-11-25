package edu.java.spring.jdbc;

import com.sun.org.apache.bcel.internal.generic.LOOKUPSWITCH;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcApp {

  private static Logger LOGGER = Logger.getLogger(JdbcApp.class.getName());

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
    StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
    LOGGER.info(" created bean " + jdbc);
//    jdbc.insert("Nguyen Quang Huy", 25);
    LOGGER.info("Total students is " + jdbc.totalRecord());
//    jdbc.loadStudent("Nguyen").forEach(student -> System.out.println(student));
//    List<Student> students = new ArrayList<>();
//    students.add(new Student("Tran Thi A", 17));
//    students.add(new Student("Le Van L", 20));
//    students.add(new Student("Phan Thi Z", 25));
//
//    int[] values = jdbc.add(students);
//
//    for (int i = 0; i < values.length; i++) {
//      LOGGER.info("add record " + i + ": " + (values[i] == 0 ? "failed" : "success"));
//    }
//
//    LOGGER.info("Total student is " + jdbc.totalRecord());
      jdbc.save("Tran Thi A", "23");
  }
}
