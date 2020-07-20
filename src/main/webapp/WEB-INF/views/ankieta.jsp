
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ankieta</title>
</head>
<body>
<h2>Ankiety</h2>
<table>
<thead>
<tr bgcolor="#ffd700">
    <th>Tytuł</th>
    <th>Opis</th>
</tr>
</thead>
<tbody>
<c:forEach items="${ankiety}" var="ankieta">
<tr>
    <td><c:out value="${ankieta.name}"/></td>
    <td><c:out value="${ankieta.description}"/></td>
</c:forEach>
</tbody>

</table>

</body>
</html>
