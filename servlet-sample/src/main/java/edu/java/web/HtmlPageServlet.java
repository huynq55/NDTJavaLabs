package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/page", name = "html-page")
public class HtmlPageServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();

    writer.println("<html><head><title>Welcome to our website!</title></head>");
    writer.println("<body><h1>Student</h1></body>");
    writer.println("</html>");
  }

}
