<%-- 
    Document   : hoidongbaovekhoaluan
    Created on : Aug 23, 2023, 11:53:19 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <a href="<c:url value="/admin/thanhlaphoidong"/>" title="Thêm hội đồng" class="btn btn-outline-success">+</a>
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
                <th></th>
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
                        <a href="<c:url value="/admin/gankhoaluanchohoidong/${hd.id}"/>" class="btn btn-outline-primary">Gán khóa luận cho hội đồng</a>
                    </td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-${hd.id}">
                            Xem thông tin giảng viên thuộc hội đồng
                        </button>

                        <!-- The Modal -->
                        <div class="modal fade" id="myModal-${hd.id}">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <a href="<c:url value="/admin/addgiangvienthuochoidong/${hd.id}"/>" title="Thêm tiêu chí thuộc khóa luận" class="btn btn-outline-success">+</a>
                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Thông tin giảng viên thuộc hội đồng ${hd.tenHoiDong}</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <table class="table table-hover">
                                            <tr>
                                                <td>Họ tên</td>
                                                <td>Vai Trò</td>
                                                <td>Ngày vào hội đồng</td>
                                                <td></td>
                                            </tr>
                                            <c:forEach items="${hd.giangVienThuocHoiDongSet}" var="gvthd">
                                                <tr>
                                                    <td>${gvthd.nguoiDungId.ho} ${gvthd.nguoiDungId.ten}</td>
                                                    <td>${gvthd.vaiTro}</td>
                                                    <td>${gvthd.ngayVaoHoiDong}</td>
                                                    <td>
                                                        <a href="<c:url value="/admin/addorupdategiangvienthuochoidong/${gvthd.id}"/>" title="Cập nhật giảng viên" class="btn btn-outline-primary">
                                                            <i class="fa-solid fa-wrench"></i>
                                                        </a>
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
                    <c:set var="continueExecuting" scope="request" value="true"/>
                    <c:forEach items="${diemKL}" var="diem">
                        <c:if test="${diem.giangVienThuocHoiDongId.hoiDongId.id == hd.id && continueExecuting}">
                            <c:set var="continueExecuting" scope="request" value="false"/>
                            <td>
                                <a href="<c:url value="/admin/donghoidong/${hd.id}"/>" title="Đóng hội đồng" class="btn btn-outline-primary">Đóng hội đồng</a>
                            </td>
                        </c:if>
                    </c:forEach>
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