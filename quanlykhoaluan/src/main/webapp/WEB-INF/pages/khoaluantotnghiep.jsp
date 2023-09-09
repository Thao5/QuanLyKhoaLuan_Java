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
                <th></th>
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
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-${kl.id}">
                            Xem thông tin tiêu chí
                        </button>

                        <!-- The Modal -->
                        <div class="modal fade" id="myModal-${kl.id}">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <a href="<c:url value="/admin/addtieuchithuockhoaluan/${kl.id}"/>" title="Thêm tiêu chí thuộc khóa luận" class="btn btn-outline-success">+</a>
                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Thông tin tiêu chí thuộc khóa luận ${kl.tenKhoaLuan}</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <table class="table table-hover">
                                            <tr>
                                                <td>nội dung tiêu chí</td>
                                                <td>Điểm</td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <c:forEach items="${kl.tieuChiThuocKhoaLuanSet}" var="tctkl">
                                                <tr>
                                                    <td>${tctkl.tieuChiId.noiDungTieuChi}</td>
                                                    <td>${tctkl.tieuChiId.diem}</td>
                                                    <td>
                                                        <a href="<c:url value="/admin/updatetieuchithuockhoaluan/${tctkl.id}"/>" title="Cập nhật tiêu chí" class="btn btn-outline-primary">
                                                            <i class="fa-solid fa-wrench"></i>
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <button onclick="del('<c:url value="/admin/deletetieuchithuockhoaluan/${kl.id}/${tctkl.id}/"/>')" title="Xóa tiêu chí" class="btn btn-outline-danger">-</button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
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
                    <td>
                        <a href="<c:url value="/admin/gankhoaluanchosinhvien/${kl.id}"/>" title="Gán khóa luận cho sinh viên" class="btn btn-outline-primary">
                            Gán khóa luận cho sinh viên
                        </a>
                    </td>
                    <c:set var="continueExecuting" scope="request" value="true"/>
                    <c:forEach items="${diemKL}" var="diem">
                        <c:if test="${diem.khoaLuanId.id == kl.id && continueExecuting}">
                            <c:set var="continueExecuting" scope="request" value="false"/>
                            <td>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-diem-${kl.id}">
                                    Xem điểm khóa luận
                                </button>

                                <!-- The Modal -->
                                <div class="modal fade" id="myModal-diem-${kl.id}">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <!-- Modal Header -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">Thông tin điểm khóa luận ${kl.tenKhoaLuan}</h4>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                            </div>

                                            <!-- Modal body -->
                                            <div class="modal-body">
                                                <table class="table table-hover">
                                                    <tr>
                                                        <td>Họ tên người chấm</td>
                                                        <td>Điểm</td>
                                                        <td></td>
                                                    </tr>
                                                    <c:forEach items="${diemKL}" var="diem">
                                                        <c:if test="${diem.khoaLuanId.id == kl.id}">
                                                            <tr>
                                                                <td>${diem.giangVienThuocHoiDongId.nguoiDungId.ho} ${diem.giangVienThuocHoiDongId.nguoiDungId.ten}</td>
                                                                <td>${diem.diem}</td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:forEach items="${DTB}" var="d">
                                                        <c:if test="${d[0] == kl.id}">
                                                            <tr>
                                                                <td>Điểm trung bình</td>
                                                                <td>${d[1]}</td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                </table>
                                            </div>

                                            <!-- Modal footer -->
                                            <div class="modal-footer">

                                                <a href="<c:url value="/admin/statDTB/${kl.id}" />" class="btn btn-info">In điểm</a>

                                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Đóng</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </td>
                        </c:if>
                    </c:forEach>
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