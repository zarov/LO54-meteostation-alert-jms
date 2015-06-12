<%-- 
    Document   : StationList
    Created on : 12 mai 2015, 13:55:42
    Author     : Julien
--%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://efsavage.com/twitter-bootstrap" prefix="bs" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Materialize -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
        <title>Stations</title>
    </head>
    <body>
        <div class="container">
            <h1>Stations</h1>
            <table class="collection">
                <c:forEach items="${stations}" var="station">
                    <tr class="collection-item">
                        <td>${station.label}</td>
                        <td><a href="/projet/SensorListServlet?id=${station.id}" class="waves-effect waves-light btn blue">Display sensors</a></td>
                    </tr>
                </c:forEach>    
            </table>
            <br>
            <a href="/projet/AlertHisListServlet" class="waves-effect waves-light btn">See alerts historic</a>
        </div>
    </body>
</html>
