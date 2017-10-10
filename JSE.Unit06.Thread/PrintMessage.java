import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class PrintMessage implements Runnable {

  private String message;

  public PrintMessage(String message) {
    this.message = message;
  }

  @Override
  public synchronized void run() {
    String[] elements = message.split(" ");
    Stream.of(elements).forEach(ele -> {
      System.out.println(Thread.currentThread().getName() + " print " + ele);
      try {
        Thread.sleep((int) (Math.random() * 3) * 1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
