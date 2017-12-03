<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Student List</title>
<script>
  function view(id) {
    var xmlHttp = new XMLHttpRequest();

    xmlHttp.open("GET", "json/" + id, true);
    xmlHttp.onload = function() {
      if (this.status != 200) return;
      var student = JSON.parse(this.responseText);
      document.getElementById('content').innerHTML = 'Name: ' + student.name + '<img src="/student/avatar/' + student.id + '"/>';
      var dialog = document.getElementById('viewStudent');
      dialog.show();
    };
    xmlHttp.send();
  }
</script>
</head>
<body>
  <form method="GET" action="list">
  <table border="1">
    <tr>
      <td colspan="4"><input type="text" name="q" size="30" /></td>
      <td><input type="submit" value="Submit" /></td>
    </tr>
    <tr>
      <td>Id</td>
      <td>Name</td>
      <td>Age</td>
    </tr>

    <c:forEach items="${students}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td><a href="delete/${student.id}">delete</a></td>
        <td><a href="edit/${student.id}">edit</a></td>
        <td><a href="javascript:view(${student.id})">${student.name}</a></td>
      </tr>
    </c:forEach>
  </table>
  </form>

  <dialog id="viewStudent" style="width:50%;border:1px dotted black;">
    <div id="content"></div>
    <button id="hide">Close</button>
  </dialog>

  <script>
    (function() {
      var dialog = document.getElementById('viewStudent');
      document.getElementById('hide').onclick = function() {
        dialog.close();
      };
    })();
  </script>
</body>
</html>