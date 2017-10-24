import com.sun.rowset.JdbcRowSetImpl;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;

public class JdbcRowSetExample {

  public static void main(String[] args) throws SQLException {
    JdbcRowSet jdbcRs = new JdbcRowSetImpl();
    File file = new File("./sampledb");
    jdbcRs.setUrl("jdbc:derby:" + file);
    jdbcRs.setCommand("select * from student");
    jdbcRs.execute();

    while (jdbcRs.next()) {
      System.out.println(jdbcRs.getInt(1) + "\t" + jdbcRs.getString("name"));
    }

    jdbcRs.first();
    jdbcRs.updateString("name", "Hoang Van X");
    jdbcRs.updateRow();

    jdbcRs.first();
    System.out.println(jdbcRs.getInt("id") + "\t" + jdbcRs.getString(2));

    jdbcRs.absolute(8);
    System.out.println(jdbcRs.getString(1) + " : "+ jdbcRs.getString("name"));

    jdbcRs.close();
  }
}
