<%@ page import="java.util.Date" %>
<html>
  <head><title>JSP Example</title></head>
  <body>
    <% response.setHeader("Refresh", "6"); %>
    <LI>Today&#39;s date is: <%= new Date() %>
    <LI>Session Id: <%= session.getId() %>
  </body>
</html>