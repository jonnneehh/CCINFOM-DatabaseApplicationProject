
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Processing</title>
    </head>
    <body>
        <h1>Processing your order</h1>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session" />
        <%  dropBean.confirmDrop();
            dropBean.clearDrop();
        %>    
    </body>
    
    click <a href="index.jsp">here to go back to Main Menu</a><br>
    <a href="index.html">Main Menu</a><br>
</html>