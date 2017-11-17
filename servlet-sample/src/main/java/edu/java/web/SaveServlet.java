package edu.java.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/save", name = "save-servlet")
public class SaveServlet extends HttpServlet {

  private Connection connection;
  private Statement statement;

  @Override
  public void init(ServletConfig config) throws ServletException {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connection = DriverManager.getConnection("jdbc:derby:C:/Temp/userdb; create=true");
      statement = connection.createStatement();

      DatabaseMetaData dmd = connection.getMetaData();
      ResultSet rs = dmd.getTables(null, null, null, new String[]{"TABLE"});

      if (rs.next() && rs.getString("TABLE_NAME").equals("HANOI_USER")) {
        return;
      }

      statement.execute(
          "create table hanoi_user(username varchar(500), password varchar(500), email varchar(1000))");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String user = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");

    String sql =
        "insert into hanoi_user " + "(username, password, email) values" + " ('" + user + "', '"
            + password + "', '" + email + "')";
    try {
      System.out.println(sql);
      statement.execute(sql);
      RequestDispatcher dispatcher = req.getRequestDispatcher("view-users.jsp");
      dispatcher.forward(req, resp);
    } catch (Exception exp) {
      exp.printStackTrace(resp.getWriter());
    }
  }

  @Override
  public void destroy() {
    try {
      DriverManager.getConnection("jdbc:derby:C:/Temp/userdb; shutdown=true");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if ("del".equals(req.getParameter("action"))) {
      String sql = "delete from hanoi_user where username = \'" + req.getParameter("user") + "\'";
      try {
        System.out.println(sql);
        statement.execute(sql);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view-users.jsp");
        dispatcher.forward(req, resp);
      } catch (Exception exp) {
        exp.printStackTrace(resp.getWriter());
      }
    }
  }
}
