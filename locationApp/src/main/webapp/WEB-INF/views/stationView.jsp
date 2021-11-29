<%--
  Created by IntelliJ IDEA.
  User: laure
  Date: 22.10.2021
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Station</title>
</head>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Station</h3>

Affichage des stations

</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <th>Emp ID</th>
        <th>Emp Addr</th>
        <th>Emp occupe</th>
        <th>Emp reserve</th>
    </tr>

    <c:forEach var="emp" items="${listeEmpView}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.adresse}</td>
            <td>${emp.vehicule.categorie} ${emp.vehicule.id}</td>

            <td>
                <c:choose>
                    <c:when test="${emp.vehicule != null}">
                    Occupé
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${emp.reserve=='true'}">
                                Reservé
                            </c:when>
                            <c:otherwise>
                                Libre
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>

            </td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="stationEtEmplacment?page=${currentPage - 1}">Previous</a></td>
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
                    <td><a href="stationEtEmplacment?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="stationEtEmplacment?page=${currentPage + 1}">Next</a></td>
</c:if>



</body>

</html>
