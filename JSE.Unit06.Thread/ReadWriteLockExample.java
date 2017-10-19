import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    Map<String, String> map = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    executor.submit(() -> {
      System.out.println("start writing");
      lock.writeLock().lock();
      try {
        TimeUnit.SECONDS.sleep(10);
        map.put("foo", "bar");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.writeLock().unlock();
        System.out.println("end writing");
      }
    });

    Runnable readTask = () -> {
      System.out.println("start reading");
      lock.readLock().lock();
      try {
        System.out.println(map.get("foo"));
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.readLock().unlock();
        System.out.println("end reading");
      }
    };

    executor.submit(readTask);
    executor.submit(readTask);

  }

}
