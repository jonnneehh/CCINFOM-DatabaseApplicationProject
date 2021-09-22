<%-- 
    Document   : drop.jsp
    Created on : 22 Sep 2021, 5:39:26 pm
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*, java.util.*, enrollment.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add To Cart</title>
    </head>
    <body>
        <form>
            <%
                enroll e = (enroll) session.getAttribute("e");
                
                int studentid = (int) session.getAttribute("studentid");
                String courseid = request.getParameter("courses");
                int term = (int) session.getAttribute("term");
                int schoolyear = (int) session.getAttribute("schoolyear");
                
                e.EnrollmentList.add(new enrollment(studentid, courseid, term, schoolyear));
            %>
            <a href ="enroll.jsp">Back to enrollment</a>
        </form>
    </body>
</html>
