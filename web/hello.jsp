<%-- 
    Document   : hello
    Created on : Dec 29, 2022, 9:29:12 PM
    Author     : KHOA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Page</title>
    </head>
    <body>
        <%
            String userID = (String) request.getAttribute("UserID");
            if (userID == null) {
                userID = "";
            }

            String responseString = (String) request.getAttribute("RESPONSE");
            if (responseString == null) {
                responseString = "";
            }
        %>
        <h1>Welcome User ID <%=userID%></h1>
        <h3><%=responseString%></h3>
    </body>
</html>
