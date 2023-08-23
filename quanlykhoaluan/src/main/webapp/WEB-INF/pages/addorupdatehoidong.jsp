<%-- 
    Document   : addorupdatehoidong
    Created on : Aug 24, 2023, 12:21:19 AM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="container">
    <c:url value="/admin/addorupdatehoidong" var="action" />
    <form:form modelAttribute="hoiDong" method="post" action="${action}">
        <form:errors path="*" element="div" cssClass="text-danger"/>
        <form:hidden path="id" />
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="tenHoiDong" id="tenHoiDong" placeholder="Tên hội đồng" name="tenHoiDong" />
            <label for="tenHoiDong">Tên hội đồng</label>
            <form:errors path="tenHoiDong" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="date" class="form-control" path="ngayThanhLap" id="ngayThanhLap" name="ngayThanhLap"/>
            <label for="ngayThanhLap">Ngày thành lập</label>
            <form:errors path="ngayThanhLap" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="date" class="form-control" path="ngayKhoa" id="ngayKhoa" name="ngayKhoa"/>
            <label for="ngayKhoa">Ngày khóa</label>
            <form:errors path="ngayKhoa" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select path="isActive" id="isActive" name="isActive" class="form-select">
                <form:option value="true"/>
                <form:option value="false"/>
            </form:select>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button type="submit" class="btn btn-info">
                <c:choose>
                    <c:when test="${hoiDong.id != null}">Cập nhật hội đồng</c:when>
                    <c:otherwise>Thêm hội đồng</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</section>