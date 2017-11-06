package edu.java.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/synch", asyncSupported = true)
public class AsynchServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    final AsyncContext ctx = req.startAsync();

    ctx.setTimeout(60 * 1000);
    ctx.start(() -> {
      BufferedReader reader = null;
      try {
        Thread.sleep(3 * 1000l);
        Writer writer = ctx.getResponse().getWriter();

        URL obj = new URL("https://www.google.com.vn");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
          writer.write(line);
        }
        ctx.complete();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
