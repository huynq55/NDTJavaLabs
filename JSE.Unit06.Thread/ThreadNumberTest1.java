public class ThreadNumberTest1 {

  public static void main(String[] args) {
    PrintNumber number = new PrintNumber();
    Thread thread1 = new Thread(number);
    thread1.setName("FSoft_Thread 1");
    thread1.start();

    Thread thread2 = new Thread(number);
    thread2.setName("FSoft_Thread 2");
    thread2.start();
  }

}
