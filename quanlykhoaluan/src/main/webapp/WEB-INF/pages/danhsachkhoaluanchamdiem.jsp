<%-- 
    Document   : danhsachkhoaluanchamdiem
    Created on : Sep 5, 2023, 8:23:43 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container">
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên khóa luận</th>
                <th>Ngày ghi nhận</th>
                <th>Ngày kết thúc</th>
                <th>Họ tên giáo vụ</th>
                <th>Tên hội đồng</th>
                <th>Ngành</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listChamDiem}" var="kl">
                <tr>
                    <td>${kl.id}</td>
                    <td>${kl.tenKhoaLuan}</td>
                    <td>${kl.ngayGhiNhan}</td>
                    <td>${kl.ngayKetThuc}</td>
                    <td>${kl.giaoVuId.ho} ${kl.giaoVuId.ten}</td>
                    <td>${kl.hoiDongId.tenHoiDong}</td>
                    <td>${kl.nganh}</td>
                    <td>
                        <a href="<c:url value="/giangvien/chamdiem/${kl.id}" />" class="btn btn-outline-primary">Chấm điểm</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
