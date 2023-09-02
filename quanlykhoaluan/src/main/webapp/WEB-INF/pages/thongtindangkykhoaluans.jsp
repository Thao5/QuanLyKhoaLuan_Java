<%-- 
    Document   : thongtindangkykhoaluans
    Created on : Aug 17, 2023, 1:21:42 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <c:if test="${thongTinDangKys.isEmpty() || thongTinDangKys == null}"><h1>Không có danh sách khóa luận chờ duyệt</h1></c:if>
    <c:if test="${!thongTinDangKys.isEmpty() && thongTinDangKys != null}">
        <table class="table">
            <tr>
                <th>MSSV</th>
                <th>Tên đề tài</th>
                <th>Ngành</th>
                <th>Mô tả</th>
                <th>Tên SV</th>
                <th>Giảng viên hướng dẫn 1</th>
                <th>Giảng viên hướng dẫn 2</th>
                <th></th>
            </tr>
            <c:forEach var="kl" items="${thongTinDangKys}">
                <tr>
                    <td>${kl.studentCode}</td>
                    <td>${kl.title}</td>
                    <c:forEach var="n" items="${kl.categories}">
                        <td>${n}</td>
                    </c:forEach>
                    <td>${kl.description}</td>
                    <td>${kl.author}</td>
                    <c:forEach var="gv" items="${kl.mentor}">
                        <td>${gv}</td>
                    </c:forEach>
                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal-${kl.studentCode}">
                            +
                        </button>

                        <!-- The Modal -->
                        <div class="modal fade" id="myModal-${kl.studentCode}">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Nhập ngày kết thúc</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>
                                    <div class="modal-body">
                                        <c:url value="/admin/thongtindangkykhoaluans/${kl.studentCode}" var="action" />
                                        <form:form modelAttribute="kltn" method="post" action="${action}">
                                            <div class="form-floating mb-3 mt-3">
                                                <form:input type="date" class="form-control" path="ngayKetThuc" id="ngayKetThuc" name="ngayKetThuc"/>
                                                <label for="ngayKhoa">Ngày kết thúc</label>
                                            </div>
                                            <div class="form-floating mb-3 mt-3">
                                                <input type="submit" value="Ghi nhận khóa luận" class="btn btn-info" />
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Đóng</button>
                                    </div>
                                </div>

                                <!-- Modal footer -->

                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</section>