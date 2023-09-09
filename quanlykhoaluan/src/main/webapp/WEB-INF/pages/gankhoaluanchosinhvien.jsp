<%-- 
    Document   : gankhoaluanchosinhvien
    Created on : Sep 9, 2023, 2:49:25 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <form method="post" action="<c:url value="/admin/gankhoaluanchosinhvien/${klID}" />">
        <select class="form-select" id="ndID" name="ndID">
            <c:forEach items="${sinhViens}" var="sv">
                <option value="${sv.id}">
                    ${sv.ho} ${sv.ten}
                </option>
            </c:forEach>
        </select>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Gán khóa luận cho sinh viên" class="btn btn-info" />
        </div>
    </form>
</section>
