<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>EL Example</title>
</head>
<body>
  <h1>EL Example</h1>
  <c:if test="${param.person != null}">
    <c:out value="hello ${param.person}" escapeXml="false" />
  </c:if>
</body>
</html>