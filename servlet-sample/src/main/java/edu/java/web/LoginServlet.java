package edu.java.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/j_security_check", name = "login-servlet")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = req.getParameter("j_username");
    String password = req.getParameter("j_password");
    try {
      req.login(username, password);

      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/hello.jsp");
      req.setAttribute("say", "Hi Ha Noi!");
      dispatcher.forward(req, resp);

      resp.getWriter().println("login successful");
    } catch (Exception e){
      resp.getWriter().println("Sorry! Login failed!");
      e.printStackTrace(resp.getWriter());
    }
  }
}
