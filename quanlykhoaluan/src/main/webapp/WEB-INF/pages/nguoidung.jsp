<%-- 
    Document   : nguoidung
    Created on : Jul 22, 2023, 8:29:32 PM
    Author     : Chung Vu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/nguoidung" var="action" />
<form:form modelAttribute="nguoiDung" method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="ho" id="ho" placeholder="họ" name="ho" />
        <label for="ho">Họ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="ten" id="ten" placeholder="Tên" name="ten" />
        <label for="ten">Tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="taiKhoan" id="taiKhoan" placeholder="Tài khoản" name="taiKhoan" />
        <label for="taiKhoan">Tài Khoản</label>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="email" id="email" placeholder="Email" name="email" />
        <label for="email">email</label>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="matKhau" id="matKhau" placeholder="Mật Khẩu" name="matKhau" />
        <label for="matKhau">Mật Khẩu</label>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="sdt" id="sdt" placeholder="Số điện thoại" name="sdt" />
        <label for="sdt">Số điện thoại</label>
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
