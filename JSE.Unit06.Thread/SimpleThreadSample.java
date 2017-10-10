import java.util.stream.Stream;

public class SimpleThreadSample {

  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      Stream.of(args).forEach(ele -> {
        try {
          Thread.sleep(1000);
          System.out.println(ele);
          System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
        }
      });
    }).start();
  }
}
