<%-- 
    Document   : enrollmentdone
    Created on : 09 23, 21, 4:17:54 AM
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*, java.util.*, enrollment.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment Done</title>
    </head>
    <body>
        <%
        enroll e = new enroll();
        e.submitEnroll();
        %>
        session.invalidate()
        <a href ="index.jsp">Back to start</a>
    </body>
</html>
