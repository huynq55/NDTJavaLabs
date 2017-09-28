import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SocketClientExample {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 9245);
		System.out.println("CLIENT start sending...");
		try (
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		) {
			output.writeUTF("Hello Server");
			System.out.println("Server Say: " + input.readUTF());
			
		} finally {
			socket.close();
		}
		
		
		
		
	}
	
}