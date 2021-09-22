<%-- 
    Document   : enroll.jsp
    Created on : 22 Sep 2021, 5:39:26 pm
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*, java.util.*, enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment</title>
    </head>
    <body>
        <h1>Enrollment</h1>
        
        <%
        enroll e = new enroll();
        e.loadCourses();
        
        if(request.getParameter("studentid") == null && session.getAttribute("studentid") == null){
            %>
            <form name = "studentinfo" action = "enroll.jsp" method = "GET">
                <input type = "number" name = "studentid" placeholder = "Student ID" required />
                <input type = "number" name = "schoolyear" placeholder = "School Year" required />
                <input type = "number" name = "term" placeholder = "Term" required /> <br><br>
                <input type = "submit" value = "Start adding courses to cart..." />
            </form>
            <%
        }
        else if(request.getParameter("studentid") != null && session.getAttribute("studentid") == null){
            
            int studentid = Integer.parseInt(request.getParameter("studentid"));
            int schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
            int term = Integer.parseInt(request.getParameter("term"));

            session.setAttribute("studentid", studentid); 
            session.setAttribute("schoolyear", schoolyear);
            session.setAttribute("term", term);
            %>
            <p>Student ID: <%= studentid %> </p>
            <p>School Year: <%= schoolyear %></p>
            <p>Term: <%= term %></p>

            <br>
            <p>Enter a Course ID to enroll:</p>
            <form name = "courseinfo" action = "addtoenrollcart.jsp" method = "GET">
                <select name = "courses">
                    <%
                    for(int i = 0; i < e.CourseList.size(); i++){%>
                    <option value = "<%= e.CourseList.get(i).getCourseid()%>"><%= e.CourseList.get(i).getCourseid()%></option>
                    <%}%>
                </select> 
                <br>
                <input type = "submit" value = "Add course to cart" />
            </form>
        <%}
        else if(session.getAttribute("studentid") != null){
        %>
        <p>Enter a Course ID to enroll:</p>
            <form name = "courseinfo" action = "addtoenrollcart.jsp" method = "GET">
                <select name = "courses">
                    <%
                    for(int i = 0; i < e.CourseList.size(); i++){%>
                    <option value = "<%= e.CourseList.get(i).getCourseid()%>"><%= e.CourseList.get(i).getCourseid()%></option>
                    <%}%>
                </select> 
                <br>
                <input type = "submit" value = "Add course to cart" />
            </form>
            
            <form name = "enrollmentfinish" action="enrollmentdone.jsp" method = "GET">
                <br>
                <input type = "submit" value = "Finish Enrolling" />
            </form>

        <%}%>    
    </body>
</html>
