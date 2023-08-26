<%-- 
    Document   : giangvienchamdiem
    Created on : Aug 26, 2023, 9:12:02 AM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <a href="<c:url value="/admin/addgiangvienchamdiem"/>" title="Thêm điểm" class="btn btn-outline-success">+</a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Tên khóa luận</th>
                <th>Điểm trung bình</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${giangVienChamDiems}" var="gvcd">
                <tr>
                    <td>${gvcd[1]}</td>
                    <td>${gvcd[2]}</td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-${gvcd[0]}">
                            Xem chi tiết
                        </button>

                        <!-- The Modal -->
                        <div class="modal fade" id="myModal-${gvcd[0]}">
                            <div class="modal-dialog">
                                <div class="modal-content">
<!--                                    <a href="<c:url value="/admin/addgiangvienthuochoidong/${hd.id}"/>" title="Thêm tiêu chí thuộc khóa luận" class="btn btn-outline-success">+</a>-->
                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Thông tin diểm chi tiết của khóa luận ${gvcd[1]}</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <table class="table table-hover">
                                            <tr>
                                                <td>ID</td>
                                                <td>Họ tên giảng viên chấm điểm</td>
                                                <td>Điểm</td>
                                                <td>Ngày chấm</td>
                                            </tr>
                                            <c:forEach items="${gvcd[3]}" var="gv">
                                                <tr>
                                                    <td>${gv[0]}</td>
                                                    <td>${gv[1]} ${gv[2]}</td>
                                                    <td>${gv[3]}</td>
                                                    <td>${gv[4]}</td>
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
