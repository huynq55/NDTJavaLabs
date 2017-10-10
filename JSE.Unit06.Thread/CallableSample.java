import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;

public class CallableSample implements Callable<Integer> {

  private ReentrantLock lock = new ReentrantLock();
  public AtomicInteger total = new AtomicInteger(0);
  private Tmp totalT2 = new Tmp();

  class Tmp {
    int number = 0;

    public void tang(int number) {
      this.number += number;
    }

    public int get() {
      return number;
    }

    public int addAndGet(int number) {
      this.tang(number);
      return this.get();
    }
  }
  @Override
  public synchronized Integer call() throws Exception {
//    lock.lock();

    IntStream.range(0, 10).forEach(number -> {
      System.out.println(Thread.currentThread().getName() + " - object " + this +
//          " is running " + total.addAndGet(number));
          " is running " + totalT2.addAndGet(number));

      Random random = new Random();
      LongStream longStream = random.longs(100, 1000);
      long sleep = longStream.findFirst().getAsLong();
    });
//    while (total.get() < 1000000000) {
//      System.out.println(total.incrementAndGet());
//    }
//    lock.unlock();
    return total.get();
  }
}
