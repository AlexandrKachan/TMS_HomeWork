<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lex-PC
  Date: 18.04.2021
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<c:forEach var="product" items="${products}">
    Title: ${product.title}
    Prise: ${product.prise}
    <br>
</c:forEach>
</body>
</html>
