import java.sql.SQLException;
import java.util.List;

public class DataAccessTest {

  public static void main(String[] args) throws SQLException{
    DataAccessLogic data = new DataAccessLogic();
    List<String> names = data.loadNames(1);
    names.forEach(System.out::println);

    System.out.println("total page = " + data.numberOfPage());
  }
}
