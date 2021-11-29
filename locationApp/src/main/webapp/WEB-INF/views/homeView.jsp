<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Laboratoire 1 - AMT | Location Véhicules </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>



<div class="container">
    <div class="row">
        <h1> Coût de location</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col">Moto</th>
                <th scope="col">Berline</th>
                <th scope="col">Fourgon</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">0 - 59 mins</th>
                <td>1.70/km</td>
                <td>2.95/km</td>
                <td>3.60/km</td>
            </tr>
            <tr>
                <th scope="row">60 - 179 mins</th>
                <td>1.50/km</td>
                <td>2.60/km</td>
                <td>3.00/km</td>
            </tr>
            <tr>
                <th scope="row">180 - </th>
                <td >1.50/km</td>
                <td >2.30/km</td>
                <td>2.80/km</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="row">
        <h1> Que Voulez-vous faire?</h1>
        <div class="container">
            <div class="row">
                <div class="col">
                    <button type="button" class="btn btn-outline-info btn-lg"><a href="stationEtEmplacment">Afficher les Stations</a></button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-outline-info btn-lg"><a href="employeeTask">Utiliser un véhicule</a></button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-outline-info btn-lg"><a href="rendreVoiture">Rendre un véhicule</a></button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-outline-info btn-lg"><a href="userInfo">Info utilisateur</a></button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-outline-info btn-lg"><a href="login">Se connecter</a></button>
                </div>
                <c:if test = "${not empty loginedUser.userName}">
                <div class="col">
                    <button type="button" class="btn btn-outline-info btn-lg"><a href="logout">Se déconnecter</a></button>
                </div>
                </c:if>
            </div>
        </div>
    </div>
    <c:if test = "${loginedUser.admin =='true'}">
    <div class="row">
        <h1>Espace administrateur</h1>
        <div class="container">
            <div class="row">
                <div class="col">
                    <button type="button" class="btn btn-outline-danger btn-lg"><a href="managerTask">Gére les abonnés</a> </button>
                </div>

            </div>
        </div>
    </div>
    </c:if>
    &nbsp;  <div class="row">
    <span style="color:red">

        <c:if test = "${not empty loginedUser.userName}">
          [  ${loginedUser.userName}
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
            ]
        </c:if>
    </span>
</div>

</div>
</body>
</html>