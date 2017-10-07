import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {

  public static List<Student> filter(List<Student> students, Filter<Student> pred)
      throws IOException {
    List<Student> list = new ArrayList<>();
    for (Student student : students) {
      if (pred.accept(student)) {
        list.add(student);
      }
    }
    return list;
  }

  public static void main(String[] args) throws IOException {
    List<Student> students = new ArrayList<>();

    students.add(new Student("Tran Van A", 23));
    students.add(new Student("Nguyen Thi B", 34));
    students.add(new Student("Nguyen Thi C", 15));
    students.add(new Student("Ta Van C", 46));

//    cach code cu
//    Filter<Student> older = student -> student.getAge() >= 30;
//    List<Student> filtered = filter(students, older);
//
//    filtered.forEach(student -> System.out.println(student));

//    cach code nhanh
//    Stream<Student> stream = students.stream().filter(student -> student.getAge() >= 30);
//    stream.forEach(student -> System.out.println(student));

//    sort theo tuoi tang dan
    Stream<Student> stream = students.stream()
        .sorted((student1, student2) -> student1.getAge() - student2.getAge());
    stream.forEach(student -> System.out.println(student));
  }
}
