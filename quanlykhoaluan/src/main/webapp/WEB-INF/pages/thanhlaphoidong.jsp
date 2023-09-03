<%-- 
    Document   : thanhlaphoidong
    Created on : Aug 30, 2023, 11:31:06 PM
    Author     : Chung Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <c:url value="/admin/thanhlaphoidong" var="action" />
    <form:form modelAttribute="thongTinThanhLapHoiDong" method="post" action="${action}" id="form_form">
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="tenHoiDong" id="tenHoiDong" placeholder="Tên hội đồng" name="tenHoiDong" />
            <label for="tenHoiDong">Tên hội đồng</label>
            <form:errors path="tenHoiDong" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="date" class="form-control" path="ngayKhoa" id="ngayKhoa" name="ngayKhoa"/>
            <label for="ngayKhoa">Ngày khóa</label>
            <form:errors path="ngayKhoa" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="kl" name="kl" path="kl" class="form-select">
                <c:forEach items="${khoaLuans}" var="kla">
                    <option value="${kla.id}">${kla.tenKhoaLuan}</option>
                </c:forEach>
            </form:select>
            <label for="kl" class="form-label">Khóa luận</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="giangVienCT" name="giangVienCT" path="giangVienCT" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                </c:forEach>
            </form:select>
            <label for="giangVienCT" class="form-label">Chủ tịch</label>
            <form:errors path="giangVienCT" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="giangVienTK" name="giangVienTK" path="giangVienTK" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                </c:forEach>
            </form:select>
            <label for="giangVienTK" class="form-label">Thư ký</label>
            <form:errors path="giangVienTK" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select id="giangVienPB" name="giangVienPB" path="giangVienPB" class="form-select">
                <c:forEach items="${giangViens}" var="gvhd">
                    <option value="${gvhd.id}">${String.format("%s %s", gvhd.ho, gvhd.ten)}</option>
                </c:forEach>
            </form:select>
            <label for="giangVienPB" class="form-label">Phản biện</label>
            <form:errors path="giangVienPB" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button onclick="addElement()" class="btn btn-success">Thêm thành viên khác 1</button>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button onclick="addElement2()" class="btn btn-success">Thêm thành viên khác 2</button>
        </div>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Thành lập hội đồng" class="btn btn-info" />
        </div>
    </form:form>
</section>

<script>
    function addElement() {
        event.preventDefault();
        const div1 = document.createElement("div");
        div1.className = "form-floating mb-3 mt-3";
        const form_select1 = document.createElement("select");
        form_select1.id = "giangVienTV1";
        form_select1.name = "giangVienTV1";
        form_select1.className = "form-select";
        form_select1.path = "giangVienTV1";
        const label1 = document.createElement("label");
        label1.className = "form-label";
        label1.for = "giangVienTV1";
        const node = document.createTextNode("Thành viên khác");
        label1.appendChild(node);
        const option_def = document.createElement("option");
        option_def.value = null;
        option_def.text = "Không có";
        form_select1.appendChild(option_def);
    <c:forEach items="${giangViens}" var="gvhd">
        const option_tmp_1_${gvhd.id} = document.createElement("option");
        option_tmp_1_${gvhd.id}.value = ${gvhd.id};
        option_tmp_1_${gvhd.id}.text = '${String.format("%s %s", gvhd.ho, gvhd.ten)}';
        form_select1.appendChild(option_tmp_1_${gvhd.id});
    </c:forEach>
        div1.appendChild(form_select1);
        div1.appendChild(label1);
        const form_form = document.getElementById("form_form");
        form_form.appendChild(div1);
    }
    function addElement2() {
        const div2 = document.createElement("div");
        div2.className = "form-floating mb-3 mt-3";
        const form_select2 = document.createElement("select");
        form_select2.id = "giangVienTV2";
        form_select2.name = "giangVienTV2";
        form_select2.className = "form-select";
        form_select2.path = "giangVienTV2";
        const node2 = document.createTextNode("Thành viên khác");
        const option_def2 = document.createElement("option");
        option_def2.value = null;
        option_def2.text = "Không có";
        const label2 = document.createElement("label");
        label2.className = "form-label";
        label2.for = "giangVienTV2";
        label2.appendChild(node2);
        form_select2.appendChild(option_def2);
    <c:forEach items="${giangViens}" var="gvhd">
        const option_tmp${gvhd.id} = document.createElement("option");
        option_tmp${gvhd.id}.value = ${gvhd.id};
        option_tmp${gvhd.id}.text = '${String.format("%s %s", gvhd.ho, gvhd.ten)}';
        form_select2.appendChild(option_tmp${gvhd.id});
    </c:forEach>
        div2.appendChild(form_select2);
        div2.appendChild(label2);
        form_form.appendChild(div2);
    }

</script>