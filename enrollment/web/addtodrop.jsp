<%-- 
    Document   : enroll_confirm
    Created on : 02 5, 21, 1:22:27 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drop Confirmation</title>
    </head>
    <jsp:useBean id ="dropBean" class ="enrollment.drop" scope = "session"/>
        <% int result = dropBean.confirmDrop();
        if (result==1) {
        %>
                <p>Dropped successfully</p>
        <%   } else {
        %>
                <p>Dropped unsuccessfully</p>
        <%   }
        %>
        
        <br> 
        <a href ="addtodropcart.jsp" > Add another info </a> 
        </br>
       
</html>
