<%-- 
    Document   : tieuchi
    Created on : Jul 23, 2023, 8:21:39 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/admin/addorupdatetieuchi" var="action" />
    <form:form modelAttribute="tieuChi" method="post" action="${action}">
        <form:hidden path="id" />
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="noiDungTieuChi" id="noiDungTieuChi" placeholder="Nội dung tiêu chí" name="noiDungTieuChi" />
            <label for="noiDungTieuChi">Nội dung tiêu chí</label>
            <form:errors path="noiDungTieuChi" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" step="0.25" class="form-control" path="diem" id="diem" placeholder="Điểm" name="diem" />
            <label for="diem">Điểm</label>
            <form:errors path="diem" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button type="submit" class="btn btn-info">
                <c:choose>
                    <c:when test="${tieuChi.id != null}">Cập nhật tiêu chí</c:when>
                    <c:otherwise>Thêm tiêu chí</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</section>