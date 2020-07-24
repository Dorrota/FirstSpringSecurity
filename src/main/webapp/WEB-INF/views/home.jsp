
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Dzień dobry</h2>

<h4>Dla wszystkich.</h4>

<div><sec:authorize access="hasRole('USER')">Text visible to user.</sec:authorize></div>
<div><sec:authorize access="hasRole('ADMIN')">Text visible to admin.</sec:authorize></div>
<div> <sec:authorize access="hasAnyRole('VIEWER')">Text visible only to viewer users.</sec:authorize>
</div>
<br>

<sec:authorize access="isAuthenticated()">
    <p>Welcome: <sec:authentication property="name"/></p>
    <br>
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>

</body>
</html>
