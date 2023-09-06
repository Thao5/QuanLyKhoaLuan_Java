<%-- 
    Document   : updatediem
    Created on : Sep 6, 2023, 2:16:57 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <c:url value="/admin/addorupdategiangvienchamdiem" var="action" />
    <form:form modelAttribute="giangVienChamDiem" method="post" action="${action}">
        <form:hidden path="id" />
        <form:hidden path="ngayCham" />
        <form:hidden path="giangVienThuocHoiDongId" />
        <form:hidden path="khoaLuanId" />
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" step="0.5" class="form-control" path="diem" id="diem" placeholder="Điểm" name="diem" />
            <label for="diem">Điểm</label>
            <form:errors path="diem" element="div" cssClass="text-danger"/>
        </div>
        <input type="submit" value="Cập nhật điểm" class="btn btn-info"/>
    </form:form>
</section>
