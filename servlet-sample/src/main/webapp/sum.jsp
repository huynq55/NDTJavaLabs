<html>
  <head><title>JSP Example</title></head>
  <body>
    <h1>Display sum</h1>
    <%
      int sum = 0;
      for(int i = 0; i < 25; i++) {
        sum += i;
      }
      out.println("Sum of number is " + sum);
    %>
    <h2>Sum of number is <% out.println(sum); %></h2>
    <h2>Sum of number is <%= sum %></h2>
  </body>
</html>