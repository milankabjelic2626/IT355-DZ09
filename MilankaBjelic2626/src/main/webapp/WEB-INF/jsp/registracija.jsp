
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
         <link href="<c:url value="/assets/css/forma.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
<body>
	<h2>Please Register</h2>
        <div id="container">
	<form:form method="post" action="${flowExecutionUrl}">
            <table>
                <tr>
                    <td><input type="hidden" name="_eventId" value="performRegister"></td>
                    <td><input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" /></td>
                </tr>
                <tr>
                    <td>Enter Username<input type="text" name="korisnickoIme" maxlength="60"></td>
                </tr>
                    <tr>
                    <td>Enter Password <input type="password" name="lozinka" maxlength="60"></td>
                    </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Registracija" /></td>
                 </tr>
            </table>
	</form:form>
        </div>
</body>
</html>

