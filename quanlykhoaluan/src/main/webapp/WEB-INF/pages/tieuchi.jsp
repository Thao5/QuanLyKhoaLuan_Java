<%-- 
    Document   : tieuchi
    Created on : Aug 23, 2023, 10:42:44 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <a href="<c:url value="/admin/addorupdatetieuchi"/>" title="Thêm tiêu chí" class="btn btn-outline-success">+</a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nội dung tiêu chí</th>
                <th>Điểm</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tieuChis}" var="tc">
                <tr>
                    <td>${tc.id}</td>
                    <td>${tc.noiDungTieuChi}</td>
                    <td>${tc.diem}</td>
                    <td>
                        <a href="<c:url value="/admin/addorupdatetieuchi/${tc.id}"/>" title="Cập nhật tiêu chí" class="btn btn-outline-primary">
                            <i class="fa-solid fa-wrench"></i>
                        </a>
                    </td>
                    <td>
                        <button onclick="del('<c:url value="/admin/deletetieuchi/${tc.id}/"/>')" title="Xóa tiêu chí" class="btn btn-outline-danger">-</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/del.js" />"></script>