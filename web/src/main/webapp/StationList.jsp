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
        <title>Stations</title>
    </head>
    <body>
        <h1>Stations</h1>
            <ul>
                <c:forEach items="${stations}" var="station">
                    <li>${station.label}
                        <a href="/backoffice/station?id=${station.id}">détails</a>
                    </li>
                </c:forEach>    
            </ul>
    </body>
</html>
