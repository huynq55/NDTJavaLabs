import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunction {

  public static void getAge(String name, int[] ages) {
    try {
      File file = new File("./sampledb");
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection connection = DriverManager
          .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
      Statement statement = connection.createStatement();

      ResultSet rs = statement
          .executeQuery("select max(age) from student where name like '%" + name + "%'");

      ages[0] = rs.next() ? rs.getInt(1) : -1;
      statement.close();
      connection.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    int[] ages = new int[]{7};
    getAge("Z", ages);
    System.out.println(ages[0]);
    getAge("Quang", ages);
    System.out.println(ages[0]);
  }
}
