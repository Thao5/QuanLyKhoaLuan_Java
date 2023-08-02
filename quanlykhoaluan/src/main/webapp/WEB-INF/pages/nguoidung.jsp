<%-- 
    Document   : nguoidung
    Created on : Jul 22, 2023, 8:29:32 PM
    Author     : Chung Vu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:url value="/nguoidung" var="action" />
<form:form modelAttribute="nguoiDung" method="post" action="${action}">
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
        <form:input type="text" class="form-control" path="email" id="email" placeholder="Email" name="email" />
        <label for="email">email</label>
        <form:errors path="email" element="div" cssClass="text-danger"/>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" path="matKhau" id="matKhau" placeholder="Mật Khẩu" name="matKhau" />
        <label for="matKhau">Mật Khẩu</label>
        <form:errors path="matKhau" element="div" cssClass="text-danger"/>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="sdt" id="sdt" placeholder="Số điện thoại" name="sdt" />
        <label for="sdt">Số điện thoại</label>
        <form:errors path="sdt" element="div" cssClass="text-danger"/>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="vaiTro" id="vaiTro" placeholder="Vai trò" name="vaiTro" />
        <label for="vaiTro">Vai trò</label>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="avatar" placeholder="Avatar" id="avatar"/>
        <label for="avatar">Avatar</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="submit" value="Thêm người dùng" class="btn btn-info" />
    </div>
</form:form>
