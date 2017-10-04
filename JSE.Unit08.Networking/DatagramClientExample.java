import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.IOException;

public class DatagramClientExample {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress address = InetAddress.getByName("localhost");
    byte[] bytes = "Client say Xin Chao".getBytes();
    DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 4445);
    socket.send(packet);
    
    // packet = new DatagramPacket(bytes, bytes.length);
    // dong ben tren co cung duoc ma khong co cung khong sao
    socket.receive(packet);
    
    // System.out.println(new String(bytes));
    System.out.println("From Server: " + new String(packet.getData(), 0, packet.getLength()));
    socket.close();
    
  }
}