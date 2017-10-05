//import java.lang.Runnable;

public class RunnableTest {

  public static void main(String[] args) {

    new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + " say hello Java class!");
      System.out.println("1 + 1 = " + (1 + 1));
    }).start();


  }
}