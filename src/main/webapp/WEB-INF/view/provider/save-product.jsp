<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Distributeur - Spring MVC</title>
    </head>
    <body>
        <h1>Gestion des produits</h1>
        <form:form method="POST" action="/provider/updateProduct" modelAttribute="productForm">
            <p>
                <form:label path="name">Nom : </form:label>
                <form:input path="name" type="text" />
                <form:errors path="name" />
            </p>
            <p>
                <form:label path="quantity">Quantité : </form:label>
                <form:input path="quantity" type="number" />
                <form:errors path="quantity" />
            </p>
            <p>
                <form:label path="price">Prix : </form:label>
                <form:input path="price" type="number" step="0.1" />
                <form:errors path="price" />
            </p>

            <input type="submit" value="Sauvegarder">
        </form:form>

    </body>
</html>