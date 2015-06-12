<%-- 
    Document   : addTrigerForm
    Created on : 7 juin 2015, 15:13:22
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
        <title>Add Trigger</title>
    </head>
    <body>
        <div class="container">
            <h1>Add Trigger</h1>
            <form action="/projet/AddTriggerServlet">
                <div class="input-field">
                    <label for="triggerHigh">Trigger High</label>
                    <input type="text" name="triggerHigh">
                </div>
                <div class="input-field">
                    <label for="triggerLow">Trigger Low</label>
                    <input type="text" name="triggerLow">
                </div>
                <div class="input-field">
                    <label for="triggerEdge">Trigger Edge</label>
                    <input type="text" name="triggerEdge"><br>
                </div>
                <div class="input-field">
                    <label>Alert</label>
                    <br>
                    <select id="selectedAlert" name="selectedAlert" class="browser-default" style="margin-top: 30px;">
                        <c:forEach var="alert" items="${alerts}">
                            <option value="${alert.id}">${alert.label}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="hidden" name="sensor" value="<%=request.getParameter("sensorId")%>" />
                <button type="submit" value="Submit" class="waves-effect waves-light btn" style="margin-top: 50px;">Submit</button>
            </form> 
        </div>
    </body>
</html>



