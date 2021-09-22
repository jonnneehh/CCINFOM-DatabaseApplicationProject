
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Drop</title>
    </head>
    <body>
        <h1>Student Drop</h1>
        <form name="dropstudent" action="drop_process.jsp" method="POST">
            Student ID Number -<input type="text" name="studentid" id="studentid"><br>
            Term - <input type="text" name="term" id="term"><br>  
            School Year - <input type="text" name="schoolyear" id="schoolyear"><br> 
            <input type="submit" value="Drop" name="Drop"/>
        </form>
        <br>
    </body>
</html>