
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj proizvod</title>
        <link href="<c:url value="/assets/css/main.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container" align="center">
        <h1>Dodaj</h1>
        <form:form method="post" action="dodajProizvod">
        <table>
            
            <tr>
                <td>Naziv: </td>
                <td><form:input path="naziv" /></td>
            </tr>
            <tr>
                <td>Opis: </td>
                <td><form:input path="opis" /></td>
            </tr>
            <tr>
                <td>Cena: </td>
                <td><form:input path="cena" /></td>
            </tr>
            
             
             <tr>
                 <td></td>
             <td><input type="submit" value="Dodaj" /></td>
             </tr>
        </table>
        </form:form>
        </div>
    </body>
</html>