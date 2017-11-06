package edu.java.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClientExample {

  public static void main(String[] args) {
    BufferedReader reader = null;
    try {
      URL url = new URL("http://localhost:8080/test/html");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      con.addRequestProperty("Accept-Encoding", "gzip");

      int responseCode = con.getResponseCode();
      System.out.println("Response Code: " + responseCode);

      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
