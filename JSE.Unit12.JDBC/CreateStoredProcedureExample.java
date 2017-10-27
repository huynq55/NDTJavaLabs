import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProcedureExample {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    File file = new File("./sampledb");
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    Connection connection = DriverManager
        .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
    Statement statement = connection.createStatement();

    statement.executeUpdate("CREATE PROCEDURE GETAGE(STREAM_NAME "
        + "VARCHAR(255), OUT AGE INT)"
        + " PARAMETER STYLE JAVA READS"
        + " SQL DATA LANGUAGE JAVA EXTERNAL NAME"
        + " 'jdbc.DbFunction.getAge'");

    System.out.println("done");

    statement.close();
    connection.close();
  }
}
