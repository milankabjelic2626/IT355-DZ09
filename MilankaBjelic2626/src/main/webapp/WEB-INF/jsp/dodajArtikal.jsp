

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dodavanje artikla</title>
        <link href="<c:url value="/assets/css/main.css" />" rel="stylesheet">
    </head>
    <body>
        
<c:url var="dodajArtikal" value="/dodajArtikal"></c:url>
    <div class="container">
        <div class="col-md-6 col-md-offset-3">
        <h1>Dodaj artikal</h1>
        <c:url var="post_url"  value="/dodajArtikal/" />
        <form:form method="POST" action="${post_url}" modelAttribute="artikal">
            <% String success = (String) request.getAttribute("porukaUspesno"); %>
            <%= (success != null) ? "<div class=\"alert alert-success\">"+success+"</div>" : "" %>
            <div class="form-group">
                <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
                <form:label path="naziv">Naziv</form:label>
                <form:input type="naziv" id="naziv" class="form-control" placeholder="Naziv" path="naziv" />
            </div>
            <div class="form-group">
                <form:label path="opis">Opis</form:label>
                <form:input type="opis" id="opis" class="form-control" placeholder="Opis" path="opis" />
            </div>
            <div class="form-group">
                <form:label path="cena">Cena</form:label>
                <form:input type="cena" id="cena" class="form-control" placeholder="Cena" path="cena" />
            </div>
            <div class="form-group">
                <form:label path="velicina">Velicina</form:label>
                <form:input type="velicina" id="velicina" class="form-control" placeholder="Velicina" path="velicina" />
            </div>
            
            <div class="form-group">
                <form:label path="boja">Boja</form:label>
                <form:input type="boja" id="boja" class="form-control" placeholder="Boja" path="boja" />
            </div>
            
            <div class="form-group">
                <form:label path="brend">Brend</form:label>
                <form:input type="brend" id="brend" class="form-control" placeholder="Brend" path="brend" />
            </div>
            
           <div class="form-group">
              <form:label for="kolekcije" path="kolekcija">Kolekcije</form:label>
                <form:select id="slcRole" class="form-control" path="kolekcija">
                    <form:option value="">SELECT</form:option>
                    <form:options items="${kolekcije}" itemValue="id" itemLabel="naziv" />
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">Dodaj artikal</button>
        </form:form>
    </div>
</div>
    </body>
</html>
