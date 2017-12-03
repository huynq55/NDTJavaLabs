<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
  <h2>Please input Student Information</h2>
  <form:form method="POST" action="save">
  <form:hidden path="id"/>
  <table>
    <tr>
      <td>Name:</td>
      <td><form:input path="name" /><form:errors path="name" /></td>
    </tr>
    <tr>
      <td>Age:</td>
      <td><form:input path="age" type="number" /><form:errors path="age" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
  </form:form>

  <c:if test="${id != null}">
    <h1>Please upload an image</h1>
    <form method="post" action="../avatar/save" enctype="multipart/form-data">
      <input type="hidden" name="id" value="${id}" />
      <input type="file" name="file" />
      <input type="submit" value="Upload" />
    </form>
  </c:if>

</body>