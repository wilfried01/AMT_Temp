<%--
  Created by IntelliJ IDEA.
  User: laure
  Date: 29.10.2021
  Time: 15:09
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



<h3>Manager Task 3</h3>

Changement solde d'un client

<br/><br/>

<form method="post" action="${pageContext.request.contextPath}/changementSoldeClient">
    choisir un utilisateur
    <select name="clientNum">
        <c:forEach items="${listUser}" var="listUser">
            <option value="${listUser.id}">  ${listUser.userName}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <tr>
        <td>Nouveau solde</td>
        <td><input type="text" name="solde" value= "${solde}" /> </td>
    </tr>
    <br/><br/>
    <input type="submit" value="Submit" />
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

</body>

</html>