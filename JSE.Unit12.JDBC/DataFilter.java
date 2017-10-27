import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;

public class DataFilter implements Predicate {


  @Override
  public boolean evaluate(RowSet rs) {
    CachedRowSet crs = (FilteredRowSet) rs;
    try {
      return crs.getString("name").indexOf("Nguyen") > -1;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean evaluate(Object value, int column) throws SQLException {
    return false;
  }

  @Override
  public boolean evaluate(Object value, String columnName) throws SQLException {
    return false;
  }

}
