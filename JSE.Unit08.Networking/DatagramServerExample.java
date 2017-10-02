import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.io.IOException;


public class DatagramServerExample implements Runnable {
  
  public DatagramSocket socket;
  
  public DatagramServerExample() throws SocketException {
    this.socket = new DatagramSocket(4445);
    System.out.println("DATA SERVER listening...");
  }
  
  public void run() {
    System.out.println("Thread da duoc chay");
    
    try {
      byte[] bytes = new byte[8];
      DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
      this.socket.receive(packet);
      System.out.println("From Client: " + new String(packet.getData(), 0, packet.getLength()));
      bytes = "Server say hello".getBytes();
      this.socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort()));
    } catch(IOException e) {}
    finally {
      this.socket.close();
    }
  }
  
  public static void main(String[] args) throws SocketException {
    new Thread(new DatagramServerExample()).start();
  }
  
}