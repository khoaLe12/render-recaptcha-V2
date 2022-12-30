<%-- 
    Document   : login
    Created on : Dec 29, 2022, 9:29:05 PM
    Author     : KHOA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""><br>
            Password<input type="password" name="password" required="">
            
            //////Input your site key here
            <div class="g-recaptcha" data-sitekey="  YOUR SITE-KEY HERE  "></div>
            <%
                String recaptcha = (String)request.getAttribute("RECAPTCHA");
                if(recaptcha==null){
                    recaptcha = "";
                }
            %>
            <h1><%=recaptcha%></h1>
            
            <br><input type="hidden" name="action" value="Login">
            <input type="submit" value="Login">
            
        </form>
        <%
            String error = (String) request.getAttribute("ERROR");
            if(error == null){
                error = "";
            }
        %>
        <h1><%=error%></h1>
        
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </body>
</html>
