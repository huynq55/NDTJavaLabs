import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
// import java.lang.Runnable;
import java.io.IOException;

public class SocketServerExample {
	
	public SocketServerExample(Integer serverPort) throws IOException {
		ServerSocket serverSock = new ServerSocket(serverPort);
		System.out.println("SERVER Listening...");
		while(true) {
			Socket socket = serverSock.accept(); 
			new Thread(() -> {
				try(
					// API: DataInputStream(InputStream in)
					// DataOutputStream(OutputStream out)
					DataInputStream input = new DataInputStream(socket.getInputStream());
					DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				) {
					System.out.println("Client Say: " + input.readUTF());
					output.writeUTF("I'm a socket server!");
				}
				catch (IOException e) {}
			}).start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new SocketServerExample(9245);
		
	}
	
	
}