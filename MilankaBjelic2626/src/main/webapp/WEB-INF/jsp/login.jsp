<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <title><spring:message code="logintitle"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="/assets/css/forma.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body onload='document.loginForm.username.focus();'>
        <div class='container'>
            <c:if test="${not empty error}">
                <div class="error" style="text-align: center; color: crimson">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg" style="text-align: center">${msg}</div>
            </c:if>
                <form class="form-signin" name='loginForm' action="<c:url value='/j_spring_security_check' />"
                      method='POST'>
                <h2 class="form-signin-heading" style="text-align: center; color: cadetblue; font-family: sans-serif"><spring:message code="pleaselogin"/></h2>
                <label for="username" class="sr-only"><spring:message code="username"/></label>
                <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Username" required autofocus style="width: 300px">
                <label for="password" class="sr-only"><spring:message code="password"/></label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required style="width: 300px">
                <button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" name="submit" style="width: 200px"><spring:message code="login"/></button>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
        </div>
    </body>
</html>