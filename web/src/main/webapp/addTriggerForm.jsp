<%-- 
    Document   : addTrigerForm
    Created on : 7 juin 2015, 15:13:22
    Author     : java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Trigger</title>
    </head>
    <body>
        <h1>Add Trigger</h1>
        <form action="/projet/AddTriggerServlet">
            Trigger High<br>
            <input type="text" name="triggerHigh"><br>
            Trigger Low:<br>
            <input type="text" name="triggerLow"><br>
            <br>
            Trigger Edge<br>
            <input type="text" name="triggerEdge"><br>
            <br>
            Alert<br>
            <select id="selectedAlert" name="selectedAlert">
                <c:forEach var="alert" items="${alerts}">
                    <option value="${alert.id}">${alert.label}</option>
                </c:forEach>
            </select>
            <br>
            <input type="hidden" name="sensor" value="<%=request.getParameter("sensorId")%>" />
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>



