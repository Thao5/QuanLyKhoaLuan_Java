<%-- 
    Document   : nguoidung
    Created on : Jul 22, 2023, 8:29:32 PM
    Author     : Chung Vu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8");%>

<c:url value="/admin/addorupdatenguoidung" var="action" />
<form:form modelAttribute="nguoiDung" method="post" action="${action}" enctype="multipart/form-data">
     <form:errors path="*" element="div" cssClass="text-danger"/>
    <form:hidden path="id" />
    <form:hidden path="createdDate" />
    <form:hidden path="khoaLuanId" />
    <form:hidden path="avatar"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="ho" id="ho" placeholder="họ" name="ho" />
        <label for="ho">Họ</label>
        <form:errors path="ho" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="ten" id="ten" placeholder="Tên" name="ten" />
        <label for="ten">Tên</label>
        <form:errors path="ten" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="taiKhoan" id="taiKhoan" placeholder="Tài khoản" name="taiKhoan" />
        <label for="taiKhoan">Tài Khoản</label>
        <form:errors path="taiKhoan" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" path="email" id="email" placeholder="Email" name="email" />
        <label for="email">email</label>
        <form:errors path="email" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" path="matKhau" id="matKhau" placeholder="Mật Khẩu" name="matKhau" />
        <label for="matKhau">Mật Khẩu</label>
        <form:errors path="matKhau" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="tel" class="form-control" path="sdt" id="sdt" placeholder="888 888 8888" name="sdt"/>
        <label for="sdt">Số điện thoại</label>
        <form:errors path="sdt" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select id="vaiTro" name="vaiTro" path="vaiTro" class="form-select">
            <option value="GIAO_VU" selected>Giáo vụ</option>
            <option value="GIANG_VIEN">Giảng Viên</option>
            <option value="SINH_VIEN">Sinh Viên</option>
        </form:select>
        <label for="vaiTro">Vai trò</label>
        <form:errors path="vaiTro" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select path="isActive" id="isActive" name="isActive" class="form-select">
            <form:option value="true"/>
            <form:option value="false"/>
        </form:select>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="img" placeholder="Avatar" id="avatar"/>
        <label for="avatar">Avatar</label>
        <form:errors path="img" element="div" cssClass="text-danger"/>
        <c:if test="${nguoiDung.avatar != null}">
            <img src="${nguoiDung.avatar}" width="120" />
        </c:if>
    </div>
<!--    <div class="form-floating mb-3 mt-3">
        <form:select id="khoaLuanId" name="khoaLuanId" path="khoaLuanId" class="form-select">
            <c:forEach items="${khoaLuans}" var="kl">
                <option value="${kl.id}">${kl.tenKhoaLuan}</option>
            </c:forEach>
        </form:select>
        <label for="khoaLuanId" class="form-label">Khóa luận</label>
        <form:errors path="khoaLuanId" element="div" cssClass="text-danger"/>
    </div>-->
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${nguoiDung.id != null}">Cập nhật người dùng</c:when>
                <c:otherwise>Thêm người dùng</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
