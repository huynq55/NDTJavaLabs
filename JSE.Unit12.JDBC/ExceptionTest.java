public class ExceptionTest {

  public static void main(String[] args) throws Exception {
    try {
      throw new Exception("abc123");
    } catch (Exception e) {
      throw new Exception("2");
    } finally {
      try {
        throw new Exception("3");
      } finally {
        throw new Exception("4");
      }
    }
  }
}
