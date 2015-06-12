<%-- 
    Document   : StationList
    Created on : 12 mai 2015, 13:55:42
    Author     : Julien
--%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Materialize -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
        <title>Triggers</title>
    </head>
    <body>
        <div class="container">
            <h1>Triggers for ${sensor}</h1>
            <table class="collection">
            <c:forEach items="${triggers}" var="trigger">
                <tr class="collection-item">
                    <td>
                        <ul>
                            <li>Trigger id: ${trigger.id}</li>
                            <li>High trigger: ${trigger.trigHigh}</li>
                            <li>Low trigger: ${trigger.trigLow}</li>
                            <li>Edge trigger: ${trigger.trigEdge}</li>
                            <li>
                                <a href="/projet/DeleteTriggerServlet?id=${trigger.id}&sensorId=${triggers[0].sensor.id}" class="waves-effect waves-light btn red">Delete Trigger</a>
                            </li>
                        </ul>
                    </td>
            </c:forEach>
            </table>
            <br>
            <a href="/projet/AddTriggerFormServlet?sensorId=${triggers[0].sensor.id}" class="waves-effect waves-light btn blue">Add a new Trigger to this sensor</a>
            <br>
            <a href="/projet/StationListServlet" class="waves-effect waves-light btn">Return to stations</a>
        </div>
    </body>
</html>
