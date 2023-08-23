<%-- 
    Document   : hoidongbaovekhoaluan
    Created on : Aug 23, 2023, 11:53:19 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <a href="<c:url value="/admin/addorupdatehoidong"/>" title="Thêm hội đồng" class="btn btn-outline-success">+</a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên hội đồng</th>
                <th>Ngày thành lập</th>
                <th>Ngày khóa</th>
                <th>Đang hoạt động</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${hoiDongs}" var="hd">
                <tr>
                    <td>${hd.id}</td>
                    <td>${hd.tenHoiDong}</td>
                    <td>${hd.ngayThanhLap}</td>
                    <td>${hd.ngayKhoa}</td>
                    <td>${hd.isActive}</td>
                    <td>
                        <a href="<c:url value="/admin/addorupdatehoidong/${hd.id}"/>" title="Cập nhật hội đồng" class="btn btn-outline-primary">
                            <i class="fa-solid fa-wrench"></i>
                        </a>
                    </td>
                    <td>
                        <button onclick="del('<c:url value="/admin/deletehoidong/${hd.id}/"/>')" title="Xóa hội đồng" class="btn btn-outline-danger">-</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/del.js" />"></script>