<%--
  Created by IntelliJ IDEA.
  User: laure
  Date: 20.10.2021
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="${pageContext.request.contextPath}/">
    Home
</a>
||
<a href="${pageContext.request.contextPath}/stationEtEmplacment">
    Station
</a>
||
<a href="${pageContext.request.contextPath}/employeeTask">
    Reserver une voiture
</a>
||
<a href="${pageContext.request.contextPath}/rendreVoiture">
    Rendre une Voiture
</a>
||
<a href="${pageContext.request.contextPath}/managerTask">
    Administrateur
</a>
||
<a href="${pageContext.request.contextPath}/userInfo">
    User Info
</a>
||
<a href="${pageContext.request.contextPath}/login">
    Login
</a>
||
<a href="${pageContext.request.contextPath}/logout">
    Logout
</a>


&nbsp;
<span style="color:red">[  ${loginedUser.userName}

        <c:if test = "${not empty loginedUser.userName}">
            <c:choose>
                <c:when test="${loginedUser.admin =='true'}">
                        (administrateur)
                </c:when>
                <c:otherwise>
                    <c:if test = "${loginedUser.trajetId != 0}">
                     /  TRAJET EN COURS
                    </c:if>
                     / solde restant : ${loginedUser.solde}
                    <c:if test = "${not empty loginedUser.vehicule}">
                        /  vehicule en cours d'utilisation : ${loginedUser.vehicule.categorie} ${loginedUser.vehicule.matricule}
                    </c:if>
                </c:otherwise>
            </c:choose>
        </c:if>
    ]</span>

