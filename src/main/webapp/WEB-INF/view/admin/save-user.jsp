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
        <form:form method="POST" action="/admin/updateUser" modelAttribute="userForm">
            <form:input path="id" hidden="true" />
            <p>
                <form:label path="lastName">Nom : </form:label>
                <form:input path="lastName" type="text" />
                <form:errors path="lastName" />
            </p>
            <p>
                <form:label path="firstName">Prénom : </form:label>
                <form:input path="firstName" type="text" />
                <form:errors path="firstName" />
            </p>
            <p>
                <form:label path="email">Email : </form:label>
                <form:input path="email" type="text" />
                <form:errors path="email" />
            </p>
            <p>
                <form:label path="password">Mot de passe : </form:label>
                <form:input path="password" type="text" />
                <form:errors path="password" />
            </p>
            <p>
                <form:label path="balance">Crédit : </form:label>
                <form:input path="balance" type="number" />
                <form:errors path="balance" />
            </p>
            <p>
                <form:label path="role">Role : </form:label>
                <form:select path="role">
                    <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                </form:select>
            </p>

            <input type="submit" value="Sauvegarder">
        </form:form>

    </body>
</html>