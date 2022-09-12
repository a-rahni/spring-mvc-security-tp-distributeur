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
        <h1>Gestion des utilisateurs</h1>
        <table>
            <caption>Liste des utilisateurs</caption>
            <tr>
                <th>Numéro d'utilisateur</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Crédit</th>
                <th>Role</th>
                <th>Option</th>
            </tr>
            <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.lastName}</td>
                    <td>${u.firstName}</td>
                    <td>${u.email}</td>
                    <td>${u.balance}</td>
                    <td>${u.role.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/updateUser?id=${u.id}">Modifier</a>
                        &nbsp;
                        <a href="${pageContext.request.contextPath}/admin/deleteUser?id=${u.id}" onclick="return confirm('Vous êtes sûr ?')">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${error != null}">
            <p style="color:red"><c:out value="${error}" /></p>
        </c:if>

        <br />
        <hr />

        <a href="addUser">Créer un utilisateur</a>

    </body>
</html>