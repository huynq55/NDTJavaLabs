<html>
  <head><title>JSP Example</title></head>
  <body>
    <LI>The path of this JSP file is: <%= request.getRequestURI() %>
    <LI>The Hostname is: <%= request.getRemoteHost() %>
  </body>
</html>