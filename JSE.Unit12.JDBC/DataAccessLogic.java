import com.sun.rowset.CachedRowSetImpl;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

public class DataAccessLogic {

  private static final Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
  private static final Integer pageSize = 10;
  private Connection connection = null;
  private CachedRowSet rowSet;

  public DataAccessLogic() {
    File file = new File("./sampledb");
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      this.connection = DriverManager
          .getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
      rowSet = new CachedRowSetImpl();
      rowSet.setCommand("select * from student");
      rowSet.execute(connection);
    } catch (ClassNotFoundException e) {
      System.out.println("khong tim thay driver");
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void disconnect() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      logger.log(Level.WARNING, e.toString());
    }
  }

  public List<String> loadNames(Integer page) throws SQLException {
    List<String> names = new ArrayList<>();
    rowSet.setPageSize(pageSize);
    Integer start = (page - 1) * pageSize + 1;
    if (!rowSet.absolute(start)) {
      return names;
    }

    rowSet.previous();
    while (rowSet.next()) {
      names.add(rowSet.getString("name"));
      if (names.size() >= pageSize) {
        break;
      }
    }
    return names;
  }

  public int numberOfPage() throws SQLException {
    Statement statement = null;
    try {
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select count(*) from student");
      if (!rs.next()) {
        return 0;
      }
      int total = rs.getInt(1);
      int totalPage = total / pageSize;
      if (total % pageSize != 0) {
        totalPage++;
      }
      return totalPage;
    } finally {
      statement.close();
    }
  }

}
