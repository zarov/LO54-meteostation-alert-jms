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
        <title>Alerts</title>
    </head>
    <body>
        <h1>Alerts</h1>
            <table class="collection">
                <c:forEach items="${alerts}" var="alert">
                    <tr class="collection-item"><td>${alert.date}</td></tr>
                </c:forEach>
            </table>
        <br>
        <a href="/projet/StationListServlet" class="waves-effect waves-light btn">Return to stations</a>
    </body>
</html>
