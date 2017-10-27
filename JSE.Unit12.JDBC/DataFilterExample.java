import com.sun.rowset.FilteredRowSetImpl;
import java.io.File;
import java.sql.SQLException;
import javax.sql.rowset.FilteredRowSet;

public class DataFilterExample {

  public static void main(String[] args) throws SQLException {
    FilteredRowSet frs = new FilteredRowSetImpl();
    File file = new File("./sampledb");
    frs.setUrl("jdbc:derby:" + file);

    frs.setCommand("select * from student");
    frs.setFilter(new DataFilter());
    frs.execute();

    System.out.println("ID\tName\t\tAge");
    while (frs.next()) {
      System.out.println(frs.getInt(1) + "\t" + frs.getString(2) + "\t" + frs.getInt(3));
    }
  }
}
