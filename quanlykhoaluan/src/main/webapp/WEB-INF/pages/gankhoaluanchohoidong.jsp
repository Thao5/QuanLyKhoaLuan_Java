<%-- 
    Document   : gankhoaluanchohoidong
    Created on : Sep 4, 2023, 8:23:01 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="container">
    <c:url value="/admin/gankhoaluanchohoidong" var="action" />
    <form:form modelAttribute="thongTinGanKhoaLuanChoHoiDong" method="post" action="${action}">
        <form:hidden path="id" />
        <div class="form-floating mb-3 mt-3">
            <form:select id="khoaLuan2" name="khoaLuan2" class="form-select" path="kl2">
                <c:forEach items="${listKhoaLuanChuaCoHoiDong}" var="kl">
                    <option value="${kl.id}">${kl.tenKhoaLuan}</option>
                </c:forEach>
            </form:select>
            <label for="khoaLuan2">Khóa luận 2</label>
            <form:errors path="kl2" element="div" cssClass="text-danger"/>
        </div>
        <div class="form-floating mb-3 mt-3" id="div-btn1">

        </div>
        <div class="form-floating mb-3 mt-3" id="div-btn2">

        </div>
        <div class="form-floating mb-3 mt-3"id="div-btn3">

        </div>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Gán khóa luận" class="btn btn-info" />
        </div>
    </form:form>
</section>

<script>
    const newButton = document.createElement('button');
    newButton.textContent = 'Gán thêm khóa luận';
    newButton.className = "btn btn-success";
    newButton.id = 'btn1';
    newButton.addEventListener('click', () => {
        addElement1();
        if (newButton !== null)
            newButton.remove();
        removeBtn1();
    });
    const div_div = document.getElementById("div-btn1");
    div_div.appendChild(newButton);

    const newButton2 = document.createElement('button');
    newButton2.textContent = 'Gán thêm khóa luận';
    newButton2.className = "btn btn-success";
    newButton2.id = 'btn2';
    newButton2.addEventListener('click', () => {
        addElement2();
        if (newButton2 !== null)
            newButton2.remove();
        removeBtn2();
    });
    const div_div2 = document.getElementById("div-btn2");
    div_div2.appendChild(newButton2);

    const newButton3 = document.createElement('button');
    newButton3.textContent = 'Gán thêm khóa luận';
    newButton3.className = "btn btn-success";
    newButton3.id = 'btn3';
    newButton3.addEventListener('click', () => {
        addElement3();
        if (newButton3 !== null)
            newButton3.remove();
        removeBtn3();
    });
    const div_div3 = document.getElementById("div-btn3");
    div_div3.appendChild(newButton3);

    function addBtn1() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = 'Gán thêm khóa luận';
        newButton.className = "btn btn-success";
        newButton.id = 'btn1';
        newButton.addEventListener('click', () => {
            addElement1();
            if (newButton !== null)
                newButton.remove();
            removeBtn1();
        });
        const div_div = document.getElementById("div-btn1");
        div_div.appendChild(newButton);
        const rmvBtn = document.getElementById('rmvBtn1');
        if (rmvBtn !== null) {
            rmvBtn.remove();
        }
    }

    function addBtn2() {
        event.preventDefault();
        const newButton2 = document.createElement('button');
        newButton2.textContent = 'Gán thêm khóa luận';
        newButton2.className = "btn btn-success";
        newButton2.id = 'btn2';
        newButton2.addEventListener('click', () => {
            addElement2();
            if (newButton2 !== null)
                newButton2.remove();
            removeBtn2();
        });
        const div_div2 = document.getElementById("div-btn2");
        div_div2.appendChild(newButton2);
    }

    function addBtn3() {
        event.preventDefault();
        const newButton3 = document.createElement('button');
        newButton3.textContent = 'Gán thêm khóa luận';
        newButton3.className = "btn btn-success";
        newButton3.id = 'btn3';
        newButton3.addEventListener('click', () => {
            addElement3();
            if (newButton3 !== null)
                newButton3.remove();
            removeBtn3();
        });
        const div_div3 = document.getElementById("div-btn3");
        div_div3.appendChild(newButton3);
    }

    function removeBtn1() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = '-';
        newButton.className = "btn btn-danger";
        newButton.id = "rmvBtn1";
        newButton.addEventListener('click', () => {
            removeElement1();
            if (newButton !== null)
                newButton.remove();
            addBtn1();
        });
        const form_form = document.getElementById("div-btn1");
        form_form.appendChild(newButton);
        const btn1 = document.getElementById('btn1');
        if (btn1 !== null) {
            btn1.remove();
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

    function removeBtn3() {
        event.preventDefault();
        const newButton = document.createElement('button');
        newButton.textContent = '-';
        newButton.className = "btn btn-danger";
        newButton.id = "rmvBtn3";
        newButton.addEventListener('click', () => {
            removeElement3();
            if (newButton !== null)
                newButton.remove();
            addBtn3();
        });
        const form_form = document.getElementById("div-btn3");
        form_form.appendChild(newButton);
        const btn1 = document.getElementById('btn3');
        if (btn1 !== null) {
            btn1.remove();
        }
    }

    function addElement1() {
        event.preventDefault();
        const div1 = document.getElementById("div-btn1");
        const form_select1 = document.createElement("select");
        form_select1.id = "kl3";
        form_select1.name = "kl3";
        form_select1.className = "form-select";
        form_select1.path="kl3";
        const label1 = document.createElement("label");
        label1.className = "form-label";
        const node = document.createTextNode("Khóa luận 3");
        label1.appendChild(node);
    <c:forEach items="${listKhoaLuanChuaCoHoiDong}" var="kl">
        const option_tmp_1_${kl.id} = document.createElement("option");
        option_tmp_1_${kl.id}.value = ${kl.id};
        option_tmp_1_${kl.id}.text = '${kl.tenKhoaLuan}';
        form_select1.appendChild(option_tmp_1_${kl.id});
    </c:forEach>
        div1.appendChild(form_select1);
        div1.appendChild(label1);
    }
    
    function addElement2() {
        event.preventDefault();
        const div2 = document.getElementById("div-btn2");
        const form_select2 = document.createElement("select");
        form_select2.id = "kl4";
        form_select2.name = "kl4";
        form_select2.className = "form-select";
        form_select2.path="kl4";
        const label2 = document.createElement("label");
        label2.className = "form-label";
        const node = document.createTextNode("Khóa luận 4");
        label2.appendChild(node);
    <c:forEach items="${listKhoaLuanChuaCoHoiDong}" var="kl">
        const option_tmp_2_${kl.id} = document.createElement("option");
        option_tmp_2_${kl.id}.value = ${kl.id};
        option_tmp_2_${kl.id}.text = '${kl.tenKhoaLuan}';
        form_select2.appendChild(option_tmp_2_${kl.id});
    </c:forEach>
        div2.appendChild(form_select2);
        div2.appendChild(label2);
    }
    
    function addElement3() {
        event.preventDefault();
        const div3 = document.getElementById("div-btn3");
        const form_select3 = document.createElement("select");
        form_select3.id = "kl5";
        form_select3.name = "kl5";
        form_select3.className = "form-select";
        form_select3.path="kl5";
        const label3 = document.createElement("label");
        label3.className = "form-label";
        const node = document.createTextNode("Khóa luận 5");
        label3.appendChild(node);
    <c:forEach items="${listKhoaLuanChuaCoHoiDong}" var="kl">
        const option_tmp_3_${kl.id} = document.createElement("option");
        option_tmp_3_${kl.id}.value = ${kl.id};
        option_tmp_3_${kl.id}.text = '${kl.tenKhoaLuan}';
        form_select3.appendChild(option_tmp_3_${kl.id});
    </c:forEach>
        div3.appendChild(form_select3);
        div3.appendChild(label3);
    }
    
    function removeElement1() {
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
    
    function removeElement3() {
        event.preventDefault();
        const div3 = document.getElementById("div-btn3");
        if (div3 !== null) {
            while (div3.hasChildNodes()) {
                div3.removeChild(div3.lastChild);
            }
        }
    }
</script>