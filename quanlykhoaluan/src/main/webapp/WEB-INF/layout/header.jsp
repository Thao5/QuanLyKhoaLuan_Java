<%-- 
    Document   : header
    Created on : Jul 22, 2023, 8:23:38 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
        <h1><a href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a></h1>
        <h1><a href="<c:url value="/logout"/>">đăng xuất</a></h1>
    </c:when>
    <c:otherwise>
        <h1><a href="<c:url value="/login"/>">đăng nhập</a></h1>
    </c:otherwise>
</c:choose>
