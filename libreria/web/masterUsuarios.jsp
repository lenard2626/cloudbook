<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.UsuariosDto"  %>
<%@ page import="Dao.UsuariosDao" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>
<% if(session.getAttribute("name") == null){
   response.sendRedirect("index.jsp");
}
%>
<!doctype html>
<html class="no-js" lang="en">
  <head>
      <%@include file="header.jsp" %>
      <script type="text/javascript">
      function fn_eliminar(idCont){
	var respuesta = confirm("Desea eliminar este item?");
            if (respuesta){
                     document.location.href='UsuarioEliminar?id='+idCont;

            }
        }
        </script>
  </head>
  <body>
   <nav class="top-bar" data-topbar>
        <ul class="title-area">
          <li class="name">
            <h1>
              <a href="#">
               MI REPOSITORIO
              </a>
            </h1>
          </li>
       </ul>
     
        <section class="top-bar-section">
            <% if(session.getAttribute("rol").equals(1)){ %>
                <%@include file="menuAdmin.jsp" %>
            <%}%>
        </section>
      </nav>
     
   
      <div class="row">
          <div class="large-12 columns">
            <ul class="breadcrumbs">
                <li><a href="Account">Cuenta</a></li>
                <li class="current"><a href="Usuarios">Usuarios</a></li>
            </ul>
          </div>      
         
        <div class="large-12 columns">
     
            <h3 class="title" >Lista de usuarios</h3>
    
          <div class="section-container tabs" data-section>
            <section class="section">
                <%
                    if (request.getAttribute("mensaje") != null) {
                %>
                    <h4><%=request.getAttribute("mensaje") %></h4>
                <% } %>
                <p class="crear-item"><a href="FormUsuario">Crear usuario</a></p>
                <table style="width: 100%"  >
                    <tr>
                        
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Perfil</th>
                        <th>Usuario sistema</th>
                        <th>Editar </th>
                        <th>Eliminar</th>
                    </tr>
                    <% for (UsuariosDto lista : (List<UsuariosDto>)request.getAttribute("lineas_list")) {%>
                    <tr>
                        <td><%= lista.getNombre() %></td>
                        <td><%= lista.getApellido() %></td>
                        <td><%= lista.getEmail() %></td>
                        <td><%= lista.getPerfil() %></td>
                        <td><%= lista.getUsuario() %></td>
                        <td><a href="FormUsuario?contId=<%= lista.getIdUsuario() %>"><i class=" fi-page-edit  "></i></a></td>
                        <td><a href="javascript:void(0);" onclick="fn_eliminar(<%= lista.getIdUsuario() %>);" ><i class=" fi-trash"></i></a></td>

                    </tr>
                    <% } %>

                </table>
                    <button class="large-1">Reporte
                    <a href="reportUsuarios.pdf"/usuariospdf?index="+i*numElement+">"+(i)+"</a> 
                    </button>
            </section>
          </div>
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
