<%-- 
    Document   : test-db-connection
    Created on : 28/07/2024, 10:15:58 a. m.
    Author     : gcardenas
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="model.DatabaseConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Test DB Connection</title>
</head>
<body>
    <h1>Test DB Connection</h1>
    <%
        Connection conn = DatabaseConnection.connect();
        if (conn != null) {
            out.println("<p>Connection to database was successful!</p>");
        } else {
            out.println("<p>Failed to connect to the database.</p>");
        }
    %>
</body>
</html>