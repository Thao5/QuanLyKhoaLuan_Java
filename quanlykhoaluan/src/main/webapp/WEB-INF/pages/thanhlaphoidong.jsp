<%-- 
    Document   : thanhlaphoidong
    Created on : Aug 30, 2023, 11:31:06 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/admin/thanhlaphoidong" var="action" />
    <form:form modelAttribute="thongTinThanhLapHoiDong" method="post" action="${action}">
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="tenHoiDong" id="tenHoiDong" placeholder="Tên hội đồng" name="tenHoiDong" />
            <label for="tenHoiDong">Tên hội đồng</label>
            <form:errors path="tenHoiDong" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="date" class="form-control" path="ngayKhoa" id="ngayKhoa" name="ngayKhoa"/>
            <label for="ngayKhoa">Ngày khóa</label>
            <form:errors path="ngayKhoa" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="kl" name="kl" path="kl" class="form-select">
                <c:forEach items="${khoaLuans}" var="kla">
                    <option value="${kla.id}">${kla.tenKhoaLuan}</option>
                </c:forEach>
            </form:select>
            <label for="kl" class="form-label">Khóa luận</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="giangVienCT" name="giangVienCT" path="giangVienCT" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                </c:forEach>
            </form:select>
            <label for="giangVienCT" class="form-label">Chủ tịch</label>
            <form:errors path="giangVienCT" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="giangVienTK" name="giangVienTK" path="giangVienTK" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                </c:forEach>
            </form:select>
            <label for="giangVienTK" class="form-label">Thư ký</label>
            <form:errors path="giangVienTK" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="giangVienPB" name="giangVienPB" path="giangVienPB" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                </c:forEach>
            </form:select>
            <label for="giangVienPB" class="form-label">Phản biện</label>
            <form:errors path="giangVienPB" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Thành lập hội đồng" class="btn btn-info" />
        </div>
    </form:form>
</section>