import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ExecuteServiceTest {

  public static void main(String[] args) {
    PrintNumber number = new PrintNumber();
    Callable<Object> value = Executors.callable(number);
    System.out.println("main say hello");
    try {
      value.call();
    } catch (Exception e) {
    }
    System.out.println("main say goodbye");
  }
}
