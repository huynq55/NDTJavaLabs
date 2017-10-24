import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMetadataExample {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Connection connection = null;
    try {
      File file = new File("./sampledb");
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connection = DriverManager
          .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");

      DatabaseMetaData metaData = connection.getMetaData();
      System.out.println("db version " + metaData.getDatabaseMajorVersion());
      System.out.println("driver name " + metaData.getDriverName());

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connection.close();
    }
  }

}
