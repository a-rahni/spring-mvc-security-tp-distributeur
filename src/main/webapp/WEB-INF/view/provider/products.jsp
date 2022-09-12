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
        <table>
            <caption>Liste des produits</caption>
            <tr>
                <th>Numéro de produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
                <th>Option</th>
            </tr>
            <c:forEach var="p" items="${stock}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.quantity}</td>
                    <td>${p.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/provider/updateProduct?id=${p.id}">Modifier</a>
                        &nbsp;
                        <a href="${pageContext.request.contextPath}/provider/deleteProduct?id=${p.id}" onclick="return confirm('Vous êtes sûr ?')">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${error != null}">
            <p style="color:red"><c:out value="${error}" /></p>
        </c:if>

        <br />
        <hr />

        <a href="addProduct">ajouter un produit</a>

    </body>
</html>