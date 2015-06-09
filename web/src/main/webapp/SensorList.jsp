<%-- 
    Document   : SensorList
    Created on : 7 juin 2015, 14:33:55
    Author     : java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sensors</title>
    </head>
    <body>
        <h1>Sensors</h1>
            <ul>
                <c:forEach items="${sensors}" var="sensor">
                    <li>${sensor.label}
                        <a href="/projet/TriggerListServlet?id=${sensor.id}">Display Triggers</a>
                    </li>
                </c:forEach>    
            </ul>
        <br>
        <a href="/projet/StationListServlet">Return to stations</a>
    </body>
</html>
