import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {

  public static void addData(List list) {
    while (true) {
      Integer random = (int) (Math.random() * 100);
      list.add(random);
      System.out.println("add new data" + random);
      try {
        Thread.sleep(100l);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void printData(List list) {
    while (true) {
      try {
        System.out.println("=============");
        list.forEach(value -> System.out.println("value = " + value));
        Thread.sleep(80l);
      } catch (Exception e) {
        e.printStackTrace();
        System.exit(1);
      }
    }
  }

  public static void main(String[] args) {
    List list = new ArrayList<>();
    new Thread(() -> addData(list)).start();
    new Thread(() -> printData(list)).start();
  }

}
