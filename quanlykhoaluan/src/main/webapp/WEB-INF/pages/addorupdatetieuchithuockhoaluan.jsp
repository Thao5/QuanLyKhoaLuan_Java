<%-- 
    Document   : addorupdatetieuchithuockhoaluan
    Created on : Aug 25, 2023, 5:33:55 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/admin/addorupdatetieuchithuockhoaluan" var="action" />
    <form:form modelAttribute="tieuChiThuocKhoaLuan" method="post" action="${action}">
        <form:hidden path="id" />
        <form:hidden path="khoaLuanId" />
        <div class="form-floating mb-3 mt-3">
            <form:select id="tieuChiId" name="tieuChiId" path="tieuChiId" class="form-select">
                <c:forEach items="${tieuChis}" var="tc">
                    <c:choose>
                        <c:when test="${tieuChiThuocKhoaLuan.tieuChiId.id == tc.id}"><option value="${tc.id}" selected>${tc.noiDungTieuChi} - ${tc.diem}</option></c:when>
                        <c:otherwise>
                            <option value="${tc.id}">${tc.noiDungTieuChi} - ${tc.diem}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="tieuChiId" class="form-label">Tiêu chí</label>
            <form:errors path="tieuChiId" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button type="submit" class="btn btn-info">
                <c:choose>
                    <c:when test="${tieuChiThuocKhoaLuan.id != null}">Cập nhật tiêu chí thuộc khóa luận</c:when>
                    <c:otherwise>Thêm tiêu chí thuộc khóa luận</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</section>
