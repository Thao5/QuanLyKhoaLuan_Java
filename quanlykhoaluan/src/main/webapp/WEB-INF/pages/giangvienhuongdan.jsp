<%-- 
    Document   : giangVienHuongDanKhoaLuan
    Created on : Aug 9, 2023, 11:12:06 AM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/giangvienhuongdankhoaluan" var="action" />
<form:form modelAttribute="giangVienHuongDan" method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" class="form-control" path="ngayBatDauHuongDan" id="ngayBatDauHuongDan" name="ngayBatDauHuongDan"/>
        <label for="ngayBatDauHuongDan">Ngày bắt đầu hướng dẫn</label>
        <form:errors path="ngayBatDauHuongDan" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select id="nguoiDungId" name="nguoiDungId" path="nguoiDungId" class="form-select">
            <c:forEach items="${giangViens}" var="gvhd">
                <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
            </c:forEach>
        </form:select>
        <label for="nguoiDungId" class="form-label">Giảng viên hướng dẫn</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select id="khoaLuanId" name="khoaLuanId" path="khoaLuanId" class="form-select">
            <c:forEach items="${khoaLuans}" var="kl">
                <option value="${kl.id}">${kl.tenKhoaLuan}</option>
            </c:forEach>
        </form:select>
        <label for="khoaLuanId" class="form-label">Khóa luận</label>
        <form:errors path="khoaLuanId" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="submit" value="Thêm giảng viên hướng dẫn" class="btn btn-info" />
    </div>
</form:form>
