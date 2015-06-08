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
        <title>Triggers</title>
    </head>
    <body>
        <h1>Triggers</h1>
        <c:forEach items="${triggers}" var="trigger">
            <ul>
                <li>
                    Trigger id: ${trigger.id}
                    <a href="/projet/DeleteTriggerServlet?id=${trigger.id}&sensorId=${triggers[0].sensor.id}">Delete Trigger</a>
                </li>
                <li>High trigger: ${trigger.trigHigh}</li>
                <li>Low trigger: ${trigger.trigLow}</li>
                <li>Edge trigger: ${trigger.trigEdge}</li>
            </ul>
        </c:forEach>
        <a href="/projet/AddTriggerFormServlet?sensorId=${triggers[0].sensor.id}">Add a new Trigger to this sensor</a>
    </body>
</html>
