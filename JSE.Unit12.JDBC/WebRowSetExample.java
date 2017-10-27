import com.sun.rowset.WebRowSetImpl;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.WebRowSet;

public class WebRowSetExample {

  public static void main(String[] args) {
    Connection connection = null;
    try {
      File file = new File("./sampledb");
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connection = DriverManager
          .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
      Statement statement = connection.createStatement();

      ResultSet rs = statement.executeQuery("select * from student");

      file = new File("output.xml");
      FileWriter writer = new FileWriter(file);
      WebRowSet wrs = new WebRowSetImpl();
      wrs.writeXml(rs, writer);

      Desktop.getDesktop().open(file);
    } catch (ClassNotFoundException|SQLException|IOException e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
