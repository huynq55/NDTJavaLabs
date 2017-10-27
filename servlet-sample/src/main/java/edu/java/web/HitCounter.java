package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/count", name="hit-counter")
public class HitCounter extends HttpServlet {

  private int hitCount;

  public void init() {
    hitCount = 0;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    hitCount++;

    resp.setContentType("text/html");

    PrintWriter writer = resp.getWriter();
    writer.println("<html>");
    writer.println("<br>Hit count = " + hitCount);
    writer.println("</html>");
  }
}
