<%-- 
    Document   : Logout
    Created on : 29-ago-2015, 15:20:01
    Author     : IDKIDC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>

