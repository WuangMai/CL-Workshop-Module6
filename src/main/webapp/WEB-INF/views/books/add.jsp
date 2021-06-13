<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>

<form:form modelAttribute="book" method="post">
    <label>Title: </label><form:input path="title"/><br/>
    <label>ISBN: </label><form:input path="isbn"/><br/>
    <label>Author: </label><form:input path="author"/><br/>
    <label>Publisher: </label><form:input path="publisher"/><br/>
    <label>Type: </label><form:input path="type"/><br/>
    <form:button type="submit">Save</form:button>
</form:form>

</body>
</html>