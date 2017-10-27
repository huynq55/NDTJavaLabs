import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

public class DataAccessTest {

  public static void main(String[] args) throws SQLException {
    DataAccessLogic data = new DataAccessLogic();
    List<String> names = data.loadNames(1);
    names.forEach(System.out::println);

    System.out.println("total page = " + data.numberOfPage());

    IntStream.range(1, data.numberOfPage() + 1).forEach(page -> {
      System.out.println("======================= "+page);
      try {
        List<String> names1 = data.loadNames(page);
        System.out.println(names1);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    });
  }
}
