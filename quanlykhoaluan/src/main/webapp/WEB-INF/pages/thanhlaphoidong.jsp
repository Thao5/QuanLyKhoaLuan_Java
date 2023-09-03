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
            <form:errors path="kl" element="div" cssClass="text-danger"/>
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
        <div id="div-btn1" class="form-floating mb-3 mt-3">
            
        </div>
        <div id="div-btn2" class="form-floating mb-3 mt-3">
            
        </div>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Thành lập hội đồng" class="btn btn-info" />
        </div>
    </form:form>
</section>

<script>
    function loadBtn() {
        const newButton = document.createElement('button');
        newButton.textContent = 'Thêm thành viên khác 1';
        newButton.className = "btn btn-success";
        newButton.id = "btn1";
        newButton.addEventListener('click', () => {
            addElement();
            if (newButton !== null)
                newButton.remove();
            removeBtn();
        });
        const form_form = document.getElementById("div-btn1");
        form_form.appendChild(newButton);
    }
    document.body.addEventListener("load", loadBtn(), false);
    
    function loadBtn2() {
        const newButton = document.createElement('button');
        newButton.textContent = 'Thêm thành viên khác 2';
        newButton.className = "btn btn-success";
        newButton.id = "btn2";
        newButton.addEventListener('click', () => {
            addElement2();
            if (newButton !== null)
                newButton.remove();
            removeBtn2();
        });
        const form_form2 = document.getElementById("div-btn2");
        form_form2.appendChild(newButton);
    }
    document.body.addEventListener("load", loadBtn2()(), false);

    function addBtn() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = 'Thêm thành viên khác 1';
        newButton.className = "btn btn-success";
        newButton.id = "btn1";
        newButton.addEventListener('click', () => {
            addElement();
            if (newButton !== null)
                newButton.remove();
            removeBtn();
        });
        const form_form = document.getElementById("div-btn1");
        form_form.appendChild(newButton);
        const rmvBtn = document.getElementById('rmvBtn1');
        if (rmvBtn !== null) {
            rmvBtn.remove();
        }
    }
    function removeBtn() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = '-';
        newButton.className = "btn btn-danger";
        newButton.id = "rmvBtn1";
        newButton.addEventListener('click', () => {
            removeElement();
            if (newButton !== null)
                newButton.remove();
            addBtn();
        });
        const form_form = document.getElementById("div-btn1");
        form_form.appendChild(newButton);
        const btn1 = document.getElementById('btn1');
        if (btn1 !== null) {
            btn1.remove();
        }
    }
    
    function addBtn2() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = 'Thêm thành viên khác 2';
        newButton.className = "btn btn-success";
        newButton.id = "btn2";
        newButton.addEventListener('click', () => {
            addElement2();
            if (newButton !== null)
                newButton.remove();
            removeBtn2();
        });
        const form_form = document.getElementById("div-btn2");
        form_form.appendChild(newButton);
        const rmvBtn = document.getElementById('rmvBtn2');
        if (rmvBtn !== null) {
            rmvBtn.remove();
        }
    }
    function removeBtn2() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = '-';
        newButton.className = "btn btn-danger";
        newButton.id = "rmvBtn2";
        newButton.addEventListener('click', () => {
            removeElement2();
            if (newButton !== null)
                newButton.remove();
            addBtn2();
        });
        const form_form = document.getElementById("div-btn2");
        form_form.appendChild(newButton);
        const btn1 = document.getElementById('btn2');
        if (btn1 !== null) {
            btn1.remove();
        }
    }

    function addElement() {
        event.preventDefault();
        const div1 = document.getElementById("div-btn1");
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
    <c:forEach items="${giangViens}" var="gvhd">
        const option_tmp_1_${gvhd.id} = document.createElement("option");
        option_tmp_1_${gvhd.id}.value = ${gvhd.id};
        option_tmp_1_${gvhd.id}.text = '${String.format("%s %s", gvhd.ho, gvhd.ten)}';
        form_select1.appendChild(option_tmp_1_${gvhd.id});
    </c:forEach>
        div1.appendChild(form_select1);
        div1.appendChild(label1);
    }
    function addElement2() {
        event.preventDefault();
        const div2 = document.getElementById("div-btn2");
        const form_select2 = document.createElement("select");
        form_select2.id = "giangVienTV2";
        form_select2.name = "giangVienTV2";
        form_select2.className = "form-select";
        form_select2.path = "giangVienTV2";
        const node2 = document.createTextNode("Thành viên khác");
        const label2 = document.createElement("label");
        label2.className = "form-label";
        label2.for = "giangVienTV2";
        label2.appendChild(node2);
    <c:forEach items="${giangViens}" var="gvhd">
        const option_tmp${gvhd.id} = document.createElement("option");
        option_tmp${gvhd.id}.value = ${gvhd.id};
        option_tmp${gvhd.id}.text = '${String.format("%s %s", gvhd.ho, gvhd.ten)}';
        form_select2.appendChild(option_tmp${gvhd.id});
    </c:forEach>
        div2.appendChild(form_select2);
        div2.appendChild(label2);
    }

    function removeElement() {
        event.preventDefault();
        const div1 = document.getElementById("div-btn1");
        if (div1 !== null) {
            while (div1.hasChildNodes()) {
                div1.removeChild(div1.lastChild);
            }
        }
    }

    function removeElement2() {
        event.preventDefault();
        const div2 = document.getElementById("div-btn2");
        if (div2 !== null) {
            while (div2.hasChildNodes()) {
                div2.removeChild(div2.lastChild);
            }
        }
    }
</script>