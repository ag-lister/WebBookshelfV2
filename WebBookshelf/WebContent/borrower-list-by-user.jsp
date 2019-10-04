<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrowing Lists</title>
</head>
<body>
<form method = "post" action = "listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
 <td><input type="radio" name="id" value="${currentlist.id}"></td>
 <tr><td colspan="3">Borrow Date: ${currentlist.borrowDate}</td></tr>
 <tr><td colspan="3">Borrower: ${currentlist.borrower.borrowerName}</td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listOfBooks}">
 <tr><td></td><td colspan="3">${listVal.title}, ${listVal.author}, ${listVal.genre}</td></tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addItemsForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>
</html>