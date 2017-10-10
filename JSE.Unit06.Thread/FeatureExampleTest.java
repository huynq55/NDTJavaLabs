import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FeatureExampleTest {

  public static void main(String[] args) {
    CallableSample callableSample = new CallableSample();

    ExecutorService executor = Executors.newFixedThreadPool(1);
    Future<Integer> future = executor.submit(callableSample);
    System.out.println("Future Done ? " + future.isDone());
    try {
      Integer result = future.get(3, TimeUnit.SECONDS);
      System.out.println("Future Done ? " + future.isDone() + " - result = " + result);
    } catch (TimeoutException | ExecutionException | InterruptedException e) {
      System.exit(0);
    }

  }
}
