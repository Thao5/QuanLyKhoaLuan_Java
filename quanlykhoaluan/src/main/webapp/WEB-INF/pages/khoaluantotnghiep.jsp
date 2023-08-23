<%-- 
    Document   : khoaluantotnghiep
    Created on : Aug 23, 2023, 5:46:00 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <a href="<c:url value="/admin/thongtindangkykhoaluans"/>" title="Thêm khóa luận" class="btn btn-outline-success">+</a>
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
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${khoaLuans}" var="kl">
                <tr>
                    <td>${kl.id}</td>
                    <td>${kl.tenKhoaLuan}</td>
                    <td>${kl.ngayGhiNhan}</td>
                    <td>${kl.ngayKetThuc}</td>
                    <td>${kl.giaoVuId.ho} ${kl.giaoVuId.ten}</td>
                    <td>${kl.hoiDongId.tenHoiDong}</td>
                    <td>${kl.nganh}</td>
                    <td>
                        <a href="<c:url value="/admin/addorupdatekhoaluan/${kl.id}"/>" title="Cập nhật khóa luận" class="btn btn-outline-primary">
                            <i class="fa-solid fa-wrench"></i>
                        </a>
                    </td>
                    <td>
                        <button onclick="del('<c:url value="/admin/deletekhoaluan/${kl.id}/"/>')" title="Xóa khóa luận" class="btn btn-outline-danger">-</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/del.js" />"></script>