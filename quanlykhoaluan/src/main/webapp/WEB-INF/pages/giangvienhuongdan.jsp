<%-- 
    Document   : giangvienthuochoidong
    Created on : Aug 26, 2023, 1:14:32 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <a href="<c:url value="/admin/addorupdategiangvienhuongdan"/>" title="Thêm hội đồng" class="btn btn-outline-success">+</a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Tên khóa luận</th>
                <th>Số giảng viên hướng dẫn khóa luận</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${giangVienHuongDans}" var="gv">
                <tr>
                    <td>${gv[1]}</td>
                    <td>${gv[2]}</td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-${gv[0]}">
                            Xem chi tiết
                        </button>

                        <!-- The Modal -->
                        <div class="modal fade" id="myModal-${gv[0]}">
                            <div class="modal-dialog">
                                <div class="modal-content">
<!--                                    <a href="<c:url value="/admin/addgiangvienthuochoidong/${hd.id}"/>" title="Thêm tiêu chí thuộc khóa luận" class="btn btn-outline-success">+</a>-->
                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Thông chi tiết của khóa luận ${gv[1]}</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <table class="table table-hover">
                                            <tr>
                                                <td>ID</td>
                                                <td>Họ tên giảng viên</td>
                                                <td>Ngày bắt đầu hướng dẫn</td>
                                                <td></td>
                                            </tr>
                                            <c:forEach items="${gv[3]}" var="gvhd">
                                                <tr>
                                                    <td>${gvhd.id}</td>
                                                    <td>${gvhd.nguoiDungId.ho} ${gvhd.nguoiDungId.ten}</td>
                                                    <td>${gvhd.ngayBatDauHuongDan}</td>
                                                    <td>
                                                        <button onclick="del('<c:url value="/admin/deletegiangvienhuongdan/${gvhd.id}/"/>')" title="Xóa điểm" class="btn btn-outline-danger">-</button>
                                                    </td>
                                                    <!--                                                    <td>
                                                                                                            <a href="<c:url value="/admin/updategiangvienthuochoidong/${hd.id}"/>" title="Cập nhật giảng viên" class="btn btn-outline-primary">
                                                                                                                <i class="fa-solid fa-wrench"></i>
                                                                                                            </a>
                                                                                                        </td>-->
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
                </tr>

            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/del.js" />"></script>