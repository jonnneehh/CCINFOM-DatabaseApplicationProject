<%-- 
    Document   : enroll.jsp
    Created on : 22 Sep 2021, 5:39:26 pm
    Author     : Jared
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, enrollment.*" %>
<%@page import="enrollment.students" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <select>
            <%students S = new students();
               S.viewAllRecords();
                %>
        </select>
    </body>
</html>
