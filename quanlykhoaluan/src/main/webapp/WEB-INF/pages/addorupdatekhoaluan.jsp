<%-- 
    Document   : addorupdatekhoaluan
    Created on : Aug 23, 2023, 6:58:08 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/admin/addorupdatekhoaluan" var="action" />
    <form:form modelAttribute="khoaLuan" method="post" action="${action}">
        <form:errors path="*" element="div" cssClass="text-danger"/>
        <form:hidden path="id" />
        <form:hidden path="ngayGhiNhan" />
        <form:hidden path="giaoVuId" />
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="tenKhoaLuan" id="tenKhoaLuan" placeholder="Tên khóa luận" name="tenKhoaLuan" />
            <label for="tenKhoaLuan">Tên khóa luận</label>
            <form:errors path="tenKhoaLuan" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="date" class="form-control" path="ngayKetThuc" id="ngayKetThuc" name="ngayKetThuc"/>
            <label for="ngayKetThuc">Ngày kết thúc</label>
            <form:errors path="ngayKetThuc" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="hoiDongId" name="hoiDongId" path="hoiDongId" class="form-select">
                <c:forEach items="${hoiDongs}" var="hd">
                    <c:choose>
                        <c:when test="${khoaLuan.hoiDongId.id == hd.id}"><option value="${hd.id}" selected>${hd.tenHoiDong}</option></c:when>
                        <c:otherwise><option value="${hd.id}">${hd.tenHoiDong}</option></c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="hoiDongId" class="form-label">Hội đồng</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="nganh" name="nganh" path="nganh" class="form-select">
                <c:forEach items="${listNganh}" var="nganh">
                    <c:choose>
                        <c:when test="${khoaLuan.nganh == nganh}"><option value="${nganh}" selected>${nganh}</option></c:when>
                        <c:otherwise>
                            <option value="${nganh}">${nganh}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="nganh" class="form-label">ngành</label>
            <form:errors path="nganh" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button type="submit" class="btn btn-info">
                <c:choose>
                    <c:when test="${khoaLuan.id != null}">Cập nhật khóa luận</c:when>
                    <c:otherwise>Thêm khóa luận</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</section>