public class PrintNumber implements Runnable {

  private Integer number = new Integer(1);
  private boolean alive = true;

  public int getNumber() {
    return number;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  @Override
  public void run() {
    Thread current = Thread.currentThread();
//    while (alive) {
//    synchronized (number) {
//    while (number < 30) {
    while (true) {
      number++;
      System.out.println(current.getName() + " number is \"" + number + "\"");
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
      }
      if (number % 10 == 0) {
        break;
      }
    }
//    }
    System.out.println(current.getName() + " is stopped!");
  }
}
