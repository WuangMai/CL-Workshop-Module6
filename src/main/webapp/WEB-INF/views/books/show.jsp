<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show single book</title>
</head>
<body>

<label>Title: </label><c:out value="${book.title}"/><br/>
<label>ISBN: </label><c:out value="${book.isbn}"/><br/>
<label>Author: </label><c:out value="${book.author}"/><br/>
<label>Publisher: </label><c:out value="${book.publisher}"/><br/>
<label>Type: </label><c:out value="${book.type}"/><br/>

</body>
</html>