<%-- 
    Document   : enroll_addtocart
    Created on : 02 4, 21, 11:28:35 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add to Cart</title>
    </head>
    <body>
        <jsp:useBean id="dropBean" class ="enrollment.enrollment" scope = "session"/>
        <% 
            int studentid = Integer.parseInt(request.getParameter("studentid"));
            String courseid = (request.getParameter("courseid"));
            int term = Integer.parseInt(request.getParameter("term"));
            int schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
            int result = dropBean.delRecord();
        %>
        
        <%
        if (result==0) {
        %>
                <p>add to cart was successful</p>
        <%   } else {
        %>
                <p>add to cart was not successful</p>
        <%   }
        %>
        
         <br> 
        <a href ="addtodrop.jsp" > Drop </a> 
        </br>
            
      
    </body>
</html>
