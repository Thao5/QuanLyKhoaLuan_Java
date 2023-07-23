<%-- 
    Document   : tieuchi
    Created on : Jul 23, 2023, 8:21:39 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/tieuchi" var="action" />
<form:form modelAttribute="tieuChi" method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="noiDungTieuChi" id="noiDungTieuChi" placeholder="Nội dung tiêu chí" name="noiDungTieuChi" />
        <label for="noiDungTieuChi">Nội dung tiêu chí</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" step="0.01" class="form-control" path="diem" id="diem" placeholder="Điểm" name="diem" />
        <label for="diem">Điểm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="submit" value="Thêm tiêu chí" class="btn btn-info" />
    </div>
</form:form>