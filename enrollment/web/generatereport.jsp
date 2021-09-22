<%-- 
    Document   : generatereport
    Created on : 22 Sep 2021, 9:39:14 pm
    Author     : Jared
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
    </head>
    <body>
        <h1>Report Generated!</h1>
        <h2> Term: <%= request.getParameter("term")%></h2>
        <h2> School Year: <%= request.getParameter("schoolyear")%></h2>
        
        
    </body>
</html>
