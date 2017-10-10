import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InvokeAllExample {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newWorkStealingPool();
    Stream<CallableSample> callabes1 = IntStream.range(1, 5).mapToObj(i -> new CallableSample());
    List<CallableSample> callabes = callabes1.collect(Collectors.toList());
    try {
      Stream<Future<Integer>> stream = executor.invokeAll(callabes).stream();
      Stream<Integer> resultStream = stream.map(future -> {
        try {
          return future.get();
        } catch (InterruptedException | ExecutionException e) {
          return -1;
        }
      });
      resultStream.forEach(e -> {
        System.out.println(e);
      });

    } catch (InterruptedException e) {
    }
  }
}
