<%--
  Created by IntelliJ IDEA.
  User: laure
  Date: 20.10.2021
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello: ${loginedUser.userName}</h3>

User Name: <b>${loginedUser.userName}</b>
<br>
Password: <b>${loginedUser.password}</b>
<br>
<c:choose>
    <c:when test="${loginedUser.admin =='true'}">
       Administrateur <br>
    </c:when>
    <c:otherwise>
        <c:if test = "${loginedUser.trajetId != 0}">
           <b>Trajet en cours </b><br>
            Station de départ :  ${stations.get(loginedUser.vehicule.getStation_id()-1).getAdresse()}
            emplacement no :  ${emplacements.get(loginedUser.vehicule.getEmplacement_id()-1).getId()} <br>
            Station d'arrivé : ${stations.get(loginedUser.trajet.getDestination_station_id()-1).getAdresse()}
            emplacement no :  ${emplacements.get(loginedUser.trajet.getDestination_emplacement_id()-1).getId()} <br>
        </c:if>
        solde restant : ${loginedUser.solde} <br>
        <c:if test = "${not empty loginedUser.vehicule}">
           vehicule en cours d'utilisation : ${loginedUser.vehicule.categorie} ${loginedUser.vehicule.matricule}<br>
        </c:if>
    </c:otherwise>
</c:choose>

</body>
</html>