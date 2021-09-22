<%-- 
    Document   : enroll_addclass
    Created on : 02 5, 21, 12:59:38 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Drop</title>
    </head>
     <body>
        <h1>Enter details to add to cart</h1>
        <form name ="DropCart" action ="addtodropcart.jsp" method ="POST">
            Student ID - <input type = "text" name ="studentid" id ="studentid"> </br>
            Course ID - <input type = "text" name ="courseid" id ="courseid"> </br>
            Term - <input type = "text" name ="term" id ="term"> </br>
            School Year - <input type = "text" name ="schoolyear" id ="schoolyear"> </br>
            <input type ="Submit"  value ="addtodrop" name="addtodrop" />
        </form>  
    </body>
</html>
