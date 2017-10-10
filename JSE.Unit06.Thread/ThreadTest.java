public class ThreadTest {

  public static void main(String[] args) {
    new Thread(new PrintMessage("Say hello to everyone")).start();
    new Thread(new PrintMessage("Say hello to everyone")).start();
//or
//    PrintMessage message = new PrintMessage("Say hello to everyone");
//    new Thread(message).start();
//    new Thread(message).start();
  }
}
