<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Médias</title>
</head>
<body>
<h1>Liste des CD/DVD</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Type</th>
        <th>Disponible</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="media" items="${medias}">
        <tr>
            <td>${media.id}</td>
            <td>${media.titre}</td>
            <td>${media.type}</td>
            <td>${media.disponible ? "Oui" : "Non"}</td>
            <td>
                <c:if test="${media.disponible}">
                    <form action="media" method="post">
                        <input type="hidden" name="mediaId" value="${media.id}">
                        <input type="hidden" name="userId" value="1"> <!-- Exemple de user ID -->
                        <button type="submit">Emprunter</button>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
