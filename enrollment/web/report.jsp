<%-- 
    Document   : report.jsp
    Created on : 22 Sep 2021, 5:39:26 pm
    Author     : Jared
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment Report</title>
    </head>
    <body>
        <h1>Enter details for report generation</h1>
            <form name ="GenerateReport" action ="generatereport.jsp" method ="POST">
            Term - <input type = "text" name ="term" id ="term"> </br>
            School Year - <input type = "text" name ="schoolyear" id ="schoolyear"> </br>
            <input type ="Submit"  value ="Generate Report" name="Generate Report" />
        </form> 
    </body>
</html>
