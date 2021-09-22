<%-- 
    Document   : generatereport
    Created on : 22 Sep 2021, 9:39:14 pm
    Author     : Jared
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, enrollment.*" %>
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
        <table border="1">
    <%
        Class.forName("com.mysql.jdbc.Driver");
        try{
        int term = Integer.parseInt(request.getParameter("term"));
        int schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
        Connection conn;
         // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid AS Course, COUNT(courseid) AS Students FROM enrolldb.enrollment WHERE term = ? AND schoolyear = ? GROUP BY courseid"); // Edit
            // 5. Supply the statement with values
            pstmt.setInt(1, term);
            pstmt.setInt(2, schoolyear);
            
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()){
        %>
        <tr>
            <td><%=rs.getString("Course")%></td>
            <td><%=rs.getInt("Students")%></td>
        </tr>
    <%
        }
        rs.close();
            pstmt.close();
            conn.close();
} catch (SQLException e) {System.out.println(e);}%>

     </table>
    </body>
</html>
