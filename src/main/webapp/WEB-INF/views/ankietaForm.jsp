
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj ankietę</title>
</head>
<body>
<h2>Dodaj ankietę</h2>
<form:form method="post" modelAttribute="ankieta">
    <div>
        <label>Nazwa: </label><form:input class="form-control" path="name"/>
        <div class="alert"><form:errors path="name"/></div>
    </div>
    <br>
    <div class="form-group">
        <label>Cała reszta: </label><form:input class="form-control" path="description"/>
        <div class="alert"><form:errors path="description"/></div>
    </div>
    <br>
    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>
