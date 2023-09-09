<%-- 
    Document   : addorupdategiangvienthuochoidong
    Created on : Sep 8, 2023, 7:29:53 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/admin/addorupdategiangvienthuochoidong" var="action" />
    <form:form modelAttribute="giangVienThuocHoiDong" method="post" action="${action}">
        <form:hidden path="id" />
        <form:hidden path="vaiTro" />
        <form:hidden path="ngayVaoHoiDong" />
        <form:hidden path="hoiDongId" />
        <div class="form-floating mb-3 mt-3">
            <form:select id="nguoiDungId" name="nguoiDungId" path="nguoiDungId" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <c:choose>
                        <c:when test="${giangVienThuocHoiDong.nguoiDungId.id == gvhd.id}">
                            <option value="${gvhd.id}" selected>${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="nguoiDungId" class="form-label">Giảng viên thuộc hội đồng</label>
            <form:errors path="nguoiDungId" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button type="submit" class="btn btn-info">
                <c:choose>
                    <c:when test="${giangVienThuocHoiDong.id != null}">Cập nhật giảng viên</c:when>
                    <c:otherwise>Thêm giảng viên</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</section>