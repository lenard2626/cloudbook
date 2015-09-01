

<%@page import="Mysql.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%                     
            try{   
                Connection con = Conexion.Conexion(); 
                out.print("Conexion Exitosa" + "<br /><br />");
            }catch (Exception ex){
                //out.print("Error al Conectar " + Conn);  
                out.print("Error de conexion porque: "+ex.getMessage());
            }             
        %>
    </body>
</html>
