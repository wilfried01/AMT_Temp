<%--
  Created by IntelliJ IDEA.
  User: laure
  Date: 20.10.2021
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Task</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>




<h3>Liste utilisateurs</h3>

Affichage de tout les utilisateurs

</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Password</th>
        <th>Role</th>
        <th>Solde</th>
        <th>Vehicule en cours d'utilisation</th>
    </tr>

    <c:forEach var="listes2" items="${listes2}">
        <tr>
            <td>${listes2.id}</td>
            <td>${listes2.userName}</td>
            <td>${listes2.password}</td>
            <td>
                <c:choose>
                    <c:when test="${listes2.admin=='true'}">
                        Administrateur
                        <br />
                    </c:when>
                    <c:otherwise>
                        Client
                        <br />
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${listes2.admin=='true'}">

                        <br />
                    </c:when>
                    <c:otherwise>
                        ${listes2.solde}
                        <br />
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${listes2.admin=='true'}">

                        <br />
                    </c:when>
                    <c:otherwise>
                        ${listes2.vehicule.categorie}  ${listes2.vehicule.matricule}
                        <br />
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="managerTask?page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="managerTask?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="managerTask?page=${currentPage + 1}">Next</a></td>
</c:if>

</body>
</br>


<h3>Ajout d'un client</h3>

<form method="POST" action="${pageContext.request.contextPath}/managerTask">

    <table border="0">
        <tr>
            <td>userName</td>
            <td><input type="text" name="newUsername" value= "${newUsername}" /> </td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="newPassword" value= "${newPassword}" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Ajout" />
                <a href="${pageContext.request.contextPath}/managerTask">Cancel</a>
            </td>
        </tr>
    </table>
</form>

</br>
<c:if test="${errors != null}">
    Erreurs:
    <ul>
        <c:forEach items="${errors}" var="error">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>


||
<a href="${pageContext.request.contextPath}/operationClient">
    Supprimer client
</a>
||
<a href="${pageContext.request.contextPath}/changementSoldeClient">
    Changer solde
</a>





</body>
</html>
