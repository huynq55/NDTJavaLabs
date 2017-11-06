package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(
    @HttpConstraint(
        transportGuarantee = TransportGuarantee.CONFIDENTIAL,
        rolesAllowed = {"read"}
    )
)
@WebServlet(value = "/html", name = "html-page")
public class HtmlPageServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    System.out.println(resp.getClass());
    PrintWriter writer = resp.getWriter();

    writer.println("<html><head><title>Welcome to our website!</title></head>");
    writer.println("<body><h1>Student</h1></body>");
    writer.println("<table border=1><tr><td>#</td><td>Name</td></tr>");
    writer.println("<tr><td>1</td><td>Nguyen Van A</td></tr>");
    writer.println("<tr><td>1</td><td>Tran Thi B</td></tr>");
    writer.println("<tr><td>1</td><td>Le Van C</td></tr>");
    writer.println("</table></html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }
}
