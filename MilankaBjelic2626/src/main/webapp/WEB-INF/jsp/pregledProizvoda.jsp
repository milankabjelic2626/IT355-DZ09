

<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prikaz proizvoda</title>
        <link href="<c:url value="/assets/css/main.css" />" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container" align="center">
        <table class="table default">
            <tr>
                <th>Naziv</th>
                <th>Opis</th>
                <th>Cena</th>
                <th>Menjaj</th>
                <th>Brisi</th>
            </tr>
                <c:forEach var="proizvod" items="${list}">
                <tr>
                    <td>${proizvod.naziv}</td>
                    <td>${proizvod.opis}</td>
                    <td>${proizvod.cena}</td>
                    <td><a href="izmeniProizvod/${proizvod.naziv}">Izmeni</a></td>
                    <td><a href="obrisiProizvod/${proizvod.naziv}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
            <br/>
        <a href="proizvodForma"> Dodaj novi proizvod </a>
        </div>
    </body>
</html>
