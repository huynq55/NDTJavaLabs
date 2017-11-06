package edu.java.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

public class AsyncHttpClientExample {

  public static void main(String[] args) {
    CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
    httpClient.start();
    HttpGet request = new HttpGet("http://localhost:8080/test/synch");

    httpClient.execute(request, new FutureCallback<HttpResponse>() {
      @Override
      public void completed(HttpResponse httpResponse) {
        BufferedReader reader = null;
        try {
          InputStream stream = httpResponse.getEntity().getContent();
          reader = new BufferedReader(new InputStreamReader(stream));

          String line;
          while ((line = reader.readLine()) != null) {
            System.out.println(line);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void failed(Exception e) {

      }

      @Override
      public void cancelled() {

      }

    });

    int counter = 1;
    while (counter < 10) {
      System.out.println("main thread is running " + counter);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      counter++;
    }
  }
}
