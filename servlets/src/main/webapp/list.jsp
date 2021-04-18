<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:forEach var="product" items="${products}">
        <c:out value="${product}"/>
    </c:forEach>

</div>
</html>
