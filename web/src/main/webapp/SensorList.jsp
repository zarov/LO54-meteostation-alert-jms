<%-- 
    Document   : SensorList
    Created on : 7 juin 2015, 14:33:55
    Author     : Julien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Materialize -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
        <title>Sensors</title>
    </head>
    <body>
        <div class="container">
            <h1>Sensors for ${station}</h1>
            <table class="collection">
                <c:forEach items="${sensors}" var="sensor">
                    <tr class="collection-item">
                        <td>${sensor.label}</td>
                        <td><a href="/projet/TriggerListServlet?id=${sensor.id}" class="waves-effect waves-light btn blue">Display Triggers</a></td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="/projet/StationListServlet" class="waves-effect waves-light btn">Return to stations</a>
        </div>
    </body>
</html>
