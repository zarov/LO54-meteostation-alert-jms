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
        <title>Alerts</title>
    </head>
    <body>
        <h1>Alerts</h1>
            <ul>
                <c:forEach items="${alerts}" var="alert">
                    <li>${alert.date}</li>   
                </c:forEach>    
            </ul>
        <br>
        <a href="/projet/StationListServlet">Return to stations</a>
    </body>
</html>
