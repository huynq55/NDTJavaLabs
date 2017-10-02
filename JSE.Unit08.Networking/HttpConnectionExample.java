import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpConnectionExample {

  public static void main(String[] args) throws MalformedURLException, IOException {
    URL url = new URL("http://budsas.net/uni/u-kinh-trungbo/trung39.htm");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    Path path = Paths.get("test.html");
    try (InputStream inputStream = connection.getInputStream();
        OutputStream outputStream =
            Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND); ) {
      int readLength;
      byte[] bytes = new byte[8];
      while ((readLength = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, readLength);
      }
    } finally {
      Desktop.getDesktop().open(path.toFile());
    }
  }
}
