<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit page</title>
</head>
<body>
<form action = "editListItemServlet" method="post">
Borrow date: <input type ="text" name = "month" placeholder="mm"
size="4"> <input type ="text" name = "day" placeholder="dd"
size="4">, <input type ="text" name = "year" placeholder="yyyy"
size="4">
Borrower Name: <input type = "text" name = "borrowerName"><br />
Available Items:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.title} | ${currentitem.author} | ${currentitem.genre}</option>
</c:forEach>
</select>
<br />
</form>
<a href = "index.html">Go add new items instead.</a>
<input type = "submit" value="Save Edited Item">
</body>
</html>