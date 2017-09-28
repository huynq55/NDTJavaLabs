import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.function.BiConsumer;

public class HttpHeaderExample {
	public static void main(String[] args) throws MalformedURLException, IOException {
		URL url = new URL("http://budsas.net/uni/u-kinh-trungbo/trung39.htm");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		System.out.println("http method " + connection.getRequestMethod());
		
		Map<String, List<String>> headers = connection.getHeaderFields();
		
		BiConsumer<String, List<String>> aBiConsumer = (key, values) -> {
			System.out.println("Key: " + key + " Values: " + values);
		};
		
		headers.forEach(aBiConsumer);
	}
}