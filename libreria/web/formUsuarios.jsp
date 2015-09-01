<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.UsuariosDto"  %>
<%@ page import="Dao.UsuariosDao" %>
<%@ page import="Modelo.RolesDto"  %>
<%@ page import="Dao.RolesDao" %>
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
      <script type="text/javascript" >
            $(function(){
               $("#frmg").validate({
                    event: "submit",
                    rules: {
                        usuario:{
                            remote:"VerificarUsuario"
                        }
                    },
                    messages: {
                        usuario:{
                            remote:"el usuario ya se encuentra en el sistema, debe generar uno diferente"
                        }
                    },
                    debug: false
                    //*errorElement: 'div',*/
                    //errorContainer: $('#errores'),
                });
           });
        </script>
  </head>
  <body>
   <nav class="top-bar" data-topbar>
        <ul class="title-area">
          <li class="name">
            <h1>
              <a href="#">
                Libreria
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
                <li><a href="Usuarios">Usuarios</a></li>
                <li class="current"><a href="FormUsuario">Formulario usuarios</a></li>
                
            </ul>
          </div>        
         
        <div class="large-12 columns">
     
            <h3 class="title" >Crear o editar usuario</h3>
    
          <div class="section-container tabs" data-section>
            <section class="section">
                
              <form action="FormUsuario" name="frmg" id="frmg" method="post" >
                <%
                     if (request.getAttribute("datau") != null) {
                        UsuariosDto item = (UsuariosDto)request.getAttribute("datau");
                %>  
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">nombre</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='nombre' class="required" value="<%= item.getNombre()%> " />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">apellido</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='apellido' class="required" value="<%= item.getApellido() %>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">correo electrónico</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='email' class="required email" value="<%= item.getEmail() %>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">perfil</label>
                    </div>
                    <div class="large-10 columns">
                      <select name="perfil" class="required" >
                          <% for (RolesDto lista : (List<RolesDto>)request.getAttribute("roles_list")) {%>
                          <option value="<%= lista.getIdRol() %>" <% if (lista.getIdRol().equals(item.getIdRol())) { %> selected <% }%> ><%= lista.getNombre() %></option>
                          <% } %>
                      </select>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Usuario</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='usuario' id="usuario" class="required" value="<%= item.getUsuario()%>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Contraseña</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='clave' class="required" value="<%= item.getContrasena() %>" />
                    </div>
                  </div>
                  <input type="hidden" name="idformato" value="<%= item.getIdUsuario() %>" />   
                <%}else{%>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">nombre</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='nombre' class="required"  />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">apellido</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='apellido' class="required" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">correo electrónico</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='email' class="required email" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">perfil</label>
                    </div>
                    <div class="large-10 columns">
                      <select name="perfil" class="required" >
                          <option value="" >------</option>
                          <% for (RolesDto lista : (List<RolesDto>)request.getAttribute("roles_list")) {%>
                          <option value="<%= lista.getIdRol() %>" ><%= lista.getNombre() %></option>
                          <% } %>
                      </select>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Usuario</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='usuario' class="required" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Contraseña</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='clave' class="required" />
                    </div>
                  </div>
                <%}%> 
                      
                  <input type="submit" name="enviar" class="button" value="Enviar" />
                </form>
            </section>
          </div>
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
