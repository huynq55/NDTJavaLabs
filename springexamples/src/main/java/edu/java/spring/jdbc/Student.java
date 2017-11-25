package edu.java.spring.jdbc;

public class Student {

  private int id;

  private String name;

  private int age;

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String toString() {
    return (id + " : " + name + " : " + age);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Student(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Student() {}
}
