import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;

public class URLConnectionExample {
	public static void main(String[] args) throws MalformedURLException, IOException {
		URL url = new URL("http://budsas.net/uni/u-kinh-trungbo/trung39.htm");
		URLConnection connection = url.openConnection();
		InputStream stream = connection.getInputStream();
		
		int readLength;
		byte[] buffer = new byte[8];
		while((readLength = stream.read(buffer)) != -1) {
			// System.out.println(new String(buffer, 0, readLength));
			
			// gan nhu la same, nhung in ra se bi loi dong cuoi
			// System.out.println(new String(buffer));
			
			// print lien mach
			System.out.print(new String(buffer, 0, readLength));
		}
		
	}
	
}