public class Student {

  private int id;
  private int age;
  private String name;

  public Student() {
  }

  public Student(String name, int age) {
    this.id = (int) (Math.random() * 1000);
    this.age = age;
    this.name = name;
  }

  public int getId() {

    return id;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return id + " : " + name + " : " + age;
  }
}
