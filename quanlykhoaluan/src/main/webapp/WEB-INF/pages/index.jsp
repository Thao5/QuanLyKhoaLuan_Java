<%-- 
    Document   : index
    Created on : Jul 18, 2023, 5:25:06 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${nguoiDungs}" var="k">
                <li>${k.ten}</li>
            </c:forEach>
        </ul>
    </body>
</html>
