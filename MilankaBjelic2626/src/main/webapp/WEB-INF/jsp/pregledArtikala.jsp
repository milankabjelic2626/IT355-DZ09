
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artikli</title>
        
        <link href="<c:url value="/assets/css/main.css" />" rel="stylesheet">
    </head>
    <body>
        
<c:if test="${!empty artikli}">
<div class="container">
    <h1>Lista artikala</h1>
    <table class="table default">
        <thead>
            <tr>
                <th>Naziv</th>
                <th>Opis</th>
                <th>Cena</th>
                <th>Velicina</th>
                <th>Boja</th>
                <th>Brend</th>
                <th>Kolekcija</th>
                <th>Izmeni</th>
                <th>Obrisi</th>
            </tr>
        </thead>
        <tbody> 
            <c:forEach items="${artikli}" var="artikal">
                <tr>
                    <td>${artikal.naziv}</td>
                    <td>${artikal.opis}</td>
                    <td>${artikal.cena}</td>
                    <td>${artikal.velicina}</td>
                    <td>${artikal.boja}</td>
                    <td>${artikal.brend}</td>
                    <td>${artikal.kolekcija}</td>
                    <td><a href="<c:url value='/izmeniArtikal/${artikal.id}' />">Izmeni</a></td>
                    <td><a href="<c:url value='/obrisiArtikal/${artikal.id}' />">Obrisi</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
    </body>
</html>
