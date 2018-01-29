

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj kolekciju</title>
        <link href="<c:url value="/assets/css/main.css" />" rel="stylesheet">
    </head>
    <body>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <h1>Dodaj kolekciju</h1>
        <c:url var="dodajKolekciju" value="/dodajKolekciju" ></c:url>
        <form:form method="POST" modelAttribute="kolekcija">
            <% String success = (String) request.getAttribute("porukaUspesno");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="naziv">Naziv</form:label>
                <form:input type="naziv" class="form-control" id="naziv" placeholder="Naziv" path="naziv" />
            </div>
            <button type="submit" class="btn btn-primary">Dodaj</button>
        </form:form>
    </div>
</div>
    </body>
</html>
