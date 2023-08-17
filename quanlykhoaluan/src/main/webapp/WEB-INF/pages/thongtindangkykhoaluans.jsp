<%-- 
    Document   : thongtindangkykhoaluans
    Created on : Aug 17, 2023, 1:21:42 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table">
    <tr>
        <th>MSSV</th>
        <th>Tên đề tài</th>
        <th>Ngành</th>
        <th>Mô tả</th>
        <th>Tên SV</th>
        <th>Giảng viên hướng dẫn</th>
    </tr>
    <c:forEach var="kl" items="${thongTinDangKys}">
        <tr>
            <td>${kl.studentCode}</td>
            <td>${kl.title}</td>
            <c:forEach var="n" items="${kl.categories.values()}">
                <td>${n}</td>
            </c:forEach>
            <td>${kl.description}</td>
            <td>${kl.author}</td>
            <c:forEach var="gv" items="${kl.mentor.values()}">
                <td>${gv}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
