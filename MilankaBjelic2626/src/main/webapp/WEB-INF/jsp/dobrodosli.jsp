<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
    <head>
        <title><spring:message code="AknaliM"/></title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body>
        <!-- Wrapper -->
        <div id="wrapper">

            <!-- Header -->
            <header id="header">
                <div class="inner">

                    <!-- Logo -->
                    <a href="/MilankaBjelic2626" class="logo">
                        <span class="symbol"><img src="images/banner.jpg" alt="" /></span>
                        <span class="title" style="font-size: 45px"><spring:message code="AknaliM"/></span>
                    </a>
                </div>
            </header>

            <!-- Main -->
            <div id="main">
                <div class="inner">
                    <header>
                        <h3 style="text-align: center"><spring:message code="dobrodosli"/></h3>
                        <p style="text-align: center"><spring:message code="kakopomoci"/></p>
                    </header>
                    <section class="tiles">
                        <article class="style1" style="text-align: center">
                            <span class="image">
                                <img src="images/pic01.png" style="height: 250px; width: 450px" alt="" />
                            </span>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <a href="login">
                                    <h2><spring:message code="login"/></h2>
                                    <div class="content">
                                        <p><spring:message code="tilelogin"/></p>
                                    </div>
                                </a>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                                <form action="${logoutUrl}" method="post" id="logoutForm">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </form>
                                <script>
                                    function formSubmit() {
                                        document.getElementById("logoutForm").submit();
                                    }
                                </script>
                                <a href="javascript:formSubmit()">
                                    <h2><spring:message code="user"/> ${pageContext.request.userPrincipal.name}</h2>
                                    <div class="content">
                                        <p><spring:message code="tilelogout"/></p>
                                    </div>
                                </a>
                            </c:if>
                        </article>
                        <article class="style2" style="text-align: center">
                            <span class="image">
                                <img src="images/pic02.png" style="height: 250px; width: 300px" alt="" />
                            </span>
                            <a href="proizvodForma">
                                <h2><spring:message code="tileinputheader"/></h2>
                                <div class="content">
                                    <p><spring:message code="tileinput"/></p>
                                </div>
                            </a>
                        </article>
                        <article class="style2" style="text-align: center">
                            <span class="image">
                                <img src="images/pic02.png" style="height: 250px; width: 300px" alt="" />
                            </span>
                            <a href="dodajArtikal">
                                <h2><spring:message code="tileinputheader2"/></h2>
                                <div class="content">
                                    <p><spring:message code="tileinput"/></p>
                                </div>
                            </a>
                        </article>
                        <article class="style2" style="text-align: center">
                            <span class="image">
                                <img src="images/pic02.png" style="height: 250px; width: 300px" alt="" />
                            </span>
                            <a href="pregledArtikala">
                                <h2><spring:message code="tileinputheader3"/></h2>
                                <div class="content">
                                    <p><spring:message code="tileinput"/></p>
                                </div>
                            </a>
                        </article>
                                <article class="style3" style="text-align: center">
                            <span class="image">
                                <img src="images/pic03.png" style="height: 250px; width: 300px" alt="" />
                            </span>
                            <a href="">
                                <h2><spring:message code="tileaboutheader"/></h2>
                                <div class="content">
                                    <p><spring:message code="tileabout"/></p>
                                </div>
                            </a>
                        </article>
                    </section>
                </div>
            </div>

            <!-- Footer -->
            <footer id="footer">
                <div class="copyright">
                    <section>
                        <h1 style='text-align: center'><spring:message code="autor"/></h1>
                    </section>
                    <ul class="copyright">
                        <p style='text-align: center'><spring:message code="copyright"/></p>
                    </ul>
                </div>
            </footer>

        </div>

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>

    </body>
</html>