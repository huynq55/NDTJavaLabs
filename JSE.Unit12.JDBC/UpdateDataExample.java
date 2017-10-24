import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataExample {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    File file = new File("./sampledb");
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    Connection connection = null;
    PreparedStatement statement = null;
    try {
      connection = DriverManager
          .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
      statement = connection
          .prepareStatement("UPDATE Student SET Name = ? WHERE ID = ?");
      statement.setString(1, "Le Thi Z");
      statement.setInt(2, 2);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      statement.close();
      connection.close();
    }
  }
}
