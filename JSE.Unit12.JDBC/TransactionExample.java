import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Connection connection = null;
    Statement statement = null;
    try {
      File file = new File("./sampledb");
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connection = DriverManager
          .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
      statement = connection.createStatement();

      connection.setAutoCommit(false);
      for (int i = 0; i < 10; i++) {
        String name = "TranVan" + i;
        int age = 10 + i;
        statement.executeUpdate(
            "insert into student (name, age) values " + "('" + name + "'," + age + ")");
      }
      connection.rollback();

      connection.setAutoCommit(true);
      ResultSet rs = statement.executeQuery("select count(*) from student");
      if (rs.next()) {
        System.out.println("total records = " + rs.getInt(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connection.close();
      statement.close();
    }
  }
}
