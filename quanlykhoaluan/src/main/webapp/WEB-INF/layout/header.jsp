<%-- 
    Document   : header
    Created on : Jul 22, 2023, 8:23:38 PM
    Author     : Chung Vu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
            <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
        </div>
    </form>
    <!-- Navbar-->

    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <h1><a href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a></h1>
            <h1><a href="<c:url value="/logout"/>">đăng xuất</a></h1>
        </c:when>
        <c:otherwise>
            <button class ="loginBtn">
                <a class="login" href="<c:url value="/login"/>">Đăng nhập</a>
            </button>
        </c:otherwise>
    </c:choose>

</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="<c:url value="/" /> ">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Dashboard
                    </a>
                    <div class="sb-sidenav-menu-heading">Interface</div>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                        Pages
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name == null}">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>

                                        </nav>
                                    </div>


                                </nav>
                            </c:when>
                            <c:otherwise>
                                <sec:authorize access="hasAuthority('GIAO_VU')">
                                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                            Admin
                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                        </a>
                                        <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                            <nav class="sb-sidenav-menu-nested nav">
                                                <a class="nav-link" href="<c:url value="/admin/hoidongbaove"/>">Hội đồng bảo vệ</a>
                                                <a class="nav-link" href="<c:url value="/admin/khoaluantotnghieps"/>">Khóa luận tốt nghiệp</a>
                                                <a class="nav-link" href="<c:url value="/admin/nguoidungs"/>">Người dùng</a>
                                                <a class="nav-link" href="<c:url value="/admin/tieuchi"/>">Tiêu chí</a>
                                                <a class="nav-link" href="<c:url value="/admin/giangvienchamdiems"/>">Giảng viên chấm điểm</a>
                                                <a class="nav-link" href="<c:url value="/admin/giangvienhuongdan"/>">Giảng viên hướng dẫn</a>
                                            </nav>
                                        </div>


                                    </nav>

                                </div>
                                <div class="sb-sidenav-menu-heading">Addons</div>
                                <a class="nav-link" href="<c:url value="/admin/thongke" />">
                                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                    Charts
                                </a>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('GIANG_VIEN')">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Giảng Viên
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>

                                        </nav>
                                    </div>


                                </nav>
                            </sec:authorize>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Start Bootstrap
            </div>
        </nav>
    </div>
    <script src="<c:url value ="/js/scripts.js"/>"></script> 