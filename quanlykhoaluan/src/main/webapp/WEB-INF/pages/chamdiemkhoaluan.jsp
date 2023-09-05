<%-- 
    Document   : chamdiemkhoaluan
    Created on : Sep 5, 2023, 6:22:10 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/giangvien/chamdiem" var="action" />
    <form:form modelAttribute="thongTinGiangVienChamDiem" method="post" action="${action}">
        <form:hidden path="klId" />
        <form:hidden path="ndId" />
        <form:errors path="*" element="div" cssClass="text-danger"/>
        <div class="form-floating mb-3 mt-3">
            <form:select id="listTC" name="listTC" path="listTC" class="select" multiple="true">
                <c:forEach items="${listTCCuaKL}" var="tc">
                    <form:option value="${tc.id}">${tc.noiDungTieuChi}-${tc.diem}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Chấm điểm" class="btn btn-info" />
        </div>
    </form:form>
</section>