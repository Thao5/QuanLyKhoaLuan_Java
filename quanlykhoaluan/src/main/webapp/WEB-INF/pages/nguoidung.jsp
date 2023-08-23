<%-- 
    Document   : nguoidung
    Created on : Aug 22, 2023, 10:36:27 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <a href="<c:url value="/admin/addorupdatenguoidung"/>" title="Thêm người dùng" class="btn btn-outline-success">+</a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>ID</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Tài Khoản</th>
                <th>email</th>
                <th>sdt</th>
                <th>Vai Trò</th>
                <th>Ngày tạo</th>
                <th>Còn hoạt động</th>
                <th>Ngành</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${nguoiDungs}" var="nd">
                <tr>
                    <td>
                        <img src ="${nd.avatar}" alt="không có hình" width="120"/>
                    </td>
                    <td>${nd.id}</td>
                    <td>${nd.ho}</td>
                    <td>${nd.ten}</td>
                    <td>${nd.taiKhoan}</td>
                    <td>${nd.email}</td>
                    <td>${nd.sdt}</td>
                    <td>${nd.vaiTro}</td>
                    <td>${nd.createdDate}</td>
                    <td>${nd.isActive}</td>
                    <td>${nd.nganh}</td>
                    <c:if test="${nd.vaiTro == 'SINH_VIEN' && nd.khoaLuanId != null}">
                        <td>
                            <!-- Button to Open the Modal -->
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-${nd.id}">
                                Xem thông tin khóa luận
                            </button>

                            <!-- The Modal -->
                            <div class="modal fade" id="myModal-${nd.id}">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">${nd.khoaLuanId.tenKhoaLuan}</h4>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                        </div>

                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            <table class="table table-hover">
                                                <tr>
                                                    <td>ID</td>
                                                    <td>${nd.khoaLuanId.id}</td>
                                                </tr>
                                                <tr>
                                                    <td>Tên khóa luận:</td>
                                                    <td>${nd.khoaLuanId.tenKhoaLuan}</td>
                                                </tr>
                                                <tr>
                                                    <td>Ngày ghi nhận</td>
                                                    <td>${nd.khoaLuanId.ngayGhiNhan}</td>
                                                </tr>
                                                <tr>
                                                    <td>Ngày kết thúc</td>
                                                    <td>${nd.khoaLuanId.ngayKetThuc}</td>
                                                </tr>
                                                <tr>
                                                    <td>Họ Tên giáo vụ</td>
                                                    <td>${nd.khoaLuanId.giaoVuId.ho} ${nd.khoaLuanId.giaoVuId.ten}</td>
                                                </tr>
                                                <tr>
                                                    <td>Tên hội đồng</td>
                                                    <td>${nd.khoaLuanId.hoiDongId.tenHoiDong}</td>
                                                </tr>
                                                <tr>
                                                    <td>Ngành</td>
                                                    <td>${nd.khoaLuanId.nganh}</td>
                                                </tr>
                                            </table>
                                        </div>

                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Đóng</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </td>
                    </c:if>
                    <td>
                        <a href="<c:url value="/admin/addorupdatenguoidung/${nd.id}"/>" title="Cập nhật người dùng" class="btn btn-outline-primary">
                            <i class="fa-solid fa-wrench"></i>
                        </a>
                    </td>
                    <td>
                        <button onclick="delNguoiDung('<c:url value="/admin/deletenguoidung/${nd.id}/"/>')" title="Xóa người dùng" class="btn btn-outline-danger">-</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
    <script src="<c:url value="/js/delNguoiDung.js" />"></script>